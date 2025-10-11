package com.example.ESTADISTICAS_BACKEND.modelos.dtos;

public class ResumenAsistenciaMensualDTO {

    private String mesAnio; // Formato: YYYY-MM
    private double porcentajeAsistencia;
    private long totalPresentes;
    private long totalAusentes;

    // Constructores, Getters y Setters...

    public ResumenAsistenciaMensualDTO() {
    }

    public ResumenAsistenciaMensualDTO(String mesAnio, double porcentajeAsistencia, long totalPresentes, long totalAusentes) {
        this.mesAnio = mesAnio;
        this.porcentajeAsistencia = porcentajeAsistencia;
        this.totalPresentes = totalPresentes;
        this.totalAusentes = totalAusentes;
    }

    public String getMesAnio() {
        return mesAnio;
    }

    public void setMesAnio(String mesAnio) {
        this.mesAnio = mesAnio;
    }

    public double getPorcentajeAsistencia() {
        return porcentajeAsistencia;
    }

    public void setPorcentajeAsistencia(double porcentajeAsistencia) {
        this.porcentajeAsistencia = porcentajeAsistencia;
    }

    public long getTotalPresentes() {
        return totalPresentes;
    }

    public void setTotalPresentes(long totalPresentes) {
        this.totalPresentes = totalPresentes;
    }

    public long getTotalAusentes() {
        return totalAusentes;
    }

    public void setTotalAusentes(long totalAusentes) {
        this.totalAusentes = totalAusentes;
    }
}
