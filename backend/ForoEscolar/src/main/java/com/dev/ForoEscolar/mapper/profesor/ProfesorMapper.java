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
            @Mapping(source = "asistenciaIds", target = "asistencia"),
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
            @Mapping(source = "asistencia", target = "asistenciaIds"),
            @Mapping(source = "tarea", target = "tareaIds")
    })
    @Override
    ProfesorResponseDTO toResponseDto(Profesor entity);

    // Convierte una lista de Ids a una lista de Estudiante
    default List<Estudiante> mapEstudiantes(List<Long> ids) {
        return ids.stream()
                .map(id -> new Estudiante(id)) // Ajusta esto según tu implementación de Estudiante
                .collect(Collectors.toList());
    }

    // Convierte una lista de Estudiante a una lista de Ids
    default List<Long> mapEstudianteIds(List<Estudiante> estudiantes) {
        return estudiantes.stream()
                .map(Estudiante::getId)
                .collect(Collectors.toList());
    }

    // Convierte una lista de Ids a una lista de Boeltin
    default List<Boletin> mapBoletines(List<Long> ids) {
        return ids.stream()
                .map(id -> new Boletin(id)) // Ajusta esto según tu implementación de Boletin
                .collect(Collectors.toList());
    }

    // Convierte una lista de Boletin a una lista de Ids
    default List<Long> mapBoletinIds(List<Boletin> boletines) {
        return boletines.stream()
                .map(Boletin::getId)
                .collect(Collectors.toList());
    }

    // Convierte una lista de Ids a una lista de Asistencia
    default List<Asistencia> mapAsistencias(List<Long> ids) {
        return ids.stream()
                .map(id -> new Asistencia(id)) // Ajusta esto según tu implementación de Tarea
                .collect(Collectors.toList());
    }

    // Convierte una lista de Asistencia a una lista de Ids
    default List<Long> mapAsistenciaIds(List<Asistencia> asistencias) {
        return asistencias.stream()
                .map(Asistencia::getId)
                .collect(Collectors.toList());
    }

    // Convierte una lista de Ids a una lista de Tarea
    default List<Tarea> mapTareas(List<Long> ids) {
        return ids.stream()
                .map(id -> new Tarea(id)) // Ajusta esto según tu implementación de Tarea
                .collect(Collectors.toList());
    }

    // Convierte una lista de Asistencia a una lista de Ids
    default List<Long> mapTareaIds(List<Tarea> tareas) {
        return tareas.stream()
                .map(Tarea::getId)
                .collect(Collectors.toList());
    }
}