package com.dev.ForoEscolar.dtos.estudiante;

import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.RoleEnum;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

public record EstudianteResponseDTO(
        @NotNull
        Long id,
        @NotNull
        String nombre,
        @NotNull
        String apellido,
        @NotNull
        String dni,
        @NotNull
        RoleEnum rol,
        @NotNull
        Date nacimiento,
        @NotNull
        CursoEnum curso,
        @NotNull
        AulaEnum aula,
        @NotNull
        TipoDocumentoEnum tipoDocumento,
        @NotNull
        List<Long> boletinIds,
        @NotNull
        List<Long> asistenciaIds,
        @NotNull
        List<Long> tareaIds
) {}
