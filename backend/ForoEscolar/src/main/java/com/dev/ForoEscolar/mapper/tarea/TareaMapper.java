package com.dev.ForoEscolar.mapper.tarea;

import com.dev.ForoEscolar.dtos.tarea.TareaResponseDto;
import com.dev.ForoEscolar.model.Estudiante;
import com.dev.ForoEscolar.model.Profesor;
import com.dev.ForoEscolar.model.Tarea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class TareaMapper {

    @Mapping(source = "profesor", target = "profesor", qualifiedByName = "profesorToLong")
    @Mapping(source = "estudiante", target = "estudiante", qualifiedByName = "estudianteToLong")
    public abstract TareaResponseDto toResponseDTO(Tarea tarea);

    @Mapping(source = "profesor", target = "profesor", qualifiedByName = "longToProfesor")
    @Mapping(source = "estudiante", target = "estudiante", qualifiedByName = "longToEstudiante")
    public abstract Tarea toEntity(TareaResponseDto tareaRequestDTO);

    @Named("profesorToLong")
    protected Long profesorToLong(Profesor profesor) {
        return profesor != null ? profesor.getId() : null;
    }

    @Named("estudianteToLong")
    protected Long estudianteToLong(Estudiante estudiante) {
        return estudiante != null ? estudiante.getId() : null;
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

    @Named("longToEstudiante")
    protected Estudiante longToEstudiante(Long id) {
        if (id == null) {
            return null;
        }
        Estudiante estudiante = new Estudiante();
        estudiante.setId(id);
        return estudiante;
    }
}
