import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OpcionesClientes extends JFrame{
    private JButton crearCliente;
    private JButton modificarCliente;
    private JButton goBackButton;
    private JPanel cuerpoPanel;

    public void initClientesOpciones() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //VentasOpciones ventana = new VentasOpciones();
        this.setContentPane(this.cuerpoPanel);
        this.setTitle("Acciones Clientes");
        this.setSize(500,250);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        crearCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // Main.ventanaAniadir_ModificarProducto.cambiarDisposicionInsertar_Editar(false, null);
                //Main.ventanaAniadir_ModificarProducto.setVisible(true);
                Main.ventanaAniadir_ModificarCliente.cambiarDisposicionInsertar_Editar(false, null);
                try {
                    Main.ventanaAniadir_ModificarCliente.cargarTiposPrecios();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Main.ventanaAniadir_ModificarCliente.setVisible(true);
                Main.ventanaClientesOpciones.setVisible(false);
            }
        });

        modificarCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Main.ventanaAniadir_ModificarCliente.cambiarDisposicionInsertar_Editar(true);
                try {
                    Main.ventanaAniadir_ModificarCliente.cargarTiposPrecios();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Main.ventanaElegirCliente.poblarTabla();
                Main.ventanaElegirCliente.setVisible(true);
                Main.ventanaClientesOpciones.setVisible(false);

            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaMenuPrincipal.setVisible(true);
                Main.ventanaClientesOpciones.setVisible(false);
            }
        });
    }
}
