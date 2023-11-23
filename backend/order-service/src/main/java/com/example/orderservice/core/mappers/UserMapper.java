package com.example.orderservice.core.mappers;

import com.example.orderservice.entity.user.UserEntity;
import com.example.orderservice.security.MyUserDetails;

public class UserMapper {
    public static MyUserDetails convertToUserDetails(UserEntity e) {
        return new MyUserDetails(e.getId(), e.getEmail(), e.getPassword(),
                e.getRole().getRole(), e.getStatus().getStatus());
    }
}