package com.dev.ForoEscolar.mapper.notificacion;

import com.dev.ForoEscolar.dtos.notificacion.NotificacionDTO;
import com.dev.ForoEscolar.enums.TipoNotificacionEnum;
import com.dev.ForoEscolar.model.Notificacion;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-17T11:57:18-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class NotificacionMapperImpl extends NotificacionMapper {

    @Override
    public NotificacionDTO toResponseDto(Notificacion notificacion) {
        if ( notificacion == null ) {
            return null;
        }

        Long user = null;
        Long tutorLegal = null;
        Long id = null;
        String titulo = null;
        LocalDate fecha = null;
        TipoNotificacionEnum tipo = null;
        String mensaje = null;

        user = userToLong( notificacion.getUser() );
        tutorLegal = tutorLegalToLong( notificacion.getTutorLegal() );
        id = notificacion.getId();
        titulo = notificacion.getTitulo();
        fecha = notificacion.getFecha();
        tipo = notificacion.getTipo();
        mensaje = notificacion.getMensaje();

        NotificacionDTO notificacionDTO = new NotificacionDTO( id, titulo, fecha, tipo, mensaje, user, tutorLegal );

        return notificacionDTO;
    }

    @Override
    public Notificacion toEntity(NotificacionDTO notificacionDTO) {
        if ( notificacionDTO == null ) {
            return null;
        }

        Notificacion notificacion = new Notificacion();

        notificacion.setUser( longToUser( notificacionDTO.user() ) );
        notificacion.setTutorLegal( longToTutorLegal( notificacionDTO.tutorLegal() ) );
        notificacion.setId( notificacionDTO.id() );
        notificacion.setTitulo( notificacionDTO.titulo() );
        notificacion.setFecha( notificacionDTO.fecha() );
        notificacion.setMensaje( notificacionDTO.mensaje() );
        notificacion.setTipo( notificacionDTO.tipo() );

        return notificacion;
    }
}
