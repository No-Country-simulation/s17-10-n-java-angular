package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.mapper.GenericMapper;
import com.dev.ForoEscolar.repository.GenericRepository;
import com.dev.ForoEscolar.services.GenericService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
    public void deleteById(ID id) {
        repository.deleteById(id);
    }


}
