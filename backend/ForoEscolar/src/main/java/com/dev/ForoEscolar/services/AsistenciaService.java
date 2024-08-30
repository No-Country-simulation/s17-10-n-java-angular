package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.asistencia.AsistenciaRequestDTO;
import com.dev.ForoEscolar.dtos.asistencia.AsistenciaResponseDTO;
import com.dev.ForoEscolar.model.Asistencia;

public interface AsistenciaService extends GenericService<Asistencia, Long, AsistenciaRequestDTO, AsistenciaResponseDTO> {

    AsistenciaResponseDTO update(AsistenciaRequestDTO asistenciaRequestDTO);

}
