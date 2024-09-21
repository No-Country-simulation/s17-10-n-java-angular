package com.dev.ForoEscolar.mapper.estudiante;

import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
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


@Mapper(componentModel = "spring")


public abstract class EstudianteMapper {



    @Autowired
    private TutorLegalRepository tutorLegalRepository;
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

    @Mapping(source = "tutor", target = "tutor", qualifiedByName = "tutorToLong")
    @Mapping(source = "boletin", target = "boletin", qualifiedByName = "boletinesToLongList")
    @Mapping(source = "asistencia", target = "asistencia", qualifiedByName = "asistenciasToLongList")
    @Mapping(source = "tarea", target = "tarea", qualifiedByName = "tareasToLongList")
    @Mapping(source = "calificaciones", target = "calificaciones", qualifiedByName = "calificacionesToLongList")
    @Mapping(source= "grado", target = "grado", qualifiedByName = "gradoToLong")
    public abstract EstudianteResponseDTO toResponseDTO(Estudiante estudiante);

    @Mapping(source = "tutor", target = "tutor", qualifiedByName = "longToTutor")
    @Mapping(source = "boletin", target = "boletin", qualifiedByName = "longListToBoletines")
    @Mapping(source = "asistencia", target = "asistencia", qualifiedByName = "longListToAsistencias")
    @Mapping(source = "tarea", target = "tarea", qualifiedByName = "longListToTareas")
    @Mapping(source = "calificaciones", target = "calificaciones", qualifiedByName = "longListToCalificaciones")
    @Mapping(source= "grado", target = "grado", qualifiedByName = "longToGrado")
    @Mapping(target = "rol", ignore = true)
    public abstract Estudiante toEntity(EstudianteResponseDTO estudianteResponseDTO);

    @Named("gradoToLong")
    protected Long gradoToLong(Grado grado) {
        return grado != null ? grado.getId() : null;
    }

    @Named("longToGrado")
    protected Grado longToGrado(Long id) {
        return id != null ? gradoRepository.findById(id).orElse(null) : null;
    }

    @Named("tutorToLong")
    protected Long tutorToLong(TutorLegal tutor) {

        return tutor != null ? tutor.getId() : null;
    }

    @Named("longToTutor")
    protected TutorLegal longToTutor(Long id) {
        return id != null ? tutorLegalRepository.findById(id).orElse(null) : null;
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
                .collect(Collectors.toList());    }

    @Named("longListToCalificaciones")
    protected List<Calificacion> longListToCalificaciones(List<Long> ids) {
        return ids != null ? ids.stream().map(id -> calificacionRepository.findById(id).orElse(null)).collect(Collectors.toList()) : null;
    }
}