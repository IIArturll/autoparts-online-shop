package com.autoparts.userservice.service;

import com.autoparts.userservice.core.dto.UserDto;
import com.autoparts.userservice.entity.UserEntity;

import java.util.UUID;

public interface UserService {
    UserEntity create(UserDto userDto);
    UserEntity update(UUID id, UserDto userDto);
    void delete(UUID id);
    UserEntity getById(UUID id);
}
