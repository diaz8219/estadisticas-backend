package com.example.ESTADISTICAS_BACKEND.modelos.dtos;

public class MateriaDTO {
    private String nombre;
    private String codigo;

    public MateriaDTO() {
    }

    public MateriaDTO(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
