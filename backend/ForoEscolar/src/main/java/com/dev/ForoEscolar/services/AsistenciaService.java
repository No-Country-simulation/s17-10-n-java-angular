package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.asistencia.AsistenciaDTO;

public interface AsistenciaService extends GenericServiceDto<Long, AsistenciaDTO>{

    AsistenciaDTO update(AsistenciaDTO asistenciaDTO);
}
