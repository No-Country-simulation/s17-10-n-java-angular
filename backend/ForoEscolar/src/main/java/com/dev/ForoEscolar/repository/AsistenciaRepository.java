package com.dev.ForoEscolar.repository;

import com.dev.ForoEscolar.model.Asistencia;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepository extends GenericRepository<Asistencia, Long> {

    long countByAsistio(boolean asistio);

    long count();
}
