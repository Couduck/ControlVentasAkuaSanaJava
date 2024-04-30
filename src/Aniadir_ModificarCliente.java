import Models.Cliente;
import Models.Contacto;
import Models.Domicilio;
import Models.DomicilioFiscal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Aniadir_ModificarCliente extends JFrame {
    private JButton goBackButton;
    private JPanel cuerpoPanel;
    private JTextField nombreClaveCampoCliente;
    private JComboBox tipoFacturaCampoCliente;
    private JComboBox momentoEmisionFacturaCampoCliente;
    private JComboBox formaPagoCampoCliente;
    private JButton crearCliente;
    private JTextField correoFacturaCampoCliente;
    private JTextField observacionesCampoCliente;
    private JPanel apartadoNombreClave;
    private JPanel apartadoStatus;
    private JComboBox statusCampoCliente;
    private JComboBox capaPrecioCampoCliente;

    private boolean editarClienteExistente;

    public int claveItemElegido = 0;

    public void initAniadir_ModificarCliente() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {

        statusCampoCliente.addItem("V");
        statusCampoCliente.addItem("C");
        statusCampoCliente.addItem("NI");
        statusCampoCliente.addItem("EP");

        tipoFacturaCampoCliente.addItem("FACT");
        tipoFacturaCampoCliente.addItem("GENE");

        momentoEmisionFacturaCampoCliente.addItem("ALPA");
        momentoEmisionFacturaCampoCliente.addItem("VACIO");

        formaPagoCampoCliente.addItem("TRAN");
        formaPagoCampoCliente.addItem("EFEC");

        this.setContentPane(this.cuerpoPanel);
        this.setSize(500, 250);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        crearCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Date currentTime = new Date();
                java.sql.Date fechaAltaProducto = new java.sql.Date(currentTime.getTime());

                String claveNombreCliente = nombreClaveCampoCliente.getText();
                String statusCliente = editarClienteExistente ? (String) statusCampoCliente.getSelectedItem() : "V";
                String capaPrecioCliente = (String) capaPrecioCampoCliente.getSelectedItem();
                String tipoFacturaCliente = (String) tipoFacturaCampoCliente.getSelectedItem();
                String momentoEmisionFacturaCliente = (String) momentoEmisionFacturaCampoCliente.getSelectedItem();
                String formaPagoCliente = (String) formaPagoCampoCliente.getSelectedItem();
                String correoFacturasCliente = correoFacturaCampoCliente.getText();
                String observacionesCliente = observacionesCampoCliente.getText();

                Cliente nuevoCliente = new Cliente(
                        claveNombreCliente,
                        statusCliente,
                        tipoFacturaCliente,
                        null,
                        momentoEmisionFacturaCliente,
                        formaPagoCliente,
                        capaPrecioCliente,
                        fechaAltaProducto,
                        fechaAltaProducto,
                        correoFacturasCliente,
                        null,
                        observacionesCliente,
                        null,
                        null);

                //TODO: MANEJO DE DOMICILIO, DOMICILIO FISCAL Y CONTACTO
                nuevoCliente.setDomicilio(new Domicilio());
                nuevoCliente.setDomicilioFiscal(new DomicilioFiscal());
                nuevoCliente.setContacto(new Contacto());

                try
                {

                    if(!editarClienteExistente)
                    {
                        Main.clienteDBController.createCliente(nuevoCliente);
                    }

                    else
                    {
                        nuevoCliente.setClave(claveItemElegido);
                        Main.clienteDBController.actualizarCliente(nuevoCliente);
                    }

                    Main.ventanaAniadir_ModificarCliente.setVisible(false);
                    Main.ventanaClientesOpciones.setVisible(true);
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
                Main.ventanaClientesOpciones.setVisible(true);
                Main.ventanaAniadir_ModificarCliente.setVisible(false);
            }
        });

    }

    public void cambiarDisposicionInsertar_Editar(boolean editar, Cliente cliente)
    {
        if(!editar)
        {
            this.setTitle("Añadir Cliente Nuevo");

            apartadoStatus.setVisible(false);
            nombreClaveCampoCliente.setEnabled(true);

            vaciarCampos();
        }

        else
        {
            this.setTitle("Modificar Cliente");

            apartadoStatus.setVisible(true);
            nombreClaveCampoCliente.setEnabled(false);

            nombreClaveCampoCliente.setText(cliente.getNombreClave());
            tipoFacturaCampoCliente.setSelectedItem(cliente.getTipoFactura());
            statusCampoCliente.setSelectedItem(cliente.getStatus());
            momentoEmisionFacturaCampoCliente.setSelectedItem(cliente.getMomentoEmisionFactura());
            formaPagoCampoCliente.setSelectedItem(cliente.getFormaPago());
            correoFacturaCampoCliente.setText(cliente.getCorreoFacturas());
            observacionesCampoCliente.setText(cliente.getObservaciones());
        }

        editarClienteExistente = editar;
    }

    public void cargarTiposPrecios() throws SQLException
    {
        capaPrecioCampoCliente.removeAllItems();
        ResultSet resultadosQuery = Main.precioDBController.recuperarTodosPrecios();

        while(resultadosQuery.next())
        {
            String claveActual = resultadosQuery.getString("prc_clave");
            capaPrecioCampoCliente.addItem(claveActual);
        }

    }

    public void vaciarCampos()
    {
        nombreClaveCampoCliente.setText("");
        correoFacturaCampoCliente.setText("");
        observacionesCampoCliente.setText("");
    }
}
