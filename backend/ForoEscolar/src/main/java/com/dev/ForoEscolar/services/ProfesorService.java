package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.model.Profesor;

public interface ProfesorService extends GenericService<Profesor, Long, ProfesorRequestDTO,ProfesorResponseDTO>{

    ProfesorResponseDTO update(ProfesorRequestDTO profesorRequestDTO);
}
