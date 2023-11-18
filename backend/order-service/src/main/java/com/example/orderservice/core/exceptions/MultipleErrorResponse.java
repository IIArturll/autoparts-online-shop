package com.example.orderservice.core.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MultipleErrorResponse {
    String errorType;
    @JsonProperty(value = "errors")
    List<ErrorField> errors;

    public MultipleErrorResponse(String errorType) {
        this.errorType=errorType;
        errors = new ArrayList<>();
    }

    public MultipleErrorResponse(List<ErrorField> errors) {
        this.errors = errors;
    }

    public List<ErrorField> getErrors() {
        return errors;
    }

    public void add(ErrorField error) {
        errors.add(error);
    }
}
