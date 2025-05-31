import Models.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class Aniadir_ModificarProducto extends JFrame {
    private JTextField claveProductoCampo;
    private JTextField nombreCampoProducto;
    private JTextField nombreBICampoProducto;
    private JButton goBackButton;
    private JButton crearProducto;
    private JPanel cuerpoPanel;
    private JSpinner litrosProductoCampo;
    private JComboBox statusProductoCampo;
    private JButton guardarCambios;

    private boolean editarProductoExistente;

    public void initAniadir_ModificarProducto() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //VentasOpciones ventana = new VentasOpciones();
        statusProductoCampo.addItem("V");
        statusProductoCampo.addItem("D");

        this.setContentPane(this.cuerpoPanel);

        this.setSize(500,350);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        crearProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if(!validarCampos())
                    {
                        Main.ventanaError.setVisible(true);
                        return;
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                Date currentTime = new Date();

                String claveProducto = claveProductoCampo.getText();
                String nombreProducto = nombreCampoProducto.getText();
                String statusProducto = editarProductoExistente ? (String) statusProductoCampo.getSelectedItem() : "V";
                java.sql.Date fechaAltaProducto = new java.sql.Date(currentTime.getTime());
                Integer litrosProducto = (Integer) litrosProductoCampo.getValue();
                String nombreBIProducto = nombreBICampoProducto.getText();

                Producto productoNuevo = new Producto(
                        claveProducto,
                        nombreProducto,
                        statusProducto,
                        fechaAltaProducto,
                        litrosProducto,
                        nombreBIProducto);

                try
                {
                    if(!editarProductoExistente)
                    {
                        Main.productoDBController.createProducto(productoNuevo);
                        Main.ventanaAniadir_ModificarProducto.setVisible(false);
                        Main.ventanaProductosOpciones.setVisible(true);
                    }

                    else
                    {
                        Main.productoDBController.actualizarProducto(productoNuevo);
                        Main.ventanaAniadir_ModificarProducto.setVisible(false);
                        Main.ventanaProductosOpciones.setVisible(true);
                    }
                }

                catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }

            }
        });
        
        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaProductosOpciones.setVisible(true);
                Main.ventanaAniadir_ModificarProducto.setVisible(false);
            }
        });
    }

    public void cambiarDisposicionInsertar_Editar(boolean editar, Producto producto)
    {
        if(!editar)
        {
            this.setTitle("AÑADIR PRODUCTO");

            /*apartadoClave.setVisible(true);
            apartadoStatus.setVisible(false);*/

            claveProductoCampo.setEnabled(true);
            statusProductoCampo.setEnabled(false);
            statusProductoCampo.setSelectedItem("V");

            vaciarCampos();
        }

        else
        {
            this.setTitle("MODIFICAR PRODUCTO");

            claveProductoCampo.setEnabled(false);
            claveProductoCampo.setText(producto.getClave());

            nombreCampoProducto.setText(producto.getNombre());

            statusProductoCampo.setEnabled(true);
            statusProductoCampo.setSelectedItem(producto.getStatus());

            litrosProductoCampo.setValue(producto.getLitros());

            nombreBICampoProducto.setText(producto.getNombreBI());
        }

        editarProductoExistente = editar;
    }

    public void vaciarCampos()
    {
        claveProductoCampo.setText("");
        nombreCampoProducto.setText("");
        litrosProductoCampo.setValue(0);
        nombreBICampoProducto.setText("");
    }

    public boolean validarCampos() throws SQLException {
        boolean sinErrores = true;
        ArrayList<String> listaErrores = new ArrayList<String>();

        if(claveProductoCampo.getText().isBlank())
        {
            listaErrores.add("• No se ha ingresado ninguna clave para identificar el Producto<br>");
            sinErrores = false;
        }

        if(Main.productoDBController.productoExiste(claveProductoCampo.getText()) && !editarProductoExistente)
        {
            listaErrores.add("• Clave proporcionada ya existente dentro de la Lista de Productos<br>");
            sinErrores = false;
        }

        if((int) litrosProductoCampo.getValue() < 1)
        {
            listaErrores.add("• Los litros mínimos del producto deen ser mayor a 0<br>");
            sinErrores = false;
        }

        if(nombreCampoProducto.getText().isBlank())
        {
            listaErrores.add("• No se ha ingresado ningún nombre para el Producto<br>");
            sinErrores = false;
        }

        if(nombreBICampoProducto.getText().isBlank())
        {
            listaErrores.add("• No se ha ingresado ningún nombre para el Producto para su uso en BI");
            sinErrores = false;
        }

        if(!sinErrores)
        {
            String listaErroresCompletaSTR = "";

            for (int i = 0; i < listaErrores.size(); i++)
            {
                listaErroresCompletaSTR += listaErrores.get(i);
            }

            Main.ventanaError.cambiarErrorTexto(listaErroresCompletaSTR);
        }

        return sinErrores;
    }
}
