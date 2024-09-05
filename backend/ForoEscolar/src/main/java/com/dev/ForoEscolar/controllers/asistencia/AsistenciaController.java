package com.dev.ForoEscolar.controllers.asistencia;


import com.dev.ForoEscolar.dtos.ApiResponseDto;
import com.dev.ForoEscolar.dtos.asistencia.AsistenciaDTO;
import com.dev.ForoEscolar.dtos.user.UserResponseDTO;
import com.dev.ForoEscolar.services.AsistenciaService;
import com.dev.ForoEscolar.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {


    private final AsistenciaService asistenciaService;
    private final UserService userService;

    @Autowired
    public AsistenciaController(AsistenciaService asistenciaService, UserService userService) {
        this.asistenciaService = asistenciaService;
        this.userService = userService;
    }

    @PostMapping("/register")
    @Operation(summary = "Register a new asistencia")
    public ResponseEntity<ApiResponseDto<AsistenciaDTO>> registerAsistencia(@RequestBody @Valid AsistenciaDTO asistenciaDTO) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserResponseDTO user = userService.findByEmail(userDetails.getUsername());
        if(user.rol().equals("PROFESOR")){
            AsistenciaDTO updatedAsistenciaDTO = new AsistenciaDTO(
                    asistenciaDTO.id(),
                    asistenciaDTO.asistio(),
                    asistenciaDTO.diasAnioEscolar(),
                    asistenciaDTO.fecha(),
                    asistenciaDTO.observaciones(),
                    asistenciaDTO.porcentajeAsistencia(),
                    user.id(),
                    asistenciaDTO.estudiante()
            );
            AsistenciaDTO asistencia = asistenciaService.save(updatedAsistenciaDTO);
            String message = "Asistencia saved";
            return ResponseEntity.ok(new ApiResponseDto<>(true, message, asistencia));
        }else{
            return ResponseEntity.badRequest().body(new ApiResponseDto<>(false, "Usuario no autorizado", null));
        }

    }
}
