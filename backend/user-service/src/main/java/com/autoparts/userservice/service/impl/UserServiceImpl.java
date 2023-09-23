package com.autoparts.userservice.service.impl;

import com.autoparts.userservice.core.dto.UserDto;
import com.autoparts.userservice.core.exceptions.ResourceNotFoundException;
import com.autoparts.userservice.core.exceptions.UserAlreadyExistsException;
import com.autoparts.userservice.core.mappers.UserEntityMapper;
import com.autoparts.userservice.entity.Role;
import com.autoparts.userservice.entity.Status;
import com.autoparts.userservice.entity.UserEntity;
import com.autoparts.userservice.repository.IUserRepository;
import com.autoparts.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository,
                           UserEntityMapper userEntityMapper,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto create(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exist with email: " + userDto.getEmail());
        }

        UserEntity user = userEntityMapper.toEntity(userDto);
        Role role = Role.USER;
        Status status = Status.WAITING_ACTIVATION;

        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRole(role);
        user.setStatus(status);

        userRepository.save(user);
        return userEntityMapper.toDto(user);
    }

    @Override
    public UserDto update(UUID id, UserDto userDto) {
        UserEntity currentUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Can`t find user with UUID: " + id));
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getById(UUID id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Can`t find user with UUID: " + id));
        return userEntityMapper.toDto(user);
    }
}
