package com.dev.ForoEscolar.dtos.asistencia;

import com.dev.ForoEscolar.model.Asistencia;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link Asistencia}
 */
@Value
public class AsistenciaRequestDTO implements Serializable {

    private int contadorAsistencia;
    private double diasAnioEscolar;
    private Date fecha;
    private String estado;
    private String observaciones;
    private Long profesorId; // Solo el ID para la relación
    private Long estudianteId; // Solo el ID para la relación
}
