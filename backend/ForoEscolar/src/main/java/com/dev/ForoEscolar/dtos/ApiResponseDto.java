package com.dev.ForoEscolar.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDto<T>{

    private boolean estado;
    private String message;
    private T data;
    private Iterable<T> dataIterable;


    public ApiResponseDto(boolean estado, String message, T data) {
        this.estado = estado;
        this.message = message;
        this.data = data;
    }

    public ApiResponseDto(boolean estado, String message, Iterable<T> dataIterable) {
        this.estado = estado;
        this.message = message;
        this.dataIterable = dataIterable;
    }

}