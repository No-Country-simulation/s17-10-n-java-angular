package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.user.UserRequestDTO;
import com.dev.ForoEscolar.dtos.user.UserResponseDTO;
import com.dev.ForoEscolar.enums.RoleEnum;
import com.dev.ForoEscolar.exceptions.ApplicationException;
import com.dev.ForoEscolar.mapper.user.UserMapper;
import com.dev.ForoEscolar.model.User;
import com.dev.ForoEscolar.repository.UserRepository;
import com.dev.ForoEscolar.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = (BCryptPasswordEncoder) passwordEncoder;
    }

    @Override
    public Optional<UserResponseDTO> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return Optional.ofNullable(UserMapper.INSTANCE.toResponseDTO(user.get()));
        }else{
            throw new ApplicationException("Usuario no encontrado");
        }
    }

    @Override
    @Transactional
    public UserResponseDTO save(UserRequestDTO user) {
        try {
            if(userRepository.existsByEmail(user.email())) {
                throw new ApplicationException("Usuario con email ya existente: " + user.email());
            }
            User newUser = UserMapper.INSTANCE.toEntity(user);
            newUser.setContrasena(passwordEncoder.encode(user.contrasena()));
            newUser.setRol(RoleEnum.valueOf("ADMINISTRADOR"));
            newUser.setActivo(true);
            newUser = userRepository.save(newUser);
            return UserMapper.INSTANCE.toResponseDTO(newUser);
        } catch (ApplicationException e) {
            throw new ApplicationException("Error al guardar el usuario: " + e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            user.get().setActivo(false);
        }else{
            throw new ApplicationException("Usuario no encontrado");
        }
    }
    @Override
    public Iterable<UserResponseDTO> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper.INSTANCE::toResponseDTO)
                .toList();
    }


    @Override
    public UserResponseDTO findByEmail(String username){
       User user= userRepository.findByEmail(username).orElse(null);
       return  UserMapper.INSTANCE.toResponseDTO(user);
    }
}
