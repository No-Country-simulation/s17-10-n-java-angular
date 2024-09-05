package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.tutorlegal.TutorLegalRequestDTO;
import com.dev.ForoEscolar.dtos.tutorlegal.TutorLegalResponseDTO;
import com.dev.ForoEscolar.enums.RoleEnum;
import com.dev.ForoEscolar.exceptions.ApplicationException;
import com.dev.ForoEscolar.mapper.tutorlegal.TutorLegalMapper;
import com.dev.ForoEscolar.model.TutorLegal;
import com.dev.ForoEscolar.repository.TutorLegalRepository;
import com.dev.ForoEscolar.services.TutorLegalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TutorLegalServiceImpl implements TutorLegalService {

    private final TutorLegalRepository tutorLegalRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TutorLegalMapper tutorLegalMapper;

    @Autowired
    public TutorLegalServiceImpl(TutorLegalRepository tutorLegalRepository, PasswordEncoder passwordEncoder, TutorLegalMapper tutorLegalMapper) {
        this.tutorLegalRepository = tutorLegalRepository;
        this.passwordEncoder = (BCryptPasswordEncoder) passwordEncoder;
        this.tutorLegalMapper = tutorLegalMapper;
    }

    @Transactional
    @Override
    public TutorLegalResponseDTO save(TutorLegalRequestDTO tutorLegalRequestDTO) {
        try{
            if(tutorLegalRepository.findByEmail(tutorLegalRequestDTO.email()).isPresent()){
                throw new ApplicationException("Tutor legal con email ya existente: " + tutorLegalRequestDTO.email());
            }
            TutorLegal newTutorLegal = TutorLegalMapper.INSTANCE.toEntity(tutorLegalRequestDTO);
            newTutorLegal.setContrasena(passwordEncoder.encode(tutorLegalRequestDTO.contrasena()));
            newTutorLegal.setRol(RoleEnum.valueOf("TUTOR"));
            newTutorLegal.setActivo(true);
            newTutorLegal = tutorLegalRepository.save(newTutorLegal);
            return tutorLegalMapper.toResponseDTO(newTutorLegal);
        }catch (ApplicationException e){
            throw new ApplicationException("Error al guardar el usuario: " + e.getMessage());
        }
    }

    @Override
    public Optional<TutorLegalResponseDTO> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public TutorLegalResponseDTO update(TutorLegalResponseDTO tutorLegalRequestDTO) {
        return null;
    }





    @Override
    public Iterable<TutorLegalResponseDTO> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
