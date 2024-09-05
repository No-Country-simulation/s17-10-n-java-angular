package com.dev.ForoEscolar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
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