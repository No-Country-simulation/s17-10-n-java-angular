package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.Tarea.TareaResponseDto;
import com.dev.ForoEscolar.mapper.tarea.TareaMapper;
import com.dev.ForoEscolar.model.Tarea;
import com.dev.ForoEscolar.repository.TareaRepository;
import com.dev.ForoEscolar.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TareaServiceImpl implements TareaService {

    @Autowired
   private TareaRepository tareaRepository;

    @Override
    public TareaResponseDto save(TareaResponseDto tareaRequestDto) {

        if(tareaRequestDto== null){
            throw new RuntimeException("La tarea no puede estar vacia");
        }

        Tarea tarea= new Tarea().builder()
                .descripcion(tareaRequestDto.getDescripcion())
                .titulo(tareaRequestDto.getTitulo())
                .estudiante(tareaRequestDto.getEstudianteId().build())
                .profesor(tareaRequestDto.getProfesorId().build())
                .fechaEntrega(tareaRequestDto.getFechaEntrega())
                .build();
                tareaRepository.save(tarea);
               return TareaMapper.INSTANCE.toResponseDTO(tarea);

    }

    @Override
    public Optional<TareaResponseDto> findById(Long idTarea) {
        Optional<Tarea> response= tareaRepository.findById(idTarea);
        if(response.isPresent()){
            Tarea tarea= response.get();
            return Optional.ofNullable(TareaMapper.INSTANCE.toResponseDTO(tarea));
        } else{
            throw  new RuntimeException(" La tarea no ha podido ser encontrada");

        }
    }

    @Override
    public Iterable<TareaResponseDto> findAll() {
        List<Tarea> listar= tareaRepository.findAll();
        return listar.stream().map(TareaMapper.INSTANCE::toResponseDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long idTarea) {

        Tarea tarea= tareaRepository.findById(idTarea).orElse(null);
        if(tarea!=null){
            tarea.setActivo(false);
            tareaRepository.save(tarea);
        }else{
            throw new RuntimeException("Tarea no encontrada");
        }

    }
}
