package com.dev.ForoEscolar.controllers.NotificacionController;

import com.dev.ForoEscolar.dtos.notificacion.NotificacionDTO;
import com.dev.ForoEscolar.services.NotificacionesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.ServiceNotFoundException;

@RestController
@RequestMapping("/notification")
public class NotificacionController {

    @Autowired
    NotificacionesService notificacionesService;

    @PutMapping( consumes = "ApplicationJSON")
    public ResponseEntity<?> sendEmail(  @RequestBody @Valid NotificacionDTO notificacionDTO) throws ServiceNotFoundException {


        return ResponseEntity.status(HttpStatus.CREATED).body(notificacionesService.sendEmial(notificacionDTO));
    }


}
