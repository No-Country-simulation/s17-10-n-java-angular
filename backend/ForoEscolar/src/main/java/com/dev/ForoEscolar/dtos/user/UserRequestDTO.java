package com.dev.ForoEscolar.dtos.user;

import com.dev.ForoEscolar.enums.TipoDocumentoEnum;

public record UserRequestDTO (
        String email,
        String nombre,
        String apellido,
        String dni,
        TipoDocumentoEnum tipoDocumento,
        String telefono,
        String contrasena,
        String institucion

){
}
