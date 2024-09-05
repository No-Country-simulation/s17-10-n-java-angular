package com.dev.ForoEscolar.dtos.estudiante;

import com.dev.ForoEscolar.enums.TipoDocumentoEnum;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public record EstudianteResponseDTO(
        Long id,
        String nombre,
        String apellido,
        String dni,
        LocalDate fechaNacimiento,
        String curso,
        String aula,
        TipoDocumentoEnum tipoDocumento,
        Boolean activo,
        Long tutor,
        List<Long> asistencia,
        List<Long> boletin,
        List<Long> tarea,
        List<Long> calificaciones
) implements Serializable {

}
