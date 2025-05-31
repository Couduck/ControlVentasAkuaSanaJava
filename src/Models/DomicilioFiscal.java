package Models;

public class DomicilioFiscal
{
    protected String calle;
    String numeroExterior;
    String numeroInterior;
    String colonia;
    String municipio;
    String estado;
    String codigoPostal;

    public DomicilioFiscal() {
        this.calle = null;
        this.numeroExterior = null;
        this.numeroInterior = null;
        this.colonia = null;
        this.municipio = null;
        this.estado = null;
        this.codigoPostal = null;
    }

    public DomicilioFiscal(String calle, String numeroExterior, String numeroInterior, String colonia, String municipio, String estado, String codigoPostal) {
        this.calle = calle;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.colonia = colonia;
        this.municipio = municipio;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
