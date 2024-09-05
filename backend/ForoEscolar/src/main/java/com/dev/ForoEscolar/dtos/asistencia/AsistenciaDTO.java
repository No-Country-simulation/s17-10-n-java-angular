package com.dev.ForoEscolar.dtos.asistencia;

import java.io.Serializable;
import java.time.LocalDate;

public record AsistenciaDTO(
        Long id,
        int contadorAsistencia,
        double diasAnioEscolar,
        LocalDate fecha,
        String estado,
        String observaciones,
        Long profesor,
        Long estudiante
) implements Serializable {
}
