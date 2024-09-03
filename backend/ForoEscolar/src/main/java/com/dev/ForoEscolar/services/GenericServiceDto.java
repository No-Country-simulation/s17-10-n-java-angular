package com.dev.ForoEscolar.services;

import java.util.Optional;

public interface GenericServiceDto<ID, EntityDto> {

    EntityDto save(EntityDto requestDTO);

    Optional<EntityDto> findById(ID id);

    Iterable<EntityDto> findAll();

    void deleteById(ID id);

}
