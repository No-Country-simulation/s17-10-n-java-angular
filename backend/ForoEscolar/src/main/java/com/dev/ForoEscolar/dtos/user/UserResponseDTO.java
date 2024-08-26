package com.dev.ForoEscolar.dtos.user;

public record UserResponseDTO(
        Long id,
        String email,
        String nombre,
        String tipoDocumento,
        String dni,
        String apellido,
        String telefono,
        String institucion,
        String rol,
        boolean activo
) {
}
