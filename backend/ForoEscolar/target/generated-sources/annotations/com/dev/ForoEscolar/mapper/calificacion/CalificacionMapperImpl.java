package com.dev.ForoEscolar.mapper.calificacion;

import com.dev.ForoEscolar.dtos.calificacion.CalificacionDTO;
import com.dev.ForoEscolar.model.Calificacion;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-15T16:44:15-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22 (Oracle Corporation)"
)
@Component
public class CalificacionMapperImpl extends CalificacionMapper {

    @Override
    public Calificacion toEntity(CalificacionDTO calificacionDTO) {
        if ( calificacionDTO == null ) {
            return null;
        }

        Calificacion calificacion = new Calificacion();

        calificacion.setEstudiante( longToEstudiante( calificacionDTO.getEstudiante() ) );
        calificacion.setProfesor( longToProfesor( calificacionDTO.getProfesor() ) );
        calificacion.setBoletin( longToBoletin( calificacionDTO.getBoletin() ) );
        calificacion.setId( calificacionDTO.getId() );
        calificacion.setMateria( calificacionDTO.getMateria() );
        calificacion.setNota( calificacionDTO.getNota() );
        calificacion.setPromedio( calificacionDTO.getPromedio() );
        calificacion.setComentario( calificacionDTO.getComentario() );
        if ( calificacionDTO.getFecha() != null ) {
            calificacion.setFecha( LocalDate.parse( calificacionDTO.getFecha() ) );
        }
        calificacion.setPeriodo( calificacionDTO.getPeriodo() );

        return calificacion;
    }

    @Override
    public CalificacionDTO toResponseDto(Calificacion calificacion) {
        if ( calificacion == null ) {
            return null;
        }

        CalificacionDTO.CalificacionDTOBuilder calificacionDTO = CalificacionDTO.builder();

        calificacionDTO.estudiante( estudianteToLong( calificacion.getEstudiante() ) );
        calificacionDTO.profesor( profesorToLong( calificacion.getProfesor() ) );
        calificacionDTO.boletin( boletinToLong( calificacion.getBoletin() ) );
        calificacionDTO.id( calificacion.getId() );
        calificacionDTO.materia( calificacion.getMateria() );
        calificacionDTO.nota( calificacion.getNota() );
        calificacionDTO.promedio( calificacion.getPromedio() );
        calificacionDTO.comentario( calificacion.getComentario() );
        if ( calificacion.getFecha() != null ) {
            calificacionDTO.fecha( DateTimeFormatter.ISO_LOCAL_DATE.format( calificacion.getFecha() ) );
        }
        calificacionDTO.periodo( calificacion.getPeriodo() );

        return calificacionDTO.build();
    }
}
