package com.dev.ForoEscolar.dtos.asistencia;

import com.dev.ForoEscolar.model.Asistencia;
import com.dev.ForoEscolar.model.Estudiante;
import com.dev.ForoEscolar.model.Profesor;
import jakarta.validation.constraints.NotNull;
import lombok.Value;
import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link Asistencia}
 */
@Value
public class AsistenciaResponseDTO implements Serializable {
    int contadorAsistencia;
    double diasAnioEscolar;
    Date fecha;
    String estado;
    String observaciones;
    Profesor profesorId;
    Estudiante estudianteId;
}