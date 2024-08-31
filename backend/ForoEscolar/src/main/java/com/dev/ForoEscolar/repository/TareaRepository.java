package com.dev.ForoEscolar.repository;

import com.dev.ForoEscolar.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}
