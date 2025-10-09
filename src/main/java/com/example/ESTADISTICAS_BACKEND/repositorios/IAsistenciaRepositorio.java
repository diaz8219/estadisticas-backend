package com.example.ESTADISTICAS_BACKEND.repositorios;

import com.example.ESTADISTICAS_BACKEND.modelos.Asistencia;
import com.example.ESTADISTICAS_BACKEND.modelos.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAsistenciaRepositorio extends JpaRepository<Asistencia, Integer> {

    List<Asistencia> findByGrupoId(Integer grupoId);

}

