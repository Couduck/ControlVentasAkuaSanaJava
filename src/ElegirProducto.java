import Models.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElegirProducto extends JFrame{
    private JTable tablaProductos;
    private JButton goBackButton;
    private JButton abrirProductoElegido;
    private JPanel cuerpoPanel;

    private Producto productoSeleccionado = null;

    public ElegirProducto() {

    }

    public void poblarTabla()
    {
        try
        {
            ResultSet resultadosQuery = Main.productoDBController.recuperarTodosProductos();
            //ResultSetMetaData informacionColumnas = resultadosQuery.getMetaData();

            String[] nombresColumnasTablas = {"Clave", "Nombre", "Status", "Fecha de último Cambio", "Litros", "Nombre BI"};

            DefaultTableModel ModeloTablaProductos = new DefaultTableModel(nombresColumnasTablas, 0)
            {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            while(resultadosQuery.next())
            {
                String claveActual = resultadosQuery.getString("prds_clave");
                String nombreActual = resultadosQuery.getString("prds_nombre");
                String statusActual = resultadosQuery.getString("prds_status");
                Date fechaCambioActual = resultadosQuery.getDate("prds_fecha_cambio");
                Integer litrosActual = resultadosQuery.getInt("prds_litros");
                String nombreBIActual = resultadosQuery.getString("prds_nombre_BI");

                Object[] registro = {claveActual, nombreActual, statusActual, fechaCambioActual, litrosActual, nombreBIActual};

                ModeloTablaProductos.addRow(registro);
            }

            tablaProductos.setModel(ModeloTablaProductos);

        }

        catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public void initElegirProducto() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //VentasOpciones ventana = new VentasqOpciones();
        this.setContentPane(this.cuerpoPanel);
        this.setTitle("ELEGIR PRODUCTO");
        this.setSize(500, 350);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaProductosOpciones.setVisible(true);
                Main.ventanaElegirProducto.setVisible(false);
                productoSeleccionado = null;
            }
        });

        tablaProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int registroSeleccionado = tablaProductos.getSelectedRow();
                DefaultTableModel modeloTablaProductos = (DefaultTableModel) tablaProductos.getModel();

                String claveProductoSeleccionado = modeloTablaProductos.getValueAt(registroSeleccionado,0).toString();
                String nombreProductoSeleccionado = modeloTablaProductos.getValueAt(registroSeleccionado,1).toString();
                String statusProductoSeleccionado = modeloTablaProductos.getValueAt(registroSeleccionado,2).toString();
                Date fechaCambioProductoSeleccionado = (Date) modeloTablaProductos.getValueAt(registroSeleccionado,3);
                Integer litrosProductoSeleccionado = (Integer) modeloTablaProductos.getValueAt(registroSeleccionado,4);
                String nombreBIProductoSeleccionado = modeloTablaProductos.getValueAt(registroSeleccionado,5).toString();

                productoSeleccionado = new Producto(claveProductoSeleccionado, nombreProductoSeleccionado, statusProductoSeleccionado, fechaCambioProductoSeleccionado, litrosProductoSeleccionado, nombreBIProductoSeleccionado);
            }
        });

        abrirProductoElegido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(productoSeleccionado != null)
                {
                    Main.ventanaAniadir_ModificarProducto.cambiarDisposicionInsertar_Editar(true, productoSeleccionado);
                    Main.ventanaAniadir_ModificarProducto.setVisible(true);
                    Main.ventanaElegirProducto.setVisible(false);
                    productoSeleccionado = null;
                }

                else
                {
                    Main.ventanaError.cambiarErrorTexto("ERROR: Producto a modificar no seleccionado");
                    Main.ventanaError.setVisible(true);
                }

            }
        });
    }


    public void seleccionarProducto(java.awt.event.MouseEvent evento)
    {


    }


}
