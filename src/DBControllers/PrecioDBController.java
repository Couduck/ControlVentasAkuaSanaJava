package DBControllers;

import DBConnection.ConexionDB;
import Models.Precio;

import java.sql.*;

public class PrecioDBController {

    private ConexionDB db;

    public PrecioDBController(ConexionDB conexion)
    {
        this.db = conexion;
    }

    public void createPrecio(Precio precioNuevo) throws SQLException {
        String instruccionSTR = "insert into precios (prc_clave, prc_precio_sin_iva, prc_porcentaje_iva, prc_importe_iva, prc_precio_total_unidad) values (?, ?, ?, ?, ?)";
        PreparedStatement instruccionConValores = this.db.getConexion().prepareCall(instruccionSTR);

        instruccionConValores.setString(1,precioNuevo.getClave());
        instruccionConValores.setBigDecimal(2,precioNuevo.getPrecioSinIva());
        instruccionConValores.setBigDecimal(3,precioNuevo.getPorcentajeIva());
        instruccionConValores.setBigDecimal(4,precioNuevo.getImporteIva());
        instruccionConValores.setBigDecimal(5,precioNuevo.getPrecioTotalUnidad());

        instruccionConValores.execute();
    }

    public ResultSet recuperarTodosPrecios() throws SQLException {
        String instruccionSTR = "select * from precios";
        Statement instruccion = this.db.getConexion().createStatement();
        ResultSet resultados = instruccion.executeQuery(instruccionSTR);

        return resultados;
    }

    public ResultSet recuperarPrecioEspecifico(String claveCapa) throws SQLException {
        String instruccionSTR = "select * from precios where prc_clave = \"" + claveCapa + "\"";
        Statement instruccion = this.db.getConexion().createStatement();
        ResultSet resultados = instruccion.executeQuery(instruccionSTR);

        return resultados;
    }
}
