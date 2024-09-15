package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.MateriaEnum;
import com.dev.ForoEscolar.enums.TurnoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
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

}
