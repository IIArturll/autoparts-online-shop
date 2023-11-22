package com.example.securityauthenticationservice.services.api;

import com.example.securityauthenticationservice.core.dtos.UserLoginDTO;

public interface IAuthenticationService {
    String login(UserLoginDTO user);
}
