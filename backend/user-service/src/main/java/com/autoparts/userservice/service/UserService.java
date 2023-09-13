package com.autoparts.userservice.service;

import java.util.UUID;

public interface UserService {
    UserDto create(UserDto userDto);
    UserDto update(UUID id, UserDto userDto);
    void delete(UUID id);
    UserDto getById(UUID id);
}
