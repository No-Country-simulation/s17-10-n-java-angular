package com.dev.ForoEscolar.mapper.estudiante;

import com.dev.ForoEscolar.dtos.estudiante.EstudianteRequestDTO;
import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.model.estudiante.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EstudianteMapper {

    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    EstudianteResponseDTO toResponseDTO(Estudiante estudiante);
    Estudiante toEntity(EstudianteRequestDTO estudianteRequestDTO);
    EstudianteRequestDTO toRequestDTO(Estudiante estudiante);
}
