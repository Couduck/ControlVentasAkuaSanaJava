import javax.swing.*;

public class MensajeError extends JFrame{
    private JPanel cuerpoPanel;
    public JLabel errorTexto;

    public MensajeError()
    {
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                errorTexto.setText("");
            }
        });
    }

    public void initMensajeError() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //VentasOpciones ventana = new VentasOpciones();
        this.setContentPane(this.cuerpoPanel);
        this.setTitle("ERROR");
        this.setSize(500, 350);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    }

    public void cambiarErrorTexto(String error)
    {
        errorTexto.setText("<html>" + error + "</html>");
    }
}
