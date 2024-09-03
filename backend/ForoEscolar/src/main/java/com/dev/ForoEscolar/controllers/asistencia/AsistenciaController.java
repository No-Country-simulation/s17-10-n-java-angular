package com.dev.ForoEscolar.controllers.asistencia;


import com.dev.ForoEscolar.dtos.ApiResponseDto;
import com.dev.ForoEscolar.dtos.asistencia.AsistenciaDTO;
import com.dev.ForoEscolar.services.AsistenciaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {


    private final AsistenciaService asistenciaService;

    @Autowired
    public AsistenciaController(AsistenciaService asistenciaService) {
        this.asistenciaService = asistenciaService;
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new asistencia")
    public ResponseEntity<ApiResponseDto<AsistenciaDTO>> registerAsistencia(@RequestBody @Valid AsistenciaDTO asistenciaDTO) {
        AsistenciaDTO asistencia = asistenciaService.save(asistenciaDTO);
        String message = "Asistencia saved";
        return ResponseEntity.ok(new ApiResponseDto<>(true, message, asistencia));
    }
}
