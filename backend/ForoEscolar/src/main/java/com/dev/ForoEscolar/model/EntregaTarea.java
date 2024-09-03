package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.enums.EstadoEntregaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "entrega_tarea")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntregaTarea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    private Tarea tarea;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    private LocalDateTime fechaEntrega;

    @Enumerated(EnumType.STRING)
    private EstadoEntregaEnum estado;
}
