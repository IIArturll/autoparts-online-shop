package com.autoparts.productservice.core.mappers;


import com.autoparts.productservice.entity.user.UserEntity;
import com.autoparts.productservice.security.MyUserDetails;

public class UserMapper {
    public static MyUserDetails convertToUserDetails(UserEntity e) {
        return new MyUserDetails(e.getId(), e.getEmail(), e.getPassword(),
                e.getRole().getRole(), e.getStatus().getStatus());
    }
}
