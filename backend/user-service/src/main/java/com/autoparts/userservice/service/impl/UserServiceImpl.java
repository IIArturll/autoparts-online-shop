package com.autoparts.userservice.service.impl;

import com.autoparts.userservice.core.dto.UserCreateDTO;
import com.autoparts.userservice.core.dto.UserDto;
import com.autoparts.userservice.core.exceptions.ResourceNotFoundException;
import com.autoparts.userservice.core.exceptions.UserAlreadyExistsException;
import com.autoparts.userservice.core.mappers.UserEntityMapper;
import com.autoparts.userservice.core.dto.Role;
import com.autoparts.userservice.core.dto.Status;
import com.autoparts.userservice.entity.RoleEntity;
import com.autoparts.userservice.entity.StatusEntity;
import com.autoparts.userservice.entity.UserEntity;
import com.autoparts.userservice.repository.IUserRepository;
import com.autoparts.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Transactional
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
    public void create(UserCreateDTO userDto) {
        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("User already exist with email: " + userDto.getEmail());
        }

        UserEntity user = new UserEntity();
        user.setEmail(userDto.getEmail());
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setPhone(userDto.getPhone());
        user.setRole(new RoleEntity(Role.USER));
        user.setStatus(new StatusEntity(Status.ACTIVATED));
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
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
