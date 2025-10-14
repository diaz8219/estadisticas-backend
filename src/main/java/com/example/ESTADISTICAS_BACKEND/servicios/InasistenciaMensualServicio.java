package com.example.ESTADISTICAS_BACKEND.servicios;

import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.InasistenciaMensualDTO;
import com.example.ESTADISTICAS_BACKEND.repositorios.IAsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InasistenciaMensualServicio {

    @Autowired
    private IAsistenciaRepositorio asistenciaRepositorio;

    public List<InasistenciaMensualDTO> obtenerReporteInasistencias(Integer idGrupo) throws Exception {
        try {

            List<InasistenciaMensualDTO> lista = asistenciaRepositorio.calcularTasaInasistenciaMensual(idGrupo);

            if (lista == null || lista.isEmpty()) {
                throw new Exception(MensajesError.ERROR_LISTAR_ASISTENCIA.getDescripcion()
                        + ": No se encontraron inasistencias.");
            }

            return lista;

        } catch (Exception err) {
            throw new Exception(
                    MensajesError.ERROR_GENERAL.getDescripcion() + ":" + err.getMessage()
            );
        }
    }
}
