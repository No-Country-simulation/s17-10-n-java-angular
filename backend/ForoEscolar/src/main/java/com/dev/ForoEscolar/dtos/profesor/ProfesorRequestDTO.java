package com.dev.ForoEscolar.dtos.profesor;

import com.dev.ForoEscolar.enums.MateriaEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfesorRequestDTO {
    @NotNull
    private Long id; // ID del profesor
    @NotNull
    private Long userId; // ID del usuario asociado al profesor
    @NotNull
    private MateriaEnum materia; // Materia que enseña el profesor
    @NotNull
    private List<Long> estudianteIds; // Lista de IDs de estudiantes asociados
    @NotNull
    private List<Long> tareaIds; // Lista de IDs de tareas asociadas
}
