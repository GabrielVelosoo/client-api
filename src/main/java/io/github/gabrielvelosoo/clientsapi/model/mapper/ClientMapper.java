package io.github.gabrielvelosoo.clientsapi.model.mapper;

import io.github.gabrielvelosoo.clientsapi.model.dto.client.RegisterClientDTO;
import io.github.gabrielvelosoo.clientsapi.model.dto.client.ResultSearchClientDTO;
import io.github.gabrielvelosoo.clientsapi.model.entity.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(RegisterClientDTO clientDTO);
    ResultSearchClientDTO toDTO(Client client);
}
