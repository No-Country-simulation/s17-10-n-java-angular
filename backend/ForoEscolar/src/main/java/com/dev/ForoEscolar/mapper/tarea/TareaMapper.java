package com.dev.ForoEscolar.mapper.tarea;

import com.dev.ForoEscolar.dtos.Tarea.TareaResponseDto;
import com.dev.ForoEscolar.model.Tarea;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TareaMapper {

    TareaMapper INSTANCE= Mappers.getMapper(TareaMapper.class);

    TareaResponseDto toResponseDTO(Tarea tarea);
    Tarea toEntity(TareaResponseDto tareaRequestDTO);
    //TareaRequestDto toRequestDTO(Tarea tarea);



}
