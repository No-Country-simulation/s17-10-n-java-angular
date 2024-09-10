package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.grado.GradoDto;
import com.dev.ForoEscolar.model.Grado;
import com.dev.ForoEscolar.services.GenericServiceDto;
import org.springframework.stereotype.Service;

@Service
public interface GradoService extends GenericServiceDto<Grado, GradoDto> {
}
