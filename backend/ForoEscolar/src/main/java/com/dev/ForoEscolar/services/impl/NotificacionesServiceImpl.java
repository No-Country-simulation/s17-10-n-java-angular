package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.notificacion.NotificacionDTO;
import com.dev.ForoEscolar.mapper.notificaciones.NotifiacacionesMapper;
import com.dev.ForoEscolar.model.Notificaciones;
import com.dev.ForoEscolar.model.User;
import com.dev.ForoEscolar.repository.NotificacionesRepository;
import com.dev.ForoEscolar.repository.UserRepository;
import com.dev.ForoEscolar.services.NotificacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class NotificacionesServiceImpl implements NotificacionesService {

    private   Map<String, String>  emailSender = new LinkedHashMap<>();

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
    public Optional<NotificacionDTO> findById(BigInteger id) {
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
    public void deleteById(BigInteger id) {
       Notificaciones notificaciones = notificacionesRepository.findById(id).orElseThrow(
               ()-> new RuntimeException("La notificacion solicitada no existe o fue eliminada anterirmente")
       );
       notificacionesRepository.deleteById(id);
    }


    @Override
    public void sendEmial(String email, String notification) {
       Optional<User> user = userRepository.findByEmail(email);
        Notificaciones notificaciones = new Notificaciones(notification);


        if(email.equalsIgnoreCase(user.get().getEmail())){
            emailSender.put(user.get().getEmail(), notificaciones.getMensaje());
        }

    }

    @Override
    public String getNotificacion(String key){

        if(emailSender.containsKey(key)){
            return emailSender.get(key);
        }else{
            throw new NullPointerException("Email no encontrado");
        }


    }



}
