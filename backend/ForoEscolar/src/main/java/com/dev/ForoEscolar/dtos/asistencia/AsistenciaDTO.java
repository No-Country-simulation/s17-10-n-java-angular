package com.dev.ForoEscolar.dtos.asistencia;

import java.io.Serializable;
import java.time.LocalDate;

public record AsistenciaDTO(
        Long id,
        boolean asistio,
        //double diasAnioEscolar,
        LocalDate fecha,
        String observaciones,
        double porcentajeAsistencia,
        Long profesor,
        Long estudiante
) implements Serializable {
}
