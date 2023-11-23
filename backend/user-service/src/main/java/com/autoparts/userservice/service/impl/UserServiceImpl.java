package com.autoparts.userservice.service.impl;

import com.autoparts.userservice.core.dto.*;
import com.autoparts.userservice.core.enums.Role;
import com.autoparts.userservice.core.enums.Status;
import com.autoparts.userservice.core.exceptions.InvalidPassword;
import com.autoparts.userservice.core.exceptions.ResourceNotFoundException;
import com.autoparts.userservice.core.exceptions.UserAlreadyExistsException;
import com.autoparts.userservice.core.mappers.UserEntityMapper;
import com.autoparts.userservice.entity.RoleEntity;
import com.autoparts.userservice.entity.StatusEntity;
import com.autoparts.userservice.entity.UserEntity;
import com.autoparts.userservice.repository.IUserRepository;
import com.autoparts.userservice.security.MyUserDetails;
import com.autoparts.userservice.security.MyUserDetailsService;
import com.autoparts.userservice.security.jwt.JwtTokenUtil;
import com.autoparts.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final IUserRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil tokenUtil;
    private final MyUserDetailsService userDetailsService;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository,
                           UserEntityMapper userEntityMapper,
                           PasswordEncoder passwordEncoder,
                           JwtTokenUtil tokenUtil,
                           MyUserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
        this.passwordEncoder = passwordEncoder;
        this.tokenUtil = tokenUtil;
        this.userDetailsService = userDetailsService;
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
        user.setStatus(new StatusEntity(Status.ACTIVATED)); //todo send email to verify now activated
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

    @Override
    public String login(UserLoginDTO user) {
        UserEntity entity = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("user with email: " + user.getEmail()
                        + " not found"));
        if (entity.getStatus().getStatus() == Status.WAITING_ACTIVATION) {
            throw new ResourceNotFoundException("authorization is not available," +
                    " the account is not verified");
        }
        if (passwordEncoder.matches(user.getPassword(), entity.getPassword())) {
            MyUserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
            return tokenUtil.generateToken(userDetails);
        } else {
            throw new InvalidPassword("Invalid password");
        }
    }
}
