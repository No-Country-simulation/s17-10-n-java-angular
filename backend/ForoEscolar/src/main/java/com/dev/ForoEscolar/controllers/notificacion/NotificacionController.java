package com.dev.ForoEscolar.controllers.notificacion;
import com.dev.ForoEscolar.dtos.ApiResponseDto;
import com.dev.ForoEscolar.dtos.notificacion.NotificacionResponseDTO;
import com.dev.ForoEscolar.exceptions.d.ApplicationException;
import com.dev.ForoEscolar.services.INotificacionService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/notificacion")
public class NotificacionController {

    @Autowired
    private INotificacionService notificacionService;

    @GetMapping("/getAll")
    @Operation(summary = "Obtiene todos los notificacions")
    public ResponseEntity<ApiResponseDto> findAll() {
        try {
            Iterable<NotificacionResponseDTO> list = notificacionService.findAll();
            return new ResponseEntity<>( new ApiResponseDto(true,"Exito",list), HttpStatus.CREATED);
        } catch (ApplicationException e){
            throw new ApplicationException(" Ha ocurrido un error "+ e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un notificacion en particular")
    public ResponseEntity<ApiResponseDto> findById(@PathVariable("id") Long id) {
        Optional<NotificacionResponseDTO> notificacion = notificacionService.findById(id);
        if (notificacion.isPresent()) {
            String message="notificacion encontrado";
            return new ResponseEntity<>(new ApiResponseDto(true, message, notificacion), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ApiResponseDto(false, "notificacion no encontrado", null),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    @Operation(summary = "Se agrega un notificacion")
    public ResponseEntity<ApiResponseDto> save(@RequestBody @Valid NotificacionResponseDTO dto) {
        NotificacionResponseDTO notificacion = notificacionService.save(dto);
        String message = "notificacion Guardado";
        return new ResponseEntity<>(new ApiResponseDto(true, message, notificacion), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @Operation(summary = "Se actualiza un notificacion en particular")
    public ResponseEntity<ApiResponseDto> update(@RequestBody @Valid NotificacionResponseDTO dto) {
        NotificacionResponseDTO notificacion = notificacionService.update(dto);
        String message = "notificacion Actualizado";
        return new ResponseEntity<>(new ApiResponseDto(true, message, notificacion), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Se elimina un notificacion en particular")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        notificacionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
