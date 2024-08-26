package com.dev.ForoEscolar.dtos.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DatosAutenticacionUsuario(
        @NotBlank(message = "El correo electrónico es obligatorio")
        @Email(message = "Debe ser una dirección de correo electrónico válida")
        String email,
        @NotBlank(message = "La contraseña es obligatoria")
        @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
        String contrasena
) {
}
