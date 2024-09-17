package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.RoleEnum;
import com.dev.ForoEscolar.exceptions.ApplicationException;
import com.dev.ForoEscolar.mapper.estudiante.EstudianteMapper;
import com.dev.ForoEscolar.model.Estudiante;
import com.dev.ForoEscolar.repository.EstudianteRepository;
import com.dev.ForoEscolar.services.EstudianteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstudianteServiceImpl implements EstudianteService {


    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;

    @Autowired
    public EstudianteServiceImpl(EstudianteRepository estudianteRepository, EstudianteMapper estudianteMapper) {
        this.estudianteRepository = estudianteRepository;
        this.estudianteMapper = estudianteMapper;
    }

    @Transactional
    @Override
    public EstudianteResponseDTO save(EstudianteResponseDTO estudianteRequestDTO) {
        Estudiante estudiante = estudianteMapper.toEntity(estudianteRequestDTO);
        estudiante.setRol(RoleEnum.valueOf("ESTUDIANTE"));
        estudiante.setActivo(true);
        estudiante = estudianteRepository.save(estudiante);
        return estudianteMapper.toResponseDTO(estudiante);
    }

    @Override
    public Optional<EstudianteResponseDTO> findById(Long id) {
        Optional<Estudiante> estudiante = estudianteRepository.findById(id);
        return estudiante.map(estudianteMapper::toResponseDTO);
    }

    @Override
    public List<EstudianteResponseDTO> findAll() {
        List<Estudiante> estudiantes = estudianteRepository.findAll();
        return estudiantes.stream()
                .map(estudianteMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Estudiante estudiante = estudianteRepository.findById(id).orElseThrow(() -> new ApplicationException("Estudiante no encontrado"));
        estudianteRepository.delete(estudiante);
    }

    @Transactional
    public EstudianteResponseDTO update(EstudianteResponseDTO estudianteRequestDTO) {
        Estudiante estudiante = estudianteMapper.toEntity(estudianteRequestDTO);
        Optional<Estudiante> existingEntity = estudianteRepository.findById(getEntityId(estudiante));
        if (existingEntity.isPresent()) {
            Estudiante updatedEntity = estudianteRepository.save(estudiante);
            return estudianteMapper.toResponseDTO(updatedEntity);
        } else {
            throw new ApplicationException("La entidad con ese ID no fue encontrado");
        }
    }

//    @Override
//
//    public List<EstudianteResponseDTO> findByAula(AulaEnum aulaEnum) {
//        List<Estudiante> estudiantes = estudianteRepository.findByAula(aulaEnum);
//        return estudiantes.stream().map(estudianteMapper::toResponseDTO).collect(Collectors.toList());
//    }

//    @Override
//    public List<EstudianteResponseDTO> findByCurso(CursoEnum cursoEnum) {
//        List<Estudiante> estudiantes= estudianteRepository.findByCurso(cursoEnum);
//        return estudiantes.stream().map(estudianteMapper::toResponseDTO).collect(Collectors.toList());
//    }
//
//    @Override
//    public List<EstudianteResponseDTO> findByCursoAndAula(CursoEnum curso, AulaEnum aula) {
//        List<Estudiante> estudiantes= estudianteRepository.findByCursoAndAula(curso,aula);
//        return estudiantes.stream().map(estudianteMapper::toResponseDTO).collect(Collectors.toList());
//    }

    @Override
    public List<EstudianteResponseDTO> findByGradoId(Long gradoId) {
        List<Estudiante> estudiantes= estudianteRepository.findByGradoId(gradoId);
        return estudiantes.stream().map(estudianteMapper::toResponseDTO).collect(Collectors.toList());
    }


    //Auxiliar para obtener el ID de la entidad
    protected Long getEntityId(Estudiante estudiante) {
        return estudiante.getId();
    }

}
