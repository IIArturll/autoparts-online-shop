package com.autoparts.userservice.core.mappers;

import com.autoparts.userservice.entity.UserEntity;
import com.autoparts.userservice.security.MyUserDetails;

public class UserMapper {
    public static MyUserDetails convertToUserDetails(UserEntity e) {
        return new MyUserDetails(e.getId(), e.getEmail(), e.getPassword(),
                e.getRole().getRole(), e.getStatus().getStatus());
    }
}
