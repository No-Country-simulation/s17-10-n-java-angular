package com.dev.ForoEscolar.mapper.calificacion;

import com.dev.ForoEscolar.dtos.calificacion.CalificacionDTO;
import com.dev.ForoEscolar.model.Boletin;
import com.dev.ForoEscolar.model.Calificacion;
import com.dev.ForoEscolar.model.Estudiante;
import com.dev.ForoEscolar.model.Profesor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class CalificacionMapper {

    @Mapping(source = "estudiante", target = "estudiante", qualifiedByName = "longToEstudiante")
    @Mapping(source = "profesor", target = "profesor", qualifiedByName = "longToProfesor")
    @Mapping(source = "boletin", target = "boletin", qualifiedByName = "longToBoletin")
    public abstract Calificacion toEntity(CalificacionDTO calificacionDTO);

    @Mapping(source = "estudiante", target = "estudiante", qualifiedByName = "estudianteToLong")
    @Mapping(source = "profesor", target = "profesor", qualifiedByName = "profesorToLong")
    @Mapping(source = "boletin", target = "boletin", qualifiedByName = "boletinToLong")
    public abstract CalificacionDTO toResponseDto(Calificacion calificacion);

    @Named("longToEstudiante")
    protected Estudiante longToEstudiante(Long id) {
        if (id == null) {
            return null;
        }
        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        return estudiante;
    }

    @Named("longToProfesor")
    protected Profesor longToProfesor(Long id) {
        if (id == null) {
            return null;
        }
        Profesor profesor = new Profesor();
        profesor.setId(id);
        return profesor;
    }

    @Named("longToBoletin")
    protected Boletin longToBoletin(Long id) {
        if (id == null) {
            return null;
        }
        Boletin boletin = new Boletin();
        boletin.setId(id);
        return boletin;
    }

    @Named("estudianteToLong")
    protected Long estudianteToLong(Estudiante estudiante) {
        return estudiante != null ? estudiante.getId() : null;
    }

    @Named("profesorToLong")
    protected Long profesorToLong(Profesor profesor) {
        return profesor != null ? profesor.getId() : null;
    }

    @Named("boletinToLong")
    protected Long boletinToLong(Boletin boletin) {
        return boletin != null ? boletin.getId() : null;
    }
}