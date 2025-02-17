package io.github.gabrielvelosoo.clientsapi.model.dto.service;

import io.github.gabrielvelosoo.clientsapi.model.entity.Client;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ResultSearchServiceDTO(
        UUID id,
        String description,
        BigDecimal price,
        Client client,
        LocalDateTime registrationDate,
        LocalDateTime updatedDate
    ) {
}
