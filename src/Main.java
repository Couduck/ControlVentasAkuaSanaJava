import DBConnection.ConexionDB;
import DBControllers.*;
import Models.Venta;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;

public class Main
{

    static ConexionDB db;

    static ProductoDBController productoDBController;
    static PrecioDBController precioDBController;

    static ClienteDBController clienteDBController;

    static SemanaDBController semanaDBController;

    static VentaDBController ventaDBController;


    static MenuPrincipal ventanaMenuPrincipal;

    static OpcionesVentas ventanaVentasOpciones;
    static OpcionesProductos ventanaProductosOpciones;

    static OpcionesClientes ventanaClientesOpciones;

    static AniadirPrecio ventanaAniadirPrecio;

    static Aniadir_ModificarProducto ventanaAniadir_ModificarProducto;
    static Aniadir_ModificarCliente ventanaAniadir_ModificarCliente;

    static Aniadir_ModificarVenta ventanaAniadir_ModificarVenta;
    static ElegirProducto ventanaElegirProducto;
    static ElegirCliente ventanaElegirCliente;

    static MensajeError ventanaError;

    static String semanaActual;

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, ParseException {

        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        /////////////////////////////////
        db = new ConexionDB();

        productoDBController = new ProductoDBController(db);
        precioDBController = new PrecioDBController(db);
        clienteDBController = new ClienteDBController(db);
        semanaDBController = new SemanaDBController(db);
        ventaDBController = new VentaDBController(db);

        ventanaVentasOpciones = new OpcionesVentas();

        ventanaMenuPrincipal = new MenuPrincipal();
        ventanaProductosOpciones = new OpcionesProductos();
        ventanaClientesOpciones = new OpcionesClientes();

        ventanaAniadir_ModificarProducto = new Aniadir_ModificarProducto();

        ventanaAniadirPrecio = new AniadirPrecio();
        ventanaElegirProducto = new ElegirProducto();
        ventanaElegirCliente = new ElegirCliente();

        ventanaAniadir_ModificarCliente = new Aniadir_ModificarCliente();

        ventanaAniadir_ModificarVenta = new Aniadir_ModificarVenta();

        ventanaError = new MensajeError();

        /////////////////////////////////

        semanaDBController.comprobarSemanas();
        semanaActual = semanaDBController.determinarSemanaActual();


        ventanaMenuPrincipal.initMenuPrincipal();

        ventanaVentasOpciones.initVentasOpciones();
        ventanaProductosOpciones.initProductosOpciones();
        ventanaClientesOpciones.initClientesOpciones();

        ventanaAniadir_ModificarProducto.initAniadir_ModificarProducto();
        ventanaAniadirPrecio.initAniadirPrecio();
        ventanaElegirProducto.initElegirProducto();
        ventanaAniadir_ModificarCliente.initAniadir_ModificarCliente();
        ventanaElegirCliente.initElegirCliente();
        ventanaAniadir_ModificarVenta.initAniadir_ModificarVenta();

        ventanaError.initMensajeError();


    }
}