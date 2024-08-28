package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.jwttoken.JWTTokenDTO;
import com.dev.ForoEscolar.dtos.user.DatosAutenticacionUsuario;
import org.springframework.security.core.userdetails.UserDetails;

public interface AutenticacionService {

    JWTTokenDTO autenticar(DatosAutenticacionUsuario datosAutenticacionUsuario);
}
