package com.dev.ForoEscolar.mapper.boletin;

import com.dev.ForoEscolar.dtos.boletin.BoletinDto;
import com.dev.ForoEscolar.model.Boletin;
import com.dev.ForoEscolar.model.Calificacion;
import com.dev.ForoEscolar.model.Estudiante;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class BoletinMapper {

    @Mapping(source = "estudiante", target = "estudiante", qualifiedByName = "estudianteToLong")
    @Mapping(source = "calificacion", target = "calificacion", qualifiedByName = "calificacionToLong")
    public abstract BoletinDto toResponseDto(Boletin boletin);

    @Mapping(source = "estudiante", target = "estudiante", qualifiedByName = "longToEstudiante")
    @Mapping(source = "calificacion", target = "calificacion", qualifiedByName = "longToCalificacion")
    public abstract Boletin toEntity(BoletinDto boletinDto);

    @Named("estudianteToLong")
    protected Long estudianteToLong(Estudiante estudiante) {
        return estudiante != null ? estudiante.getId() : null;
    }

    @Named("longToEstudiante")
    protected Estudiante longToEstudiante(Long id) {
        if (id == null) {
            return null;
        }
        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        return estudiante;
    }

    @Named("calificacionToLong")
    protected Long calificacionToLong(Calificacion calificacion) {
        return calificacion != null ? calificacion.getId() : null;
    }

    @Named("longToCalificacion")
    protected Calificacion longToCalificacion(Long id) {
        if (id == null) {
            return null;
        }
        Calificacion calificacion = new Calificacion();
        calificacion.setId(id);
        return calificacion;
    }
}