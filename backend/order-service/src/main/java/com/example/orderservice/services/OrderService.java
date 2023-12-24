package com.example.orderservice.services;

import com.example.orderservice.controllers.clients.ICartClient;
import com.example.orderservice.controllers.clients.IProductClient;
import com.example.orderservice.core.mappers.CartOrderEntityMapper;
import com.example.orderservice.core.dto.OrderDTO;
import com.example.orderservice.core.mappers.OrderMapper;
import com.example.orderservice.core.dto.ReqProductDTO;
import com.example.orderservice.core.exceptions.InsufficientQuantityException;
import com.example.orderservice.core.exceptions.ResourceNotFoundException;
import com.example.orderservice.entity.OrderEntity;
import com.example.orderservice.entity.cart.CartEntity;
import com.example.orderservice.repositories.IOrderRepository;
import com.example.orderservice.services.api.IOrderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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
        long count = cartEntity.getProducts().stream().filter(p -> p.getAmount() > p.getProduct().getAmount()).count();
        if (count == 0) {
            OrderEntity orderEntity = CartOrderEntityMapper.cartToOrderEntity(cartEntity);

            orderEntity.getProducts().forEach(p -> productClient.delete(new ReqProductDTO(p.getProduct().getId(), p.getAmount())));
            cartClient.cleanCart(user);
            repository.save(orderEntity);
        } else {
            throw new InsufficientQuantityException("there is not enough product in stock for " + count + " items");
        }
    }

    @Override
    public Page<OrderDTO> getPageForUserWhereOrderIsReady(String userEmail, Pageable page) {
        Page<OrderEntity> orders = repository.findAllByUserEmailOrderByReady(userEmail, page);
        return orders.map(OrderMapper::convertOrderEntityToDTO);
    }

    @Override
    public Page<OrderDTO> getPageOfOrdersWitchIsNotReady(Pageable page) {
        Page<OrderEntity> orders = repository.findAllByReadyIsFalseOrderByOrderTimeDesc(page);
        return orders.map(OrderMapper::convertOrderEntityToDTO);
    }

    @Override
    public Page<OrderDTO> getAllOrders(Pageable pageable) {
        return repository.findAll(pageable).map(OrderMapper::convertOrderEntityToDTO);
    }

    @Override
    public void markAsReady(UUID orderId) {
        OrderEntity orderEntity = repository.findById(orderId).orElseThrow(() ->
                new ResourceNotFoundException("Order with id: " + orderId + " not found"));
        orderEntity.setReady(true);
        repository.save(orderEntity);
    }

    @Override
    public void issuanceOfOrder(UUID orderId) {
        OrderEntity orderEntity = repository.findById(orderId).orElseThrow(() ->
                new ResourceNotFoundException("Order with id: " + orderId + " not found"));
        orderEntity.setIssuanceTime(LocalDateTime.now());
        repository.save(orderEntity);
    }


}
