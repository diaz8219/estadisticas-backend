package com.example.ESTADISTICAS_BACKEND.modelos.dtos;

import com.example.ESTADISTICAS_BACKEND.ayudas.EstadosUsuario;
import com.example.ESTADISTICAS_BACKEND.ayudas.RolesUsuario;

public class UsuarioDTO {
    private String nombre;
    private String correo;
    private RolesUsuario rol;
    private EstadosUsuario estado;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String correo, RolesUsuario rol, String nombre, EstadosUsuario estado) {
        this.correo = correo;
        this.rol = rol;
        this.nombre = nombre;
        this.estado = estado;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public EstadosUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadosUsuario estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RolesUsuario getRol() {
        return rol;
    }

    public void setRol(RolesUsuario rol) {
        this.rol = rol;
    }
}
