package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.model.Estudiante;

public interface EstudianteService extends GenericServiceDto<Estudiante, Long, EstudianteResponseDTO>{

    EstudianteResponseDTO update(EstudianteResponseDTO estudianteRequestDTO);
}
