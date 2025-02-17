package io.github.gabrielvelosoo.clientsapi.model.mapper;

import io.github.gabrielvelosoo.clientsapi.model.dto.service.RegisterServiceDTO;
import io.github.gabrielvelosoo.clientsapi.model.dto.service.ResultSearchServiceDTO;
import io.github.gabrielvelosoo.clientsapi.model.entity.ProvidedService;
import io.github.gabrielvelosoo.clientsapi.model.repository.ClientRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = ClientMapper.class)
public abstract class ServiceMapper {

    @Autowired
    ClientRepository clientRepository;

    @Mapping(target = "client", expression = "java( clientRepository.findById(serviceDTO.clientId()).orElse(null) )")
    public abstract ProvidedService toEntity(RegisterServiceDTO serviceDTO);
    public abstract ResultSearchServiceDTO toDTO(ProvidedService service);
}
