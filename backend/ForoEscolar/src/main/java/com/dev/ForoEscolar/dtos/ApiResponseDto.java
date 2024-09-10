package com.dev.ForoEscolar.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
//Esto esta todo roto!!!!. Ojo arreglar
/*
public class ApiResponseDto<T> {
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDto<T>  implements Serializable {

    boolean estado;
    String message;
    T data;
    Iterable<T> dataIterable;


    public ApiResponseDto(boolean estado, String message, T data) {
        this.estado = estado;
        this.message = message;
        this.data = data;
    }

    public ApiResponseDto(boolean estado, String message, Iterable dataIterable) {
        this.estado = estado;
        this.message = message;
        this.dataIterable = dataIterable;

        }
    public ApiResponseDto (boolean estado,String message,  Iterable<T> dataIterable){
        this.estado=estado;
        this.message=message;
        this.dataIterable=dataIterable;
    }

}
*/