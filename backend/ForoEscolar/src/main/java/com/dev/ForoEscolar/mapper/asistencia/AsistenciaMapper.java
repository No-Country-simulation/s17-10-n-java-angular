package com.dev.ForoEscolar.mapper.asistencia;

import com.dev.ForoEscolar.dtos.asistencia.AsistenciaDTO;
import com.dev.ForoEscolar.model.Asistencia;
import com.dev.ForoEscolar.model.Estudiante;
import com.dev.ForoEscolar.model.Profesor;
import com.dev.ForoEscolar.repository.EstudianteRepository;
import com.dev.ForoEscolar.repository.ProfesorRepository;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {AsistenciaMapper.class, EstudianteRepository.class ,ProfesorRepository.class})
public abstract class AsistenciaMapper {

    @Autowired
    private  EstudianteRepository estudianteRepository;

    @Autowired
    private  ProfesorRepository profesorRepository;

    @Mapping(source = "estudiante", target = "estudiante", qualifiedByName = "longToEstudiante")
    @Mapping(source = "profesor", target = "profesor", qualifiedByName = "longToProfesor")
    public abstract Asistencia toEntity(AsistenciaDTO asistenciaDTO);

    @Mapping(source = "estudiante" , target = "estudiante", qualifiedByName = "estudianteToLong")
    @Mapping(source = "profesor", target = "profesor", qualifiedByName = "profesorToLong")
    public abstract AsistenciaDTO toResponseDto(Asistencia asistencia);

    @Named("longToEstudiante")
    protected Estudiante longToEstudiante(Long id){
        return id != null ? estudianteRepository.findById(id).orElse(null) : null;
    }
    @Named("longToProfesor")
    protected Profesor longToProfesor(Long id){
        return id != null ? profesorRepository.findById(id).orElse(null) : null;
    }

    @Named("estudianteToLong")
    protected Long estudianteToLong (Estudiante estudiante){
        return estudiante != null ? estudiante.getId() : null;
    }

    @Named("profesorToLong")
    protected Long profesorToLong (Profesor profesor){
        return profesor != null ? profesor.getId() : null;
    }

}
