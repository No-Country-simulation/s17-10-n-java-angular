package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.calificacion.CalificacionDTO;
import com.dev.ForoEscolar.model.Calificacion;

public interface CalificacionService extends GenericServiceDto<Calificacion, Long, CalificacionDTO>{

    CalificacionDTO update(CalificacionDTO calificacionDTO);

}
