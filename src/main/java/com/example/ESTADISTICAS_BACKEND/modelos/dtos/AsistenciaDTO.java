package com.example.ESTADISTICAS_BACKEND.modelos.dtos;

import com.example.ESTADISTICAS_BACKEND.ayudas.EstadosAsistencia;
import java.time.LocalDate;

public class AsistenciaDTO {
    private LocalDate fecha;
    private EstadosAsistencia estado;
    private String observaciones;
    private String estudiante;

    public AsistenciaDTO() {
    }

    public AsistenciaDTO(String estudiante, EstadosAsistencia estado, String observaciones, LocalDate fecha) {
        this.estudiante = estudiante;
        this.observaciones = observaciones;
        this.estado = estado;
        this.fecha = fecha;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public EstadosAsistencia getEstado() {
        return estado;
    }

    public void setEstado(EstadosAsistencia estado) {
        this.estado = estado;
    }
}
