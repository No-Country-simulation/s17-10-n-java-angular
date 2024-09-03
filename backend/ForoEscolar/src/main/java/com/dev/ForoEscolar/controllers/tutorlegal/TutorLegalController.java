package com.dev.ForoEscolar.controllers.tutorlegal;

import com.dev.ForoEscolar.dtos.ApiResponseDto;
import com.dev.ForoEscolar.dtos.tutorlegal.TutorLegalRequestDTO;
import com.dev.ForoEscolar.dtos.tutorlegal.TutorLegalResponseDTO;
import com.dev.ForoEscolar.services.TutorLegalService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tutorlegal")
public class TutorLegalController {

    private final TutorLegalService tutorLegalService;

    @Autowired
    public TutorLegalController(TutorLegalService tutorLegalService) {
        this.tutorLegalService = tutorLegalService;
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Registra un nuevo tutor legal")
    public ResponseEntity<ApiResponseDto<TutorLegalResponseDTO>> registerTutorLegal(@RequestBody @Valid TutorLegalRequestDTO tutorLegalRequestDTO) {
        TutorLegalResponseDTO tutorLegal = tutorLegalService.save(tutorLegalRequestDTO);
        if (tutorLegal == null) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponseDto<>(false, "Tutor legal no registrado", null));
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponseDto<>(true, "Tutor legal registrado", tutorLegal));
    }
}
