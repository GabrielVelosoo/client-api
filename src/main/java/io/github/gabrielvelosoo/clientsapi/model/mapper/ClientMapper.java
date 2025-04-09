package io.github.gabrielvelosoo.clientsapi.model.mapper;

import io.github.gabrielvelosoo.clientsapi.model.dto.client.RegisterClientDTO;
import io.github.gabrielvelosoo.clientsapi.model.dto.client.ResultSearchClientDTO;
import io.github.gabrielvelosoo.clientsapi.model.entity.Client;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    Client toEntity(RegisterClientDTO clientDTO);
    ResultSearchClientDTO toDTO(Client client);
    List<ResultSearchClientDTO> toDTOs(List<Client> clients);
}
