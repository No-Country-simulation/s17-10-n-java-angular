package com.dev.ForoEscolar.dtos.estudiante;

import com.dev.ForoEscolar.enums.GeneroEnum;
import com.dev.ForoEscolar.enums.RoleEnum;
import com.dev.ForoEscolar.enums.TipoDocumentoEnum;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public record EstudianteResponseDTO(
        Long id,
        String nombre,
        String apellido,
        String dni,
        GeneroEnum genero,
        Date fechaNacimiento,
        String curso,
        String aula,
        TipoDocumentoEnum tipoDocumento,
        Boolean activo,
        Long tutorId
//        List<Long> boletinIds,
//        List<Long> asistenciaIds,
//        List<Long> tareaIds,
//        List<Long> calificacionesIds

) implements Serializable {


}
