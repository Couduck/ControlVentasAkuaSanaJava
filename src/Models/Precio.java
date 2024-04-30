package Models;

import java.math.BigDecimal;

public class Precio
{
    private String clave;

    private BigDecimal precioSinIva;

    private BigDecimal porcentajeIva;

    private BigDecimal importeIva;

    private BigDecimal precioTotalUnidad;

    public Precio(String clave, BigDecimal precioSinIva, BigDecimal porcentajeIva, BigDecimal importeIva, BigDecimal precioTotalUnidad) {
        this.clave = clave;
        this.precioSinIva = precioSinIva;
        this.porcentajeIva = porcentajeIva;
        this.importeIva = importeIva;
        this.precioTotalUnidad = precioTotalUnidad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public BigDecimal getPrecioSinIva() {
        return precioSinIva;
    }

    public void setPrecioSinIva(BigDecimal precioSinIva) {
        this.precioSinIva = precioSinIva;
    }

    public BigDecimal getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(BigDecimal porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public BigDecimal getImporteIva() {
        return importeIva;
    }

    public void setImporteIva(BigDecimal importeIva) {
        this.importeIva = importeIva;
    }

    public BigDecimal getPrecioTotalUnidad() {
        return precioTotalUnidad;
    }

    public void setPrecioTotalUnidad(BigDecimal precioTotalUnidad) {
        this.precioTotalUnidad = precioTotalUnidad;
    }
}
