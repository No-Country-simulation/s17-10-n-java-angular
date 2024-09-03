package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.notificacion.NotificacionResponseDTO;
import com.dev.ForoEscolar.model.Notificacion;

public interface INotificacionService extends GenericServiceDto<Notificacion, Long, NotificacionResponseDTO>{

    NotificacionResponseDTO update(NotificacionResponseDTO notificacionResponseDTO);
}
