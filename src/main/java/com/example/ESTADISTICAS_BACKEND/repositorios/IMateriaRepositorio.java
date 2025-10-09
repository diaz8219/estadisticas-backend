package com.example.ESTADISTICAS_BACKEND.repositorios;

import com.example.ESTADISTICAS_BACKEND.modelos.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMateriaRepositorio extends JpaRepository<Materia, Integer> {
}
