package com.dev.ForoEscolar.dtos.notificacion;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;


public record NotificacionDTO(
        DateTimeFormat fecha_envio,
        String mensaje,
        String tipo_notificacion,
        String titulo) {

}
