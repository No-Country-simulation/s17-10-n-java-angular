package com.dev.ForoEscolar.mapper.tarea;

import com.dev.ForoEscolar.dtos.Tarea.TareaRequestDto;
import com.dev.ForoEscolar.dtos.Tarea.TareaResponseDto;
import com.dev.ForoEscolar.dtos.user.UserRequestDTO;
import com.dev.ForoEscolar.dtos.user.UserResponseDTO;
import com.dev.ForoEscolar.model.Tarea;
import com.dev.ForoEscolar.model.User;
import org.mapstruct.factory.Mappers;

public interface TareaMapper {

    TareaMapper INSTANCE= Mappers.getMapper(TareaMapper.class);

    TareaResponseDto toResponseDTO(Tarea tarea);
    Tarea toEntity(TareaResponseDto tareaRequestDTO);
    //TareaRequestDto toRequestDTO(Tarea tarea);



}
