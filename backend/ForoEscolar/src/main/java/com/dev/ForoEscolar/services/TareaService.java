package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.tarea.TareaResponseDto;
import com.dev.ForoEscolar.enums.EstadoEntregaEnum;

import org.springframework.stereotype.Service;

@Service
public interface TareaService extends GenericServiceDto<Long, TareaResponseDto> {

    void updateTarea(TareaResponseDto tareaResponseDto);
    String validarTarea(Long idTarea, EstadoEntregaEnum estadoEntregaEnum);


}
