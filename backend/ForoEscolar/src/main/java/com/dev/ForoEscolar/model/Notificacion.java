package com.dev.ForoEscolar.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Notificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date fecha_nevio;

    private String titulo;

    private String tipo_notificacion;

    private String mensaje;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "administrador_escolar", joinColumns = @JoinColumn(name = "notificacion_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = tutor_legal_id)
//    private TutorLegal tutor_legal;

}
