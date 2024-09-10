package com.dev.ForoEscolar.controllers.grado;

import com.dev.ForoEscolar.dtos.ApiResponseDto;
import com.dev.ForoEscolar.dtos.grado.GradoDto;
import com.dev.ForoEscolar.dtos.user.UserResponseDTO;
import com.dev.ForoEscolar.exceptions.ApplicationException;
import com.dev.ForoEscolar.services.GradoService;
import com.dev.ForoEscolar.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/grado")
public class GradoController {

    private final GradoService gradoService;
    private final UserService userService;

    public GradoController(GradoService gradoService, UserService userService) {
        this.gradoService = gradoService;
        this.userService = userService;
    }

    @PostMapping("/register")
    @Operation(summary = "Registra un nuevo grado")
    public ResponseEntity<ApiResponseDto<GradoDto>> registerGrado(@RequestBody GradoDto gradoDto) {

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserResponseDTO user = userService.findByEmail(userDetails.getUsername());
        if (user.rol().equals("ADMINISTRADOR")) {
            return new ResponseEntity<>(new ApiResponseDto<>(true, "Grado Creado", gradoService.save(gradoDto)), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(new ApiResponseDto<>(false, "No tiene permisos para realizar esta accion", null), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAll")
    @Operation(summary = "Obtiene todos los grados")
    public ResponseEntity<ApiResponseDto<GradoDto>> getAll(){
        try{

        return new ResponseEntity<>(new ApiResponseDto<>(true,"Grados Creados",gradoService.findAll()), HttpStatus.CREATED);
        } catch (ApplicationException e){
            throw new ApplicationException(" Ha ocurrido un error "+e.getMessage());
        }
    }
    @GetMapping("/{id}")
    @Operation(summary = "Obtiene un grado por Id")
    public ResponseEntity<ApiResponseDto<GradoDto>>getById(@PathVariable("id") Long id){

        Optional<GradoDto> response = gradoService.findById(id);
        if(response.isPresent()){
            GradoDto getGrado = response.get();
            String message = "Grado Encontrado";
            return new ResponseEntity<>(new ApiResponseDto<>(true, message, getGrado), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ApiResponseDto<>(false, "Grado no encontrado", null), HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Elimina un grado por Id")
    public ResponseEntity<ApiResponseDto<GradoDto>>deleteById(@PathVariable("id") Long id){
        Optional<GradoDto> response = gradoService.findById(id);
        if(response.isPresent()){
            GradoDto getGrado = response.get();
            gradoService.deleteById(id);
            String message = "Grado Removido";
            return new ResponseEntity<>(new ApiResponseDto<>(true, message, getGrado), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ApiResponseDto<>(false, "Grado no encontrado", null), HttpStatus.NOT_FOUND);
    }

}
