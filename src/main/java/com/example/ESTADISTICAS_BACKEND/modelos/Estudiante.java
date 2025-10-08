package com.example.ESTADISTICAS_BACKEND.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante {

    // atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "programa", nullable = false, length = 100)
    private String programa;

    @Column(name = "semestre", nullable = false, length = 100)
    private String semestre;

    @Column(name = "fechaNacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "genero", nullable = false)
    private Boolean genero; // 1/true: Masculino - 0/false: Femenino

    // relaciones

    @OneToOne
    @JoinColumn(name = "fk_usuario", referencedColumnName = "id")
    @JsonManagedReference(value = "RelacionEstudianteUsuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "estudiante")
    @JsonManagedReference(value="RelacionEstudianteAsistencia")
    private List<Asistencia> asistencias;

    @ManyToOne
    @JoinColumn(name = "fk_grupo",referencedColumnName = "id")
    @JsonBackReference(value="RelacionEstudianteGrupo")
    private Grupo grupo;

    // constructores

    public Estudiante() {
    }

    public Estudiante(LocalDate fechaNacimiento, Boolean genero, String programa, String semestre) {
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.programa = programa;
        this.semestre = semestre;
    }

    // metodos

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getGenero() {
        return genero;
    }

    public void setGenero(Boolean genero) {
        this.genero = genero;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    // metodos por relaciones

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

}
