package com.dev.ForoEscolar.mapper.estudiante;

import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.mapper.GenericMapperDTO;
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
            @Mapping(source = "tarea", target = "tareaIds")
    })
    @Override
    EstudianteResponseDTO toResponseDTO(Estudiante entity);

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
