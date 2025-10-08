package com.example.ESTADISTICAS_BACKEND.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupos")
public class Grupo {

    // atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "semestre", nullable = false, length = 100)
    private String semestre;

    // relaciones

    @OneToMany(mappedBy = "grupo")
    @JsonManagedReference(value="RelacionEstudianteGrupo")
    private List<Estudiante> estudiantes;

    @OneToMany(mappedBy = "grupo")
    @JsonManagedReference("RelacionGrupoAsistencia")
    private List<Asistencia> asistencias;

    @ManyToOne
    @JoinColumn(name = "fk_materia", referencedColumnName = "id")
    @JsonBackReference(value="RelacionGrupoMateria")
    private Materia materia;

    // constructores

    public Grupo() {
    }

    public Grupo(String semestre, String nombre) {
        this.semestre = semestre;
        this.nombre = nombre;
    }

    // metodos

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

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    // metodos por relaciones

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

}
