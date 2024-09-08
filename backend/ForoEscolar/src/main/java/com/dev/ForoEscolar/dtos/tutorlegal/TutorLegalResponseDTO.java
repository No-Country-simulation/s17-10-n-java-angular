package com.dev.ForoEscolar.dtos.tutorlegal;

import java.io.Serializable;
import java.util.List;

public record TutorLegalResponseDTO(
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
        List<Long> estudiante
) implements Serializable {
}
