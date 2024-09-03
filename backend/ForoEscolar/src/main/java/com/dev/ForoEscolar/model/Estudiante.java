package com.dev.ForoEscolar.model;

import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.RoleEnum;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    @OneToMany(mappedBy = "estudiante",orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Boletin> boletin;

    @OneToMany(mappedBy = "estudianteId",orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Asistencia> asistencia;

    @OneToMany(mappedBy = "estudiante",orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Tarea> tarea;

    public Estudiante(Long id) {
        this.id = id;
    }
}
