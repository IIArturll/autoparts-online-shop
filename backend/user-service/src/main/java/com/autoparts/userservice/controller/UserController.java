package com.autoparts.userservice.controller;

import com.autoparts.userservice.core.dto.UserDto;
import com.autoparts.userservice.core.mappers.UserEntityMapper;
import com.autoparts.userservice.entity.UserEntity;
import com.autoparts.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id") UUID id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }

    @PutMapping
    public UserEntity update(@RequestBody @Validated UserDto userDto) {
        throw new UnsupportedOperationException();
    }

    @PostMapping
    public void create(@RequestBody @Valid UserDto user){
        userService.create(user);
    }
}
