package com.example.ESTADISTICAS_BACKEND.servicios;

import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.Asistencia;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.AsistenciaDTO;
import com.example.ESTADISTICAS_BACKEND.modelos.mapas.IMapaAsistenciaDTO;
import com.example.ESTADISTICAS_BACKEND.repositorios.IAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AsistenciaServicio {

    @Autowired
    private IAsistenciaRepositorio asistenciaRepositorio;

    @Autowired
    private IMapaAsistenciaDTO mapaAsistenciaDTO;

    public AsistenciaDTO guardarAsistencia(Asistencia asistencia) throws Exception {
        try {
            Asistencia asistenciaGuardada = asistenciaRepositorio.save(asistencia);
            return mapaAsistenciaDTO.convertirModeloADTO(asistenciaGuardada);
        } catch (Exception e) {
            throw new Exception(
                    MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage()
            );
        }
    }

    public List<AsistenciaDTO> listarAsistencias() throws Exception {
        try {
            List<Asistencia> asistencias = asistenciaRepositorio.findAll();

            if (asistencias.isEmpty()) {
                throw new Exception(MensajesError.ERROR_LISTAR_ASISTENCIA.getDescripcion() + ": No hay asistencias registradas.");
            }

            return mapaAsistenciaDTO.convertirModelosADTOS(asistencias);
        } catch (Exception e) {
            throw new Exception(
                    MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage()
            );
        }
    }

    public List<AsistenciaDTO> listarAsistenciasPorGrupo(Integer grupoId) throws Exception {
        try {
            List<Asistencia> asistencias = asistenciaRepositorio.findByGrupoId(grupoId);

            if (asistencias == null || asistencias.isEmpty()) {
                throw new Exception(MensajesError.ERROR_LISTAR_ASISTENCIA.getDescripcion() + ": No se encontraron asistencias para el grupo " + grupoId);
            }

            return mapaAsistenciaDTO.convertirModelosADTOS(asistencias);
        } catch (Exception e) {
            throw new Exception(
                    MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage()
            );
        }
    }

}

