import Models.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Aniadir_ModificarProducto extends JFrame {
    private JTextField claveProductoCampo;
    private JTextField nombreCampoProducto;
    private JTextField nombreBICampoProducto;
    private JButton goBackButton;
    private JButton crearProducto;
    private JPanel cuerpoPanel;
    private JSpinner litrosProductoCampo;
    private JPanel apartadoStatus;
    private JPanel apartadoClave;
    private JComboBox statusProductoCampo;
    private JButton guardarCambios;

    private boolean editarProductoExistente;

    public void initAniadir_ModificarProducto() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //VentasOpciones ventana = new VentasOpciones();
        statusProductoCampo.addItem("V");
        statusProductoCampo.addItem("D");

        this.setContentPane(this.cuerpoPanel);

        this.setSize(500,250);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        crearProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
            this.setTitle("Añadir Producto Nuevo");

            apartadoClave.setVisible(true);
            apartadoStatus.setVisible(false);

            vaciarCampos();
        }

        else
        {
            this.setTitle("Modificar Producto");

            apartadoClave.setVisible(false);
            claveProductoCampo.setText(producto.getClave());

            nombreCampoProducto.setText(producto.getNombre());

            apartadoStatus.setVisible(true);
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
}
