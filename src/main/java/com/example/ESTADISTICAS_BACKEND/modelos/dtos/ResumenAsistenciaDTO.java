package com.example.ESTADISTICAS_BACKEND.modelos.dtos;

public class ResumenAsistenciaDTO {
    private Integer grupoId;
    private String grupoNombre;
    private long presentes;
    private long ausentes;
    private long tardanzas;

    public ResumenAsistenciaDTO() {
    }

    public ResumenAsistenciaDTO(Integer grupoId, String grupoNombre, long total, long presentes, long ausentes) {
        this.grupoId = grupoId;
        this.grupoNombre = grupoNombre;
        this.presentes = presentes;
        this.ausentes = ausentes;
        this.tardanzas = total;
    }

    public long getAusentes() {
        return ausentes;
    }

    public void setAusentes(long ausentes) {
        this.ausentes = ausentes;
    }

    public String getGrupoNombre() {
        return grupoNombre;
    }

    public void setGrupoNombre(String grupoNombre) {
        this.grupoNombre = grupoNombre;
    }

    public Integer getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(Integer grupoId) {
        this.grupoId = grupoId;
    }

    public long getPresentes() {
        return presentes;
    }

    public void setPresentes(long presentes) {
        this.presentes = presentes;
    }

    public long getTardanzas() {
        return tardanzas;
    }

    public void setTardanzas(long tardanzas) {
        this.tardanzas = tardanzas;
    }

}

