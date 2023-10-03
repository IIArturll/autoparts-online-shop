package com.autoparts.productservice.core.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

@JsonIgnoreProperties(value = {"cause", "localizedMessage", "stackTrace", "suppressed"})
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
