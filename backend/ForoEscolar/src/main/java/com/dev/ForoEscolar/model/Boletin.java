package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.MateriaEnum;
import jakarta.persistence.*;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Boletin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double promedio;
    private String comentarios;
    private String pedido;
    private LocalDate fechaEmision;
    private String observaciones;
    private String periodo;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Enumerated(EnumType.STRING)
    private CursoEnum curso;

    @OneToMany(mappedBy = "boletin", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Calificacion> calificaciones;

    //private Set<Calificacion> calificaciones;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;






}
