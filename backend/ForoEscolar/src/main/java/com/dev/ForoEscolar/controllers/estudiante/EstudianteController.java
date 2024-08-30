package com.dev.ForoEscolar.controllers.estudiante;

import com.dev.ForoEscolar.dtos.ApiResponseDto;
import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.exceptions.d.ApplicationException;
import com.dev.ForoEscolar.services.IEstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {

    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping("/getAll")
    @Operation(summary = "Obtiene todos los estudiantes")
    public ResponseEntity<ApiResponseDto> findAll() {
        try {
            Iterable<EstudianteResponseDTO> list = estudianteService.findAll();
            return new ResponseEntity<>( new ApiResponseDto(true,"Exito",list), HttpStatus.CREATED);
        } catch (ApplicationException e){
            throw new ApplicationException(" Ha ocurrido un error "+ e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un estudiante en particular")
    public ResponseEntity<ApiResponseDto> findById(@PathVariable("id") Long id) {
        Optional<EstudianteResponseDTO> estudiante = estudianteService.findById(id);
        if (estudiante.isPresent()) {
            String message="Estudiante encontrado";
            return new ResponseEntity<>(new ApiResponseDto(true, message, estudiante), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ApiResponseDto(false, "Estudiante no encontrado", null),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    @Operation(summary = "Se agrega un estudiante")
    public ResponseEntity<ApiResponseDto> save(@RequestBody @Valid EstudianteResponseDTO dto) {
        EstudianteResponseDTO estudiante = estudianteService.save(dto);
        String message = "Estudiante Guardado";
        return new ResponseEntity<>(new ApiResponseDto(true, message, estudiante), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @Operation(summary = "Se actualiza un estudiante en particular")
    public ResponseEntity<ApiResponseDto> update(@RequestBody @Valid EstudianteResponseDTO dto) {
        EstudianteResponseDTO estudiante = estudianteService.update(dto);
        String message = "Estudiante Actualizado";
        return new ResponseEntity<>(new ApiResponseDto(true, message, estudiante), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Se elimina un estudiante en particular")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        estudianteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}