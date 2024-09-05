package com.dev.ForoEscolar.dtos.estudiante;

import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.RoleEnum;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class EstudianteResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaNacimiento;
    @Enumerated(EnumType.STRING)
    private CursoEnum curso;
    @Enumerated(EnumType.STRING)
    private AulaEnum aula;
    @Enumerated(EnumType.STRING)
    private TipoDocumentoEnum tipoDocumento;
//    @Enumerated(EnumType.STRING)
//    private RoleEnum rol;
    private Boolean activo;
    private Long tutor;
   // private List<Long> asistencia;
      // private     List<Long> boletin;
    private List<Long> tarea;
   // private List<Long> calificacion;
}
//} implements Serializable {
//
//}
