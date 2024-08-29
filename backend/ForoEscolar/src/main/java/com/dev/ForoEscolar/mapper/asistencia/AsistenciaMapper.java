package com.dev.ForoEscolar.mapper.asistencia;

import com.dev.ForoEscolar.model.Asistencia;
import org.mapstruct.factory.Mappers;

public interface AsistenciaMapper {

    AsistenciaMapper INSTANCE = Mappers.getMapper(AsistenciaMapper.class);

    AsistenciaResponseDTO toResponseDTO(Asistencia asistencia);
    Asistencia toEntity(AsistenciaRequestDTO asistenciaRequestDTO);
    AsistenciaResquestDTO toRequestDTO(Asistencia asistencia);
}
