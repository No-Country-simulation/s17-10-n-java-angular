package com.dev.ForoEscolar.dtos;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.Getter;


public class ApiResponseDto<T>{

    boolean estado;
    String message;
    T data;
    Iterable dataIterable;


    public ApiResponseDto (boolean estado,String message, T data){
        this.estado=estado;
        this.message=message;
        this.data= data;
    }

    public ApiResponseDto (boolean estado,String message, Iterable dataIterable){
        this.estado=estado;
        this.message=message;
        this.dataIterable=dataIterable;
    }

}
