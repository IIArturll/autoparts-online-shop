package com.autoparts.userservice.core.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.UUID;

public class UserDto {

    private UUID id;

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$",
            message = "illegal format of email,correct example: email@mail.ru , google@gmail.com")
    private String email;

    @NotNull
    @NotBlank
    private String firstname;

    @NotNull
    @NotBlank
    private String lastname;

    @NotNull
    @NotBlank
    private String phone;

    public UserDto() {
    }

    public UserDto(UUID id, String email, String firstname, String lastname, String phone) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public UserDto(String email, String firstname, String lastname, String phone) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
