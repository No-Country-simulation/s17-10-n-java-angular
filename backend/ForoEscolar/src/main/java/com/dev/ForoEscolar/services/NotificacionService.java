package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.notificacion.NotificacionResponseDTO;

public interface NotificacionService extends GenericServiceDto<Long, NotificacionResponseDTO>{

    NotificacionResponseDTO update(NotificacionResponseDTO notificacionResponseDTO);
}
