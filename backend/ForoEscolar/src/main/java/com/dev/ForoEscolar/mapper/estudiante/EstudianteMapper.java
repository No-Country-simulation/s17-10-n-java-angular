package com.dev.ForoEscolar.mapper.estudiante;

import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.model.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstudianteMapper {

    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    EstudianteResponseDTO toResponseDTO(Estudiante estudiante);
    Estudiante toEntity(EstudianteResponseDTO estudianteRequestDTO);
    //EstudianteRequestDTO toRequestDTO(Estudiante estudiante);
}
