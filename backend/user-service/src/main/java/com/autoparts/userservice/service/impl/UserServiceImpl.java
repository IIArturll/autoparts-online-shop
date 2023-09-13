package com.autoparts.userservice.service.impl;

import com.autoparts.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDto create(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto update(UUID id, UserDto userDto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public UserDto getById(UUID id) {
        return null;
    }
}
