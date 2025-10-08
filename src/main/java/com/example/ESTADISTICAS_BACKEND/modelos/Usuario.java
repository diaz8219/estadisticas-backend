package com.example.ESTADISTICAS_BACKEND.modelos;

import com.example.ESTADISTICAS_BACKEND.ayudas.EstadosUsuario;
import com.example.ESTADISTICAS_BACKEND.ayudas.RolesUsuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    // atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "correo", nullable = false, unique = true, length = 100)
    private String correo;

    @Column(name = "contrasena", nullable = false, length = 10)
    private String contrasena;

    @Column(name = "rol", nullable = false)
    @Enumerated(EnumType.STRING)
    private RolesUsuario rol;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadosUsuario estado;

    // relaciones

    @OneToOne(mappedBy = "usuario")
    @JsonBackReference(value = "RelacionEstudianteUsuario")
    private Estudiante estudiante;

    // constructores

    public Usuario() {
    }

    public Usuario(String contrasena, RolesUsuario rol, String nombre, EstadosUsuario estado, String correo) {
        this.contrasena = contrasena;
        this.rol = rol;
        this.nombre = nombre;
        this.estado = estado;
        this.correo = correo;
    }

    // metodos

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    // metodos por relaciones

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

}
