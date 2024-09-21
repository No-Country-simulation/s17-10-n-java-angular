package com.dev.ForoEscolar.dtos.notificacion;

import com.dev.ForoEscolar.enums.TipoNotificacionEnum;

import java.io.Serializable;
import java.time.LocalDate;

public record NotificacionDTO (

        Long id,
        String titulo,
        LocalDate fecha,
        TipoNotificacionEnum tipo,
        String mensaje,
        Long user,
        Long tutorLegal

)implements Serializable {
}
