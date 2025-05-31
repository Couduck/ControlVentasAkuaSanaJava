import Models.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElegirCliente extends JFrame{
    private JTable tablaClientes;
    private JButton abrirClienteElegido;
    private JButton goBackButton;
    private JPanel cuerpoPanel;

    private Cliente clienteSeleccionado = null;

    public ElegirCliente() {
        tablaClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int registroSeleccionado = tablaClientes.getSelectedRow();
                DefaultTableModel modeloTablaClientes = (DefaultTableModel) tablaClientes.getModel();

                int claveSeleccionado = (int) modeloTablaClientes.getValueAt(registroSeleccionado,0);
                String nombreCortoSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,1).toString();
                String statusSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,2).toString();
                String tipoFacturaSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,3).toString();
                String cliRepoSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,4) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,4).toString() : "";
                String momentoEmisionFactura = modeloTablaClientes.getValueAt(registroSeleccionado,5).toString();

                String formaPagoSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,6).toString();
                Date fechaAltaSeleccionado = (Date) modeloTablaClientes.getValueAt(registroSeleccionado,7);
                Date fechaSeleccionadoizacionSeleccionado = (Date) modeloTablaClientes.getValueAt(registroSeleccionado,8);
                String clavePrecioSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,9).toString();
                String apellidoPaternoSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,10) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,10).toString() : "";
                String apellidoMaternoSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,11) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,11).toString() : "";

                String contactoNombreSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,12) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,12).toString() : "";
                String contactoCorreoSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,13) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,13).toString() : "";
                String contactoTelefono1Seleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,14) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,14).toString() : "";
                String contactoTelefono2Seleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,15) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,15).toString() : "";
                String domicilioCalleSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,16) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,16).toString() : "";
                String domicilioNumExtSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,17) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,17).toString() : "";

                String domicilioNumIntSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,18) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,18).toString() : "";
                String domicilioColoniaSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,19) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,19).toString() : "";
                String domicilioMunicipioSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,20) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,20).toString() : "";
                String domicilioEstadoSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,21) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,21).toString() : "";
                String domicilioCodigoPostal = modeloTablaClientes.getValueAt(registroSeleccionado,22) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,22).toString() : "";
                String domicilioRFCSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,23) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,23).toString() : "";

                String domicilioFiscalCalleSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,24) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,24).toString() : "";
                String domicilioFiscalNumExtSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,25) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,25).toString() : "";
                String domicilioFiscalNumIntSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,26) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,26).toString() : "";
                String domicilioFiscalColoniaSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,27) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,27).toString() : "";
                String domicilioFiscalMunicipioSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,28) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,28).toString() : "";
                String domicilioFiscalEstadoSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,29) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,29).toString() : "";

                String domicilioFiscalCodigoPostalSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,30) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,30).toString() : "";
                String correoFacturasSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,31) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,31).toString() : "";
                Date fechaUltimaCompraSeleccionado = (Date) modeloTablaClientes.getValueAt(registroSeleccionado, 32);
                String observacionesSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,33) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,33).toString() : "";
                String latitudSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,34) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,34).toString() : "";
                String longitudSeleccionado = modeloTablaClientes.getValueAt(registroSeleccionado,35) != null ? modeloTablaClientes.getValueAt(registroSeleccionado,35).toString() : "";

                Contacto contactoSeleccionado= new Contacto(contactoNombreSeleccionado, apellidoPaternoSeleccionado,apellidoMaternoSeleccionado,contactoCorreoSeleccionado,contactoTelefono1Seleccionado,contactoTelefono2Seleccionado);
                Domicilio domicilioCompletoSeleccionado = new Domicilio(domicilioCalleSeleccionado, domicilioNumExtSeleccionado, domicilioNumIntSeleccionado, domicilioColoniaSeleccionado, domicilioMunicipioSeleccionado, domicilioEstadoSeleccionado,domicilioCodigoPostal, domicilioRFCSeleccionado);
                DomicilioFiscal domicilioFiscalCompletoSeleccionado = new DomicilioFiscal(domicilioFiscalCalleSeleccionado, domicilioFiscalNumExtSeleccionado, domicilioFiscalNumIntSeleccionado, domicilioFiscalColoniaSeleccionado, domicilioFiscalMunicipioSeleccionado, domicilioFiscalEstadoSeleccionado, domicilioFiscalCodigoPostalSeleccionado);

                clienteSeleccionado = new Cliente(claveSeleccionado, nombreCortoSeleccionado, statusSeleccionado, tipoFacturaSeleccionado, cliRepoSeleccionado, momentoEmisionFactura, formaPagoSeleccionado, clavePrecioSeleccionado,fechaAltaSeleccionado,fechaSeleccionadoizacionSeleccionado,correoFacturasSeleccionado,fechaUltimaCompraSeleccionado,observacionesSeleccionado,latitudSeleccionado,longitudSeleccionado);
                clienteSeleccionado.setContacto(contactoSeleccionado);
                clienteSeleccionado.setDomicilio(domicilioCompletoSeleccionado);
                clienteSeleccionado.setDomicilioFiscal(domicilioFiscalCompletoSeleccionado);

            }
        });
    }

    public void poblarTabla()
    {
        try
        {
            ResultSet resultadosQuery = Main.clienteDBController.recuperarTodosClientes();
            //ResultSetMetaData informacionColumnas = resultadosQuery.getMetaData();

            String[] nombresColumnasTablas =
            {
                    "Clave", "Nombre", "Status", "Tipo de Factura", "cliRepo", "Momento de emisión de Factura",
                    "Forma de Pago", "Fecha de Alta", "Fecha de última actualizacion", "Clave de Precio", "Apellido Paterno", "Apellido Materno",
                    "Nombre de Contacto", "Correo de Contacto", "Telefono 1", "Telefono 2", "Calle Domicilio", "Numero Exterior Domicilio",
                    "Numero Interior", "Colonia", "Status", "Tipo de Factura", "cliRepo", "Momento de emisión de Factura",
                    "Clave", "Nombre", "Status", "Tipo de Factura", "cliRepo", "Momento de emisión de Factura",
                    "Clave", "Nombre", "Status", "Tipo de Factura", "cliRepo", "Momento de emisión de Factura",
            };

            DefaultTableModel ModeloTablaClientes = new DefaultTableModel(nombresColumnasTablas, 0)
            {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            while(resultadosQuery.next())
            {
                int claveActual = resultadosQuery.getInt("clnts_clave");
                String nombreCortoActual = resultadosQuery.getString("clnts_nombre_corto");
                String statusActual = resultadosQuery.getString("clnts_status");
                String tipoFacturaActual = resultadosQuery.getString("clnts_tipo_factura");
                String cliRepoActual = resultadosQuery.getString("clnts_cli_repo");
                String momentoEmisionFactura = resultadosQuery.getString("clnts_momento_emision_factura");

                String formaPagoActual = resultadosQuery.getString("clnts_forma_pago");
                Date fechaAltaActual = resultadosQuery.getDate("clnts_fecha_alta");
                Date fechaActualizacionActual = resultadosQuery.getDate("clnts_fecha_actualizacion");
                String clavePrecioActual = resultadosQuery.getString("clnts_clave_precio");
                String apellidoPaternoActual = resultadosQuery.getString("clnts_contacto_apellido_paterno");
                String apellidoMaternoActual = resultadosQuery.getString("clnts_contacto_apellido_materno");

                String contactoNombreActual = resultadosQuery.getString("clnts_contacto_nombre");
                String contactoCorreoActual = resultadosQuery.getString("clnts_contacto_correo");
                String contactoTelefono1Actual = resultadosQuery.getString("clnts_contacto_telefono1");
                String contactoTelefono2Actual = resultadosQuery.getString("clnts_contacto_telefono2");
                String domicilioCalleActual = resultadosQuery.getString("clnts_domicilio_calle");
                String domicilioNumExtActual = resultadosQuery.getString("clnts_domicilio_numero_exterior");

                String domicilioNumIntActual = resultadosQuery.getString("clnts_domicilio_numero_interior");
                String domicilioColoniaActual = resultadosQuery.getString("clnts_domicilio_colonia");
                String domicilioMunicipioActual = resultadosQuery.getString("clnts_domicilio_municipio");
                String domicilioEstadoActual = resultadosQuery.getString("clnts_domicilio_estado");
                String domicilioCodigoPostal = resultadosQuery.getString("clnts_domicilio_codigo_postal");
                String domicilioRFCActual = resultadosQuery.getString("clnts_domicillio_rfc");

                String domicilioFiscalCalleActual = resultadosQuery.getString("clnts_domicilio_fiscal_calle");
                String domicilioFiscalNumExtActual = resultadosQuery.getString("clnts_domicilio_fiscal_numero_exterior");
                String domicilioFiscalNumIntActual = resultadosQuery.getString("clnts_domicilio_fiscal_numero_interior");
                String domicilioFiscalColoniaActual = resultadosQuery.getString("clnts_domicilio_fiscal_colonia");
                String domicilioFiscalMunicipioActual = resultadosQuery.getString("clnts_domicilio_fiscal_municipio");
                String domicilioFiscalEstadoActual = resultadosQuery.getString("clnts_domicilio_fiscal_estado");

                String domicilioFiscalCodigoPostalActual = resultadosQuery.getString("clnts_domicilio_fiscal_codigo_postal");
                String correoFacturasActual = resultadosQuery.getString("clnts_correo_facturas");
                Date fechaUltimaCompraActual = resultadosQuery.getDate("clnts_fecha_ultima_compra");
                String observacionesActual = resultadosQuery.getString("clnts_observaciones");
                String latitudActual = resultadosQuery.getString("clnts_gps_latitud");
                String longitudActual = resultadosQuery.getString("clnts_gps_longitud");

                Contacto contactoActual= new Contacto(contactoNombreActual, apellidoPaternoActual,apellidoMaternoActual,contactoCorreoActual,contactoTelefono1Actual,contactoTelefono2Actual);
                Domicilio domicilioCompletoActual = new Domicilio(domicilioCalleActual, domicilioNumExtActual, domicilioNumIntActual, domicilioColoniaActual, domicilioMunicipioActual, domicilioEstadoActual,domicilioCodigoPostal, domicilioRFCActual);
                DomicilioFiscal domicilioFiscalCompletoActual = new DomicilioFiscal(domicilioFiscalCalleActual, domicilioFiscalNumExtActual, domicilioFiscalNumIntActual, domicilioFiscalColoniaActual, domicilioFiscalMunicipioActual, domicilioFiscalEstadoActual, domicilioFiscalCodigoPostalActual);
                Cliente clienteActual = new Cliente(claveActual, nombreCortoActual, statusActual, tipoFacturaActual, cliRepoActual, momentoEmisionFactura, formaPagoActual, clavePrecioActual,fechaAltaActual,fechaActualizacionActual,correoFacturasActual,fechaUltimaCompraActual,observacionesActual,latitudActual,longitudActual);

                Object[] registro = {claveActual, nombreCortoActual, statusActual, tipoFacturaActual, cliRepoActual,
                        momentoEmisionFactura,
                        formaPagoActual,
                        fechaAltaActual,
                        fechaActualizacionActual,
                        clavePrecioActual,
                        apellidoPaternoActual,
                        apellidoMaternoActual,
                        contactoNombreActual,
                        contactoCorreoActual,
                        contactoTelefono1Actual,
                        contactoTelefono2Actual,
                        domicilioCalleActual,
                        domicilioNumExtActual,
                        domicilioNumIntActual,
                        domicilioColoniaActual,
                        domicilioMunicipioActual,
                        domicilioEstadoActual,
                        domicilioCodigoPostal,
                        domicilioRFCActual,
                        domicilioFiscalCalleActual,
                        domicilioFiscalNumExtActual,
                        domicilioFiscalNumIntActual,
                        domicilioFiscalColoniaActual,
                        domicilioFiscalMunicipioActual,
                        domicilioFiscalEstadoActual,
                        domicilioFiscalCodigoPostalActual,
                        correoFacturasActual,
                        fechaUltimaCompraActual,
                        observacionesActual,
                        latitudActual,
                        longitudActual};

                ModeloTablaClientes.addRow(registro);
            }

            tablaClientes.setModel(ModeloTablaClientes);

            for(int i = 0; i < nombresColumnasTablas.length; i++)
            {
                if(i != 1)
                {
                    tablaClientes.getColumnModel().getColumn(i).setMinWidth(0);
                    tablaClientes.getColumnModel().getColumn(i).setMaxWidth(0);
                    tablaClientes.getColumnModel().getColumn(i).setWidth(0);
                }

            }

        }

        catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
    }

    public void initElegirCliente() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //VentasOpciones ventana = new VentasOpciones();
        this.setContentPane(this.cuerpoPanel);
        this.setTitle("ELEGIR CLIENTE");
        this.setSize(500, 350);
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.ventanaClientesOpciones.setVisible(true);
                Main.ventanaElegirCliente.setVisible(false);
                clienteSeleccionado = null;
            }
        });

        tablaClientes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {


            }
        });

        abrirClienteElegido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(clienteSeleccionado != null)
                {
                    Main.ventanaAniadir_ModificarCliente.cambiarDisposicionInsertar_Editar(true, clienteSeleccionado);
                    Main.ventanaAniadir_ModificarCliente.claveItemElegido = clienteSeleccionado.getClave();
                    Main.ventanaAniadir_ModificarCliente.setVisible(true);
                    Main.ventanaElegirCliente.setVisible(false);
                    clienteSeleccionado = null;
                }

                else
                {
                    Main.ventanaError.cambiarErrorTexto("ERROR: Producto a modificar no seleccionado");
                    Main.ventanaError.setVisible(true);
                }

            }
        });
    }
}
