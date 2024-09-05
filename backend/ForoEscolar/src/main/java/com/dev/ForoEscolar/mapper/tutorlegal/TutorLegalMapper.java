package com.dev.ForoEscolar.mapper.tutorlegal;

import com.dev.ForoEscolar.dtos.tutorlegal.TutorLegalRequestDTO;
import com.dev.ForoEscolar.dtos.tutorlegal.TutorLegalResponseDTO;
import com.dev.ForoEscolar.model.TutorLegal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TutorLegalMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "rol", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "estudiantes", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    TutorLegal toEntity(TutorLegalRequestDTO tutorLegalRequestDTO);

    TutorLegalResponseDTO toResponseDTO(TutorLegal tutorLegal);

    TutorLegalRequestDTO toRequestDTO(TutorLegal tutorLegal);
}
