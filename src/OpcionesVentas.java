import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OpcionesVentas extends JFrame {
    private JPanel cuerpoPanel;
    private JButton aniadirBoton;
    private JButton modificarVenta;
    private JButton goBackButton;

    public void initVentasOpciones() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //VentasOpciones ventana = new VentasOpciones();
        this.setContentPane(this.cuerpoPanel);
        this.setTitle("Menu Principal");
        this.setSize(500,250);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        aniadirBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Main.ventanaAniadir_ModificarVenta.cargarClientes();
                    Main.ventanaAniadir_ModificarVenta.cargarTiposPrecios();
                    Main.ventanaAniadir_ModificarVenta.cargarTiposProductos();
                    Main.ventanaAniadir_ModificarVenta.setVisible(true);
                    Main.ventanaVentasOpciones.setVisible(false);
                }

                catch (SQLException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        });

        /*modificarVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaMenuPrincipal.setVisible(true);
                Main.ventanaVentasOpciones.setVisible(false);
            }
        });*/

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaMenuPrincipal.setVisible(true);
                Main.ventanaVentasOpciones.setVisible(false);
            }
        });
    }
}
