package com.autoparts.userservice.service;

import com.autoparts.userservice.entity.UserEntity;

import java.util.UUID;

public interface MicroUserService {
    UserEntity get(UUID id);
}
