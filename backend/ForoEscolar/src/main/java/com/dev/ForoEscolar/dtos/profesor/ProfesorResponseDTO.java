package com.dev.ForoEscolar.dtos.profesor;

import java.io.Serializable;
import java.util.List;

public record ProfesorResponseDTO(
        Long id,
        String email,
        String nombre,
        String tipoDocumento,
        String dni,
        String apellido,
        String telefono,
        String institucion,
        String rol,
        boolean activo,
        String materia,
        List<Long> estudianteIds,
        List<Long> boletinIds,
        List<Long> asistenciaIds,
        List<Long> tareaIds,
        List<Long> calificacionIds,
        List<Long> gradoIds
) implements Serializable {
}
