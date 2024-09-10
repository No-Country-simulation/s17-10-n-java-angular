package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.notificacion.NotificacionDTO;
import com.dev.ForoEscolar.mapper.notificaciones.NotifiacacionesMapper;
import com.dev.ForoEscolar.model.Notificaciones;
import com.dev.ForoEscolar.model.User;
import com.dev.ForoEscolar.repository.NotificacionesRepository;
import com.dev.ForoEscolar.repository.UserRepository;
import com.dev.ForoEscolar.services.NotificacionesService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.ServiceNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class NotificacionesServiceImpl implements NotificacionesService {

    private Notificaciones notificaciones;

    @Autowired
    private NotificacionesRepository notificacionesRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public NotificacionDTO save(NotificacionDTO requestDTO) {
        Notificaciones notificacion = NotifiacacionesMapper.INSTANCE.toEntity(requestDTO);
       notificacionesRepository.save(notificacion);

        return NotifiacacionesMapper.INSTANCE.toResponseNotificacion(notificacion);
    }

    @Override
    public Optional<NotificacionDTO> findById(Long id) {
       Optional<Notificaciones> notificacion = notificacionesRepository.findById(id);

        return notificacion.map(NotifiacacionesMapper.INSTANCE::toResponseNotificacion);
    }

    @Override
    public Iterable<NotificacionDTO> findAll() {
        List<Notificaciones> notificaciones = notificacionesRepository.findAll();

        return notificaciones.stream().map(NotifiacacionesMapper.INSTANCE::toResponseNotificacion)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
       Notificaciones notificaciones = notificacionesRepository.findById(id).orElseThrow(
               ()-> new RuntimeException("La notificacion solicitada no existe o fue eliminada anterirmente")
       );
       notificacionesRepository.deleteById(id);
    }

    @Override
    public Notificaciones sendEmial(NotificacionDTO notificacionDTO) throws ServiceNotFoundException {



        try{
        User user = this.userRepository.findByEmail(notificacionDTO.email()).orElseThrow( () ->
                new EntityNotFoundException("Usuario no encontrado")
                );
        User userId = this.userRepository.findById(notificacionDTO.idUser()).orElseThrow( () ->
                    new EntityNotFoundException("Usuario no encontrado")
            );

        var notfication = Notificaciones.builder().administrador_escolar_id(userId)
                .tutor_legal_id(user)
                .fecha_envio(new Date())
                .mensaje(notificacionDTO.mensaje())
                .tipo_notificacion(notificacionDTO.tipo_notificacion())
                .titulo(notificacionDTO.titulo())
                .build();




        return notificacionesRepository.save(notfication);
    }catch (Exception e){
            throw new ServiceNotFoundException("Hubo un problema" + e.getMessage());
        }
    }

//titulo mensaje y tipo

    }





