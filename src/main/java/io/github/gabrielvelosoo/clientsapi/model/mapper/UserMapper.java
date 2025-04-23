package io.github.gabrielvelosoo.clientsapi.model.mapper;

import io.github.gabrielvelosoo.clientsapi.model.dto.user.RequestUserDTO;
import io.github.gabrielvelosoo.clientsapi.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(RequestUserDTO dto);
}
