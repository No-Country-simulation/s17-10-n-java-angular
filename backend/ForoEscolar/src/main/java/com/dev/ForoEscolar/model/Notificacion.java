package com.dev.ForoEscolar.model;


import com.dev.ForoEscolar.enums.TipoNotificacionEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "notificaciones")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titulo;

    @Column(name = "fecha_envio")
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "administrador_escolar_id" )
    private User user;

    @ManyToOne
    @JoinColumn(name = "tutor_legal_id")
    private TutorLegal tutorLegal;

    private String mensaje;

    @Enumerated(EnumType.STRING)
    private TipoNotificacionEnum tipo;

}
