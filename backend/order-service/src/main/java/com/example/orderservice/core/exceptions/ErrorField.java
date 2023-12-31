package com.example.orderservice.core.exceptions;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"field", "message",})
public record ErrorField(String field, String message) {
}
