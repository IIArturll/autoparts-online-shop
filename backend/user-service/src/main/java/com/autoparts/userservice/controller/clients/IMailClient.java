package com.autoparts.userservice.controller.clients;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "mail-service", path = "/mail")
public interface IMailClient {

    @PostMapping(value = "/send/email/{email}")
    ResponseEntity<?> sendSimpleEmail(@NotBlank @Email @PathVariable("email") String email);

    @GetMapping(value = "/verification/email/{email}/code/{code}")
    ResponseEntity<Boolean> verify(@NotBlank @Email @PathVariable("email") String email,
                                   @NotBlank @PathVariable("code") String code);

}
