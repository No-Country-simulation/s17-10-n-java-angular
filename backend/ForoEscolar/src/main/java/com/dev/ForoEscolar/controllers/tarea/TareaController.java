package com.dev.ForoEscolar.controllers.tarea;

import com.dev.ForoEscolar.dtos.ApiResponseDto;
import com.dev.ForoEscolar.dtos.tarea.TareaResponseDto;
import com.dev.ForoEscolar.dtos.user.UserResponseDTO;
import com.dev.ForoEscolar.enums.EstadoEntregaEnum;
import com.dev.ForoEscolar.exceptions.ApplicationException;
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
@RequestMapping("api/tarea")
public class TareaController {

    private final TareaService tareaService;

    private final UserService userService;

    @Autowired
    public TareaController(TareaService tareaService, UserService userService) {
        this.tareaService = tareaService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene una tarea por Id")
    public ResponseEntity<ApiResponseDto<TareaResponseDto>> getTaskById(@PathVariable("id") Long id) {

        Optional<TareaResponseDto> response = tareaService.findById(id);
        if (response.isPresent()) {
            TareaResponseDto getTask = response.get();
            String message = "Tarea Encontrada";
            return new ResponseEntity<>(new ApiResponseDto<>(true, message, getTask), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ApiResponseDto<>(false, "Tarea no encontrada", null), HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getAll")
    @Operation(summary = "Obtiene todas las tareas")
    public ResponseEntity<ApiResponseDto<TareaResponseDto>> taskList() {
        try {
            Iterable<TareaResponseDto> listaDeTareas = tareaService.findAll();
            return new ResponseEntity<>(new ApiResponseDto<>(true, "Exito", listaDeTareas), HttpStatus.CREATED);
        } catch (ApplicationException e) {
            throw new ApplicationException(" Ha ocurrido un error " + e.getMessage());

        }
    }

    @PostMapping("/add")
    @Operation(summary = "Agrega una tarea")
    public ResponseEntity<ApiResponseDto<TareaResponseDto>> addTask(@RequestBody TareaResponseDto tarea) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserResponseDTO user = userService.findByEmail(userDetails.getUsername());
        if (user.rol().equals("PROFESOR")) {

            tarea.setProfesor(user.id());
            return
                    new ResponseEntity<>(
                            new ApiResponseDto<>(true, "Tarea Creada con exito", tareaService.save(tarea))
                            , HttpStatus.CREATED);
        }
        return ResponseEntity.ok(new ApiResponseDto<>(false, String.valueOf(HttpStatus.BAD_REQUEST), null));
    }

    @PutMapping("/{id}")
    @Operation(summary = " Actualiza una tarea")
    public ResponseEntity<ApiResponseDto<TareaResponseDto>> updateTask(@PathVariable("id") Long idTarea, @RequestBody TareaResponseDto tarea) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserResponseDTO user = userService.findByEmail(userDetails.getUsername());
        if (user.rol().equals("PROFESOR")) {
            Optional<TareaResponseDto> responseDto = tareaService.findById(idTarea);
            if (responseDto.isPresent()) {
                tarea.setId(idTarea);
                tarea.setProfesor(user.id());
                tareaService.updateTarea(tarea);
                ApiResponseDto<TareaResponseDto> responseSalida = new ApiResponseDto<>(true, "Tarea actualizada", tarea);
                return new ResponseEntity<>(responseSalida, HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(new ApiResponseDto<>(false, "No tiene permisos para realizar esta accion", null), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/evaluar/{id}")
    public ResponseEntity<ApiResponseDto<String>> taskEvaluation(@PathVariable("id") Long id, @RequestParam("estado") String estado) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserResponseDTO user = userService.findByEmail(userDetails.getUsername());

        if (user.rol().equals("PROFESOR")) {
            String message = tareaService.validarTarea(id, EstadoEntregaEnum.valueOf(estado));
            return new ResponseEntity<>(new ApiResponseDto<>(true, message, null), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ApiResponseDto<>(false, "No tiene permisos para realizar esta accion", null), HttpStatus.NOT_FOUND);
    }
}