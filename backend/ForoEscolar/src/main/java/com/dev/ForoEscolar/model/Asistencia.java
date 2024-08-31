package com.dev.ForoEscolar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
    private Date fecha;

    private String estado;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesorId;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudianteId;

    public Asistencia(Long id) {
        this.Id = id;
    }
}
