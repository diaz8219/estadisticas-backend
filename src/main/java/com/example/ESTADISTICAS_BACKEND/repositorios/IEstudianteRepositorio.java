package com.example.ESTADISTICAS_BACKEND.repositorios;

import com.example.ESTADISTICAS_BACKEND.modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudianteRepositorio extends JpaRepository<Estudiante, Integer> {

}
