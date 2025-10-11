package com.example.ESTADISTICAS_BACKEND.repositorios;

import com.example.ESTADISTICAS_BACKEND.modelos.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; // Importar
import org.springframework.data.repository.query.Param; // Importar
import org.springframework.stereotype.Repository;

import java.time.LocalDate; // Importar
import java.util.List;

@Repository
public interface IAsistenciaRepositorio extends JpaRepository<Asistencia, Integer> {

    List<Asistencia> findByGrupoId(Integer grupoId);

    /**
     * HU05: Consulta que agrupa asistencias por mes (formato YYYY-MM)
     * y las filtra por un estudiante y un rango de fechas.
     */
    @Query("SELECT FUNCTION('DATE_FORMAT', a.fecha, '%Y-%m') AS mesAnio, " +
            "       SUM(CASE WHEN a.estado = 'PRESENTE' THEN 1 ELSE 0 END) AS presentes, " +
            "       SUM(CASE WHEN a.estado = 'AUSENTE' THEN 1 ELSE 0 END) AS ausentes " +
            "FROM Asistencia a " +
            "WHERE a.estudiante.id = :estudianteId " +
            "  AND a.fecha BETWEEN :fechaInicio AND :fechaFin " +
            "GROUP BY mesAnio " +
            "ORDER BY mesAnio")
    List<Object[]> obtenerResumenMensualPorEstudianteYRango(
            @Param("estudianteId") Integer estudianteId,
            @Param("fechaInicio") LocalDate fechaInicio,
            @Param("fechaFin") LocalDate fechaFin);
}