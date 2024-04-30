package DBControllers;

import DBConnection.ConexionDB;
import Models.Venta;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class VentaDBController {

    ConexionDB db;

    public VentaDBController(ConexionDB db) {
        this.db = db;
    }

    public void generarVenta(Venta ventaNueva) throws SQLException, ParseException {
        String instruccionSTR = "insert into ventas (vnts_renglon, vnts_status, vnts_fecha_venta," +
                "vnts_hora_registro, vnts_numsem, vnts_status_pago, " +
                "vnts_fecha_pago, vnts_importe_pago, vnts_saldo, " +
                "vnts_cli_nom_corto, vnts_forma_factura, vnts_num_factura, " +
                "vnts_fecha_factura, vnts_mes_factura, vnts_capa_cliente, " +
                "vnts_clave_cliente, vnts_clave_producto, vnts_capa_producto, " +
                "vnts_precio_unitario, vnts_precio_sin_iva, vnts_cantidad, " +
                "vnts_porcentaje_iva, vnts_total_sin_iva, vnts_importe_iva, " +
                "vnts_total) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement instruccionConValores = this.db.getConexion().prepareCall(instruccionSTR);
        SimpleDateFormat formatoHoras = new SimpleDateFormat("HH:mm:ss");

        Calendar c = new GregorianCalendar();
        c.setTime(ventaNueva.getFecha());

        instruccionConValores.setInt(1,ventaNueva.getRenglon());
        instruccionConValores.setString(2,ventaNueva.getStatus());
        instruccionConValores.setDate(3,new java.sql.Date(ventaNueva.getFecha().getTime()));
        instruccionConValores.setTime(4,new Time(formatoHoras.parse(Calendar.HOUR_OF_DAY + ":" + Calendar.MINUTE + ":" + Calendar.SECOND).getTime()));
        instruccionConValores.setString(5,ventaNueva.getNumSemana());
        instruccionConValores.setString(6,ventaNueva.getStatusPago());
        instruccionConValores.setDate(7,ventaNueva.getFechaPago() != null ? new java.sql.Date(ventaNueva.getFechaPago().getTime()) : null);
        instruccionConValores.setBigDecimal(8,ventaNueva.getImportePago());
        instruccionConValores.setBigDecimal(9,ventaNueva.getSaldo());
        instruccionConValores.setString(10,ventaNueva.getNombreClienteCorto());
        instruccionConValores.setString(11,ventaNueva.getFormaFactura());
        instruccionConValores.setString(12,ventaNueva.getNumeroFactura());
        instruccionConValores.setDate(13,ventaNueva.getFechaFactura() != null ? new java.sql.Date(ventaNueva.getFechaFactura().getTime()) : null);
        instruccionConValores.setString(14,ventaNueva.getMesFactura());
        instruccionConValores.setString(15,ventaNueva.getCapaCliente());
        instruccionConValores.setString(16,ventaNueva.getClaveCliente());
        instruccionConValores.setString(17,ventaNueva.getClaveProducto());
        instruccionConValores.setString(18,ventaNueva.getCapaProducto());
        instruccionConValores.setBigDecimal(19,ventaNueva.getPrecioUnitario());
        instruccionConValores.setDouble(20,ventaNueva.getPrecioSinIva());
        instruccionConValores.setInt(21,ventaNueva.getCantidad());
        instruccionConValores.setBigDecimal(22,ventaNueva.getPorcentajeIva());
        instruccionConValores.setBigDecimal(23,ventaNueva.getTotalSinIva());
        instruccionConValores.setBigDecimal(24,ventaNueva.getImporteIva());
        instruccionConValores.setBigDecimal(25,ventaNueva.getTotal());

        instruccionConValores.execute();
    }
}
