package com.dev.ForoEscolar.services.impl;

import com.dev.ForoEscolar.repository.GenericRepository;
import com.dev.ForoEscolar.services.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public abstract class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

    protected final GenericRepository<T, ID> repository;

    @Autowired
    protected GenericServiceImpl(GenericRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }

}
