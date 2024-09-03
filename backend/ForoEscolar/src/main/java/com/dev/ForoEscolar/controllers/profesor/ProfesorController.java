package com.dev.ForoEscolar.controllers.profesor;

import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.exceptions.d.ApplicationException;
import com.dev.ForoEscolar.services.IProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

    @Autowired
    private IProfesorService profesorService;

    @GetMapping("/getAll")
    @Operation(summary = "Obtiene todos los profesores")
    public ResponseEntity<Iterable<ProfesorResponseDTO>> findAll() {
        try {
            Iterable<ProfesorResponseDTO> list = profesorService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (ApplicationException e){
            throw new ApplicationException(" Ha ocurrido un error "+ e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un profesor en particular")
    public ResponseEntity<ProfesorResponseDTO> findById(@PathVariable("id") Long id) {
        Optional<ProfesorResponseDTO> profesor = profesorService.findById(id);
        if (profesor.isPresent()) {
            return new ResponseEntity<>(profesor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    @Operation(summary = "Se agrega un profesor")
    public ResponseEntity<Void> save(@RequestBody @Valid ProfesorRequestDTO dto) {
        ProfesorResponseDTO profesor = profesorService.save(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @Operation(summary = "Se actualiza un profesor en particular")
    public ResponseEntity<ProfesorResponseDTO> update(@RequestBody @Valid ProfesorRequestDTO dto) {
        ProfesorResponseDTO profesor = profesorService.update(dto);
        return new ResponseEntity<>(profesor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Se elimina un estudiante en particular")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        profesorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}