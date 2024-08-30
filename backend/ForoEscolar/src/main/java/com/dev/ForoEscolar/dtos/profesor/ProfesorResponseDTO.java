package com.dev.ForoEscolar.dtos.profesor;

import com.dev.ForoEscolar.enums.MateriaEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfesorResponseDTO {
    private Long id; // ID del profesor
    private Long userId; // ID del usuario asociado al profesor
    private String usuarioNombre; // Nombre del usuario asociado
    private String materia; // Materia que enseña el profesor
    private List<String> estudiantesNombres; // Lista de nombres de los estudiantes asociados
//    private List<String> boletinResumen;  // Resumen o IDs de los boletines
//    private List<String> asistenciaResumen;  // Resumen o IDs de asistencias
    private List<String> tareaTitulos; // Lista de títulos de las tareas asociadas

}
