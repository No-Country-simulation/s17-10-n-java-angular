package com.dev.ForoEscolar.model;

import jakarta.persistence.*;

@Entity
public class Calificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "boletin_id")
    private Boletin boletin;
}
