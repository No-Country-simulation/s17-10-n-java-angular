package com.dev.ForoEscolar.mapper.estudiante;

import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.GeneroEnum;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;
import com.dev.ForoEscolar.model.Estudiante;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-14T10:22:02-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class EstudianteMapperImpl extends EstudianteMapper {

    @Override
    public EstudianteResponseDTO toResponseDTO(Estudiante estudiante) {
        if ( estudiante == null ) {
            return null;
        }

        Long tutor = null;
        List<Long> boletin = null;
        List<Long> asistencia = null;
        List<Long> tarea = null;
        List<Long> calificaciones = null;
        Long id = null;
        String nombre = null;
        String apellido = null;
        String dni = null;
        GeneroEnum genero = null;
        LocalDate fechaNacimiento = null;
        String curso = null;
        String aula = null;
        TipoDocumentoEnum tipoDocumento = null;
        Boolean activo = null;

        tutor = tutorToLong( estudiante.getTutor() );
        boletin = boletinesToLongList( estudiante.getBoletin() );
        asistencia = asistenciasToLongList( estudiante.getAsistencia() );
        tarea = tareasToLongList( estudiante.getTarea() );
        calificaciones = calificacionesToLongList( estudiante.getCalificaciones() );
        id = estudiante.getId();
        nombre = estudiante.getNombre();
        apellido = estudiante.getApellido();
        dni = estudiante.getDni();
        genero = estudiante.getGenero();
        if ( estudiante.getFechaNacimiento() != null ) {
            fechaNacimiento = estudiante.getFechaNacimiento().toLocalDate();
        }
        if ( estudiante.getCurso() != null ) {
            curso = estudiante.getCurso().name();
        }
        if ( estudiante.getAula() != null ) {
            aula = estudiante.getAula().name();
        }
        tipoDocumento = estudiante.getTipoDocumento();
        activo = estudiante.getActivo();

        EstudianteResponseDTO estudianteResponseDTO = new EstudianteResponseDTO( id, nombre, apellido, dni, genero, fechaNacimiento, curso, aula, tipoDocumento, activo, tutor, asistencia, boletin, tarea, calificaciones );

        return estudianteResponseDTO;
    }

    @Override
    public Estudiante toEntity(EstudianteResponseDTO estudianteResponseDTO) {
        if ( estudianteResponseDTO == null ) {
            return null;
        }

        Estudiante.EstudianteBuilder estudiante = Estudiante.builder();

        estudiante.tutor( longToTutor( estudianteResponseDTO.tutor() ) );
        estudiante.boletin( longListToBoletines( estudianteResponseDTO.boletin() ) );
        estudiante.asistencia( longListToAsistencias( estudianteResponseDTO.asistencia() ) );
        estudiante.tarea( longListToTareas( estudianteResponseDTO.tarea() ) );
        estudiante.calificaciones( longListToCalificaciones( estudianteResponseDTO.calificaciones() ) );
        estudiante.id( estudianteResponseDTO.id() );
        estudiante.nombre( estudianteResponseDTO.nombre() );
        estudiante.apellido( estudianteResponseDTO.apellido() );
        estudiante.dni( estudianteResponseDTO.dni() );
        estudiante.genero( estudianteResponseDTO.genero() );
        estudiante.activo( estudianteResponseDTO.activo() );
        if ( estudianteResponseDTO.fechaNacimiento() != null ) {
            estudiante.fechaNacimiento( new Date( estudianteResponseDTO.fechaNacimiento().atStartOfDay( ZoneOffset.UTC ).toInstant().toEpochMilli() ) );
        }
        if ( estudianteResponseDTO.curso() != null ) {
            estudiante.curso( Enum.valueOf( CursoEnum.class, estudianteResponseDTO.curso() ) );
        }
        if ( estudianteResponseDTO.aula() != null ) {
            estudiante.aula( Enum.valueOf( AulaEnum.class, estudianteResponseDTO.aula() ) );
        }
        estudiante.tipoDocumento( estudianteResponseDTO.tipoDocumento() );

        return estudiante.build();
    }
}
