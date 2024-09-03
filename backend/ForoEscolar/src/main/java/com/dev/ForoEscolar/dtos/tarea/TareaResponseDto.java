package com.dev.ForoEscolar.dtos.tarea;

import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TareaResponseDto {

    private Long id;
    private String descripcion;
    private String titulo;
    private Date fechaEntrega;
    private Long profesorId;
    private Long estudianteId;
}
