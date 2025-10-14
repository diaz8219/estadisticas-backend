package com.example.ESTADISTICAS_BACKEND.modelos.dtos;

public class InasistenciaMensualDTO {
    private Number idGrupo;
    private String mesNombre;
    private Double porcentajeInasistencia;

    public InasistenciaMensualDTO() {}

    public InasistenciaMensualDTO(Number idGrupo, Number mesNumero, Double porcentajeInasistencia) {
        this.idGrupo = idGrupo.intValue();
        this.mesNombre = convertirMes(mesNumero);
        this.porcentajeInasistencia = porcentajeInasistencia;
    }

    public Number getIdGrupo() { return idGrupo; }

    public void setIdGrupo(Number idGrupo) { this.idGrupo = idGrupo; }

    public String getMesNombre() { return mesNombre; }

    public void setMesNombre(String mesNombre) { this.mesNombre = mesNombre; }

    public Double getPorcentajeInasistencia() {
        if (porcentajeInasistencia == null) return null;
        return Math.round(porcentajeInasistencia * 10.0) / 10.0;
    }

    public void setPorcentajeInasistencia(Double porcentajeInasistencia) {
        this.porcentajeInasistencia = porcentajeInasistencia;
    }

    private String convertirMes(Number mesNumero) {
        if (mesNumero == null) return "Desconocido";

        int mes = mesNumero.intValue();
        switch (mes) {
            case 1:  return "Enero";
            case 2:  return "Febrero";
            case 3:  return "Marzo";
            case 4:  return "Abril";
            case 5:  return "Mayo";
            case 6:  return "Junio";
            case 7:  return "Julio";
            case 8:  return "Agosto";
            case 9:  return "Septiembre";
            case 10: return "Octubre";
            case 11: return "Noviembre";
            case 12: return "Diciembre";
            default: return "Mes inválido";
        }
    }
}