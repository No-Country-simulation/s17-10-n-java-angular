package com.dev.ForoEscolar.controllers.profesor;


import com.dev.ForoEscolar.dtos.ApiResponseDto;
import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.enums.MateriaEnum;
import com.dev.ForoEscolar.exceptions.ApplicationException;
import com.dev.ForoEscolar.services.ProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/profesor")
public class ProfesorController {

    private final ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Obtiene todos los profesores")
    public ResponseEntity<ApiResponseDto<ProfesorResponseDTO>> findAll() {
        try {
            Iterable<ProfesorResponseDTO> list = profesorService.findAll();
            return new ResponseEntity<>(new ApiResponseDto<>(true, "Exito", list), HttpStatus.CREATED);
        } catch (ApplicationException e) {
            throw new ApplicationException(" Ha ocurrido un error " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un profesor en particular")
    public ResponseEntity<ApiResponseDto<ProfesorResponseDTO>> findById(@PathVariable("id") Long id) {
        Optional<ProfesorResponseDTO> profesor = profesorService.findById(id);
        if (profesor.isPresent()) {
            ProfesorResponseDTO profesorResponseDTO = profesor.get();
            String message = "Profesor encontrado";
            return new ResponseEntity<>(new ApiResponseDto<>(true, message, profesorResponseDTO), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ApiResponseDto<>(false, "Profesor no encontrado", null), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    @Operation(summary = "Se agrega un profesor")
    public ResponseEntity<ApiResponseDto<ProfesorResponseDTO>> save(@RequestBody @Valid ProfesorRequestDTO dto) {
        ProfesorResponseDTO profesor = profesorService.save(dto);
        String message = "Profesor Registrado";
        return new ResponseEntity<>(new ApiResponseDto<>(true, message, profesor), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @Operation(summary = "Se actualiza un profesor en particular")
    public ResponseEntity<ApiResponseDto<ProfesorResponseDTO>> update(@RequestBody @Valid ProfesorRequestDTO dto) {
        ProfesorResponseDTO profesor = profesorService.update(dto);
        String message = "Profesor Actualizado";
        return new ResponseEntity<>(new ApiResponseDto<>(true, message, profesor), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Se elimina un profesor en particular")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        profesorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/filter")
    @Operation(summary = "Se filtra a los profesores por materia")
    public ResponseEntity<ApiResponseDto<ProfesorResponseDTO>> filtoXMateria(@RequestParam MateriaEnum materia) {
        try {
            List<ProfesorResponseDTO> profesorResponseDTOS = profesorService.findByMateria(materia);
            return new ResponseEntity<>(new ApiResponseDto<>(true, "Exito", profesorResponseDTOS), HttpStatus.CREATED);
        } catch (ApplicationException e) {
            throw new ApplicationException(" Ha ocurrido un error " + e.getMessage());
        }
    }
}