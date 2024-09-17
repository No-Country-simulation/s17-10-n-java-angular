package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.enums.MateriaEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "calificaciones")
@Entity(name = "Calificacion")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MateriaEnum materia;
    private Double nota;
    //private Double promedio;
    private String comentario;
    private LocalDate fecha;
    private String periodo;
    @ManyToOne
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudiante;
    @ManyToOne
    @JoinColumn(name = "profesor_id", nullable = false)
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "boletin_id")
    private Boletin boletin;

}
