package com.dev.ForoEscolar.repository;


import com.dev.ForoEscolar.enums.AulaEnum;
import com.dev.ForoEscolar.enums.CursoEnum;
import com.dev.ForoEscolar.model.Estudiante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends GenericRepository<Estudiante, Long>{

//    List<Estudiante> findByAula(AulaEnum aulaEnum);
//    List<Estudiante> findByCurso(CursoEnum cursoEnum);
//
//    @Query("SELECT e FROM Estudiante e WHERE e.curso = :curso AND e.aula = :aula")
//    List<Estudiante> findByCursoAndAula(@Param("curso") CursoEnum curso, @Param("aula") AulaEnum aula);

    List<Estudiante> findByGradoId(Long gradoId);


}
