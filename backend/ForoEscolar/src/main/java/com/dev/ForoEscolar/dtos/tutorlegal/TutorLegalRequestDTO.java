package com.dev.ForoEscolar.dtos.tutorlegal;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.List;


public record TutorLegalRequestDTO(
        @NotNull(message = "El email no puede estar vacío")
        @Email(message = "El email debe ser válido")
        String email,
        @NotNull(message = "El nombre no puede estar vacío")
        String nombre,
        @NotNull(message = "El apellido no puede estar vacío")
        String apellido,
        @NotNull(message = "El DNI no puede estar vacío")
        String dni,
        @NotNull(message = "El tipo de documento no puede estar vacío")
        String tipoDocumento,
        String telefono,
        @NotNull(message = "La contraseña no puede estar vacía")
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
        String contrasena,
        @NotNull(message = "La institucion no puede estar vacío")
        String institucion,
        List<Long> estudiante
) implements Serializable {
}
