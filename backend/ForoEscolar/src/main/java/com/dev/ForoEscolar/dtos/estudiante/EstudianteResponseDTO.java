package com.dev.ForoEscolar.dtos.estudiante;

import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.GeneroEnum;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public record EstudianteResponseDTO(
        Long id,
        String nombre,
        String apellido,
        String dni,
        GeneroEnum genero,
        LocalDate fechaNacimiento,
        CursoEnum curso,
        AulaEnum aula,
        TipoDocumentoEnum tipoDocumento,
        Boolean activo,
        Long tutor,
//        List<Long> boletin,
        List<Long> asistencia
//        List<Long> tarea,
//        List<Long> calificaciones

) implements Serializable {


}
