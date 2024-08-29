package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.model.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface TokenService {

    boolean validateToken(String token, UserDetails userDetails);
    String generateToken(User user);
    String getUsernameFromToken(String token);
}
