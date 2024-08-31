package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.mapper.profesor.ProfesorMapper;
import com.dev.ForoEscolar.model.Profesor;
import com.dev.ForoEscolar.repository.IProfesorRepository;
import com.dev.ForoEscolar.services.IProfesorService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfesorServiceImpl extends GenericServiceImpl<Profesor, Long, ProfesorRequestDTO,ProfesorResponseDTO> implements IProfesorService {

    @Autowired
    private IProfesorRepository profesorRepository;

    @Transactional
    @Override
    public ProfesorResponseDTO save(ProfesorRequestDTO profesorRequestDTO) {
        Profesor profesor = ProfesorMapper.INSTANCE.toEntity(profesorRequestDTO);
        profesorRepository.save(profesor);
        return ProfesorMapper.INSTANCE.toResponseDto(profesor);
    }

    @Override
    public Optional<ProfesorResponseDTO> findById(Long id) {
        Optional<Profesor> profesor = profesorRepository.findById(id);
        return profesor.map(ProfesorMapper.INSTANCE::toResponseDto);
    }

    @Override
    public List<ProfesorResponseDTO> findAll() {
        List<Profesor> profesores = profesorRepository.findAll();
        return profesores.stream()
                .map(ProfesorMapper.INSTANCE::toResponseDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public ProfesorResponseDTO update(ProfesorRequestDTO profesorRequestDTO) {
        Profesor profesor = ProfesorMapper.INSTANCE.toEntity(profesorRequestDTO);
        Optional<Profesor> existingEntity = profesorRepository.findById(getEntityId(profesor));
        if (existingEntity.isPresent()) {
            Profesor updatedEntity = profesorRepository.save(profesor);
            return ProfesorMapper.INSTANCE.toResponseDto(updatedEntity);
        } else {
            throw new RuntimeException("La entidad con ese ID no fue encontrado");
        }
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Profesor profesor = profesorRepository.findById(id).orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        profesorRepository.delete(profesor);
    }

    //Auxiliar para obtener el ID de la entidad
    protected Long getEntityId(Profesor profesor) {
        return profesor.getId();
    }
}
