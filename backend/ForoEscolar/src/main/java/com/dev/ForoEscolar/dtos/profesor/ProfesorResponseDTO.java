package com.dev.ForoEscolar.dtos.profesor;

import com.dev.ForoEscolar.enums.MateriaEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfesorResponseDTO {
    private Long id;
    private MateriaEnum materia;
    private String usuarioNombre;
    private List<String> estudiantesNombres;  // Nombres de los estudiantes
    private List<String> boletinResumen;  // Resumen o IDs de los boletines
    private List<String> asistenciaResumen;  // Resumen o IDs de asistencias
    private List<String> tareaResumen;  // Resumen o IDs de tareas
}
