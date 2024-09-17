package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.calificacion.CalificacionDTO;
import com.dev.ForoEscolar.enums.MateriaEnum;
import com.dev.ForoEscolar.exceptions.ApplicationException;
import com.dev.ForoEscolar.mapper.calificacion.CalificacionMapper;
import com.dev.ForoEscolar.model.Calificacion;
import com.dev.ForoEscolar.repository.CalificacionRepository;
import com.dev.ForoEscolar.services.CalificacionService;
import com.dev.ForoEscolar.services.GenericServiceDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CalificacionServiceImpl implements CalificacionService, GenericServiceDto<Long, CalificacionDTO> {



    private final CalificacionRepository calificacionRepository;

    private final CalificacionMapper calificacionMapper;

    @Autowired
    public CalificacionServiceImpl(CalificacionRepository calificacionRepository, CalificacionMapper calificacionMapper) {
        this.calificacionRepository = calificacionRepository;
        this.calificacionMapper = calificacionMapper;
    }

    @Transactional
    @Override
    public CalificacionDTO save(CalificacionDTO requestDTO) {
        if(requestDTO==null){
            throw new ApplicationException("Debe asignar una calificacion");
        }
        System.out.println(requestDTO);
        Calificacion newCalificacion = calificacionMapper.toEntity(requestDTO);
        calificacionRepository.save(newCalificacion);
        return calificacionMapper.toResponseDto(newCalificacion);
    }

    @Override
    public Optional<CalificacionDTO> findById(Long id) {
        Optional<Calificacion> calificacion = calificacionRepository.findById(id);
        if(calificacion.isEmpty()){
            throw new RuntimeException("Calificacion no encontrada");
        }else{
            return Optional.ofNullable(calificacionMapper.toResponseDto(calificacion.get()));
        }
    }

    @Override
    public Iterable<CalificacionDTO> findAll() {
        List<Calificacion> calificaciones = calificacionRepository.findAll();
        return calificaciones.stream().map(calificacionMapper::toResponseDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Optional<Calificacion> response= calificacionRepository.findById(id);
        if(response.isEmpty()){
            throw new ApplicationException("Error al buscar su calificacion");
        }
        calificacionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public CalificacionDTO update(CalificacionDTO calificacionDTO) {
        Calificacion calificacion = calificacionMapper.toEntity(calificacionDTO);
        Optional<Calificacion> existingEntity = calificacionRepository.findById(calificacion.getId());
        if (existingEntity.isPresent()) {
            Calificacion updatedEntity = calificacionRepository.save(calificacion);
            return calificacionMapper.toResponseDto(updatedEntity);
        } else {
            throw new ApplicationException("La calificacion con ese ID no fue encontrado");
        }
    }
    @Override
    public List<CalificacionDTO> findByEstudianteId(Long id){
        List<Calificacion> calificaciones = calificacionRepository.findByEstudianteId(id);
        return calificaciones.stream().map(calificacionMapper::toResponseDto).collect(Collectors.toList());
    }

    @Override
    public List<CalificacionDTO> findByMateria(MateriaEnum materiaEnum) {
        List<Calificacion> calificaciones = calificacionRepository.findByMateria(materiaEnum);
        return calificaciones
                .stream()
                .map(calificacionMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
