package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.notificacion.NotificacionResponseDTO;
import com.dev.ForoEscolar.mapper.notificacion.NotificacionMapper;
import com.dev.ForoEscolar.model.Notificacion;
import com.dev.ForoEscolar.repository.INotificacionRepository;
import com.dev.ForoEscolar.services.NotificacionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    @Autowired
    private INotificacionRepository notificacionRepository;

    @Transactional
    @Override
    public NotificacionResponseDTO save(NotificacionResponseDTO notificacionRequestDTO) {
        Notificacion notificacion = NotificacionMapper.INSTANCE.toEntity(notificacionRequestDTO);
        notificacionRepository.save(notificacion);
        return NotificacionMapper.INSTANCE.toResponseDTO(notificacion);
    }

    @Override
    public Optional<NotificacionResponseDTO> findById(Long id) {
        Optional<Notificacion> notificacion = notificacionRepository.findById(id);
        return notificacion.map(NotificacionMapper.INSTANCE::toResponseDTO);
    }

    @Override
    public List<NotificacionResponseDTO> findAll() {
        List<Notificacion> notificacions = notificacionRepository.findAll();
        return notificacions.stream()
                .map(NotificacionMapper.INSTANCE::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Notificacion notificacion = notificacionRepository.findById(id).orElseThrow(() -> new RuntimeException("Notificacion no encontrado"));
        notificacionRepository.delete(notificacion);
    }

    @Transactional
    public NotificacionResponseDTO update(NotificacionResponseDTO NotificacionRequestDTO) {
        Notificacion Notificacion = NotificacionMapper.INSTANCE.toEntity(NotificacionRequestDTO);
        Optional<Notificacion> existingEntity = notificacionRepository.findById(getEntityId(Notificacion));
        if (existingEntity.isPresent()) {
            Notificacion updatedEntity = notificacionRepository.save(Notificacion);
            return NotificacionMapper.INSTANCE.toResponseDTO(updatedEntity);
        } else {
            throw new RuntimeException("La entidad con ese ID no fue encontrado");
        }
    }

    //Auxiliar para obtener el ID de la entidad
    protected Long getEntityId(Notificacion notificacion) {
        return notificacion.getId();
    }

}
