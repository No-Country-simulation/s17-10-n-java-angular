package com.dev.ForoEscolar.mapper.notificaciones;

import com.dev.ForoEscolar.dtos.notificacion.NotificacionDTO;
import com.dev.ForoEscolar.model.Notificaciones;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotifiacacionesMapper {

    NotifiacacionesMapper INSTANCE = Mappers.getMapper(NotifiacacionesMapper.class);

    NotificacionDTO toResponseNotificacion(Notificaciones notificaciones);
    Notificaciones toEntity(NotificacionDTO notificacionDTO);


}
