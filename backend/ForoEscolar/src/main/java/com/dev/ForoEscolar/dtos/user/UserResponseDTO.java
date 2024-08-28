package com.dev.ForoEscolar.dtos.user;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


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
