package com.dev.ForoEscolar.services;

import java.util.Optional;

public interface GenericService<T, ID, RequestDTO, ResponseDTO> {

    ResponseDTO save(RequestDTO requestDTO);

    Optional<ResponseDTO> findById(ID id);

    Iterable<ResponseDTO> findAll();

    ResponseDTO update(RequestDTO requestDTO);

    void deleteById(ID id);
}
