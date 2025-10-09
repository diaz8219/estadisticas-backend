package com.example.ESTADISTICAS_BACKEND.modelos.dtos;

public class GrupoDTO {
    private String nombre;
    private String semestre;
    private String materia;

    public GrupoDTO() {
    }

    public GrupoDTO(String materia, String semestre, String nombre) {
        this.materia = materia;
        this.semestre = semestre;
        this.nombre = nombre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
}
