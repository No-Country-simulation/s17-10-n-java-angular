package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.dtos.asistencia.AsistenciaRequestDTO;
import com.dev.ForoEscolar.dtos.asistencia.AsistenciaResponseDTO;
import com.dev.ForoEscolar.mapper.asistencia.AsistenciaMapper;
import com.dev.ForoEscolar.model.Asistencia;
import com.dev.ForoEscolar.repository.IAsistenciaRepository;
import com.dev.ForoEscolar.services.AsistenciaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsistenciaServiceImpl extends GenericServiceImpl<Asistencia, Long, AsistenciaRequestDTO, AsistenciaResponseDTO> implements AsistenciaService {


    @Autowired
    private IAsistenciaRepository asistenciaRepository;

    @Transactional
    @Override
    public AsistenciaResponseDTO save(AsistenciaRequestDTO asistenciaRequestDTO) {
        Asistencia asistencia = AsistenciaMapper.INSTANCE.toEntity(asistenciaRequestDTO);
        asistenciaRepository.save(asistencia);
        return AsistenciaMapper.INSTANCE.toResponseDTO(asistencia);
    }

    @Override
    public Optional<AsistenciaResponseDTO> findById(Long id) {
        Optional<Asistencia> asistencia = asistenciaRepository.findById(id);
        return asistencia.map(AsistenciaMapper.INSTANCE::toResponseDTO);
    }

    @Override
    public Iterable<AsistenciaResponseDTO> findAll() {
        List<Asistencia> asistencias = asistenciaRepository.findAll();
        return asistencias.stream()
                .map(AsistenciaMapper.INSTANCE::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public AsistenciaResponseDTO update(AsistenciaRequestDTO asistenciaRequestDTO) {
        Asistencia asistencia = AsistenciaMapper.INSTANCE.toEntity(asistenciaRequestDTO);
        Optional<Asistencia> existEntity = asistenciaRepository.findById(asistencia.getId());
        if (existEntity.isPresent()) {
            Asistencia asistenciaUpdate = asistenciaRepository.save(asistencia);
            return AsistenciaMapper.INSTANCE.toResponseDTO(asistenciaUpdate);
        }else{
            throw new RuntimeException("Asistencia no encontrada");
        }
    }

    @Override
    public void deleteById(Long id) {
        Asistencia asistencia = asistenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Asistencia no encontrada"));
        asistenciaRepository.delete(asistencia);
    }
}
