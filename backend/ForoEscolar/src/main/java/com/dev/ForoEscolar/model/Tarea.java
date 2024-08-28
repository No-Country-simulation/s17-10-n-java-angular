package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.model.estudiante.Estudiante;
import com.dev.ForoEscolar.model.profesor.Profesor;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
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


    private Date fechaEntrega;
    private boolean activo;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
    @ManyToOne
    @JoinColumn(name = "profesores_id")
    private Profesor profesor;


}
