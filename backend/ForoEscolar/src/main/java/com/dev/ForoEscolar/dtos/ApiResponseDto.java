package com.dev.ForoEscolar.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDto<T>  implements Serializable {

    boolean estado;
    String message;
    T data;
    Iterable<T> dataIterable;


    public ApiResponseDto (boolean estado,String message, T data){
        this.estado=estado;
        this.message=message;
        this.data= data;
    }

    public ApiResponseDto (boolean estado,String message, Iterable<T> dataIterable){
        this.estado=estado;
        this.message=message;
        this.dataIterable=dataIterable;
    }

}
