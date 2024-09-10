package com.dev.ForoEscolar.mapper.profesor;

import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.model.*;
import com.dev.ForoEscolar.repository.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Mapper(componentModel = "spring", uses = {EstudianteRepository.class, BoletinRepository.class, AsistenciaRepository.class, TareaRepository.class, CalificacionRepository.class, GradoRepository.class})
public abstract class ProfesorMapper {

    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private BoletinRepository boletinRepository;
    @Autowired
    private AsistenciaRepository asistenciaRepository;
    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private CalificacionRepository calificacionRepository;
    @Autowired
    private GradoRepository gradoRepository;

    @Mapping(source = "estudiantes", target = "estudianteIds", qualifiedByName = "estudiantesToLongList")
    @Mapping(source = "boletin", target = "boletinIds", qualifiedByName = "boletinesToLongList")
    @Mapping(source = "asistencia", target = "asistenciaIds", qualifiedByName = "asistenciasToLongList")
    @Mapping(source = "tarea", target = "tareaIds", qualifiedByName = "tareasToLongList")
    @Mapping(source = "calificaciones", target = "calificacionIds", qualifiedByName = "calificacionesToLongList")
    @Mapping(source = "grado", target = "gradoIds", qualifiedByName = "gradosToLongList")
    public abstract ProfesorResponseDTO toResponseDTO(Profesor profesor);

    @Mapping(target = "id", source = "id")
    @Mapping(source = "estudianteIds", target = "estudiantes", qualifiedByName = "longListToEstudiantes")
    @Mapping(source = "boletinIds", target = "boletin", qualifiedByName = "longListToBoletines")
    @Mapping(source = "asistenciaIds", target = "asistencia", qualifiedByName = "longListToAsistencias")
    @Mapping(source = "tareaIds", target = "tarea", qualifiedByName = "longListToTareas")
    @Mapping(source = "calificacionIds", target = "calificaciones", qualifiedByName = "longListToCalificaciones")
    @Mapping(source = "gradoIds", target = "grado", qualifiedByName = "longListToGrados")
    public abstract Profesor toEntity(ProfesorRequestDTO profesorRequestDTO);

    @Named("estudiantesToLongList")
    protected List<Long> estudiantesToLongList(List<Estudiante> estudiantes) {
        if (estudiantes == null) {
            return Collections.emptyList();
        }
        return estudiantes.stream()
                .map(boletin -> {
                    if (boletin == null) {
                        return null;
                    }
                    return boletin.getId();
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Named("longListToEstudiantes")
    protected List<Estudiante> longListToEstudiantes(List<Long> ids) {
        return ids != null ? ids.stream().map(id -> estudianteRepository.findById(id).orElse(null)).collect(Collectors.toList()) : null;
    }

    @Named("boletinesToLongList")
    protected List<Long> boletinesToLongList(List<Boletin> boletines) {
        if (boletines == null) {
            return Collections.emptyList();
        }
        return boletines.stream()
                .map(boletin -> {
                    if (boletin == null) {
                        return null;
                    }
                    return boletin.getId();
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Named("longListToBoletines")
    protected List<Boletin> longListToBoletines(List<Long> ids) {
        return ids != null ? ids.stream().map(id -> boletinRepository.findById(id).orElse(null)).collect(Collectors.toList()) : null;
    }

    @Named("asistenciasToLongList")
    protected List<Long> asistenciasToLongList(List<Asistencia> asistencias) {
        if (asistencias == null) {
            return Collections.emptyList();
        }
        return asistencias.stream()
                .map(asistencia -> {
                    if (asistencia == null) {
                        return null;
                    }
                    return asistencia.getId();
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Named("longListToAsistencias")
    protected List<Asistencia> longListToAsistencias(List<Long> ids) {
        return ids != null ? ids.stream().map(id -> asistenciaRepository.findById(id).orElse(null)).collect(Collectors.toList()) : null;
    }

    @Named("tareasToLongList")
    protected List<Long> tareasToLongList(List<Tarea> tareas) {
        if (tareas == null) {
            return Collections.emptyList();
        }
        return tareas.stream()
                .map(tarea -> {
                    if (tarea == null) {
                        return null;
                    }
                    return tarea.getId();
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Named("longListToTareas")
    protected List<Tarea> longListToTareas(List<Long> ids) {
        return ids != null ? ids.stream().map(id -> tareaRepository.findById(id).orElse(null)).collect(Collectors.toList()) : null;
    }

    @Named("calificacionesToLongList")
    protected List<Long> calificacionesToLongList(List<Calificacion> calificaciones) {
        if (calificaciones == null) {
            return Collections.emptyList();
        }
        return calificaciones.stream()
                .map(calificacion -> {
                    if (calificacion == null) {
                        return null;
                    }
                    return calificacion.getId();
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Named("longListToCalificaciones")
    protected List<Calificacion> longListToCalificaciones(List<Long> ids) {
        return ids != null ? ids.stream().map(id -> calificacionRepository.findById(id).orElse(null)).collect(Collectors.toList()) : null;
    }

    @Named("gradosToLongList")
    protected List<Long> gradosToLongList(List<Grado> grados) {
        if (grados == null) {
            return Collections.emptyList();
        }
        return grados.stream()
                .map(calificacion -> {
                    if (calificacion == null) {
                        return null;
                    }
                    return calificacion.getId();
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Named("longListToGrados")
    protected List<Grado> longListToGrados(List<Long> ids) {
        return ids != null ? ids.stream().map(id -> gradoRepository.findById(id).orElse(null)).collect(Collectors.toList()) : null;
    }
}