package com.example.ESTADISTICAS_BACKEND.controladores;

import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.Asistencia;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.AsistenciaDTO;
import com.example.ESTADISTICAS_BACKEND.servicios.AsistenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/asistencias")
public class AsistenciaControlador {

    @Autowired
    private AsistenciaServicio asistenciaServicio;

    @PostMapping
    public ResponseEntity<?> crearAsistencia(@RequestBody Asistencia asistencia) {
        try {
            AsistenciaDTO asistenciaGuardada = asistenciaServicio.guardarAsistencia(asistencia);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(asistenciaGuardada);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarAsistencias() {
        try {
            List<AsistenciaDTO> asistencias = asistenciaServicio.listarAsistencias();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(asistencias);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

}

