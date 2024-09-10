package com.dev.ForoEscolar.mapper.asistencia;

import com.dev.ForoEscolar.dtos.asistencia.AsistenciaDTO;
import com.dev.ForoEscolar.model.Asistencia;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-10T12:05:51-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class AsistenciaMapperImpl extends AsistenciaMapper {

    @Override
    public Asistencia toEntity(AsistenciaDTO asistenciaDTO) {
        if ( asistenciaDTO == null ) {
            return null;
        }

        Asistencia asistencia = new Asistencia();

        asistencia.setProfesor( longToProfesor( asistenciaDTO.profesor() ) );
        asistencia.setEstudiante( longToEstudiante( asistenciaDTO.estudiante() ) );
        asistencia.setId( asistenciaDTO.id() );
        asistencia.setAsistio( asistenciaDTO.asistio() );
        asistencia.setDiasAnioEscolar( asistenciaDTO.diasAnioEscolar() );
        asistencia.setFecha( asistenciaDTO.fecha() );
        asistencia.setObservaciones( asistenciaDTO.observaciones() );

        return asistencia;
    }

    @Override
    public AsistenciaDTO toResponseDto(Asistencia asistencia) {
        if ( asistencia == null ) {
            return null;
        }

        Long profesor = null;
        Long estudiante = null;
        Long id = null;
        boolean asistio = false;
        double diasAnioEscolar = 0.0d;
        LocalDate fecha = null;
        String observaciones = null;

        profesor = profesorToLong( asistencia.getProfesor() );
        estudiante = estudianteToLong( asistencia.getEstudiante() );
        id = asistencia.getId();
        asistio = asistencia.isAsistio();
        diasAnioEscolar = asistencia.getDiasAnioEscolar();
        fecha = asistencia.getFecha();
        observaciones = asistencia.getObservaciones();

        double porcentajeAsistencia = 0.0d;

        AsistenciaDTO asistenciaDTO = new AsistenciaDTO( id, asistio, diasAnioEscolar, fecha, observaciones, porcentajeAsistencia, profesor, estudiante );

        return asistenciaDTO;
    }
}
