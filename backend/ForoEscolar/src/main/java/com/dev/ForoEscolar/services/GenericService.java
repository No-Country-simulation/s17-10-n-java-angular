package com.dev.ForoEscolar.services;

import java.util.Optional;

public interface GenericService<T, ID> {

    T save(T entity);

    Optional<T> findById(ID id);

    Iterable<T> findAll();

    void deleteById(ID id);
}
