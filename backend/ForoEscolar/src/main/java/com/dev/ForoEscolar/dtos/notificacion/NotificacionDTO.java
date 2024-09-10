package com.dev.ForoEscolar.dtos.notificacion;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;


public record NotificacionDTO(
        @NotBlank
        @NotEmpty
        Long idUser,
        @NotBlank
        @Email
        @NotEmpty
        String email,
        @NotBlank
        @NotEmpty
        String mensaje,
        @NotBlank
        @NotEmpty
        String tipo_notificacion,
        @NotBlank
        @NotEmpty
        String titulo) {

}
