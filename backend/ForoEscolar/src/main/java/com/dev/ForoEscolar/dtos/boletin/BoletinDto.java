package com.dev.ForoEscolar.dtos.boletin;

import com.dev.ForoEscolar.enums.CursoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoletinDto {

    private Long id;
    private Double promedio;
    private String observaciones;
    private String periodo;

    @Enumerated(EnumType.STRING)
    private CursoEnum curso;
    private List<Long> calificacion;
    private Long estudiante;
    private LocalDate fecha;

}
