package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.user.UserRequestDTO;
import com.dev.ForoEscolar.dtos.user.UserResponseDTO;
import com.dev.ForoEscolar.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService extends GenericService<User, Long, UserRequestDTO ,UserResponseDTO>{

    Optional<UserResponseDTO> findById(Long id);
    UserResponseDTO save(UserRequestDTO user);
    void deleteById(Long id);
    Iterable<UserResponseDTO> findAll();
    UserResponseDTO findByEmail(String email);
}
