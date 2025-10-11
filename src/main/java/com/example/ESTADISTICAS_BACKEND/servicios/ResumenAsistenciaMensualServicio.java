package com.example.ESTADISTICAS_BACKEND.servicios;

import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.ResumenAsistenciaMensualDTO;
import com.example.ESTADISTICAS_BACKEND.repositorios.IAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResumenAsistenciaMensualServicio {

    @Autowired
    private IAsistenciaRepositorio asistenciaRepositorio;

    public List<ResumenAsistenciaMensualDTO> obtenerReporteMensual(
            Integer estudianteId,
            LocalDate fechaInicio,
            LocalDate fechaFin) throws Exception {

        try {
            // 1. Obtener la data agrupada del repositorio
            List<Object[]> resultados = asistenciaRepositorio.obtenerResumenMensualPorEstudianteYRango(
                    estudianteId, fechaInicio, fechaFin);

            if (resultados == null || resultados.isEmpty()) {
                // Notar que uso el mismo estilo de manejo de excepciones que en sus servicios
                throw new Exception(MensajesError.ERROR_LISTAR_ASISTENCIA.getDescripcion()
                        + ": No se encontraron asistencias para el estudiante " + estudianteId + " en el rango de fechas.");
            }

            List<ResumenAsistenciaMensualDTO> reporte = new ArrayList<>();

            // 2. Procesar los resultados y calcular el porcentaje
            for (Object[] fila : resultados) {
                String mesAnio = (String) fila[0];
                // Los resultados de SUM son de tipo Long
                long presentes = ((Number) fila[1]).longValue();
                long ausentes = ((Number) fila[2]).longValue();
                long total = presentes + ausentes;

                double porcentaje = (total > 0) ? (double) presentes / total * 100 : 0.0;

                // 3. Mapear y añadir al DTO de respuesta
                reporte.add(new ResumenAsistenciaMensualDTO(
                        mesAnio,
                        Math.round(porcentaje * 100.0) / 100.0, // Redondeo a 2 decimales
                        presentes,
                        ausentes));
            }

            return reporte;

        } catch (Exception e) {
            // Manejo de errores
            throw new Exception(
                    MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage()
            );
        }
    }
}
