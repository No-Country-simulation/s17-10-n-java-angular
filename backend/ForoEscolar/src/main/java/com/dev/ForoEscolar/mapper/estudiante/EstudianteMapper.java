package com.dev.ForoEscolar.mapper.estudiante;


import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.model.*;
import com.dev.ForoEscolar.repository.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;



//@Mapper(componentModel = "spring", uses = {TutorLegalRepository.class, BoletinRepository.class, AsistenciaRepository.class, TareaRepository.class, CalificacionRepository.class})
@Mapper(componentModel = "spring", uses = {TutorLegalRepository.class})

public abstract class EstudianteMapper {

    //public static final EstudianteMapper INSTANCE = Mappers.getMapper(EstudianteMapper.class);

    @Autowired
    private TutorLegalRepository tutorLegalRepository;
//    @Autowired
//    private BoletinRepository boletinRepository;
//    @Autowired
//    private AsistenciaRepository asistenciaRepository;
//    @Autowired
//    private TareaRepository tareaRepository;
//    @Autowired
//    private CalificacionRepository calificacionRepository;

    @Mapping(source = "tutor", target = "tutorId", qualifiedByName = "tutorToLong")
//    @Mapping(source = "boletin", target = "boletinIds", qualifiedByName = "boletinesToLongList")
//    @Mapping(source = "asistencia", target = "asistenciaIds", qualifiedByName = "asistenciasToLongList")
//    @Mapping(source = "tarea", target = "tareaIds", qualifiedByName = "tareasToLongList")
//    @Mapping(source = "calificaciones", target = "calificacionesIds", qualifiedByName = "calificacionesToLongList")
    public abstract EstudianteResponseDTO toResponseDTO(Estudiante estudiante);


    @Mapping(source = "tutorId", target = "tutor", qualifiedByName = "longToTutor")
//    @Mapping(source = "boletinIds", target = "boletin", qualifiedByName = "longListToBoletines")
//    @Mapping(source = "asistenciaIds", target = "asistencia", qualifiedByName = "longListToAsistencias")
//    @Mapping(source = "tareaIds", target = "tarea", qualifiedByName = "longListToTareas")
//    @Mapping(source = "calificacionesIds", target = "calificaciones", qualifiedByName = "longListToCalificaciones")
    public abstract Estudiante toEntity(EstudianteResponseDTO estudianteResponseDTO);

    @Named("tutorToLong")
    protected Long tutorToLong(TutorLegal tutor) {
        return tutor != null ? tutor.getId() : null;
    }

    @Named("longToTutor")
    protected TutorLegal longToTutor(Long id) {
        return id != null ? tutorLegalRepository.findById(id).orElse(null) : null;
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
//
//    @Named("asistenciasToLongList")
//    protected List<Long> asistenciasToLongList(List<Asistencia> asistencias) {
//        return asistencias != null ? asistencias.stream().map(Asistencia::getId).collect(Collectors.toList()) : null;
//    }
//
//    @Named("longListToAsistencias")
//    protected List<Asistencia> longListToAsistencias(List<Long> ids) {
//        return ids != null ? ids.stream().map(id -> asistenciaRepository.findById(id).orElse(null)).collect(Collectors.toList()) : null;
//    }
//
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