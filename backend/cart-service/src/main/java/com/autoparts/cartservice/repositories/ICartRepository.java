package com.autoparts.cartservice.repositories;

import com.autoparts.cartservice.entity.CartEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ICartRepository extends CrudRepository<CartEntity, UUID> {
    Optional<CartEntity> findByUserId(UUID id);
}
