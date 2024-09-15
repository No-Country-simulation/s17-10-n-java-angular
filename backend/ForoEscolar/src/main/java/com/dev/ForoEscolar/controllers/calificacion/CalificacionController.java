package com.dev.ForoEscolar.controllers.calificacion;

import com.dev.ForoEscolar.dtos.ApiResponseDto;
import com.dev.ForoEscolar.dtos.calificacion.CalificacionDTO;
import com.dev.ForoEscolar.dtos.user.UserResponseDTO;
import com.dev.ForoEscolar.enums.MateriaEnum;
import com.dev.ForoEscolar.exceptions.ApplicationException;
import com.dev.ForoEscolar.services.CalificacionService;
import com.dev.ForoEscolar.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/calificacion")
public class CalificacionController {

    private final CalificacionService calificacionService;
    private final UserService userService;

    @Autowired
    public CalificacionController(CalificacionService calificacionService, UserService userService) {
        this.calificacionService = calificacionService;
        this.userService=userService;
    }
    private static final String ID_ESTUDIANTE= "/{idEstudiante}";

    @PostMapping(ID_ESTUDIANTE)
    @Operation(summary = " Agrega la nota individual a un estudiante")
    public ResponseEntity<ApiResponseDto<CalificacionDTO>> saveCalification
            (@PathVariable("idEstudiante")Long idEstudiante, @RequestBody CalificacionDTO calificacionDTO){
        UserDetails userDetails= (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserResponseDTO user= userService.findByEmail(userDetails.getUsername());

        if(user.rol().equals("PROFESOR")){
                calificacionDTO.setProfesor(user.id());
                calificacionDTO.setEstudiante(idEstudiante);
               CalificacionDTO response= calificacionService.save(calificacionDTO);
               return new ResponseEntity<>(new ApiResponseDto<>( true,"Se ha guardado con exito",response),HttpStatus.CREATED);
        } else if (user.rol().equals("ADMINISTRADOR")|| user.rol().equals("TUTOR")) {
            return new ResponseEntity<>(new ApiResponseDto<>( false,"No tiene permisos para acceder a esta opcion",null),HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(new ApiResponseDto<>(false,"Ha ocurrido un error", null),HttpStatus.BAD_REQUEST);

    }
    @GetMapping(ID_ESTUDIANTE)
    @Operation(summary = "Obtiene una calificacion por estudiante")
    public ResponseEntity<ApiResponseDto<CalificacionDTO>> getCalificacion(@PathVariable ("idEstudiante") Long idEstudiante){
        Optional<CalificacionDTO> response= calificacionService.findById(idEstudiante);
        if(response.isEmpty()){
            return new ResponseEntity<>(new ApiResponseDto<>(false,"Calificacion no encontrada",null),HttpStatus.NOT_FOUND);
        }
        CalificacionDTO calificacion= response.get();
        return new ResponseEntity<>(new ApiResponseDto<>(true,"Encontrado con exito",calificacion),HttpStatus.CREATED);

    }


    @GetMapping("/getAll")
    @Operation(summary = "Obtiene todas las calificaciones del plantel")
    public ResponseEntity<ApiResponseDto<CalificacionDTO>> findAll() {
        try {
            Iterable<CalificacionDTO> list = calificacionService.findAll();
            return new ResponseEntity<>(new ApiResponseDto<>(true,"Busqueda Exitosa", list),HttpStatus.CREATED);

        } catch (ApplicationException e){
            throw new ApplicationException(" Ha ocurrido un error en el servidor: "+ e.getMessage());
        }
    }

    @GetMapping("/getByEstudiante/{idEstudiante}")
    @Operation(summary = "Obtiene todas las calificaciones de un estudiante")
    public ResponseEntity<ApiResponseDto<CalificacionDTO>> findByEstudianteId(@PathVariable("idEstudiante") Long idEstudiante) {
        List<CalificacionDTO> response = calificacionService.findByEstudianteId(idEstudiante);
        if (response.isEmpty()) {
            return new ResponseEntity<>(new ApiResponseDto<>(false, "No se ha encontrado al estudiante", null), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new ApiResponseDto<>(true, "Busqueda exitosa", response), HttpStatus.CREATED);
    }
    @GetMapping("/getByMateria")
    @Operation(summary = "Obtiene todas las calificaciones por materia")
    public ResponseEntity<ApiResponseDto<CalificacionDTO>>obtenerPorMateria(@RequestParam("materia") String materia){
       MateriaEnum materiaEnum= MateriaEnum.valueOf(materia);
        if(materiaEnum.compareTo(MateriaEnum.values()[0])==0){
            throw new ApplicationException("LA materia no registra calificaciones");
        }
        List<CalificacionDTO> response= calificacionService .findByMateria(MateriaEnum.valueOf(materia));
        return new ResponseEntity<>(new ApiResponseDto<>(true,"Busqueda exitosa",response),HttpStatus.CREATED);
    }

}


