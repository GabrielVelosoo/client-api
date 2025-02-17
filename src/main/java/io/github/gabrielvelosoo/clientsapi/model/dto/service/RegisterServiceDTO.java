package io.github.gabrielvelosoo.clientsapi.model.dto.service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record RegisterServiceDTO(
        @NotBlank(message = "Required field")
        @Size(min = 5, max = 255, message = "Field outside standard size")
        String description,
        @NotBlank(message = "Required field")
        BigDecimal price,
        @NotBlank(message = "Required field")
        UUID clientId
    ) {
}
