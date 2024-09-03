package com.dev.ForoEscolar.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Notificaciones {

    public Notificaciones(String mensaje){
        this.mensaje = mensaje;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long administrador_escolar_id;


    private DateTimeFormat fecha_envio;

    @Column(name = "id", unique = true, nullable = false)
    private Long id;

     @ManyToMany
     @JoinTable( name = "tutor_notification",
             joinColumns = @JoinColumn(name = "notificacion", referencedColumnName = "administrador_escolar_id"),
             inverseJoinColumns = @JoinColumn(name = "tutor_legal", referencedColumnName = "id")

     )
    private List<User> tutor_legal;

     private String mensaje;

     private String tipo_notificacion;

     private String titulo;

}
