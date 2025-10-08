package com.example.ESTADISTICAS_BACKEND.repositorios;

import com.example.ESTADISTICAS_BACKEND.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Integer> {
}
