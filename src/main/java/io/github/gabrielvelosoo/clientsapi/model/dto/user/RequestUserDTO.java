package io.github.gabrielvelosoo.clientsapi.model.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestUserDTO(
        @NotBlank(message = "Required field")
        @Size(min = 5, max = 255, message = "Field outside standard size")
        String username,
        @NotBlank(message = "Required field")
        @Size(min = 5, max = 100, message = "Field outside standard size")
        String password
    ) {
}
