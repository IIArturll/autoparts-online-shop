package com.autoparts.cartservice.core.mappers;


import com.autoparts.cartservice.entity.user.UserEntity;
import com.autoparts.cartservice.security.MyUserDetails;

public class UserMapper {
    public static MyUserDetails convertToUserDetails(UserEntity e) {
        return new MyUserDetails(e.getId(), e.getEmail(), e.getPassword(),
                e.getRole().getRole(), e.getStatus().getStatus());
    }
}
