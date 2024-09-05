package com.dev.ForoEscolar.mapper.notificacion;

import com.dev.ForoEscolar.dtos.notificacion.NotificacionResponseDTO;
import com.dev.ForoEscolar.model.Notificacion;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

public interface NotificacionMapper {

    NotificacionMapper INSTANCE = Mappers.getMapper(NotificacionMapper.class);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "fechaEnvio", target = "fecha_nevio"),
            @Mapping(source = "titulo", target = "titulo"),
            @Mapping(source = "tipoNotificacion", target = "tipo_notificacion"),
            @Mapping(source = "mensaje", target = "mensaje")

    })
    NotificacionResponseDTO toResponseDTO(Notificacion notificacion);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "fecha_nevio", target = "fechaEnvio"),
            @Mapping(source = "titulo", target = "titulo"),
            @Mapping(source = "tipo_notificacion", target = "tipoNotificacion"),
            @Mapping(source = "mensaje", target = "mensaje")

    })
    Notificacion toEntity(NotificacionResponseDTO notificacionResponseDTO);
}
