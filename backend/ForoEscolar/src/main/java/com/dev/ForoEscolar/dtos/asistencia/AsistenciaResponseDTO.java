package com.dev.ForoEscolar.dtos.asistencia;

import com.dev.ForoEscolar.model.Asistencia;
import lombok.Value;
import java.io.Serializable;
import java.util.Date;


@Value
public class AsistenciaResponseDTO implements Serializable {

    private int contadorAsistencia;
    private double diasAnioEscolar;
    private Date fecha;
    private String estado;
    private String observaciones;
    private Long profesorId;
    private Long estudianteId;
}