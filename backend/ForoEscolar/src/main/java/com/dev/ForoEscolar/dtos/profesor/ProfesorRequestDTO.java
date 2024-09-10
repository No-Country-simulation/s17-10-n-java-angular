package com.dev.ForoEscolar.dtos.profesor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;


public record ProfesorRequestDTO (
        Long id,
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
        @NotNull(message = "El telefono no puede estar vacío")
        String telefono,
        @NotNull(message = "La contraseña no puede estar vacía")
        @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
        String contrasena,
        @NotNull(message = "El institucion no puede estar vacío")
        String institucion,
        @NotNull(message = "La materia no puede estar vacía")
        String materia,
        List<Long> estudianteIds,
        List<Long> boletinIds,
        List<Long> asistenciaIds,
        List<Long> tareaIds,
        List<Long> calificacionIds,
        List<Long> gradoIds

){

}
