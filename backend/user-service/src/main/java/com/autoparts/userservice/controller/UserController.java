package com.autoparts.userservice.controller;

import com.autoparts.userservice.core.dto.UserDto;
import com.autoparts.userservice.core.mappers.UserEntityMapper;
import com.autoparts.userservice.entity.UserEntity;
import com.autoparts.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Validated
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private final UserEntityMapper userEntityMapper;

    @Autowired
    public UserController(UserService userService, UserEntityMapper userEntityMapper) {
        this.userService = userService;
        this.userEntityMapper = userEntityMapper;
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable UUID id) {
        return userEntityMapper.toDto(userService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }

    @PutMapping
    public UserEntity update(@RequestBody @Validated UserDto userDto) {
        throw new UnsupportedOperationException();
    }
}
