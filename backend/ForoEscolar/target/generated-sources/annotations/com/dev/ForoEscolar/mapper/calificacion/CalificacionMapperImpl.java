package com.dev.ForoEscolar.mapper.calificacion;

import com.dev.ForoEscolar.dtos.calificacion.CalificacionDTO;
import com.dev.ForoEscolar.enums.MateriaEnum;
import com.dev.ForoEscolar.model.Calificacion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-10T04:22:45-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class CalificacionMapperImpl extends CalificacionMapper {

    @Override
    public Calificacion toEntity(CalificacionDTO calificacionDTO) {
        if ( calificacionDTO == null ) {
            return null;
        }

        Calificacion calificacion = new Calificacion();

        calificacion.setEstudiante( longToEstudiante( calificacionDTO.estudiante() ) );
        calificacion.setProfesor( longToProfesor( calificacionDTO.profesor() ) );
        calificacion.setBoletin( longToBoletin( calificacionDTO.boletin() ) );
        calificacion.setId( calificacionDTO.id() );
        if ( calificacionDTO.materia() != null ) {
            calificacion.setMateria( Enum.valueOf( MateriaEnum.class, calificacionDTO.materia() ) );
        }
        calificacion.setNota( calificacionDTO.nota() );
        calificacion.setPromedio( calificacionDTO.promedio() );
        calificacion.setComentario( calificacionDTO.comentario() );
        if ( calificacionDTO.fecha() != null ) {
            calificacion.setFecha( LocalDate.parse( calificacionDTO.fecha() ) );
        }
        calificacion.setPeriodo( calificacionDTO.periodo() );

        return calificacion;
    }

    @Override
    public CalificacionDTO toResponseDto(Calificacion calificacion) {
        if ( calificacion == null ) {
            return null;
        }

        Long estudiante = null;
        Long profesor = null;
        Long boletin = null;
        Long id = null;
        String materia = null;
        Double nota = null;
        Double promedio = null;
        String comentario = null;
        String fecha = null;
        String periodo = null;

        estudiante = estudianteToLong( calificacion.getEstudiante() );
        profesor = profesorToLong( calificacion.getProfesor() );
        boletin = boletinToLong( calificacion.getBoletin() );
        id = calificacion.getId();
        if ( calificacion.getMateria() != null ) {
            materia = calificacion.getMateria().name();
        }
        nota = calificacion.getNota();
        promedio = calificacion.getPromedio();
        comentario = calificacion.getComentario();
        if ( calificacion.getFecha() != null ) {
            fecha = DateTimeFormatter.ISO_LOCAL_DATE.format( calificacion.getFecha() );
        }
        periodo = calificacion.getPeriodo();

        CalificacionDTO calificacionDTO = new CalificacionDTO( id, materia, nota, promedio, comentario, fecha, periodo, estudiante, profesor, boletin );

        return calificacionDTO;
    }
}
