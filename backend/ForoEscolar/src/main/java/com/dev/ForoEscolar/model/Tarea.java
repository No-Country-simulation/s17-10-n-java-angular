package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.enums.EstadoEntregaEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private String titulo;
    private LocalDate fechaEntrega;
    private boolean activo;
    @Enumerated(EnumType.STRING)
    private EstadoEntregaEnum estadoDeEntrega;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

}
