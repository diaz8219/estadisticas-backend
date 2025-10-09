package com.example.ESTADISTICAS_BACKEND.controladores;

import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.Grupo;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.GrupoDTO;
import com.example.ESTADISTICAS_BACKEND.servicios.GrupoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grupos")
public class GrupoControlador {

    @Autowired
    private GrupoServicio grupoServicio;

    @PostMapping
    public ResponseEntity<?> crearGrupo(@RequestBody Grupo grupo) {
        try {
            GrupoDTO grupoGuardado = grupoServicio.guardarGrupo(grupo);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(grupoGuardado);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> listarGrupos() {
        try {
            List<GrupoDTO> grupos = grupoServicio.listarGrupos();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(grupos);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

    @GetMapping("/{grupoId}")
    public ResponseEntity<?> obtenerGrupoPorId(@PathVariable Integer grupoId) {
        try {
            GrupoDTO grupo = grupoServicio.obtenerGrupoPorId(grupoId);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(grupo);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

}