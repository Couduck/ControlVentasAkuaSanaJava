package Models;

import java.util.Date;

public class Semana {

    Date fechaInicio;

    Date fechaFinal;

    String anio;

    String numSemana;

    String idSemanaCombinado;

    public Semana(Date fechaInicio, Date fechaFinal, String anio, String numSemana, String idSemanaCombinado) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.anio = anio;
        this.numSemana = numSemana;
        this.idSemanaCombinado = idSemanaCombinado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getNumSemana() {
        return numSemana;
    }

    public void setNumSemana(String numSemana) {
        this.numSemana = numSemana;
    }

    public String getIdSemanaCombinado() {
        return idSemanaCombinado;
    }

    public void setIdSemanaCombinado(String idSemanaCombinado) {
        this.idSemanaCombinado = idSemanaCombinado;
    }
}
