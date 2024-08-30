package com.dev.ForoEscolar.mapper.profesor;

import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.mapper.GenericMapper;
import com.dev.ForoEscolar.model.Estudiante;
import com.dev.ForoEscolar.model.Profesor;
import com.dev.ForoEscolar.model.Tarea;
import com.dev.ForoEscolar.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProfesorMapper {

    ProfesorMapper INSTANCE = Mappers.getMapper(ProfesorMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "estudianteIds", target = "estudiantes", qualifiedByName = "estudianteIdsToEstudiantes")
    @Mapping(source = "tareaIds", target = "tarea", qualifiedByName = "tareaIdsToTareas")
    Profesor toEntity(ProfesorRequestDTO dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.nombre", target = "usuarioNombre")
    @Mapping(source = "estudiantes", target = "estudiantesNombres", qualifiedByName = "estudiantesToEstudianteNombres")
    @Mapping(source = "tarea", target = "tareaTitulos", qualifiedByName = "tareasToTareaTitulos")
    ProfesorResponseDTO toResponseDTO(Profesor entity);

    //Metodos auxiliares para el Mapeo:

    @Named("estudianteIdsToEstudiantes")
    default List<Estudiante> estudianteIdsToEstudiantes(List<Long> ids) {
        return ids.stream().map(id -> {
            Estudiante estudiante = new Estudiante();
            estudiante.setId(id);
            return estudiante;
        }).collect(Collectors.toList());
    }

    @Named("tareaIdsToTareas")
    default List<Tarea> tareaIdsToTareas(List<Long> ids) {
        return ids.stream().map(id -> {
            Tarea tarea = new Tarea();
            tarea.setId(id);
            return tarea;
        }).collect(Collectors.toList());
    }

    @Named("estudiantesToEstudianteNombres")
    default List<String> estudiantesToEstudianteNombres(List<Estudiante> estudiantes) {
        return estudiantes.stream().map(Estudiante::getNombre).collect(Collectors.toList());
    }

    @Named("tareasToTareaTitulos")
    default List<String> tareasToTareaTitulos(List<Tarea> tareas) {
        return tareas.stream().map(Tarea::getTitulo).collect(Collectors.toList());
    }
}