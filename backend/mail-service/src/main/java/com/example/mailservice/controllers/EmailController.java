package com.example.mailservice.controllers;

import com.example.mailservice.services.api.ISenderService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class EmailController {

    private final ISenderService senderService;

    public EmailController(ISenderService senderService) {
        this.senderService = senderService;
    }

    @PostMapping(value = "/send/email/{email}")
    public ResponseEntity<?> sendSimpleEmail(@NotBlank @Email @PathVariable("email") String email) {
        senderService.send(email);
        return ResponseEntity.status(200).build();
    }

    @GetMapping(value = "/verification/email/{email}/code/{code}")
    public ResponseEntity<Boolean> verify(@NotBlank @Email @PathVariable("email") String email,
                                          @NotBlank @PathVariable("code") String code) {
        return ResponseEntity.status(200).body(senderService.verify(email, code));
    }
}