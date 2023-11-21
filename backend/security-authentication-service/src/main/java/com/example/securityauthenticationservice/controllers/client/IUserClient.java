package com.example.securityauthenticationservice.controllers.client;

import com.example.securityauthenticationservice.entity.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(value = "user-service", path = "micro/user")
public interface IUserClient {
    @GetMapping("/email/{email}")
    ResponseEntity<Optional<UserEntity>> getByEmail(@PathVariable("email") String email);
}
