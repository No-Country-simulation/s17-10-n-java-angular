package com.dev.ForoEscolar.repository;

import com.dev.ForoEscolar.model.Profesor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends GenericRepository<Profesor, Long>{

    Optional<Profesor> findByEmail(String email);

}
