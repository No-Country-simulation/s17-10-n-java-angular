package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.enums.MateriaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "calificaciones")
@Entity(name = "Calificacion")
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private MateriaEnum materia;
    private Double nota;
    private Double promedio;
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
