package com.autoparts.userservice.service.api;

import com.autoparts.userservice.core.dto.UserDto;
import com.autoparts.userservice.domain.User;

public interface UserService {
    User create(UserDto userDto);
    User update(UserDto userDto);
    void delete(Long id);
    User getById(Long id);
    User getByUsername(String username);
    User getByEmail(String email);
}
