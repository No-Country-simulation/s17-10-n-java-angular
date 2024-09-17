package com.dev.ForoEscolar.controllers.estudiante;

import com.dev.ForoEscolar.dtos.ApiResponseDto;
import com.dev.ForoEscolar.dtos.estudiante.EstudianteResponseDTO;
import com.dev.ForoEscolar.dtos.profesor.ProfesorResponseDTO;
import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.enums.MateriaEnum;
import com.dev.ForoEscolar.exceptions.ApplicationException;
import com.dev.ForoEscolar.services.EstudianteService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/estudiante")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping("/getAll")
    @Operation(summary = "Obtiene todos los estudiantes")
    public ResponseEntity<ApiResponseDto<EstudianteResponseDTO>> findAll() {
        try {
            Iterable<EstudianteResponseDTO> list = estudianteService.findAll();
            return new ResponseEntity<>( new ApiResponseDto<>(true,"Exito",list), HttpStatus.CREATED);
        } catch (ApplicationException e){
            throw new ApplicationException(" Ha ocurrido un error "+ e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un estudiante en particular")
    public ResponseEntity<ApiResponseDto<EstudianteResponseDTO>> findById(@PathVariable("id") Long id) {
        Optional<EstudianteResponseDTO> estudiante = estudianteService.findById(id);
        if (estudiante.isPresent()) {
            EstudianteResponseDTO estudianteResponseDTO = estudiante.get();
            String message="Estudiante encontrado";
            return new ResponseEntity<>(new ApiResponseDto<>(true, message, estudianteResponseDTO), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ApiResponseDto<>(false, "Estudiante no encontrado", null),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    @Operation(summary = "Se agrega un estudiante")
    public ResponseEntity<ApiResponseDto<EstudianteResponseDTO>> save(@RequestBody @Valid EstudianteResponseDTO dto) {
        EstudianteResponseDTO estudiante = estudianteService.save(dto);
        String message = "Estudiante Guardado";
        return new ResponseEntity<>(new ApiResponseDto<>(true, message, estudiante), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    @Operation(summary = "Se actualiza un estudiante en particular")
    public ResponseEntity<ApiResponseDto<EstudianteResponseDTO>> update(@RequestBody @Valid EstudianteResponseDTO dto) {
        EstudianteResponseDTO estudiante = estudianteService.update(dto);
        String message = "Estudiante Actualizado";
        return new ResponseEntity<>(new ApiResponseDto<>(true, message, estudiante), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Se elimina un estudiante en particular")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        estudianteService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/filterGrado")
    @Operation(summary = "Se filtra a los estudiantes por grado")
    public ResponseEntity<ApiResponseDto<EstudianteResponseDTO>> filtroXGrado(@RequestParam Long gradoId) {
        try {
            List<EstudianteResponseDTO> estudianteResponseDTOS= estudianteService.findByGradoId(gradoId);
            if(estudianteResponseDTOS.isEmpty())
            { return new ResponseEntity<>(new ApiResponseDto<>(true, "No hay estudiantes asignados al grado", null), HttpStatus.NOT_FOUND);}
            return new ResponseEntity<>(new ApiResponseDto<>(true, "Exito", estudianteResponseDTOS), HttpStatus.CREATED);
        } catch (ApplicationException e) {
            throw new ApplicationException(" Ha ocurrido un error " + e.getMessage());
        }
    }

//    @GetMapping("/filterAula")
//    @Operation(summary = "Se filtra a los estudiantes por aula")
//    public ResponseEntity<ApiResponseDto<EstudianteResponseDTO>> filtroXAula(@RequestParam String aula) {
//        try {
//           List<EstudianteResponseDTO> estudianteResponseDTOS= estudianteService.findByAula(AulaEnum.valueOf(aula));
//           if(estudianteResponseDTOS.isEmpty())
//           { return new ResponseEntity<>(new ApiResponseDto<>(true, "No hay estudiantes asignados al aula", null), HttpStatus.NOT_FOUND);}
//            return new ResponseEntity<>(new ApiResponseDto<>(true, "Exito", estudianteResponseDTOS), HttpStatus.CREATED);
//        } catch (ApplicationException e) {
//            throw new ApplicationException(" Ha ocurrido un error " + e.getMessage());
//        }
//    }
//    @GetMapping("/filterCurso")
//    @Operation(summary = "Se filtra a los estudiantes por grado")
//    public ResponseEntity<ApiResponseDto<EstudianteResponseDTO>> filtroXCurso(@RequestParam String curso) {
//        try {
//            List<EstudianteResponseDTO> estudianteResponseDTOS= estudianteService.findByCurso(CursoEnum.valueOf(curso));
//            if(estudianteResponseDTOS.isEmpty())
//            { return new ResponseEntity<>(new ApiResponseDto<>(true, "No hay estudiantes asignados al curso", null), HttpStatus.NOT_FOUND);}
//            return new ResponseEntity<>(new ApiResponseDto<>(true, "Exito", estudianteResponseDTOS), HttpStatus.CREATED);
//        } catch (ApplicationException e) {
//            throw new ApplicationException(" Ha ocurrido un error " + e.getMessage());
//        }
//    }
//    @GetMapping("/filterCursoAndAula")
//    @Operation(summary = "Se filtra a los estudiantes por grado y curso")
//    public ResponseEntity<ApiResponseDto<EstudianteResponseDTO>> filtroXCursoYAula(@RequestParam String curso, @RequestParam String aula) {
//        try {
//            List<EstudianteResponseDTO> estudianteResponseDTOS= estudianteService.findByCursoAndAula(CursoEnum.valueOf(curso), AulaEnum.valueOf(aula));
//            if(estudianteResponseDTOS.isEmpty())
//            { return new ResponseEntity<>(new ApiResponseDto<>(true, "No hay estudiantes asignados al curso", null), HttpStatus.NOT_FOUND);}
//            return new ResponseEntity<>(new ApiResponseDto<>(true, "Exito", estudianteResponseDTOS), HttpStatus.CREATED);
//        } catch (ApplicationException e) {
//            throw new ApplicationException(" Ha ocurrido un error " + e.getMessage());
//        }
//    }

}