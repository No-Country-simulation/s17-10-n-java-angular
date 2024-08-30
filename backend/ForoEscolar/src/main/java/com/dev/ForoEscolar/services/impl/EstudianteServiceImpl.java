package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.mapper.estudiante.EstudianteMapper;
import com.dev.ForoEscolar.model.Estudiante;
import com.dev.ForoEscolar.repository.IEstudianteRepository;
import com.dev.ForoEscolar.services.IEstudianteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements IEstudianteService {

    @Autowired
    private IEstudianteRepository estudianteRepository;

    @Transactional
    @Override
    public EstudianteResponseDTO save(EstudianteResponseDTO estudianteRequestDTO) {
        Estudiante estudiante = EstudianteMapper.INSTANCE.toEntity(estudianteRequestDTO);
        estudianteRepository.save(estudiante);
        return EstudianteMapper.INSTANCE.toResponseDTO(estudiante);
    }

    @Override
    public Optional<EstudianteResponseDTO> findById(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.map(EstudianteMapper.INSTANCE::toResponseDTO);
    }

    @Override
    public List<EstudianteResponseDTO> findAll() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudiantes.stream()
                .map(EstudianteMapper.INSTANCE::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));
        estudianteRepository.delete(estudiante);
    }

    @Transactional
    public EstudianteResponseDTO update(EstudianteResponseDTO estudianteRequestDTO) {
        Estudiante estudiante = EstudianteMapper.INSTANCE.toEntity(estudianteRequestDTO);
        Optional<Estudiante> existingEntity = estudianteRepository.findById(getEntityId(estudiante));
        if (existingEntity.isPresent()) {
            Estudiante updatedEntity = estudianteRepository.save(estudiante);
            return EstudianteMapper.INSTANCE.toResponseDTO(updatedEntity);
        } else {
            throw new RuntimeException("La entidad con ese ID no fue encontrado");
        }
    }

    //Auxiliar para obtener el ID de la entidad
    protected Long getEntityId(Estudiante estudiante) {
        return estudiante.getId();
    }

}
