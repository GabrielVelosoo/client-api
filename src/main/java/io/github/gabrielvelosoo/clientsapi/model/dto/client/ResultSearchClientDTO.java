package io.github.gabrielvelosoo.clientsapi.model.dto.client;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResultSearchClientDTO(
        UUID id,
        String nome,
        String cpf,
        LocalDateTime registrationDate,
        LocalDateTime updatedDate
    ) {
}
