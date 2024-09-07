package com.dev.ForoEscolar.dtos.tarea;

import com.dev.ForoEscolar.enums.EstadoEntregaEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TareaResponseDto {

    private Long id;
    private String descripcion;
    private String titulo;
    private Date fechaEntrega;
    private boolean activo;

//    @Enumerated(EnumType.STRING)
//    private EstadoEntregaEnum estadoDeEntrega;


    private Long profesorId;
    private Long estudianteId;


}
