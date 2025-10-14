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

    private String convertirMes(Number mesNumero) {
        if (mesNumero == null) return "Desconocido";

        int mes = mesNumero.intValue();

        switch (mes) {
            case 1:  return "Enero";
            case 2:  return "Febrero";
            case 3:  return "Marzo";
            case 4:  return "Abril";
            case 5:  return "Mayo";
            case 6:  return "Junio";
            case 7:  return "Julio";
            case 8:  return "Agosto";
            case 9:  return "Septiembre";
            case 10: return "Octubre";
            case 11: return "Noviembre";
            case 12: return "Diciembre";
            default: return "Mes inválido";
        }
    }


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
