package com.dev.ForoEscolar.mapper.profesor;

import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.model.Profesor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProfesorMapper {

    ProfesorMapper INSTANCE = Mappers.getMapper(ProfesorMapper.class);

    ProfesorResponseDTO toResponseDTO(Profesor profesor);
    Profesor toEntity(ProfesorRequestDTO profesorRequestDTO);
    ProfesorRequestDTO toRequestDTO(Profesor profesor);
}