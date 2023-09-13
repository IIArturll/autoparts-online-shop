package com.autoparts.userservice.service.impl;

import com.autoparts.userservice.core.dto.UserDto;
import com.autoparts.userservice.domain.User;
import com.autoparts.userservice.service.api.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User create(UserDto userDto) {
        return null;
    }

    @Override
    public User update(UserDto userDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }
}
