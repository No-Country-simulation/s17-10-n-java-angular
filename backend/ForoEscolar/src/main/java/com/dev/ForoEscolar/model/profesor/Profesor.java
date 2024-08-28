package com.dev.ForoEscolar.model.profesor;

import com.dev.ForoEscolar.enums.MateriaEnum;
import com.dev.ForoEscolar.model.Tarea;
import com.dev.ForoEscolar.model.User;
import com.dev.ForoEscolar.model.estudiante.Estudiante;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MateriaEnum materia;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name="FK_USER_ID"))
    private User usuario;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name="profesor_estudiante", joinColumns = @JoinColumn(name = "profesor_id"), inverseJoinColumns = @JoinColumn(name = "estudante_id"))
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "profesor",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Boletin> boletin;

    @OneToMany(mappedBy = "profesor",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Asistencia> asistencia;

    @OneToMany(mappedBy = "profesor",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Tarea> tarea;
}
