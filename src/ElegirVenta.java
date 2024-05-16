import DBControllers.VentaDBController;
import Models.Venta;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElegirVenta extends JFrame {
    private JButton goBackButton;
    private JButton editarVenta;
    private JTextField numeroFolioCampo;
    private JPanel cuerpoPanel;

    public ElegirVenta() {

    }

    public void initElegirVenta() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //VentasOpciones ventana = new VentasOpciones();
        this.setContentPane(this.cuerpoPanel);
        this.setTitle("ELEGIR VENTA");
        this.setSize(500, 350);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        editarVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Pattern pattern = Pattern.compile("^[0-9]+$", Pattern.CASE_INSENSITIVE);
                    Matcher matcher = pattern.matcher(numeroFolioCampo.getText());
                    boolean valido = matcher.find();

                    if(valido)
                    {
                        int numeroFolio = Integer.parseInt(numeroFolioCampo.getText());
                        ResultSet ventaRecuperada = Main.ventaDBController.recuperarVentaEspecifico(numeroFolio);

                        /*int rowCount = 0;
                        while (ventaRecuperada.next()) {
                            rowCount++;
                        }*/

                        if(ventaRecuperada.next())
                        {
                            Venta ventaModificar = new Venta(
                                    ventaRecuperada.getInt("vnts_folio"),
                                    ventaRecuperada.getInt("vnts_renglon"),
                                    ventaRecuperada.getString("vnts_status"),
                                    ventaRecuperada.getDate("vnts_fecha_venta"),
                                    ventaRecuperada.getTime("vnts_hora_registro"),
                                    ventaRecuperada.getString("vnts_numsem"),
                                    ventaRecuperada.getString("vnts_status_pago"),
                                    ventaRecuperada.getDate("vnts_fecha_pago"),
                                    ventaRecuperada.getBigDecimal("vnts_importe_pago"),
                                    ventaRecuperada.getBigDecimal("vnts_saldo"),
                                    ventaRecuperada.getString("vnts_cli_nom_corto"),
                                    ventaRecuperada.getString("vnts_forma_factura"),
                                    ventaRecuperada.getString("vnts_num_factura"),
                                    ventaRecuperada.getDate("vnts_fecha_factura"),
                                    ventaRecuperada.getString("vnts_mes_factura"),
                                    ventaRecuperada.getString("vnts_capa_cliente"),
                                    ventaRecuperada.getString("vnts_clave_cliente"),
                                    ventaRecuperada.getString("vnts_clave_producto"),
                                    ventaRecuperada.getString("vnts_capa_producto"),
                                    ventaRecuperada.getBigDecimal("vnts_precio_unitario"),
                                    ventaRecuperada.getDouble("vnts_precio_sin_iva"),
                                    ventaRecuperada.getInt("vnts_cantidad"),
                                    ventaRecuperada.getBigDecimal("vnts_porcentaje_iva"),
                                    ventaRecuperada.getBigDecimal("vnts_total_sin_iva"),
                                    ventaRecuperada.getBigDecimal("vnts_importe_iva"),
                                    ventaRecuperada.getBigDecimal("vnts_total")
                            );

                            Main.ventanaAniadir_ModificarVenta.cambiarDisposicionInsertar_Editar(true, ventaModificar);
                            Main.ventanaAniadir_ModificarVenta.setVisible(true);
                        }

                        else
                        {
                            Main.ventanaError.cambiarErrorTexto("ERROR: No se ha encontrado ninguna venta con el folio ingresado");
                            Main.ventanaError.setVisible(true);
                        }
                    }

                    else
                    {
                        Main.ventanaError.cambiarErrorTexto("ERROR: Valor inválido de Folio Ingresado");
                        Main.ventanaError.setVisible(true);
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
                Main.ventanaVentasOpciones.setVisible(true);
                Main.ventanaElegirVenta.setVisible(false);
            }
        });
    }


}
