package com.example.ESTADISTICAS_BACKEND.servicios;

import com.example.ESTADISTICAS_BACKEND.ayudas.EstadosAsistencia;
import com.example.ESTADISTICAS_BACKEND.ayudas.MensajesError;
import com.example.ESTADISTICAS_BACKEND.modelos.Asistencia;
import com.example.ESTADISTICAS_BACKEND.modelos.dtos.ResumenAsistenciaDTO;
import com.example.ESTADISTICAS_BACKEND.repositorios.IAsistenciaRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class ResumenAsistenciaServicio {

    @Autowired
    private IAsistenciaRepositorio asistenciaRepositorio;

    public ResumenAsistenciaDTO obtenerResumenAsistenciaPorGrupo(Integer grupoId) throws Exception {
        try {
            // buscar las asistencias asociadas a un grupo
            List<Asistencia> asistencias = asistenciaRepositorio.findByGrupoId(grupoId);

            if (asistencias.isEmpty() || asistencias.getFirst().getGrupo() == null) {
                throw new Exception(
                        MensajesError.ERROR_GRUPO_NO_ENCONTRADO.getDescripcion() +
                                ": No se encontró un grupo con el ID " + grupoId
                );
            }

            int presentes = 0;
            int ausentes = 0;

            // contador de asistencias
            for (Asistencia asistencia : asistencias) {
                if (asistencia.getEstado() == EstadosAsistencia.PRESENTE) {
                    presentes++;
                } else if (asistencia.getEstado() == EstadosAsistencia.AUSENTE) {
                    ausentes++;
                }
            }

            // nombre del grupo y total de asistencias
            String nombreGrupo = asistencias.getFirst().getGrupo().getNombre();
            int total = asistencias.size();

            return new ResumenAsistenciaDTO(grupoId, nombreGrupo, total, presentes, ausentes);

        } catch (Exception e) {
            if (e.getMessage().contains("No se encontró un grupo")) {
                throw new Exception(
                        MensajesError.ERROR_GRUPO_NO_ENCONTRADO.getDescripcion() + ": " + e.getMessage()
                );
            }

            throw new Exception(
                    MensajesError.ERROR_RESUMEN_ASISTENCIA.getDescripcion() + ": " + e.getMessage()
            );
        }
    }
}


