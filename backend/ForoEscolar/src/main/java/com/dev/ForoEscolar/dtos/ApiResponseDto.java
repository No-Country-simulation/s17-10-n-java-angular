package com.dev.ForoEscolar.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Iterable<T> getDataIterable() {
        return dataIterable;
    }

    public void setDataIterable(Iterable<T> dataIterable) {
        this.dataIterable = dataIterable;
    }
}
