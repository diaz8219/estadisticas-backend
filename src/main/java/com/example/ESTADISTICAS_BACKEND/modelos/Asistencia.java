package com.example.ESTADISTICAS_BACKEND.modelos;

import com.example.ESTADISTICAS_BACKEND.ayudas.EstadosAsistencia;
import com.example.ESTADISTICAS_BACKEND.ayudas.RolesUsuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "asistencias")
public class Asistencia {

    // atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadosAsistencia estado;

    @Column(name = "observaciones", nullable = true, length = 200)
    private String observaciones;

    // relaciones

    @ManyToOne
    @JoinColumn(name = "fk_estudiante", referencedColumnName = "id")
    @JsonBackReference(value="RelacionEstudianteAsistencia")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "fk_grupo", referencedColumnName = "id")
    @JsonBackReference(value="RelacionGrupoAsistencia")
    private Grupo grupo;

    // constructores

    public Asistencia() {
    }

    public Asistencia(LocalDate fecha, EstadosAsistencia estado, String observaciones) {
        this.fecha = fecha;
        this.estado = estado;
        this.observaciones = observaciones;
    }

    // metodos

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EstadosAsistencia getEstado() {
        return estado;
    }

    public void setEstado(EstadosAsistencia estado) {
        this.estado = estado;
    }

    // metodos por relaciones

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

}

