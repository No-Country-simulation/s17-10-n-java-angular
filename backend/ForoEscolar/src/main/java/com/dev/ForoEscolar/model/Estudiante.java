package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.RoleEnum;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

    @Enumerated(EnumType.STRING)
    private RoleEnum rol;

    @Column(name = "fecha_nacimiento")
    private Date nacimiento;

    @Enumerated(EnumType.STRING)
    private CursoEnum curso;

    @Enumerated(EnumType.STRING)
    private AulaEnum aula;

    @Column(name = "tipo_documento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDocumentoEnum tipoDocumento;

//    @ManyToOne
//    @JoinColumn(name = "tutor_legal",nullable = false,foreignKey = @ForeignKey(name="FK_TUTOR_LEGAL"))
//    private TutorLegal tutor;
//
//    @OneToMany(mappedBy = "estudiante",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
//    private List<Boletin> boletin;
//
//    @OneToMany(mappedBy = "estudiante",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
//    private List<Asistencia> asistencia;

    @OneToMany(mappedBy = "estudiante",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Tarea> tarea;

    @OneToMany(mappedBy = "estudiante")
    private Set<Calificacion> calificaciones;
}
