package com.autoparts.userservice.controller;

import com.autoparts.userservice.core.dto.UserCreateDTO;
import com.autoparts.userservice.core.dto.UserDto;
import com.autoparts.userservice.core.dto.UserLoginDTO;
import com.autoparts.userservice.entity.UserEntity;
import com.autoparts.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.OK)
    public UserDto getById(@PathVariable("id") UUID id) {
        return userService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        userService.delete(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UserEntity update(@RequestBody @Valid UserDto userDto) {
        throw new UnsupportedOperationException();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registrate(@RequestBody @Valid UserCreateDTO user) {
        userService.create(user);
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public String login(@RequestBody @Valid UserLoginDTO user) {
        return userService.login(user);
    }
}
