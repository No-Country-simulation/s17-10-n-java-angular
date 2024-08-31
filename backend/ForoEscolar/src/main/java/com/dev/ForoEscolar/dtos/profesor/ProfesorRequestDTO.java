package com.dev.ForoEscolar.dtos.profesor;

import com.dev.ForoEscolar.enums.MateriaEnum;
import java.util.List;

public record ProfesorRequestDTO(
        MateriaEnum materia,
        Long userId,
        List<Long> estudianteIds,
        List<Long> boletinIds,
        List<Long> asistenciaIds,
        List<Long> tareaIds
) {}
