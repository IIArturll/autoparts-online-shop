package com.autoparts.userservice.service;

import com.autoparts.userservice.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface MicroUserService {
    Optional<UserEntity> get(UUID id);
    Optional<UserEntity> getByEmail(String email);
}
