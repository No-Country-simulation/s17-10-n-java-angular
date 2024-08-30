package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.asistencia.AsistenciaRequestDTO;
import com.dev.ForoEscolar.dtos.asistencia.AsistenciaResponseDTO;
import com.dev.ForoEscolar.model.Asistencia;
import com.dev.ForoEscolar.services.AsistenciaService;
import org.springframework.stereotype.Service;

@Service
public class AsistenciaServiceImpl extends GenericServiceImpl<Asistencia, Long, AsistenciaRequestDTO, AsistenciaResponseDTO> implements AsistenciaService {
}
