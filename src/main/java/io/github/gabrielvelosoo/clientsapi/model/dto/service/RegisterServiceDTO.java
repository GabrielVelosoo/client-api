package io.github.gabrielvelosoo.clientsapi.model.dto.service;

import java.math.BigDecimal;
import java.util.UUID;

public record RegisterServiceDTO(
        String description,
        BigDecimal price,
        UUID clientId
    ) {
}
