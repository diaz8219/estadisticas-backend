package com.example.ESTADISTICAS_BACKEND.servicios;

import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.Grupo;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.GrupoDTO;
import com.example.ESTADISTICAS_BACKEND.modelos.mapas.IMapaGrupoDTO;
import com.example.ESTADISTICAS_BACKEND.repositorios.IGrupoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GrupoServicio {

    @Autowired
    private IGrupoRepositorio grupoRepositorio;

    @Autowired
    private IMapaGrupoDTO mapaGrupoDTO;

    public GrupoDTO guardarGrupo(Grupo grupo) throws Exception {
        try {
            Grupo grupoGuardado = grupoRepositorio.save(grupo);
            return mapaGrupoDTO.convertirModeloADTO(grupoGuardado);
        } catch (Exception e) {
            throw new Exception(
                    MensajesError.ERROR_GUARDAR_GRUPO.getDescripcion() + ": " + e.getMessage()
            );
        }
    }

    public List<GrupoDTO> listarGrupos() throws Exception {
        try {
            List<Grupo> grupos = grupoRepositorio.findAll();

            if (grupos.isEmpty()) {
                throw new Exception(MensajesError.ERROR_LISTAR_GRUPO.getDescripcion() + ": No hay grupos registrados.");
            }

            return mapaGrupoDTO.convertirModelosADTOS(grupos);
        } catch (Exception e) {
            throw new Exception(
                    MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage()
            );
        }
    }

    public GrupoDTO obtenerGrupoPorId(Integer grupoId) throws Exception {
        try {
            Optional<Grupo> grupoOpt = grupoRepositorio.findById(grupoId);

            if (grupoOpt.isEmpty()) {
                throw new Exception(MensajesError.ERROR_GRUPO_NO_ENCONTRADO.getDescripcion()
                        + ": No se encontró un grupo con el ID " + grupoId);
            }

            return mapaGrupoDTO.convertirModeloADTO(grupoOpt.get());
        } catch (Exception e) {
            throw new Exception(
                    MensajesError.ERROR_GENERAL.getDescripcion() + ": " + e.getMessage()
            );
        }
    }

}

