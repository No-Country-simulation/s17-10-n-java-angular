package com.dev.ForoEscolar.dtos.calificacion;

public record CalificacionDTO(
        Long id,
        String materia,
        Double nota,
        Double promedio,
        String comentario,
        String fecha,
        String periodo,
        Long estudiante,
        Long profesor,
        Long boletin
) {
}
