package DBConnection;

import java.sql.*;

public class ConexionDB {

    Connection conexion;

    public ConexionDB()
    {
        this.conexion = null;

        try
        {
            this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/akuasanaventas", "root", "");
            Statement statement = conexion.createStatement();
            ResultSet resultado = statement.executeQuery("select * from precios");
        }

        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

    }

    public Connection getConexion()
    {
        return this.conexion;
    }
}
