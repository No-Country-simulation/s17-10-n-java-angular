package com.dev.ForoEscolar.dtos.grado;

import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.MateriaEnum;
import com.dev.ForoEscolar.enums.TurnoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GradoDto {

    private Long id;

    @Enumerated(value = EnumType.STRING)
    private AulaEnum aula;
    @Enumerated(value = EnumType.STRING)
    private CursoEnum curso;
    @Enumerated(value = EnumType.STRING)
    private TurnoEnum turno;
    @Enumerated(value = EnumType.STRING)
    private MateriaEnum materia;
    private Long profesor;
}
