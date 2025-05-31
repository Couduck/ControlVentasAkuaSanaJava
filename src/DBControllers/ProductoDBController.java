package DBControllers;

import DBConnection.ConexionDB;
import Models.Producto;
import java.sql.*;

public class ProductoDBController
{
    private ConexionDB db;

    public ProductoDBController(ConexionDB conexion)
    {
        this.db = conexion;
    }

    public void createProducto(Producto productoNuevo) throws SQLException {
        String instruccionSTR = "insert into productos (prds_clave, prds_nombre, prds_status, prds_fecha_cambio, prds_litros, prds_nombre_BI) values (?, ?, ?,  ?, ?, ?)";
        PreparedStatement instruccionConValores = this.db.getConexion().prepareCall(instruccionSTR);

        instruccionConValores.setString(1,productoNuevo.getClave());
        instruccionConValores.setString(2,productoNuevo.getNombre());
        instruccionConValores.setString(3,productoNuevo.getStatus());
        instruccionConValores.setDate(4, (Date) productoNuevo.getFechaAlta());
        instruccionConValores.setInt(5,productoNuevo.getLitros());
        instruccionConValores.setString(6,productoNuevo.getNombreBI());

        instruccionConValores.execute();
    }

    public ResultSet recuperarTodosProductos() throws SQLException {
        String instruccionSTR = "select * from productos";
        Statement  instruccion = this.db.getConexion().createStatement();
        ResultSet resultados = instruccion.executeQuery(instruccionSTR);

        return resultados;
    }

    public ResultSet recuperarTodosProductosVigentes() throws SQLException
    {
        String instruccionSTR = "select * from productos where prds_status = \"V\"";
        Statement  instruccion = this.db.getConexion().createStatement();
        ResultSet resultados = instruccion.executeQuery(instruccionSTR);

        return resultados;
    }

    public void actualizarProducto(Producto productoEditar) throws SQLException {
        String instruccionSTR = "update productos set prds_nombre = ?, prds_status = ?, prds_fecha_cambio = ?, prds_litros = ?, prds_nombre_BI = ? where prds_clave = ?";
        PreparedStatement instruccionConValores = this.db.getConexion().prepareCall(instruccionSTR);

        instruccionConValores.setString(1,productoEditar.getNombre());
        instruccionConValores.setString(2,productoEditar.getStatus());
        instruccionConValores.setDate(3, (Date) productoEditar.getFechaAlta());
        instruccionConValores.setInt(4,productoEditar.getLitros());
        instruccionConValores.setString(5,productoEditar.getNombreBI());
        instruccionConValores.setString(6,productoEditar.getClave());

        instruccionConValores.execute();
    }

    public boolean productoExiste(String claveProducto) throws SQLException {
        String instruccionSTR = "select * from productos where prds_clave = \""+ claveProducto +"\"";
        Statement  instruccion = this.db.getConexion().createStatement();
        ResultSet resultados = instruccion.executeQuery(instruccionSTR);

        boolean productoYaExiste = false;

        if(resultados.next())
        {
            productoYaExiste = true;
        }

        return productoYaExiste;
    }
}
