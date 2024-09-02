package com.dev.ForoEscolar.dtos.tutorlegal;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.List;


public record TutorLegalRequestDTO(
        @NotNull(message = "El email no puede estar vacío")
        String email,
        String nombre,
        String apellido,
        String dni,
        String tipoDocumento,
        String telefono,
        String contrasena,
        String institucion,
        List<Long> estudianteIds
) implements Serializable {
}
