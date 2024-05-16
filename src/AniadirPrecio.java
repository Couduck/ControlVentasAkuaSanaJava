import Models.Precio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AniadirPrecio extends JFrame {
    private JPanel cuerpoPanel;
    private JComboBox campoTipoProducto;
    private JSpinner campoPrecioSinIva;
    private JButton goBackButton;
    private JButton guardarPrecioButton;

    public void initAniadirPrecio()
    {
        this.setContentPane(this.cuerpoPanel);
        this.setSize(500,350);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("AÑADIR PRECIO");

        guardarPrecioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(!validarCampos())
                {
                    Main.ventanaError.setVisible(true);
                    return;
                }

                int precioImporteSinIVA = (Integer) campoPrecioSinIva.getValue();

                double porcentajeIVA = 0;

                BigDecimal importeTotal = new BigDecimal(precioImporteSinIVA + porcentajeIVA * precioImporteSinIVA);

                String clavePrecio = campoTipoProducto.getSelectedItem().toString() + importeTotal;

                campoTipoProducto.getSelectedItem();

                Precio nuevoPrecio = new Precio(clavePrecio, new BigDecimal(precioImporteSinIVA), new BigDecimal(porcentajeIVA), new BigDecimal(porcentajeIVA * precioImporteSinIVA), importeTotal);

                try {
                    Main.precioDBController.createPrecio(nuevoPrecio);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                Main.ventanaAniadirPrecio.setVisible(false);
                Main.ventanaMenuPrincipal.setVisible(true);
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaAniadirPrecio.setVisible(false);
                Main.ventanaMenuPrincipal.setVisible(true);
            }
        });
    }

    public void cargarTiposProductos() throws SQLException
    {
        campoTipoProducto.removeAllItems();
        ResultSet resultadosQuery = Main.productoDBController.recuperarTodosProductosVigentes();

        while(resultadosQuery.next())
        {
            String claveActual = resultadosQuery.getString("prds_clave");
            campoTipoProducto.addItem(claveActual);
        }
    }

    public boolean validarCampos()
    {
        boolean sinErrores = true;
        ArrayList<String> listaErrores = new ArrayList<String>();

        if((int) campoPrecioSinIva.getValue() < 1)
        {
            listaErrores.add("• El precio del producto no puede ser menor a 1<br>");
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
