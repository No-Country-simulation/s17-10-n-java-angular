package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.calificacion.CalificacionDTO;


public interface CalificacionService extends GenericServiceDto<Long, CalificacionDTO>{

    CalificacionDTO update(CalificacionDTO calificacionDTO);

}
