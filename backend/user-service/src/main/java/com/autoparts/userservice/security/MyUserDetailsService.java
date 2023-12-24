package com.autoparts.userservice.security;

import com.autoparts.userservice.core.exceptions.ResourceNotFoundException;
import com.autoparts.userservice.core.mappers.UserMapper;
import com.autoparts.userservice.service.MicroUserService;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {
    private final MicroUserService service;

    public MyUserDetailsService(MicroUserService service) {
        this.service = service;
    }

    @Override
    public MyUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return UserMapper.convertToUserDetails(service.getByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User with this email not found")));
    }
}
