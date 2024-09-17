package com.dev.ForoEscolar.mapper.calificacion;

import com.dev.ForoEscolar.dtos.calificacion.CalificacionDTO;
import com.dev.ForoEscolar.model.Calificacion;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-17T11:57:19-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class CalificacionMapperImpl extends CalificacionMapper {

    @Override
    public Calificacion toEntity(CalificacionDTO calificacionDTO) {
        if ( calificacionDTO == null ) {
            return null;
        }

        Calificacion.CalificacionBuilder calificacion = Calificacion.builder();

        calificacion.estudiante( longToEstudiante( calificacionDTO.getEstudiante() ) );
        calificacion.profesor( longToProfesor( calificacionDTO.getProfesor() ) );
        calificacion.boletin( longToBoletin( calificacionDTO.getBoletin() ) );
        calificacion.id( calificacionDTO.getId() );
        calificacion.materia( calificacionDTO.getMateria() );
        calificacion.nota( calificacionDTO.getNota() );
        calificacion.comentario( calificacionDTO.getComentario() );
        calificacion.fecha( calificacionDTO.getFecha() );
        calificacion.periodo( calificacionDTO.getPeriodo() );

        return calificacion.build();
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
        calificacionDTO.comentario( calificacion.getComentario() );
        calificacionDTO.fecha( calificacion.getFecha() );
        calificacionDTO.periodo( calificacion.getPeriodo() );

        return calificacionDTO.build();
    }
}
