package io.github.gabrielvelosoo.clientsapi.model.dto.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public record RegisterClientDTO(
        @NotBlank(message = "Required field")
        @Size(min = 2, max = 100, message = "Field outside standard size")
        String name,
        @NotBlank(message = "Required field")
        @CPF(message = "Invalid field")
        String cpf
    ) {
}
