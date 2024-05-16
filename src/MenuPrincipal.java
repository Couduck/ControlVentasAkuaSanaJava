import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MenuPrincipal extends JFrame {
    private JButton ventasButton;
    private JButton clientesButton;
    private JButton preciosButton;
    private JButton productosButton;
    private JPanel cuerpoPanel;

    public void MenuPrincipal()
    {

    }

    public void initMenuPrincipal() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
       // MenuPrincipal ventana = new MenuPrincipal();

        this.setContentPane(this.cuerpoPanel);
        this.setTitle("CONTROL VENTAS AKUASANA");
        this.setSize(500,350);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        ventasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //VentasOpciones vntsOpc = new VentasOpciones();
                Main.ventanaVentasOpciones.setVisible(true);
                Main.ventanaMenuPrincipal.setVisible(false);
            }
        });

        preciosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //VentasOpciones vntsOpc = new VentasOpciones();
                try
                {
                    Main.ventanaAniadirPrecio.cargarTiposProductos();
                    Main.ventanaAniadirPrecio.setVisible(true);
                    Main.ventanaMenuPrincipal.setVisible(false);
                }
                catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        clientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //VentasOpciones vntsOpc = new VentasOpciones();
                Main.ventanaClientesOpciones.setVisible(true);
                Main.ventanaMenuPrincipal.setVisible(false);
            }
        });

        productosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //VentasOpciones vntsOpc = new VentasOpciones();
                Main.ventanaProductosOpciones.setVisible(true);
                Main.ventanaMenuPrincipal.setVisible(false);
            }
        });
    }


}
