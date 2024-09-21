package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.enums.CursoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Boletin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double promedio;
    private String observaciones;
    private String periodo;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Enumerated(EnumType.STRING)
    private CursoEnum curso;

    @OneToMany(mappedBy = "boletin", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Calificacion> calificacion;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

}
