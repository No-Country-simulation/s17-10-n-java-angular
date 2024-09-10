package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.grado.GradoDto;
import com.dev.ForoEscolar.exceptions.ApplicationException;

import com.dev.ForoEscolar.mapper.grado.GradoMapper;
import com.dev.ForoEscolar.model.Grado;
import com.dev.ForoEscolar.model.Profesor;
import com.dev.ForoEscolar.repository.GradoRepository;
import com.dev.ForoEscolar.services.GradoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GradoServiceImp implements GradoService {

    private final GradoRepository gradoRepository;
    private final GradoMapper gradoMapper;

    public GradoServiceImp(GradoRepository gradoRepository, GradoMapper gradoMapper) {
        this.gradoRepository = gradoRepository;
        this.gradoMapper = gradoMapper;
    }
    @Override
    public GradoDto save(GradoDto gradoDto) {
        if(gradoDto==null){
            throw new ApplicationException("El grado no puede estar vacio");
        }
        Profesor profesor= new Profesor();
        profesor.setId(gradoDto.getProfesor());
        Grado grado=Grado.builder()
                .curso(gradoDto.getCurso())
                .aula(gradoDto.getAula())
                .turno(gradoDto.getTurno())
                .materia(gradoDto.getMateria())
                .profesor(profesor)
                .build();
        gradoRepository.save(grado);
        return gradoMapper.toResponseDto(grado);
   }

    @Override
    public Optional<GradoDto> findById(Long id) {
        Optional<Grado> response= gradoRepository.findById(id);
        if(response.isEmpty()){
            throw new ApplicationException("No se encontro el grado");
        }
        Grado grado= response.get();
        return Optional.ofNullable(gradoMapper.toResponseDto(grado));
    }

    @Override
    public Iterable<GradoDto> findAll() {
       List<Grado> grados= gradoRepository.findAll();
        return grados.stream().map(gradoMapper::toResponseDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        Optional<Grado> response= gradoRepository.findById(id);
        if(response.isEmpty()){
            throw new ApplicationException("No se encontro el grado");
        }
        gradoRepository.deleteById(id);
    }
}
