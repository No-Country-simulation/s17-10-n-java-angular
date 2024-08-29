package com.dev.ForoEscolar.dtos.profesor;

import com.dev.ForoEscolar.enums.MateriaEnum;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfesorRequestDTO {

    @NotNull(message = "La materia no puede estar vacía")
    private MateriaEnum materia;

    @NotNull(message = "El ID del usuario no puede estar vacío")
    private Long usuarioId;

    private List<Long> estudianteIds; // Lista de IDs de estudiantes
}
