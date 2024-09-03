package com.dev.ForoEscolar.dtos.profesor;

import com.dev.ForoEscolar.enums.MateriaEnum;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record ProfesorRequestDTO(
        @NotNull
        MateriaEnum materia,
        @NotNull
        Long userId,
        @NotNull
        List<Long> estudianteIds,
        @NotNull
        List<Long> boletinIds,
        @NotNull
        List<Long> asistenciaIds,
        @NotNull
        List<Long> tareaIds
) {}
