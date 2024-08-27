package com.dev.ForoEscolar.controllers.tarea;

import com.dev.ForoEscolar.dtos.Tarea.TareaResponseDto;
import com.dev.ForoEscolar.services.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
   private TareaService tareaService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable("id") Long id){

        Optional<TareaResponseDto> response= tareaService.findById(id);
        if(response.isPresent()){
            TareaResponseDto getTask=response.get();
            return  new ResponseEntity<>(getTask, HttpStatus.CREATED);
        }
    return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }


}
