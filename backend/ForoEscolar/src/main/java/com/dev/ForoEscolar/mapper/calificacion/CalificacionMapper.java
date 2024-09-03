package com.dev.ForoEscolar.mapper.calificacion;

import com.dev.ForoEscolar.dtos.calificacion.CalificacionDTO;
import com.dev.ForoEscolar.model.Calificacion;
import org.mapstruct.factory.Mappers;

public interface CalificacionMapper {

    CalificacionMapper INSTANCE = Mappers.getMapper(CalificacionMapper.class);

    Calificacion toEntity(CalificacionDTO calificacionDTO);
    CalificacionDTO toResponseDto(Calificacion calificacion);
}
