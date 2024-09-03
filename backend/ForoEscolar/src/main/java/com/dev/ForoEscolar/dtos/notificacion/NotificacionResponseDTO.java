package com.dev.ForoEscolar.dtos.notificacion;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record NotificacionResponseDTO(
        Long id,
        Date fecha_nevio,
        String titulo,
        String tipo_notificacion,
        String mensaje
//        Long userId,
//        TutorLegal tutor_legal_id
) {
}
