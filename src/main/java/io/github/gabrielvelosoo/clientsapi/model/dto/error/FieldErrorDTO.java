package io.github.gabrielvelosoo.clientsapi.model.dto.error;

public record FieldErrorDTO(
        String field,
        String message
    ) {
}
