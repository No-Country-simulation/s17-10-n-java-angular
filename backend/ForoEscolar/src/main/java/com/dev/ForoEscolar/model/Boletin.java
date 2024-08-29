package com.dev.ForoEscolar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boletin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double calificacion;
    private String comentarios;
    private String pedido;
    @Enumerated(EnumType.STRING)
    private CursoEnum curso;
    @Enumerated(EnumType.STRING)
    private MateriaEnum materia;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;




}
