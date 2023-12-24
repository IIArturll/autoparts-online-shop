package com.example.orderservice.security;

import com.example.orderservice.controllers.clients.IUserClient;
import com.example.orderservice.core.exceptions.ResourceNotFoundException;
import com.example.orderservice.core.mappers.UserMapper;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {
    private final IUserClient client;

    public MyUserDetailsService(IUserClient client) {
        this.client = client;
    }

    @Override
    public MyUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return UserMapper.convertToUserDetails(client.getByEmail(email).getBody()
                .orElseThrow(() -> new ResourceNotFoundException("User with this email not found")));
    }
}
