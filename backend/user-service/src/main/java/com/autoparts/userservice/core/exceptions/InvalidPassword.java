package com.autoparts.userservice.core.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"cause", "localizedMessage", "stackTrace", "suppressed"})
public class InvalidPassword extends RuntimeException{
    public InvalidPassword(String message) {
        super(message);
    }
}
