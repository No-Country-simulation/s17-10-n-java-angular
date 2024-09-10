package com.dev.ForoEscolar.dtos.tarea;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TareaRequestDto {

    Long id;

    String descripcion;
    String titulo;

    Timestamp fechaEntrega;
    Long profesorId;
    Long estudianteId;


}
