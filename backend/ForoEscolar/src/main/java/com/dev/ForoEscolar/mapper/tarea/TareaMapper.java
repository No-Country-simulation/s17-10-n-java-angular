package com.dev.ForoEscolar.mapper.tarea;

import com.dev.ForoEscolar.dtos.tarea.TareaResponseDto;
import com.dev.ForoEscolar.model.Profesor;
import com.dev.ForoEscolar.model.Tarea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper(componentModel = "spring")
public interface TareaMapper {


    @Mapping(source = "profesor.id", target = "profesorId")
    @Mapping(source = "estudiante.id", target = "estudianteId")
    TareaResponseDto toResponseDTO(Tarea tarea);

    @Mapping(source = "profesorId", target = "profesor.id")
    @Mapping(source = "estudianteId", target = "estudiante.id")
    Tarea toEntity(TareaResponseDto tareaRequestDTO);




}
