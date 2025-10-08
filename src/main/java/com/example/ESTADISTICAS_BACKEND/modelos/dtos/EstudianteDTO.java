package com.example.ESTADISTICAS_BACKEND.modelos.dtos;

public class EstudianteDTO {
    private String nombre; // viene de 'Usuario'
    private String correo; // viene de 'Usuario'
    private String grupo; // viene de 'Grupo'
    private String programa;
    private String semestre;

    public EstudianteDTO() {
    }

    public EstudianteDTO(String correo, String semestre, String grupo, String programa, String nombre) {
        this.correo = correo;
        this.semestre = semestre;
        this.grupo = grupo;
        this.programa = programa;
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
}
