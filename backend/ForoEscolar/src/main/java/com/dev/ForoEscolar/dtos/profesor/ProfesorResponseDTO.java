package com.dev.ForoEscolar.dtos.profesor;

import com.dev.ForoEscolar.enums.MateriaEnum;
import java.util.List;

public record ProfesorResponseDTO(

        MateriaEnum materia,
        Long userId,
        //String userName, Añadir nombre del usuario
        List<Long> estudianteIds,
        List<Long> boletinIds,
        List<Long> asistenciaIds,
        List<Long> tareaIds
) {}
