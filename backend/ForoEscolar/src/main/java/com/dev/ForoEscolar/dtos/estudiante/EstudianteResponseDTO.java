package com.dev.ForoEscolar.dtos.estudiante;

import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.RoleEnum;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;

import java.util.Date;
import java.util.List;

public record EstudianteResponseDTO(
        Long id,
        String nombre,
        String apellido,
        String dni,
        RoleEnum rol,
        Date nacimiento,
        CursoEnum curso,
        AulaEnum aula,
        TipoDocumentoEnum tipoDocumento,
        List<Long> boletinIds,
        List<Long> tareaIds
) {}
