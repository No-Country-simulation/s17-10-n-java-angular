package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.tarea.TareaResponseDto;
import com.dev.ForoEscolar.exceptions.ApplicationException;
import com.dev.ForoEscolar.mapper.tarea.TareaMapper;
import com.dev.ForoEscolar.model.Estudiante;
import com.dev.ForoEscolar.model.Profesor;
import com.dev.ForoEscolar.model.Tarea;
import com.dev.ForoEscolar.repository.TareaRepository;
import com.dev.ForoEscolar.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TareaServiceImpl implements TareaService {

    private final TareaRepository tareaRepository;
    private final TareaMapper tareaMapper;
    @Autowired
    public TareaServiceImpl(TareaRepository tareaRepository, TareaMapper tareaMapper) {
        this.tareaRepository = tareaRepository;
        this.tareaMapper=tareaMapper;
    }


    @Override
    public TareaResponseDto save(TareaResponseDto tareaRequestDto) {
        if(tareaRequestDto== null){
            throw new  ApplicationException("La tarea no puede estar vacia");
        }
        Profesor profesor= new Profesor();
        profesor.setId(tareaRequestDto.getProfesorId());
        new Tarea();
        Tarea tarea= Tarea.builder()
                .descripcion(tareaRequestDto.getDescripcion())
                .titulo(tareaRequestDto.getTitulo())
                .estudiante(Estudiante.builder().id(tareaRequestDto.getEstudianteId()).build())
                .profesor(profesor)
                .fechaEntrega(tareaRequestDto.getFechaEntrega())
                .activo(true)
                .build();
        tareaRepository.save(tarea);
        return tareaMapper.toResponseDTO(tarea);
    }

    @Override
    public Optional<TareaResponseDto> findById(Long idTarea) {
        Optional<Tarea> response= tareaRepository.findById(idTarea);
        if(response.isPresent()){
            Tarea tarea= response.get();
            return Optional.ofNullable(tareaMapper.toResponseDTO(tarea));
        }
        throw new ApplicationException("Tarea no encontrada");
    }

    @Override
    public Iterable<TareaResponseDto> findAll() {
        List<Tarea> listar= tareaRepository.findAll();
       return listar.stream().map(tareaMapper::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {

        Tarea tarea= tareaRepository.findById(id).orElse(null);
        if(tarea!=null){
            tarea.setActivo(false);
            tareaRepository.save(tarea);
        }else{
            throw new ApplicationException("Tarea no encontrada");
        }
    }
//
//    @Override
//    public TareaResponseDto save(TareaResponseDto tareaRequestDto) {
//
//        if(tareaRequestDto== null){
//            throw new RuntimeException("La tarea no puede estar vacia");
//        }
//        Profesor profesor= new Profesor();
//        profesor.setId(tareaRequestDto.getProfesorId());
//        new Tarea();
//        Tarea tarea= Tarea.builder()
//                .descripcion(tareaRequestDto.getDescripcion())
//                .titulo(tareaRequestDto.getTitulo())
//                .estudiante(Estudiante.builder().id(tareaRequestDto.getEstudianteId()).build())
//                .profesor(profesor)
//                .fechaEntrega(tareaRequestDto.getFechaEntrega())
//                .build();
//        tareaRepository.save(tarea);
//        return TareaMapper.INSTANCE.toResponseDTO(tarea);
//
//    }
//
//    @Override
//    public Iterable<TareaResponseDto> findAll() {
//        List<Tarea> listar= tareaRepository.findAll();
//        return listar.stream().map(TareaMapper.INSTANCE::toResponseDTO).collect(Collectors.toList());
//    }


}
