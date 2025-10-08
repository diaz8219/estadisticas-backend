package com.example.ESTADISTICAS_BACKEND.ayudas;

public enum MensajesError {

    ERROR_GENERAL("🟥Ups! Fallo al intentar procesar la API.🟥"),

    // errores en Asistencia:
    ERROR_RESUMEN_ASISTENCIA("🟥Error consultar resumen de asistencias.🟥"),
    ERROR_LISTAR_ASISTENCIA("🟥Error al listar asistencias.🟥"),

    // errores en Grupo:
    ERROR_GRUPO_NO_ENCONTRADO("🟥El grupo que buscas no existe en la base de datos.🟥"),
    ERROR_GUARDAR_GRUPO("🟥Error al guardar grupo.🟥"),
    ERROR_LISTAR_GRUPO("🟥Error al listar grupos.🟥"),

    // errores en Estudiante:
    ERROR_ESTUDIANTE_NO_ENCONTRADO("🟥El estudiante que buscas no existe en la base de datos.🟥"),
    ERROR_LISTAR_ESTUDIANTE("🟥Error al listar estudiantes.🟥"),

    // errores en Usuario:
    ERROR_USUARIO_NO_ENCONTRADO("🟥El estudiante que buscas no existe en la base de datos.🟥"),
    ERROR_LISTAR_USUARIO("🟥Error al listar usuarios.🟥"),

    // errores en Materia:

    ERROR_MATERIA_NO_ENCONTRADA("🟥La materia que buscas no existe en la base de datos.🟥"),
    ERROR_GUARDAR_MATERIA("🟥Error al guardar materia.🟥"),
    ERROR_LISTAR_MATERIAS("🟥Error al listar materias.🟥")

    ;

    private final String descripcion; // variable

    MensajesError(String descripcion) { // constructor
        this.descripcion = descripcion;
    }

    public String getDescripcion() { // getter sin setter pq no se modificará
        return descripcion;
    }
}
