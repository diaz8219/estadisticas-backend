package com.example.ESTADISTICAS_BACKEND.controladores;

import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.Estudiante;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.EstudianteDTO;
import com.example.ESTADISTICAS_BACKEND.servicios.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteControlador {

    @Autowired
    private EstudianteServicio estudianteServicio;

    @PostMapping
    public ResponseEntity<?> crearEstudiante(@RequestBody Estudiante estudiante) {
        try {
            EstudianteDTO nuevo = estudianteServicio.guardarEstudiante(estudiante);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarEstudiantes() {
        try {
            List<EstudianteDTO> estudiantes = estudianteServicio.listarEstudiantes();
            return ResponseEntity.ok(estudiantes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerEstudiantePorId(@PathVariable Integer id) {
        try {
            EstudianteDTO estudiante = estudianteServicio.obtenerEstudiantePorId(id);
            return ResponseEntity.ok(estudiante);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

}

