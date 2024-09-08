package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.enums.MateriaEnum;
import com.dev.ForoEscolar.enums.RoleEnum;
import com.dev.ForoEscolar.exceptions.ApplicationException;
import com.dev.ForoEscolar.mapper.profesor.ProfesorMapper;
import com.dev.ForoEscolar.model.Profesor;
import com.dev.ForoEscolar.repository.ProfesorRepository;
import com.dev.ForoEscolar.services.ProfesorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceImpl extends GenericServiceImpl<Profesor, Long, ProfesorRequestDTO,ProfesorResponseDTO> implements ProfesorService {


    private final ProfesorRepository profesorRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ProfesorMapper profesorMapper;

    @Autowired
    public ProfesorServiceImpl(ProfesorRepository profesorRepository, PasswordEncoder passwordEncoder, ProfesorMapper profesorMapper) {
        this.profesorRepository = profesorRepository;
        this.passwordEncoder = (BCryptPasswordEncoder) passwordEncoder;
        this.profesorMapper = profesorMapper;
    }

    @Transactional
    @Override
    public ProfesorResponseDTO save(ProfesorRequestDTO profesorRequestDTO) {
        try{
            if(profesorRepository.findByEmail(profesorRequestDTO.email()).isPresent()){
                throw new ApplicationException("Profesor con email ya existente: " + profesorRequestDTO.email());
            }
            Profesor newProfesor = profesorMapper.toEntity(profesorRequestDTO);
            newProfesor.setContrasena(passwordEncoder.encode(profesorRequestDTO.contrasena()));
            newProfesor.setRol(RoleEnum.valueOf("PROFESOR"));
            newProfesor.setActivo(true);
            newProfesor = profesorRepository.save(newProfesor);
            return profesorMapper.toResponseDTO(newProfesor);
        }catch (ApplicationException e){
            throw new ApplicationException("Error al guardar el usuario: " + e.getMessage());

        }

    }

    @Override
    public Optional<ProfesorResponseDTO> findById(Long id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        return profesor.map(profesorMapper::toResponseDTO);
    }

    @Override
    public List<ProfesorResponseDTO> findAll() {
        List<Profesor> profesores = profesorRepository.findAll();
        return profesores.stream()
                .map(profesorMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ProfesorResponseDTO update(ProfesorRequestDTO profesorRequestDTO) {
        Profesor profesor = profesorMapper.toEntity(profesorRequestDTO);
        Optional<Profesor> existingEntity = profesorRepository.findById(getEntityId(profesor));
        if (existingEntity.isPresent()) {
            Profesor updatedEntity = profesorRepository.save(profesor);
            return profesorMapper.toResponseDTO(updatedEntity);
        } else {
            throw new ApplicationException("La entidad con ese ID no fue encontrado");
        }
    }

    @Override
    public List<ProfesorResponseDTO> findByMateria(MateriaEnum materia) {
        List<Profesor> profesores = profesorRepository.findByMateria(materia);
        return profesores.stream()
                .map(profesorMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new ApplicationException("Profesor no encontrado"));
        profesorRepository.delete(profesor);
    }


    //Auxiliar para obtener el ID de la entidad
    protected Long getEntityId(Profesor profesor) {
        return profesor.getId();
    }
}
