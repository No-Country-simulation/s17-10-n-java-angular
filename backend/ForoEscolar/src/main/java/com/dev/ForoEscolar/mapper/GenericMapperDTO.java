package com.dev.ForoEscolar.mapper;

public interface GenericMapperDTO<T, ResponseDTO>{

    T toEntity(ResponseDTO requestDTO);

    ResponseDTO toResponseDTO(T entity);
}
