package com.example.orderservice.repositories;

import com.example.orderservice.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IOrderRepository extends CrudRepository<OrderEntity, UUID>,
        PagingAndSortingRepository<OrderEntity, UUID> {
}
