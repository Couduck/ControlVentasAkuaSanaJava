import javax.swing.*;

public class MensajeError extends JFrame{
    private JPanel cuerpoPanel;
    private JLabel errorTexto;

    public void initMensajeError() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //VentasOpciones ventana = new VentasOpciones();
        this.setContentPane(this.cuerpoPanel);
        this.setTitle("ERROR");
        this.setSize(500, 250);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    }

    public void cambiarErrorTexto(String error)
    {
        errorTexto.setText(error);
    }
}
