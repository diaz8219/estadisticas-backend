package com.example.ESTADISTICAS_BACKEND.controladores;

import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.Materia;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.MateriaDTO;
import com.example.ESTADISTICAS_BACKEND.servicios.MateriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/materias")
public class MateriaControlador {

    @Autowired
    private MateriaServicio materiaServicio;

    @PostMapping
    public ResponseEntity<?> crearMateria(@RequestBody Materia materia) {
        try {
            MateriaDTO materiaGuardada = materiaServicio.guardarMateria(materia);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(materiaGuardada);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarMaterias() {
        try {
            List<MateriaDTO> materias = materiaServicio.listarMaterias();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(materias);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }
}
