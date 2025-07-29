package com.gestortareas.gestor.repository;

import com.gestortareas.gestor.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}

