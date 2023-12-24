package com.autoparts.userservice.service.impl;

import com.autoparts.userservice.entity.UserEntity;
import com.autoparts.userservice.repository.IUserRepository;
import com.autoparts.userservice.service.MicroUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MicroUserImpl implements MicroUserService {
    private final IUserRepository repository;

    public MicroUserImpl(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<UserEntity> get(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Optional<UserEntity> getByEmail(String email) {
        return repository.findByEmail(email);
    }


}
