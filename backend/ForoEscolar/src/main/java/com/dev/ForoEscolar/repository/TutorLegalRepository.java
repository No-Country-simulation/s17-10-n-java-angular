package com.dev.ForoEscolar.repository;

import com.dev.ForoEscolar.model.TutorLegal;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TutorLegalRepository extends GenericRepository<TutorLegal, Long> {

    Optional<TutorLegal> findByEmail(String email);


}
