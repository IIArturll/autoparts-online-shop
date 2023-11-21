package com.autoparts.userservice.service;

import com.autoparts.userservice.core.dto.UserCreateDTO;
import com.autoparts.userservice.core.dto.UserDto;
import com.autoparts.userservice.entity.UserEntity;

import java.util.UUID;

public interface UserService {
    void create(UserCreateDTO userDto);
    UserDto update(UUID id, UserDto userDto);
    void delete(UUID id);
    UserDto getById(UUID id);
}
