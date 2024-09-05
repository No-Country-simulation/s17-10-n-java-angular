package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.boletin.BoletinDto;
import com.dev.ForoEscolar.mapper.boletin.BoletinMapper;
import com.dev.ForoEscolar.model.Boletin;
import com.dev.ForoEscolar.model.Calificacion;
import com.dev.ForoEscolar.model.Estudiante;
import com.dev.ForoEscolar.repository.BoletinRepository;
import com.dev.ForoEscolar.services.BoletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BoletinServiceImp implements BoletinService {

    @Autowired
    private BoletinRepository boletinRepository;

    @Override
    public BoletinDto save(BoletinDto boletinDto) {
        if(boletinDto==null){
            throw new RuntimeException("El boletin no puede tener campos vacios");
        }

        Boletin boletin= new Boletin().builder()
                .observaciones(boletinDto.getObservaciones())
                .curso(boletinDto.getCurso())
                .calificaciones(boletinDto.getCalificacions())
                .periodo(boletinDto.getPeriodo())
                .fecha(LocalDate.now())
                .estudiante(Estudiante.builder().id(boletinDto.getEstudianteId()).build())
                .build();
        boletinRepository.save(boletin);
        return BoletinMapper.INSTANCE.toResponseDto(boletin);
    }

    @Override
    public Optional<BoletinDto> findById(Long idBoletin) {
      Optional<Boletin> response= boletinRepository.findById(idBoletin);
      if(response.isPresent()){
          Boletin boletin= response.get();
          return Optional.ofNullable(BoletinMapper.INSTANCE.toResponseDto(boletin));
      }else{
          throw  new RuntimeException("El boletin no puede ser encontrado");
      }
    }

    @Override
    public Iterable<BoletinDto> findAll() {
       List<Boletin> boletines= boletinRepository.findAll();
       return boletines.stream().map(BoletinMapper.INSTANCE::toResponseDto).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long idBoletin) {
        boletinRepository.deleteById(idBoletin);

    }

    public Double promediarnotas(List<Calificacion> calificacions, Long idBoletin){
        Boletin boletin= boletinRepository.findById(idBoletin).orElse(null);
        Double promedio= 0.0;

        boletin.setPromedio(promedio);
        boletinRepository.save(boletin);

        return null;
    }
}
