package com.dev.ForoEscolar.dtos.estudiante;

import com.dev.ForoEscolar.enums.TipoDocumentoEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public record EstudianteResponseDTO(
        Long id,
        String nombre,
        String apellido,
        String dni,
        Date fechaNacimiento,
        String curso,
        String aula,
        TipoDocumentoEnum tipoDocumento,
        Boolean activo,
        Long tutor
//        List<Long> boletin,
//        List<Long> asistencia,
//        List<Long> tarea,
//        List<Long> calificaciones

) implements Serializable {


}
