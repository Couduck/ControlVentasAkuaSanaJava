package Models;

import java.util.Date;

public class Cliente {
    int clave;
    String nombreClave;
    String status;
    String tipoFactura;
    String cliRepo;
    String momentoEmisionFactura;
    String formaPago;
    String clavePrecio;
    Date fechaAlta;
    Date fechaModificacion;
    Contacto contacto;
    Domicilio domicilio;
    DomicilioFiscal domicilioFiscal;

    String correoFacturas;

    Date fechaUltimaCompra;

    String observaciones;

    String latitud;

    String longitud;

    public Cliente(/*int clave,*/ String nombreClave, String status, String tipoFactura, String cliRepo, String momentoEmisionFactura, String formaPago, String clavePrecio, Date fechaAlta, Date fechaModificacion, String correoFacturas, Date fechaUltimaCompra, String observaciones, String latitud, String longitud)
    {
        //this.clave = clave;
        this.nombreClave = nombreClave;
        this.status = status;
        this.tipoFactura = tipoFactura;
        this.cliRepo = cliRepo;
        this.momentoEmisionFactura = momentoEmisionFactura;
        this.formaPago = formaPago;
        this.clavePrecio = clavePrecio;
        this.fechaAlta = fechaAlta;
        this.fechaModificacion = fechaModificacion;
        this.correoFacturas = correoFacturas;
        this.fechaUltimaCompra = fechaUltimaCompra;
        this.observaciones = observaciones;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public Cliente(int clave, String nombreClave, String status, String tipoFactura, String cliRepo, String momentoEmisionFactura, String formaPago, String clavePrecio, Date fechaAlta, Date fechaModificacion, String correoFacturas, Date fechaUltimaCompra, String observaciones, String latitud, String longitud) {
        this.clave = clave;
        this.nombreClave = nombreClave;
        this.status = status;
        this.tipoFactura = tipoFactura;
        this.cliRepo = cliRepo;
        this.momentoEmisionFactura = momentoEmisionFactura;
        this.formaPago = formaPago;
        this.clavePrecio = clavePrecio;
        this.fechaAlta = fechaAlta;
        this.fechaModificacion = fechaModificacion;
        this.correoFacturas = correoFacturas;
        this.fechaUltimaCompra = fechaUltimaCompra;
        this.observaciones = observaciones;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public String getNombreClave() {
        return nombreClave;
    }

    public void setNombreClave(String nombreClave) {
        this.nombreClave = nombreClave;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(String tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public String getCliRepo() {
        return cliRepo;
    }

    public void setCliRepo(String cliRepo) {
        this.cliRepo = cliRepo;
    }

    public String getMomentoEmisionFactura() {
        return momentoEmisionFactura;
    }

    public void setMomentoEmisionFactura(String momentoEmisionFactura) {
        this.momentoEmisionFactura = momentoEmisionFactura;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getClavePrecio() {
        return clavePrecio;
    }

    public void setClavePrecio(String clavePrecio) {
        this.clavePrecio = clavePrecio;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public DomicilioFiscal getDomicilioFiscal() {
        return domicilioFiscal;
    }

    public void setDomicilioFiscal(DomicilioFiscal domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }

    public String getCorreoFacturas() {
        return correoFacturas;
    }

    public void setCorreoFacturas(String correoFacturas) {
        this.correoFacturas = correoFacturas;
    }

    public Date getFechaUltimaCompra() {
        return fechaUltimaCompra;
    }

    public void setFechaUltimaCompra(Date fechaUltimaCompra) {
        this.fechaUltimaCompra = fechaUltimaCompra;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
