package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;

public interface EstudianteService extends GenericServiceDto<Long, EstudianteResponseDTO>{

    EstudianteResponseDTO update(EstudianteResponseDTO estudianteRequestDTO);
}
