package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estudiantes")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    private Boolean activo;

    @Enumerated(EnumType.STRING)
    private RoleEnum rol;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Enumerated(EnumType.STRING)
    private CursoEnum curso;

    @Enumerated(EnumType.STRING)
    private AulaEnum aula;

    @Column(name = "tipo_documento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDocumentoEnum tipoDocumento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tutor_legal_id", nullable = false, foreignKey = @ForeignKey(name="FK_TUTOR_LEGAL"))
    private TutorLegal tutor;

    @OneToMany(mappedBy = "estudiante",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Boletin> boletin  = new ArrayList<>();

    @OneToMany(mappedBy = "estudiante",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Asistencia> asistencia  = new ArrayList<>();

    @OneToMany(mappedBy = "estudiante",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Tarea> tarea  = new ArrayList<>();

    @OneToMany(mappedBy = "estudiante", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Calificacion> calificaciones  = new ArrayList<>();
}
