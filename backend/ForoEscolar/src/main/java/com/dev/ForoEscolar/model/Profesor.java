package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.enums.MateriaEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "profesores")
@PrimaryKeyJoinColumn(name = "user_id")
@DiscriminatorValue("PROFESOR")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Profesor extends User {

    @Enumerated(EnumType.STRING)
    private MateriaEnum materia;

    @ManyToMany(fetch = FetchType.LAZY)//, cascade = CascadeType.ALL)
    @JoinTable(name="profesor_estudiante", joinColumns = @JoinColumn(name = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "estudiante_id"))
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "profesor",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Boletin> boletin;

    @OneToMany(mappedBy = "profesor",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Asistencia> asistencia;

    @OneToMany(mappedBy = "profesor")
    private List<Tarea> tarea;

    @OneToMany(mappedBy = "profesor")
    private List<Calificacion> calificaciones;

    @OneToMany(mappedBy = "profesor", cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Grado> grado;

}
