package Models;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;

public class Venta
{
    int folio;
    int renglon;
    String status;
    Date fecha;
    Time hora;
    String numSemana;
    String statusPago;
    Date fechaPago;
    BigDecimal importePago;
    BigDecimal saldo;
    String nombreClienteCorto;
    String formaFactura;
    String numeroFactura;
    Date fechaFactura;
    String mesFactura;
    String capaCliente;
    String claveCliente;
    String claveProducto;
    String capaProducto;
    BigDecimal precioUnitario;
    double precioSinIva;
    int cantidad;
    BigDecimal porcentajeIva;
    BigDecimal totalSinIva;
    BigDecimal importeIva;
    BigDecimal total;

    public Venta(int renglon, String status, Date fecha, Time hora, String numSemana, String statusPago, Date fechaPago, BigDecimal importePago, BigDecimal saldo, String nombreClienteCorto, String formaFactura, String numeroFactura, Date fechaFactura, String mesFactura, String capaCliente, String claveCliente, String claveProducto, String capaProducto, BigDecimal precioUnitario, double precioSinIva, int cantidad, BigDecimal porcentajeIva, BigDecimal totalSinIva, BigDecimal importeIva, BigDecimal total) {
        this.renglon = renglon;
        this.status = status;
        this.fecha = fecha;
        this.hora = hora;
        this.numSemana = numSemana;
        this.statusPago = statusPago;
        this.fechaPago = fechaPago;
        this.importePago = importePago;
        this.saldo = saldo;
        this.nombreClienteCorto = nombreClienteCorto;
        this.formaFactura = formaFactura;
        this.numeroFactura = numeroFactura;
        this.fechaFactura = fechaFactura;
        this.mesFactura = mesFactura;
        this.capaCliente = capaCliente;
        this.claveCliente = claveCliente;
        this.claveProducto = claveProducto;
        this.capaProducto = capaProducto;
        this.precioUnitario = precioUnitario;
        this.precioSinIva = precioSinIva;
        this.cantidad = cantidad;
        this.porcentajeIva = porcentajeIva;
        this.totalSinIva = totalSinIva;
        this.importeIva = importeIva;
        this.total = total;
    }

    public Venta(int folio, int renglon, String status, Date fecha, Time hora, String numSemana, String statusPago, Date fechaPago, BigDecimal importePago, BigDecimal saldo, String nombreClienteCorto, String formaFactura, String numeroFactura, Date fechaFactura, String mesFactura, String capaCliente, String claveCliente, String claveProducto, String capaProducto, BigDecimal precioUnitario, double precioSinIva, int cantidad, BigDecimal porcentajeIva, BigDecimal totalSinIva, BigDecimal importeIva, BigDecimal total) {
        this.folio = folio;
        this.renglon = renglon;
        this.status = status;
        this.fecha = fecha;
        this.hora = hora;
        this.numSemana = numSemana;
        this.statusPago = statusPago;
        this.fechaPago = fechaPago;
        this.importePago = importePago;
        this.saldo = saldo;
        this.nombreClienteCorto = nombreClienteCorto;
        this.formaFactura = formaFactura;
        this.numeroFactura = numeroFactura;
        this.fechaFactura = fechaFactura;
        this.mesFactura = mesFactura;
        this.capaCliente = capaCliente;
        this.claveCliente = claveCliente;
        this.claveProducto = claveProducto;
        this.capaProducto = capaProducto;
        this.precioUnitario = precioUnitario;
        this.precioSinIva = precioSinIva;
        this.cantidad = cantidad;
        this.porcentajeIva = porcentajeIva;
        this.totalSinIva = totalSinIva;
        this.importeIva = importeIva;
        this.total = total;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getRenglon() {
        return renglon;
    }

    public void setRenglon(int renglon) {
        this.renglon = renglon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getNumSemana() {
        return numSemana;
    }

    public void setNumSemana(String numSemana) {
        this.numSemana = numSemana;
    }

    public String getStatusPago() {
        return statusPago;
    }

    public void setStatusPago(String statusPago) {
        this.statusPago = statusPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public BigDecimal getImportePago() {
        return importePago;
    }

    public void setImportePago(BigDecimal importePago) {
        this.importePago = importePago;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public String getNombreClienteCorto() {
        return nombreClienteCorto;
    }

    public void setNombreClienteCorto(String nombreClienteCorto) {
        this.nombreClienteCorto = nombreClienteCorto;
    }

    public String getFormaFactura() {
        return formaFactura;
    }

    public void setFormaFactura(String formaFactura) {
        this.formaFactura = formaFactura;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public String getMesFactura() {
        return mesFactura;
    }

    public void setMesFactura(String mesFactura) {
        this.mesFactura = mesFactura;
    }

    public String getCapaCliente() {
        return capaCliente;
    }

    public void setCapaCliente(String capaCliente) {
        this.capaCliente = capaCliente;
    }

    public String getClaveCliente() {
        return claveCliente;
    }

    public void setClaveCliente(String claveCliente) {
        this.claveCliente = claveCliente;
    }

    public String getClaveProducto() {
        return claveProducto;
    }

    public void setClaveProducto(String claveProducto) {
        this.claveProducto = claveProducto;
    }

    public String getCapaProducto() {
        return capaProducto;
    }

    public void setCapaProducto(String capaProducto) {
        this.capaProducto = capaProducto;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public double getPrecioSinIva() {
        return precioSinIva;
    }

    public void setPrecioSinIva(double precioSinIva) {
        this.precioSinIva = precioSinIva;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPorcentajeIva() {
        return porcentajeIva;
    }

    public void setPorcentajeIva(BigDecimal porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public BigDecimal getTotalSinIva() {
        return totalSinIva;
    }

    public void setTotalSinIva(BigDecimal totalSinIva) {
        this.totalSinIva = totalSinIva;
    }

    public BigDecimal getImporteIva() {
        return importeIva;
    }

    public void setImporteIva(BigDecimal importeIva) {
        this.importeIva = importeIva;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
