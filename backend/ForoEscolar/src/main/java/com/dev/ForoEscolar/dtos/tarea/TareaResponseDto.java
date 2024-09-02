package com.dev.ForoEscolar.dtos.tarea;

import lombok.*;

import java.sql.Timestamp;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TareaResponseDto {

    Long id;
    String descripcion;
    String titulo;
    Timestamp fechaEntrega;
    Long profesorId;
    Long estudianteId;
}
