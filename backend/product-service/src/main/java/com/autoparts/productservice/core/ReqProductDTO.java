package com.autoparts.productservice.core;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record ReqProductDTO(@NotNull UUID productId, @Positive Integer amount) { }
