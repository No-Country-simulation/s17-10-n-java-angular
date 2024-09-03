package com.dev.ForoEscolar.mapper.estudiante;

import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.mapper.GenericMapperDTO;
import com.dev.ForoEscolar.model.Asistencia;
import com.dev.ForoEscolar.model.Boletin;
import com.dev.ForoEscolar.model.Estudiante;
import com.dev.ForoEscolar.model.Tarea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface EstudianteMapper extends GenericMapperDTO<Estudiante, EstudianteResponseDTO> {

    EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "apellido", target = "apellido"),
            @Mapping(source = "dni", target = "dni"),
            @Mapping(source = "rol", target = "rol"),
            @Mapping(source = "nacimiento", target = "nacimiento"),
            @Mapping(source = "curso", target = "curso"),
            @Mapping(source = "aula", target = "aula"),
            @Mapping(source = "tipoDocumento", target = "tipoDocumento"),
            @Mapping(source = "boletinIds", target = "boletin"),
            @Mapping(source = "tareaIds", target = "tarea")
    })
    @Override
    Estudiante toEntity(EstudianteResponseDTO requestDTO);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "apellido", target = "apellido"),
            @Mapping(source = "dni", target = "dni"),
            @Mapping(source = "rol", target = "rol"),
            @Mapping(source = "nacimiento", target = "nacimiento"),
            @Mapping(source = "curso", target = "curso"),
            @Mapping(source = "aula", target = "aula"),
            @Mapping(source = "tipoDocumento", target = "tipoDocumento"),
            @Mapping(source = "boletin", target = "boletinIds"),
            @Mapping(source = "asistencia", target = "asistenciaIds"),
            @Mapping(source = "tarea", target = "tareaIds")
    })
    @Override
    EstudianteResponseDTO toResponseDTO(Estudiante entity);

    // Convierte una lista de Ids a una lista de Boletin
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

    // Convierte una lista de Ids a una lista de Tarea
    default List<Tarea> mapTareas(List<Long> ids) {
        return ids.stream()
                .map(id -> new Tarea(id)) // Ajusta esto según tu implementación de Tarea
                .collect(Collectors.toList());
    }

    // Convierte una lista de Tarea a una lista de Ids
    default List<Long> mapTareaIds(List<Tarea> tareas) {
        return tareas.stream()
                .map(Tarea::getId)
                .collect(Collectors.toList());
    }

    // Convierte una lista de Ids a una lista de Asistencia
    default List<Asistencia> mapAsistencias(List<Long> ids) {
        return ids.stream()
                .map(id -> new Asistencia(id))
                .collect(Collectors.toList());
    }

    // Convierte una lista de Asistencia a una lista de Ids
    default List<Long> mapAsistenciaIds(List<Asistencia> asistencias) {
        return asistencias.stream()
                .map(Asistencia::getId)
                .collect(Collectors.toList());
    }
}
