package com.dev.ForoEscolar.dtos.estudiante;

import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EstudianteResponseDTO {
    private Long id;
    private String dni;
    private Date nacimiento;
    private CursoEnum curso;
    private AulaEnum aula;
    private TipoDocumentoEnum tipoDocumento;
    private String usuarioNombre;
    private String tutorNombre;
    private List<String> boletinResumen;  // Resumen o IDs de los boletines
    private List<String> asistenciaResumen;  // Resumen o IDs de asistencias
    private List<String> tareaResumen;  // Resumen o IDs de tareas
}
