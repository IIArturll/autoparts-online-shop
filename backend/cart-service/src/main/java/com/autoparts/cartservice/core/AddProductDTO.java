package com.autoparts.cartservice.core;

import java.util.UUID;

public record AddProductDTO(UUID userId, UUID productId, Integer amount) {
}
