package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.jwttoken.JWTTokenDTO;
import com.dev.ForoEscolar.dtos.user.DatosAutenticacionUsuario;

public interface AutenticacionService {

    JWTTokenDTO autenticar(DatosAutenticacionUsuario datosAutenticacionUsuario);
}
