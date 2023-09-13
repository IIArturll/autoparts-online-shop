package com.autoparts.userservice.service.impl;

import com.autoparts.userservice.core.dto.UserDto;
import com.autoparts.userservice.core.exceptions.ResourceNotFoundException;
import com.autoparts.userservice.entity.UserEntity;
import com.autoparts.userservice.repository.UserRepository;
import com.autoparts.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto create(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto update(UUID id, UserDto userDto) {
        UserEntity currentUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Can`t find user with UUID: " + id));
        return null;
    }

    @Override
    public void delete(UUID id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getById(UUID id) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Can`t find user with UUID: " + id));

        return null;
    }
}
