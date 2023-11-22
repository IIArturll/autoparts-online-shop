package com.example.securityauthenticationservice.services;

import com.example.securityauthenticationservice.controllers.client.IUserClient;
import com.example.securityauthenticationservice.core.dtos.MyUserDetails;
import com.example.securityauthenticationservice.core.dtos.UserLoginDTO;
import com.example.securityauthenticationservice.core.enums.Status;
import com.example.securityauthenticationservice.core.exceptions.InvalidPassword;
import com.example.securityauthenticationservice.core.exceptions.ResourceNotFoundException;
import com.example.securityauthenticationservice.entity.UserEntity;
import com.example.securityauthenticationservice.jwt.JwtTokenUtil;
import com.example.securityauthenticationservice.services.api.IAuthenticationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService implements IAuthenticationService {
    private final IUserClient client;
    private final PasswordEncoder encoder;
    private final JwtTokenUtil tokenUtil;
    private final MyUserDetailsService userDetailsService;

    public AuthenticationService(IUserClient client, PasswordEncoder encoder,
                                 JwtTokenUtil tokenUtil, MyUserDetailsService userDetailsService) {
        this.client = client;
        this.encoder = encoder;
        this.tokenUtil = tokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public String login(UserLoginDTO user) {
        UserEntity entity = client.getByEmail(user.getEmail()).getBody().orElseThrow(() ->
                new ResourceNotFoundException("user with email: " + user.getEmail()
                        + " not found"));
        if (entity.getStatus().getStatus() == Status.WAITING_ACTIVATION) {
            throw new ResourceNotFoundException("authorization is not available," +
                    " the account is not verified");
        }
        if (encoder.matches(user.getPassword(), entity.getPassword())) {
            MyUserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
            return tokenUtil.generateToken(userDetails);
        } else {
            throw new InvalidPassword("Invalid password");
        }
    }
}
