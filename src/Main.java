import DBConnection.ConexionDB;
import DBControllers.*;

import javax.swing.*;
import java.sql.SQLException;
import java.text.ParseException;

public class Main
{

    static ConexionDB db;

    //Controladores de Base de datos
    static ProductoDBController productoDBController;
    static PrecioDBController precioDBController;
    static ClienteDBController clienteDBController;
    static SemanaDBController semanaDBController;
    static VentaDBController ventaDBController;


    //Ventana Principal
    static MenuPrincipal ventanaMenuPrincipal;


    //Ventanas relacionadas al manejo de Ventas
    static OpcionesVentas ventanaVentasOpciones;
    static ElegirVenta ventanaElegirVenta;
    static Aniadir_ModificarVenta ventanaAniadir_ModificarVenta;


    //Ventanas relacionadas al manejo de Productos
    static OpcionesProductos ventanaProductosOpciones;
    static ElegirProducto ventanaElegirProducto;
    static Aniadir_ModificarProducto ventanaAniadir_ModificarProducto;


    //Ventanas relacionadas al manejo de Clientes
    static OpcionesClientes ventanaClientesOpciones;
    static ElegirCliente ventanaElegirCliente;
    static Aniadir_ModificarCliente ventanaAniadir_ModificarCliente;

    //Ventanas relacionadas con el Manejo de Precios
    static AniadirPrecio ventanaAniadirPrecio;

    //Ventana Error
    static MensajeError ventanaError;

    //Semana actual del sistema para registrar ventas
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

        /////////////////////////////////

        ventanaMenuPrincipal = new MenuPrincipal();

        /////////////////////////////////

        ventanaVentasOpciones = new OpcionesVentas();
        ventanaElegirVenta = new ElegirVenta();
        ventanaAniadir_ModificarVenta = new Aniadir_ModificarVenta();

        /////////////////////////////////

        ventanaProductosOpciones = new OpcionesProductos();
        ventanaElegirProducto = new ElegirProducto();
        ventanaAniadir_ModificarProducto = new Aniadir_ModificarProducto();

        /////////////////////////////////

        ventanaClientesOpciones = new OpcionesClientes();
        ventanaElegirCliente = new ElegirCliente();
        ventanaAniadir_ModificarCliente = new Aniadir_ModificarCliente();

        /////////////////////////////////

        ventanaAniadirPrecio = new AniadirPrecio();

        /////////////////////////////////

        ventanaError = new MensajeError();

        /////////////////////////////////
        /////////////////////////////////
        /////////////////////////////////

        semanaDBController.comprobarSemanas();
        semanaActual = semanaDBController.determinarSemanaActual();

        /////////////////////////////////

        ventanaMenuPrincipal.initMenuPrincipal();

        /////////////////////////////////

        ventanaVentasOpciones.initVentasOpciones();
        ventanaElegirVenta.initElegirVenta();
        ventanaAniadir_ModificarVenta.initAniadir_ModificarVenta();

        /////////////////////////////////

        ventanaProductosOpciones.initProductosOpciones();
        ventanaElegirProducto.initElegirProducto();
        ventanaAniadir_ModificarProducto.initAniadir_ModificarProducto();

        /////////////////////////////////

        ventanaClientesOpciones.initClientesOpciones();
        ventanaElegirCliente.initElegirCliente();
        ventanaAniadir_ModificarCliente.initAniadir_ModificarCliente();

        /////////////////////////////////

        ventanaAniadirPrecio.initAniadirPrecio();

        /////////////////////////////////

        ventanaError.initMensajeError();
    }
}