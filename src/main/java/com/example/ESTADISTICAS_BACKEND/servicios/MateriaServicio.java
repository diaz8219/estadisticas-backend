package com.example.ESTADISTICAS_BACKEND.servicios;

import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.Grupo;
import com.example.ESTADISTICAS_BACKEND.modelos.Materia;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.GrupoDTO;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.MateriaDTO;
import com.example.ESTADISTICAS_BACKEND.modelos.mapas.IMapaMateriaDTO;
import com.example.ESTADISTICAS_BACKEND.repositorios.IMateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaServicio {

    @Autowired
    private IMateriaRepositorio materiaRepositorio;

    @Autowired
    private IMapaMateriaDTO mapaMateriaDTO;

    public MateriaDTO guardarMateria(Materia materia) throws Exception {
        try {
            Materia materiaGuardada = materiaRepositorio.save(materia);
            return mapaMateriaDTO.convertirModeloADTO(materiaGuardada);
        } catch (Exception e) {
            throw new Exception(
                    MensajesError.ERROR_GUARDAR_MATERIA.getDescripcion() + ": " + e.getMessage()
            );
        }
    }

    public List<MateriaDTO> listarMaterias() throws Exception {
        try {
            List<Materia> materias = materiaRepositorio.findAll();

            if (materias.isEmpty()) {
                throw new Exception(MensajesError.ERROR_LISTAR_MATERIAS.getDescripcion() + ": No hay materias registradas.");
            }

            return mapaMateriaDTO.convertirModelosADTOS(materias);
        } catch (Exception e) {
            throw new Exception(
                    MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage()
            );
        }
    }

    public MateriaDTO obtenerMateriaPorId(Integer materiaId) throws Exception {
        try {
            Optional<Materia> materiaOpt = materiaRepositorio.findById(materiaId);

            if (materiaOpt.isEmpty()) {
                throw new Exception(MensajesError.ERROR_MATERIA_NO_ENCONTRADA.getDescripcion()
                        + ": No se encontró una materia con el ID " + materiaId);
            }

            return mapaMateriaDTO.convertirModeloADTO(materiaOpt.get());
        } catch (Exception e) {
            throw new Exception(
                    MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage()
            );
        }
    }

}
