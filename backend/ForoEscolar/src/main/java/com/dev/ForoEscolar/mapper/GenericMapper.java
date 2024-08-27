package com.dev.ForoEscolar.mapper;

public interface GenericMapper <T, RequestDTO, ResponseDTO>{

    T toEntity(RequestDTO requestDTO);

    ResponseDTO toResponseDto(T entity);

}
