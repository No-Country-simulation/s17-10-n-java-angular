package com.dev.ForoEscolar.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "asistencia")
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "contador_asistencias")
    private int contadorAsistencia;

    @Column(name = "dias_anio_escolar")
    private double diasAnioEscolar;

    @Column(name = "fecha")
    private LocalDate fecha;

    private String estado;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

}