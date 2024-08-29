package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.model.Profesor;

public interface IProfesorService extends GenericService<Profesor, Long, ProfesorRequestDTO,ProfesorResponseDTO>{
}
