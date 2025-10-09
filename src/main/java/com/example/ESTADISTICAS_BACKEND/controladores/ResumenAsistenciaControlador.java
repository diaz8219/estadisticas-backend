package com.example.ESTADISTICAS_BACKEND.controladores;

import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.ResumenAsistenciaDTO;
import com.example.ESTADISTICAS_BACKEND.servicios.ResumenAsistenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estadisticas")
public class ResumenAsistenciaControlador {

    @Autowired
    private ResumenAsistenciaServicio resumenAsistenciaServicio;

    @GetMapping("/asistencias/resumen/{grupoId}")
    public ResponseEntity<?> obtenerResumenPorGrupo(@PathVariable Integer grupoId) {
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

}
