package com.dev.ForoEscolar.mapper.profesor;

import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.model.Profesor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface ProfesorMapper {

    ProfesorMapper INSTANCE = Mappers.getMapper(ProfesorMapper.class);

    @Mapping(target = "estudianteIds", ignore = true)
    ProfesorResponseDTO toResponseDTO(Profesor profesor);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rol", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "estudiantes", ignore = true)
    @Mapping(target = "tarea", ignore = true)
    @Mapping(target = "calificaciones", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    Profesor toEntity(ProfesorRequestDTO profesorRequestDTO);

    @Mapping(target = "estudianteIds", ignore = true)
    ProfesorRequestDTO toRequestDTO(Profesor profesor);
}