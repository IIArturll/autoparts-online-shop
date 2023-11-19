package com.autoparts.cartservice.services;

import com.autoparts.cartservice.controllers.clients.IProductClient;
import com.autoparts.cartservice.controllers.clients.IUserClient;
import com.autoparts.cartservice.core.ReqProductDTO;
import com.autoparts.cartservice.core.CartDTO;
import com.autoparts.cartservice.core.CartMapper;
import com.autoparts.cartservice.core.exceptions.ResourceNotFoundException;
import com.autoparts.cartservice.entity.CartEntity;
import com.autoparts.cartservice.entity.product.ProductEntity;
import com.autoparts.cartservice.entity.user.UserEntity;
import com.autoparts.cartservice.repositories.ICartRepository;
import com.autoparts.cartservice.services.api.ICartService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class CartService implements ICartService {
    private final ICartRepository repository;
    private final IProductClient productClient;
    private final IUserClient userClient;

    public CartService(ICartRepository repository, IProductClient productClient,
                       IUserClient userClient) {
        this.repository = repository;
        this.productClient = productClient;
        this.userClient = userClient;
    }

    @Override
    public CartDTO get(UUID user) {
        UserEntity userEntity = userClient.get(user).getBody()
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + user + ", not found"));
        CartEntity cartEntity = repository.findByUserId(user).orElseGet(() -> {
            CartEntity entity = new CartEntity(userEntity);
            return repository.save(entity);
        });
        return CartMapper.convertCartEntityToDTO(cartEntity);
    }

    @Override
    public void add(ReqProductDTO req) {
        ProductEntity product = productClient.getCard(req.productId()).getBody()
                .orElseThrow(() -> new ResourceNotFoundException("Product with id: " + req.productId() + ", not found"));
        UserEntity user = userClient.get(req.userId()).getBody()
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + req.userId() + ", not found"));
        CartEntity cartEntity = repository.findByUserId(user.getId()).orElseGet(() -> new CartEntity(user));
        cartEntity.add(product, req.amount());
        repository.save(cartEntity);
    }

    @Override
    public void delete(ReqProductDTO req) {
        UserEntity user = userClient.get(req.userId()).getBody()
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + req.userId() + ", not found"));
        ProductEntity product = productClient.getCard(req.productId()).getBody()
                .orElseThrow(() -> new ResourceNotFoundException("Product with id: " + req.productId() + ", not found"));
        CartEntity cartEntity = repository.findByUserId(user.getId()).orElseGet(() -> new CartEntity(user));
        cartEntity.delete(product,req.amount());
        repository.save(cartEntity);
    }
}
