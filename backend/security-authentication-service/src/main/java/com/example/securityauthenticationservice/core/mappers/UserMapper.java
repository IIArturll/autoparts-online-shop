package com.example.securityauthenticationservice.core.mappers;

import com.example.securityauthenticationservice.core.dtos.MyUserDetails;
import com.example.securityauthenticationservice.entity.UserEntity;

public class UserMapper {
    public static MyUserDetails convertToUserDetails(UserEntity e) {
        return new MyUserDetails(e.getId(), e.getEmail(), e.getPassword(),
                e.getRole().getRole(), e.getStatus().getStatus());
    }
}
