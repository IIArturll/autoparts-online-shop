package com.example.orderservice.services;

import com.example.orderservice.controllers.clients.ICartClient;
import com.example.orderservice.controllers.clients.IProductClient;
import com.example.orderservice.core.CartOrderEntityMapper;
import com.example.orderservice.core.ReqProductDTO;
import com.example.orderservice.core.exceptions.ResourceNotFoundException;
import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.entity.cart.CartEntity;
import com.example.orderservice.repositories.IOrderRepository;
import com.example.orderservice.services.api.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class OrderService implements IOrderService {
    private final IOrderRepository repository;
    private final ICartClient cartClient;
    private final IProductClient productClient;

    public OrderService(IOrderRepository repository, ICartClient cartClient, IProductClient productClient) {
        this.repository = repository;
        this.cartClient = cartClient;
        this.productClient = productClient;
    }

    @Override
    public void makeOrder(UUID user) {
        CartEntity cartEntity = cartClient.get(user).getBody()
                .orElseThrow(() -> new ResourceNotFoundException("Cart for user with id: " + user + " not found"));
        if (cartEntity.getProducts().isEmpty()) {
            throw new ResourceNotFoundException("Cart for user with id: " + user + " is empty");
        }
        OrderEntity orderEntity = CartOrderEntityMapper.cartToOrderEntity(cartEntity);
        orderEntity.getProducts().forEach(p -> productClient.delete(new ReqProductDTO(p.getProduct().getId(), p.getAmount())));
        cartClient.cleanCart(user);
        repository.save(orderEntity);
    }

}
