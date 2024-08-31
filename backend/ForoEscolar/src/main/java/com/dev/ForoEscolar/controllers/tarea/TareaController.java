package com.dev.ForoEscolar.controllers.tarea;

import com.dev.ForoEscolar.dtos.ApiResponseDto;
import com.dev.ForoEscolar.dtos.Tarea.TareaResponseDto;
import com.dev.ForoEscolar.dtos.user.UserResponseDTO;
import com.dev.ForoEscolar.exceptions.d.ApplicationException;
import com.dev.ForoEscolar.services.IEstudianteService;
import com.dev.ForoEscolar.services.TareaService;
import com.dev.ForoEscolar.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tareas")
public class TareaController {

    private final TareaService tareaService;

    public TareaController (TareaService tareaService){
        this.tareaService=tareaService;
    }
    @Autowired
    private UserService userService;
    @Autowired
    private IEstudianteService estudianteService;

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene una tarea por Id")
    public ResponseEntity<ApiResponseDto> getTaskById(@PathVariable("id") Long id) {

        Optional<TareaResponseDto> response = tareaService.findById(id);
        if (response.isPresent()) {
            TareaResponseDto getTask = response.get();
            String message = "Tarea Encontrada";
            return new ResponseEntity<>(new ApiResponseDto(true, message, getTask), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ApiResponseDto(false, "Tarea no encontrada", null), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAll")
    @Operation(summary = "Obtiene todas las tareas")
    public ResponseEntity<ApiResponseDto> taskList() {
        try {
            Iterable listaDeTareas = tareaService.findAll();
            return new ResponseEntity<>(new ApiResponseDto(true, "Exito", listaDeTareas), HttpStatus.CREATED);
        } catch (ApplicationException e) {
            throw new ApplicationException(" Ha ocurrido un error " + e.getMessage());

        }
    }

    @PostMapping("/add")
    @Operation(summary = "Agrega una tarea")
    public ResponseEntity<ApiResponseDto> addTask(@RequestBody TareaResponseDto tarea) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserResponseDTO user = userService.findByEmail(userDetails.getUsername());

        if (user.rol().equals("PROFESOR")) {

            tarea.setProfesorId(user.id());
            return
                    new ResponseEntity<>(
                            new ApiResponseDto(true, "Tarea Creada con exito", tareaService.save(tarea))
                            , HttpStatus.CREATED);
        }
        return ResponseEntity.ok(new ApiResponseDto(false, String.valueOf(HttpStatus.BAD_REQUEST), null));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualiza una tarea")
    public ResponseEntity<ApiResponseDto> updateTask(@PathVariable("id") Long idTarea, @RequestBody TareaResponseDto tarea) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserResponseDTO user = userService.findByEmail(userDetails.getUsername());
        if (user.rol().equals("PROFESOR")) {
            Optional<TareaResponseDto> responseDto = tareaService.findById(idTarea);
            if (responseDto.isPresent()) {
                tarea.setId(idTarea);
                tarea.setProfesorId(user.id());
                tareaService.save(tarea);
                ApiResponseDto responseSalida = new ApiResponseDto<>(true, "Tarea actualizada", tarea);
                return new ResponseEntity<>(responseSalida, HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto> deleteTask(@PathVariable("id") Long id){

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserResponseDTO user = userService.findByEmail(userDetails.getUsername());
        if (user.rol().equals("PROFESOR")) {
            tareaService.deleteById(id);
            return
                    new ResponseEntity<>(
                            new ApiResponseDto(true, "Tarea eliminada con Exito",null)
                            , HttpStatus.CREATED);
        }
        return ResponseEntity.ok(new ApiResponseDto(false, String.valueOf(HttpStatus.BAD_REQUEST), null));

    }
}
