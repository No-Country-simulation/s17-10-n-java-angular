package com.dev.ForoEscolar.mapper.asistencia;

import com.dev.ForoEscolar.dtos.asistencia.AsistenciaDTO;
import com.dev.ForoEscolar.model.Asistencia;
import com.dev.ForoEscolar.model.Estudiante;
import com.dev.ForoEscolar.model.Profesor;
import com.dev.ForoEscolar.repository.EstudianteRepository;
import com.dev.ForoEscolar.repository.ProfesorRepository;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class AsistenciaMapper {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Autowired
    private ProfesorRepository profesorRepository;

    @Mapping(source = "profesor", target = "profesor", qualifiedByName = "longToProfesor")
    @Mapping(source = "estudiante", target = "estudiante", qualifiedByName = "longToEstudiante")
    public abstract Asistencia toEntity(AsistenciaDTO asistenciaDTO);

    @Mapping(source = "profesor", target = "profesor", qualifiedByName = "profesorToLong")
    @Mapping(source = "estudiante", target = "estudiante", qualifiedByName = "estudianteToLong")
    public abstract AsistenciaDTO toResponseDto(Asistencia asistencia);

    @Named("longToProfesor")
    protected Profesor longToProfesor(Long id) {
        return id != null ? profesorRepository.findById(id).orElse(null) : null;
    }

    @Named("longToEstudiante")
    protected Estudiante longToEstudiante(Long id) {
        return id != null ? estudianteRepository.findById(id).orElse(null) : null;
    }

    @Named("profesorToLong")
    protected Long profesorToLong(Profesor profesor) {
        return profesor != null ? profesor.getId() : null;
    }

    @Named("estudianteToLong")
    protected Long estudianteToLong(Estudiante estudiante) {
        return estudiante != null ? estudiante.getId() : null;
    }
}
