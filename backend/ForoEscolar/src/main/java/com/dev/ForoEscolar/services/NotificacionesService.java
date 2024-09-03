package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.notificacion.NotificacionDTO;
import com.dev.ForoEscolar.model.Notificaciones;

import java.math.BigInteger;

public interface NotificacionesService extends  GenericServiceDto<Notificaciones, BigInteger, NotificacionDTO> {

    public void sendEmial(String email, String notification);
    String getNotificacion(String key);
}
