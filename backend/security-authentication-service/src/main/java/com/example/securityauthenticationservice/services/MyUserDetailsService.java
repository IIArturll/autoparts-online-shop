package com.example.securityauthenticationservice.services;

import com.example.securityauthenticationservice.controllers.client.IUserClient;
import com.example.securityauthenticationservice.core.dtos.MyUserDetails;
import com.example.securityauthenticationservice.core.exceptions.ResourceNotFoundException;
import com.example.securityauthenticationservice.core.mappers.UserMapper;
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
                .orElseThrow(() -> new ResourceNotFoundException("user with this email not found")));
    }
}
