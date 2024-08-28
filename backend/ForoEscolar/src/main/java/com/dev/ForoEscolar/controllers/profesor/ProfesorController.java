package com.dev.ForoEscolar.controllers.profesor;


import com.dev.ForoEscolar.dtos.profesor.ProfesorRequestDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.services.IProfesorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesor")
public class ProfesorController {

    @Autowired
    private IProfesorService profesorService;

    @GetMapping
    public ResponseEntity<Iterable<ProfesorResponseDTO>> findAll() {
        Iterable<ProfesorResponseDTO> list = profesorService.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorResponseDTO> findById(@PathVariable("id") Long id) {
        Optional<ProfesorResponseDTO> profesor = profesorService.findById(id);
        if (profesor.isPresent()) {
            return new ResponseEntity<>(profesor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid ProfesorRequestDTO dto) {
        ProfesorResponseDTO profesor = profesorService.save(dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(profesor.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<ProfesorResponseDTO> update(@RequestBody @Valid ProfesorRequestDTO dto) {
        ProfesorResponseDTO profesor = profesorService.update(dto);
        return new ResponseEntity<>(profesor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        profesorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}