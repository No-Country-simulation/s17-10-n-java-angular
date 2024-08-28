package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.estudiante.EstudianteRequestDTO;
import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.model.estudiante.Estudiante;

public interface IEstudianteService extends GenericService<Estudiante, Long, EstudianteRequestDTO, EstudianteResponseDTO>{
}
