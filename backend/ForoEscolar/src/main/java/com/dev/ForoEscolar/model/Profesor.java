package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.enums.MateriaEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MateriaEnum materia;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name = "FK_PROFILES_USER"))
    private User user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="profesor_estudiante", joinColumns = @JoinColumn(name = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "estudiante_id"))
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "profesor",orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Boletin> boletin;

    @OneToMany(mappedBy = "profesorId",orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Asistencia> asistencia;

    @OneToMany(mappedBy = "profesor", orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Tarea> tarea;
}