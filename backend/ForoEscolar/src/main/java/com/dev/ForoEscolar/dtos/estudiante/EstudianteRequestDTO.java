package com.dev.ForoEscolar.dtos.estudiante;

import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EstudianteRequestDTO {

    @NotNull(message = "El DNI no puede estar vacío")
    private String dni;

    @NotNull(message = "La fecha de nacimiento no puede estar vacía")
    private Date nacimiento;

    @NotNull(message = "El curso no puede estar vacío")
    private CursoEnum curso;

    @NotNull(message = "El aula no puede estar vacía")
    private AulaEnum aula;

    @NotNull(message = "El tipo de documento no puede estar vacío")
    private TipoDocumentoEnum tipoDocumento;

    @NotNull(message = "El ID del usuario no puede estar vacío")
    private Long usuarioId;

    @NotNull(message = "El ID del tutor legal no puede estar vacío")
    private Long tutorId;
}
