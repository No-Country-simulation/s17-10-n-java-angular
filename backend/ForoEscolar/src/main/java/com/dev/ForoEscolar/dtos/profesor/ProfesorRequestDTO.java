package com.dev.ForoEscolar.dtos.profesor;

import jakarta.validation.constraints.NotNull;
import java.util.List;


public record ProfesorRequestDTO (
        @NotNull(message = "El email no puede estar vacío")
        String email,
        String nombre,
        String apellido,
        String dni,
        String tipoDocumento,
        String telefono,
        String contrasena,
        String institucion,
        @NotNull(message = "La materia no puede estar vacía")
        String materia,
        List<Long> estudianteIds,
        List<Long> boletinIds,
        List<Long> asistenciaIds,
        List<Long> tareaIds,
        List<Long> calificacionIds
){

}
