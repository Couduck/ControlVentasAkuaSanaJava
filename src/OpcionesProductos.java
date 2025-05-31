import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpcionesProductos extends JFrame{
    private JButton crearProducto;
    private JButton modificarProducto;
    private JButton goBackButton;
    private JPanel cuerpoPanel;

    public void initProductosOpciones() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //VentasOpciones ventana = new VentasOpciones();
        this.setContentPane(this.cuerpoPanel);
        this.setTitle("PRODUCTOS");
        this.setSize(500,350);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        crearProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaAniadir_ModificarProducto.cambiarDisposicionInsertar_Editar(false, null);
                Main.ventanaAniadir_ModificarProducto.setVisible(true);
                Main.ventanaProductosOpciones.setVisible(false);
            }
        });

        modificarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaElegirProducto.poblarTabla();
                Main.ventanaElegirProducto.setVisible(true);
                Main.ventanaProductosOpciones.setVisible(false);

            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaMenuPrincipal.setVisible(true);
                Main.ventanaProductosOpciones.setVisible(false);
            }
        });
    }
}
