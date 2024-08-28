package com.dev.ForoEscolar.dtos.user;

public record UserRequestDTO (
        String email,
        String nombre,
        String apellido,
        String dni,
        String tipoDocumento,
        String telefono,
        String contrasena,
        String institucion

){
}
