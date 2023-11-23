package com.autoparts.cartservice.core.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record ReqProductDTO(@NotNull UUID userId, @NotNull UUID productId, @Positive Integer amount){}
