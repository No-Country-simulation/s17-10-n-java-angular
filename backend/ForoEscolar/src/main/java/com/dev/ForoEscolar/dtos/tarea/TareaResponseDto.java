package com.dev.ForoEscolar.dtos.tarea;

import com.dev.ForoEscolar.model.Estudiante;
import com.dev.ForoEscolar.model.Profesor;
import com.dev.ForoEscolar.model.Tarea;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private boolean activo;


    private Long profesorId;
    private Long estudianteId;


}
