package com.dev.ForoEscolar.model.estudiante;

import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;
import com.dev.ForoEscolar.model.Tarea;
import com.dev.ForoEscolar.model.User;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dni;

    @Column(name = "fecha_nacimiento")
    private Date nacimiento;

    @Enumerated(EnumType.STRING)
    private CursoEnum curso;

    @Enumerated(EnumType.STRING)
    private AulaEnum aula;

    @Column(name = "tipo_documento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoDocumentoEnum tipoDocumento;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false,foreignKey = @ForeignKey(name="FK_USER_ID"))
    private User usuario;

    @ManyToOne
    @JoinColumn(name = "tutor_legal",nullable = false,foreignKey = @ForeignKey(name="FK_TUTOR_LEGAL"))
    private TutorLegal tutor;

    @OneToMany(mappedBy = "estudiante",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Boletin> boletin;

    @OneToMany(mappedBy = "estudiante",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Asistencia> asistencia;

    @OneToMany(mappedBy = "estudiante",cascade = {CascadeType.ALL},orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Tarea> tarea;
}
