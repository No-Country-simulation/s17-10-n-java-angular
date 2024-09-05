package com.dev.ForoEscolar.mapper.profesor;

import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.model.*;
import com.dev.ForoEscolar.repository.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {EstudianteRepository.class, BoletinRepository.class, AsistenciaRepository.class, TareaRepository.class, CalificacionRepository.class})
public abstract class ProfesorMapper {

    @Autowired
    private EstudianteRepository estudianteRepository;
//    @Autowired
//    private BoletinRepository boletinRepository;
    @Autowired
    private AsistenciaRepository asistenciaRepository;
//    @Autowired
//    private TareaRepository tareaRepository;
//    @Autowired
//    private CalificacionRepository calificacionRepository;

    @Mapping(source = "estudiantes", target = "estudianteIds", qualifiedByName = "estudiantesToLongList")
//    @Mapping(source = "boletin", target = "boletinIds", qualifiedByName = "boletinesToLongList")
    @Mapping(source = "asistencia", target = "asistenciaIds", qualifiedByName = "asistenciasToLongList")
//    @Mapping(source = "tarea", target = "tareaIds", qualifiedByName = "tareasToLongList")
//    @Mapping(source = "calificaciones", target = "calificacionIds", qualifiedByName = "calificacionesToLongList")
    public abstract ProfesorResponseDTO toResponseDTO(Profesor profesor);

    @Mapping(target = "id", source = "id")
    @Mapping(source = "estudianteIds", target = "estudiantes", qualifiedByName = "longListToEstudiantes")
//    @Mapping(source = "boletinIds", target = "boletin", qualifiedByName = "longListToBoletines")
    @Mapping(source = "asistenciaIds", target = "asistencia", qualifiedByName = "longListToAsistencias")
//    @Mapping(source = "tareaIds", target = "tarea", qualifiedByName = "longListToTareas")
//    @Mapping(source = "calificacionIds", target = "calificaciones", qualifiedByName = "longListToCalificaciones")
    public abstract Profesor toEntity(ProfesorRequestDTO profesorRequestDTO);

    @Named("estudiantesToLongList")
    protected List<Long> estudiantesToLongList(List<Estudiante> estudiantes) {
        return estudiantes != null ? estudiantes.stream().map(Estudiante::getId).collect(Collectors.toList()) : null;
    }

    @Named("longListToEstudiantes")
    protected List<Estudiante> longListToEstudiantes(List<Long> ids) {
        return ids != null ? ids.stream().map(id -> estudianteRepository.findById(id).orElse(null)).collect(Collectors.toList()) : null;
    }

//    @Named("boletinesToLongList")
//    protected List<Long> boletinesToLongList(List<Boletin> boletines) {
//        return boletines != null ? boletines.stream().map(Boletin::getId).collect(Collectors.toList()) : null;
//    }
//
//    @Named("longListToBoletines")
//    protected List<Boletin> longListToBoletines(List<Long> ids) {
//        return ids != null ? ids.stream().map(id -> boletinRepository.findById(id).orElse(null)).collect(Collectors.toList()) : null;
//    }

    @Named("asistenciasToLongList")
    protected List<Long> asistenciasToLongList(List<Asistencia> asistencias) {
        return asistencias != null ? asistencias.stream().map(Asistencia::getId).collect(Collectors.toList()) : null;
    }

    @Named("longListToAsistencias")
    protected List<Asistencia> longListToAsistencias(List<Long> ids) {
        return ids != null ? ids.stream().map(id -> asistenciaRepository.findById(id).orElse(null)).collect(Collectors.toList()) : null;
    }

//    @Named("tareasToLongList")
//    protected List<Long> tareasToLongList(List<Tarea> tareas) {
//        return tareas != null ? tareas.stream().map(Tarea::getId).collect(Collectors.toList()) : null;
//    }
//
//    @Named("longListToTareas")
//    protected List<Tarea> longListToTareas(List<Long> ids) {
//        return ids != null ? ids.stream().map(id -> tareaRepository.findById(id).orElse(null)).collect(Collectors.toList()) : null;
//    }
//
//    @Named("calificacionesToLongList")
//    protected List<Long> calificacionesToLongList(List<Calificacion> calificaciones) {
//        return calificaciones != null ? calificaciones.stream().map(Calificacion::getId).collect(Collectors.toList()) : null;
//    }
//
//    @Named("longListToCalificaciones")
//    protected List<Calificacion> longListToCalificaciones(List<Long> ids) {
//        return ids != null ? ids.stream().map(id -> calificacionRepository.findById(id).orElse(null)).collect(Collectors.toList()) : null;
//    }
}