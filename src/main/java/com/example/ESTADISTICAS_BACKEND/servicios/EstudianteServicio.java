package com.example.ESTADISTICAS_BACKEND.servicios;

import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.Estudiante;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.EstudianteDTO;
import com.example.ESTADISTICAS_BACKEND.modelos.mapas.IMapaEstudianteDTO;
import com.example.ESTADISTICAS_BACKEND.repositorios.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicio {

    @Autowired
    private IEstudianteRepositorio estudianteRepositorio;

    @Autowired
    private IMapaEstudianteDTO mapaEstudianteDTO;

    public EstudianteDTO guardarEstudiante(Estudiante estudiante) throws Exception {
        try {
            Estudiante estudianteGuardado = estudianteRepositorio.save(estudiante);
            return mapaEstudianteDTO.convertirModeloADTO(estudianteGuardado);
        } catch (Exception e) {
            throw new Exception(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

    public List<EstudianteDTO> listarEstudiantes() throws Exception {
        try {
            List<Estudiante> estudiantes = estudianteRepositorio.findAll();

            if (estudiantes == null || estudiantes.isEmpty()) {
                throw new Exception(
                        MensajesError.ERROR_LISTAR_ESTUDIANTE.getDescripcion() + ": No se encontraron estudiantes registrados."
                );
            }

            return mapaEstudianteDTO.convertirModelosADTOS(estudiantes);
        } catch (Exception e) {
            throw new Exception(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

    public EstudianteDTO obtenerEstudiantePorId(Integer id) throws Exception {
        try {
            Optional<Estudiante> estudianteOpt = estudianteRepositorio.findById(id);

            if (estudianteOpt.isEmpty()) {
                throw new Exception(
                        MensajesError.ERROR_ESTUDIANTE_NO_ENCONTRADO.getDescripcion() +
                                ": No se encontró un estudiante con el ID " + id
                );
            }

            return mapaEstudianteDTO.convertirModeloADTO(estudianteOpt.get());
        } catch (Exception e) {
            throw new Exception(MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage());
        }
    }

}

