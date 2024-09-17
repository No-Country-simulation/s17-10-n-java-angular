package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.MateriaEnum;
import com.dev.ForoEscolar.enums.TurnoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Grado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private AulaEnum aula;
    @Enumerated(value = EnumType.STRING)
    private CursoEnum curso;
    @Enumerated(value = EnumType.STRING)
    private TurnoEnum turno;
    @Enumerated(value = EnumType.STRING)
    private MateriaEnum materia;

    @ManyToOne
    @JoinColumn(name="profesor_id")
    private Profesor profesor;

    @OneToMany(mappedBy = "grado",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Estudiante> estudiantes;

}
