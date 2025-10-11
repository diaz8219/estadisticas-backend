package com.example.ESTADISTICAS_BACKEND.controladores;

import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.ResumenAsistenciaDTO;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.ResumenAsistenciaMensualDTO; // Importar
import com.example.ESTADISTICAS_BACKEND.servicios.ResumenAsistenciaServicio;
import com.example.ESTADISTICAS_BACKEND.servicios.ResumenAsistenciaMensualServicio; // Importar
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate; // Importar
import java.util.List; // Importar

@RestController
@RequestMapping("/estadisticas")
public class ResumenAsistenciaControlador {

    // ... (El servicio existente se mantiene)
    @Autowired
    private ResumenAsistenciaServicio resumenAsistenciaServicio;

    @Autowired // Nuevo atributo inyectado para el servicio mensual
    private ResumenAsistenciaMensualServicio resumenAsistenciaMensualServicio;

    // Endpoint existente: obtenerResumenPorGrupo
    @GetMapping("/asistencias/resumen/{grupoId}")
    public ResponseEntity<?> obtenerResumenPorGrupo(@PathVariable Integer grupoId) {
        // ... (Implementación existente)
        try {
            ResumenAsistenciaDTO resultado = resumenAsistenciaServicio.obtenerResumenAsistenciaPorGrupo(grupoId);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(resultado);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

    /**
     * HU05: Endpoint para obtener el reporte mensual de asistencia por estudiante
     * Uso: GET /estadisticas/asistencias/mensual/1?inicio=2024-01-01&fin=2024-12-31
     */
    @GetMapping("/asistencias/mensual/{estudianteId}")
    public ResponseEntity<?> obtenerReporteMensualPorEstudiante(
            @PathVariable Integer estudianteId,
            @RequestParam("inicio") LocalDate fechaInicio,
            @RequestParam("fin") LocalDate fechaFin) {

        try {
            List<ResumenAsistenciaMensualDTO> resultado =
                    resumenAsistenciaMensualServicio.obtenerReporteMensual(estudianteId, fechaInicio, fechaFin);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(resultado);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage()); // Devuelve el mensaje de error personalizado del servicio
        }
    }

}
