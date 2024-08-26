package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.jwttoken.JWTTokenDTO;
import com.dev.ForoEscolar.dtos.user.DatosAutenticacionUsuario;
import com.dev.ForoEscolar.model.User;
import com.dev.ForoEscolar.services.AutenticacionService;
import com.dev.ForoEscolar.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AutenticacionServiceImpl implements AutenticacionService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Autowired
    public AutenticacionServiceImpl(AuthenticationManager authenticationManager,
                                    TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }


    @Override
    public JWTTokenDTO autenticar(DatosAutenticacionUsuario datosAutenticacionUsuario) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.email(), datosAutenticacionUsuario.contrasena())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = (User) authentication.getPrincipal();
        String token = tokenService.generateToken(user);
        return new JWTTokenDTO(token);
    }


}
