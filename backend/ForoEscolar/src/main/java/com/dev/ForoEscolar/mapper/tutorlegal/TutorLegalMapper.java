package com.dev.ForoEscolar.mapper.tutorlegal;

import com.dev.ForoEscolar.dtos.tutorlegal.TutorLegalRequestDTO;
import com.dev.ForoEscolar.dtos.tutorlegal.TutorLegalResponseDTO;
import com.dev.ForoEscolar.model.TutorLegal;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface TutorLegalMapper {

    TutorLegalMapper INSTANCE = Mappers.getMapper(TutorLegalMapper.class);

    TutorLegalResponseDTO toResponseDTO(TutorLegal tutorLegal);
    TutorLegal toEntity(TutorLegalRequestDTO tutorLegalRequestDTO);
    TutorLegalRequestDTO toRequestDTO(TutorLegal tutorLegal);

}
