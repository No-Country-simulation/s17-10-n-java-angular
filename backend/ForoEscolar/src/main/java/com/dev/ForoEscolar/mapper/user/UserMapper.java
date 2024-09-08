package com.dev.ForoEscolar.mapper.user;

import com.dev.ForoEscolar.dtos.user.UserRequestDTO;
import com.dev.ForoEscolar.dtos.user.UserResponseDTO;
import com.dev.ForoEscolar.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDTO toResponseDTO(User user);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rol", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User toEntity(UserRequestDTO userRequestDTO);
    //UserRequestDTO toRequestDTO(User user);
}
