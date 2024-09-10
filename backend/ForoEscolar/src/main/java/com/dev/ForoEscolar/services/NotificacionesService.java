package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.notificacion.NotificacionDTO;
import com.dev.ForoEscolar.model.Notificaciones;
import jakarta.validation.Valid;

import javax.management.ServiceNotFoundException;
import java.math.BigInteger;

public interface NotificacionesService extends  GenericServiceDto<Notificaciones, Long, NotificacionDTO> {



    Object sendEmial(@Valid NotificacionDTO notificacionDTO) throws ServiceNotFoundException;
}
