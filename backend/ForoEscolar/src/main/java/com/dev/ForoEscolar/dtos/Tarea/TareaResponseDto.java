package com.dev.ForoEscolar.dtos.Tarea;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TareaResponseDto {

    private Long id;
    private String descripcion;
    private String titulo;
    private Date fechaEntrega;
    private Long profesorId;
    private Long estudianteId;
}
