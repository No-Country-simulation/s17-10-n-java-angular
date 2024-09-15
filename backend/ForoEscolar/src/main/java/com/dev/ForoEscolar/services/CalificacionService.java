package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.calificacion.CalificacionDTO;
import com.dev.ForoEscolar.enums.MateriaEnum;

import java.util.List;


public interface CalificacionService extends GenericServiceDto<Long, CalificacionDTO>{

    CalificacionDTO update(CalificacionDTO calificacionDTO);

    List<CalificacionDTO> findByEstudianteId(Long estudianteId);

    List<CalificacionDTO> findByMateria(MateriaEnum materiaEnum);

}
