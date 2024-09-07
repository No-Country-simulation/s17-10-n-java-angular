package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.tarea.TareaResponseDto;
import com.dev.ForoEscolar.enums.EstadoEntregaEnum;
import com.dev.ForoEscolar.model.Tarea;
import org.springframework.stereotype.Service;

@Service
public interface TareaService extends GenericServiceDto<Long, TareaResponseDto> {

    public TareaResponseDto updateTarea(TareaResponseDto tareaResponseDto);
    public String validarTarea(Long idTarea, EstadoEntregaEnum estadoEntregaEnum);





}
