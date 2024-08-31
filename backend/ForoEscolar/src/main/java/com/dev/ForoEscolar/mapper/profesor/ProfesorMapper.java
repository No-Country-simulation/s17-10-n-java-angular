package com.dev.ForoEscolar.mapper.profesor;

import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.mapper.GenericMapper;
import com.dev.ForoEscolar.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ProfesorMapper extends GenericMapper<Profesor, ProfesorRequestDTO, ProfesorResponseDTO> {

    ProfesorMapper INSTANCE = Mappers.getMapper(ProfesorMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "materia", target = "materia"),
            @Mapping(source = "userId", target = "user.id"),
            @Mapping(source = "estudianteIds", target = "estudiantes"),
            @Mapping(source = "boletinIds", target = "boletin"),
            @Mapping(source = "tareaIds", target = "tarea")
    })
    @Override
    Profesor toEntity(ProfesorRequestDTO requestDTO);

    @Mappings({
            @Mapping(source = "materia", target = "materia"),
            @Mapping(source = "user.id", target = "userId"),
//            @Mapping(source = "user.nombre", target = "userName"),
            @Mapping(source = "estudiantes", target = "estudianteIds"),
            @Mapping(source = "boletin", target = "boletinIds"),
            @Mapping(source = "tarea", target = "tareaIds")
    })
    @Override
    ProfesorResponseDTO toResponseDto(Profesor entity);

    // Convert list of IDs to list of Estudiante
    default List<Estudiante> mapEstudiantes(List<Long> ids) {
        return ids.stream()
                .map(id -> new Estudiante(id)) // Ajusta esto según tu implementación de Estudiante
                .collect(Collectors.toList());
    }

    // Convert list of Estudiante to list of IDs
    default List<Long> mapEstudianteIds(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .map(Estudiante::getId)
                .collect(Collectors.toList());
    }

    // Convert list of IDs to list of Boletin
    default List<Boletin> mapBoletines(List<Long> ids) {
        return ids.stream()
                .map(id -> new Boletin(id)) // Ajusta esto según tu implementación de Boletin
                .collect(Collectors.toList());
    }

    // Convert list of Boletin to list of IDs
    default List<Long> mapBoletinIds(List<Boletin> boletines) {
        return boletines.stream()
                .map(Boletin::getId)
                .collect(Collectors.toList());
    }

    // Convert list of IDs to list of Tarea
    default List<Tarea> mapTareas(List<Long> ids) {
        return ids.stream()
                .map(id -> new Tarea(id)) // Ajusta esto según tu implementación de Tarea
                .collect(Collectors.toList());
    }

    // Convert list of Tarea to list of IDs
    default List<Long> mapTareaIds(List<Tarea> tareas) {
        return tareas.stream()
                .map(Tarea::getId)
                .collect(Collectors.toList());
    }
}