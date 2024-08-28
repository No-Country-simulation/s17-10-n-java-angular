package com.dev.ForoEscolar.controllers.estudiante;

import com.dev.ForoEscolar.dtos.estudiante.EstudianteRequestDTO;
import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.services.IEstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/estudiante")
public class EstudianteController {

    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping
    public ResponseEntity<Iterable<EstudianteResponseDTO>> findAll() {
        Iterable<EstudianteResponseDTO> list = estudianteService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteResponseDTO> findById(@PathVariable("id") Long id) {
        Optional<EstudianteResponseDTO> estudiante = estudianteService.findById(id);
        if (estudiante.isPresent()) {
            return new ResponseEntity<>(estudiante.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid EstudianteRequestDTO dto) {
        EstudianteResponseDTO estudiante = estudianteService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estudiante.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<EstudianteResponseDTO> update(@RequestBody @Valid EstudianteRequestDTO dto) {
        EstudianteResponseDTO estudiante = estudianteService.update(dto);
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        estudianteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}