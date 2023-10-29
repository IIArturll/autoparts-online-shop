package com.autoparts.cartservice.core;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record AddProductDTO(@NotNull UUID userId, @NotNull UUID productId, @Positive Integer amount){}
