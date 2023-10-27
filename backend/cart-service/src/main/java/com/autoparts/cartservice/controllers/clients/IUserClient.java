package com.autoparts.cartservice.controllers.clients;

import com.autoparts.cartservice.entity.user.UserEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@FeignClient(value = "user-service", path = "micro/user")
public interface IUserClient {
    @GetMapping("/{id}")
    ResponseEntity<Optional<UserEntity>> get(@PathVariable("id") UUID id);
}
