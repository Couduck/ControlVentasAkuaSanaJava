package Models;

import java.util.Date;

public class Producto
{
    String clave;
    String nombre;
    String status;
    Date fechaAlta;
    Integer litros;
    String nombreBI;

    public Producto(String clave, String nombre, String status, Date fechaAlta, Integer litros, String nombreBI) {
        this.clave = clave;
        this.nombre = nombre;
        this.status = status;
        this.fechaAlta = fechaAlta;
        this.litros = litros;
        this.nombreBI = nombreBI;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Integer getLitros() {
        return litros;
    }

    public void setLitros(Integer litros) {
        this.litros = litros;
    }

    public String getNombreBI() {
        return nombreBI;
    }

    public void setNombreBI(String nombreBI) {
        this.nombreBI = nombreBI;
    }
}
