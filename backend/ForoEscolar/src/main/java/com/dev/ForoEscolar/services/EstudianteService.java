package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;


import java.util.List;

public interface EstudianteService extends GenericServiceDto<Long, EstudianteResponseDTO>{

    EstudianteResponseDTO update(EstudianteResponseDTO estudianteRequestDTO);
//    List<EstudianteResponseDTO> findByAula(AulaEnum aulaEnum);
//    List<EstudianteResponseDTO> findByCurso(CursoEnum cursoEnum);

//    List<EstudianteResponseDTO> findByCursoAndAula(CursoEnum curso, AulaEnum aula);


    List<EstudianteResponseDTO> findByGradoId(Long gradoId);
}
