package com.dev.ForoEscolar.controllers.asistencia;

import com.dev.ForoEscolar.dtos.asistencia.AsistenciaRequestDTO;
import com.dev.ForoEscolar.dtos.asistencia.AsistenciaResponseDTO;
import com.dev.ForoEscolar.exceptions.d.ApplicationException;
import com.dev.ForoEscolar.services.AsistenciaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/asistencia")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping("/getAll")
    @Operation(summary = "Obtiene todas la asistencias")
    public ResponseEntity<Iterable<AsistenciaResponseDTO>> findAll() {
        try {
            Iterable<AsistenciaResponseDTO> list = asistenciaService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (ApplicationException e){
            throw new ApplicationException(" Ha ocurrido un error "+ e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene una asistencia específica")
    public ResponseEntity<AsistenciaResponseDTO> findById(@PathVariable("id") Long id) {
        Optional<AsistenciaResponseDTO> asistencia = asistenciaService.findById(id);
        if (asistencia.isPresent()) {
            return new ResponseEntity<>(asistencia.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    @Operation(summary = "Se agrega una asistencia")
    public ResponseEntity<Void> save(@RequestBody @Valid AsistenciaRequestDTO dto) {
        AsistenciaResponseDTO asistencia = asistenciaService.save(dto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @Operation(summary = "Se actualiza una asistencia en particular")
    public ResponseEntity<AsistenciaResponseDTO> update(@RequestBody @Valid AsistenciaRequestDTO dto) {
        AsistenciaResponseDTO asistencia = asistenciaService.update(dto);
        return new ResponseEntity<>(asistencia, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Se elimina una asistencia en particular")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        asistenciaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
