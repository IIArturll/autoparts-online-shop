package com.autoparts.cartservice.core;

import java.util.UUID;

public record AddReq(UUID userId, UUID productId, Integer amount) {
}
