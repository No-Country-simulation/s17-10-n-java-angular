package com.dev.ForoEscolar.repository;

import com.dev.ForoEscolar.enums.MateriaEnum;
import com.dev.ForoEscolar.model.Calificacion;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalificacionRepository extends GenericRepository<Calificacion, Long>{

    List<Calificacion> findByEstudianteId(Long estudianteId);
    List<Calificacion> findByMateria(MateriaEnum materiaEnum);

}
