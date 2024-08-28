package com.dev.ForoEscolar.services.Impl;

import com.dev.ForoEscolar.mapper.GenericMapper;
import com.dev.ForoEscolar.repository.GenericRepository;
import com.dev.ForoEscolar.services.GenericService;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class GenericServiceImpl<T, ID , RequestDTO, ResponseDTO> implements GenericService<T, ID, RequestDTO, ResponseDTO> {

    protected GenericRepository<T, ID> repository;

    protected GenericMapper<T, RequestDTO, ResponseDTO> mapper;

    @Override
    public ResponseDTO save(RequestDTO requestDTO) {
        T entity = mapper.toEntity(requestDTO);
        T savedEntity = repository.save(entity);
        return mapper.toResponseDto(savedEntity);
    }

    @Override
    public Optional<ResponseDTO> findById(ID id) {
        return repository.findById(id).map(mapper::toResponseDto);
    }

    @Override
    public Iterable<ResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(mapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDTO update(RequestDTO requestDTO) {
        T entity = mapper.toEntity(requestDTO);
        Optional<T> existingEntity = repository.findById(getEntityId(entity));
        if (existingEntity.isPresent()) {
            T updatedEntity = repository.save(entity);
            return mapper.toResponseDto(updatedEntity);
        } else {
            throw new RuntimeException("La entidad con ese ID no fue encontrado");
        }
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    //Auxiliar para obtener el ID de la entidad
    protected abstract ID getEntityId(T entity);
}
