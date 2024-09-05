package com.dev.ForoEscolar.services;

import com.dev.ForoEscolar.dtos.tutorlegal.TutorLegalRequestDTO;
import com.dev.ForoEscolar.dtos.tutorlegal.TutorLegalResponseDTO;
import com.dev.ForoEscolar.model.TutorLegal;

public interface TutorLegalService extends GenericService<TutorLegal, Long, TutorLegalRequestDTO,TutorLegalResponseDTO>{

    TutorLegalResponseDTO update(TutorLegalRequestDTO tutorLegalRequestDTO);
}
