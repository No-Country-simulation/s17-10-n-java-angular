package com.dev.ForoEscolar.dtos.calificacion;

import com.dev.ForoEscolar.enums.MateriaEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Builder
@Data
public class CalificacionDTO {
    private Long id;
    @Enumerated(EnumType.STRING)
    private MateriaEnum materia;
    private Double nota;
    //private Double promedio;
    private String comentario;
    private LocalDate fecha;
    private String periodo;
    private Long estudiante;
    private Long profesor;
    private Long boletin;


}
