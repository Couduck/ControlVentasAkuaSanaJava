import Models.Cliente;
import Models.Venta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Aniadir_ModificarVenta extends JFrame{
    private JPanel cuerpoPanel;
    private JComboBox clienteVentaCampo;
    private JComboBox statusVentaCampo;
    private JTextField capaClienteCampo;
    private JComboBox capaVentaCampo;
    private JComboBox productoVentaCampo;
    private JSpinner cantidadVentaCampo;
    private JButton goBackButton;
    private JButton guardarVenta;
    private JPanel apartadoStatusVenta;
    private JComboBox statusPagoCampo;

    private String formaFacturaclienteElegido;
    private String claveClienteElegido;

    public Aniadir_ModificarVenta() {

    }

    public void initAniadir_ModificarVenta() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //VentasOpciones ventana = new VentasOpciones();
        statusVentaCampo.addItem("V");
        statusVentaCampo.addItem("C");

        statusPagoCampo.addItem("PA");
        statusPagoCampo.addItem("PE");
        apartadoStatusVenta.setVisible(false);
        capaClienteCampo.setEnabled(false);

        this.setContentPane(this.cuerpoPanel);
        this.setTitle("Generar Venta");
        this.setSize(500, 250);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaVentasOpciones.setVisible(true);
                Main.ventanaAniadir_ModificarVenta.setVisible(false);
            }
        });

        guardarVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nombreCliente = (String) clienteVentaCampo.getSelectedItem();
                String statusVenta = "V";
                String producto = (String) productoVentaCampo.getSelectedItem();
                int cantidad = (int) cantidadVentaCampo.getValue();
                String statusPago = (String) statusPagoCampo.getSelectedItem();
                String capaCliente = capaClienteCampo.getText();
                String capaVenta = (String) capaVentaCampo.getSelectedItem();

                try {
                    ResultSet capaPrecioItem = Main.precioDBController.recuperarPrecioEspecifico(capaVenta);
                    capaPrecioItem.next();

                    BigDecimal precioSinIVA = capaPrecioItem.getBigDecimal("prc_precio_sin_iva");
                    BigDecimal porcentajeIVA = capaPrecioItem.getBigDecimal("prc_porcentaje_iva");
                    BigDecimal importeIVA = capaPrecioItem.getBigDecimal("prc_importe_iva");
                    BigDecimal totalUnidad = capaPrecioItem.getBigDecimal("prc_precio_total_unidad");

                    BigDecimal importe = totalUnidad.multiply(new BigDecimal(cantidad));
                    LocalDate ld = LocalDate.now();

                    Venta nuevaVenta = new Venta(
                            1,
                            statusVenta,
                            new Date(),
                            new Time(new Date().getTime()),
                            Main.semanaActual,
                            statusPago,
                            statusPago == "PA" ? new Date() : null,
                            statusPago == "PA" ? importe : BigDecimal.ZERO,
                            BigDecimal.ZERO,
                            nombreCliente,
                            formaFacturaclienteElegido,
                            "",
                            null,
                            statusPago == "PA" ? String.valueOf(ld.getMonthValue()) : null,
                            capaCliente,
                            claveClienteElegido,
                            producto,
                            capaVenta,
                            totalUnidad,
                            precioSinIVA.doubleValue(),
                            cantidad,
                            porcentajeIVA,
                            precioSinIVA.multiply(new BigDecimal(cantidad)),
                            importeIVA.multiply(new BigDecimal(cantidad)),
                            totalUnidad.multiply(new BigDecimal(cantidad))
                    );

                    Main.ventaDBController.generarVenta(nuevaVenta);

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

                Main.ventanaVentasOpciones.setVisible(true);
                Main.ventanaAniadir_ModificarVenta.setVisible(false);
            }
        });

        clienteVentaCampo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    if(clienteVentaCampo.getSelectedItem() != null)
                    {
                        ResultSet cliente = Main.clienteDBController.recuperarClienteEspecifico( (String) clienteVentaCampo.getSelectedItem());
                        cliente.next();
                        capaClienteCampo.setText(cliente.getString("clnts_clave_precio"));
                        capaVentaCampo.setSelectedItem(cliente.getString("clnts_clave_precio"));
                        formaFacturaclienteElegido = cliente.getString("clnts_tipo_factura");
                        claveClienteElegido = cliente.getString("clnts_clave");
                    }

                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void cargarClientes() throws SQLException
    {
        clienteVentaCampo.removeAllItems();
        ResultSet resultadosQuery = Main.clienteDBController.recuperarTodosClientes();

        while(resultadosQuery.next())
        {
            String claveActual = resultadosQuery.getString("clnts_nombre_corto");
            clienteVentaCampo.addItem(claveActual);
        }

    }

    public void cargarTiposProductos() throws SQLException
    {
        productoVentaCampo.removeAllItems();
        ResultSet resultadosQuery = Main.productoDBController.recuperarTodosProductosVigentes();

        while(resultadosQuery.next())
        {
            String claveActual = resultadosQuery.getString("prds_clave");
            productoVentaCampo.addItem(claveActual);
        }

    }

    public void cargarTiposPrecios() throws SQLException
    {
        capaVentaCampo.removeAllItems();
        ResultSet resultadosQuery = Main.precioDBController.recuperarTodosPrecios();

        while(resultadosQuery.next())
        {
            String claveActual = resultadosQuery.getString("prc_clave");
            capaVentaCampo.addItem(claveActual);
        }

    }

}
