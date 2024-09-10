package com.dev.ForoEscolar.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "notficaciones")
public class Notificaciones {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "administrador_escolar_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administrador_escolar_id", referencedColumnName = "id")
    private User administrador_escolar_id;


    @Column(name = "fecha_envio")
    private Date fecha_envio;


    @Column(name = "tutor_legal_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_legal_id", referencedColumnName = "id")
    private User tutor_legal_id;

    @Column(name = "mensaje")
     private String mensaje;

    //Cambiar a enum!!!
    @Column(name = "tipo_notificacion")
     private String tipo_notificacion;

    @Column(name = "titulos")
     private String titulo;

}
