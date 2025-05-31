package DBControllers;

import DBConnection.ConexionDB;
import Models.Cliente;
import Models.Precio;

import java.sql.*;

public class ClienteDBController
{
    private ConexionDB db;

    public ClienteDBController(ConexionDB db)
    {
        this.db = db;
    }

    public void createCliente(Cliente clienteNuevo) throws SQLException {
        String instruccionSTR = "insert into clientes (" +
                "clnts_nombre_corto, clnts_status, clnts_tipo_factura," +
                "clnts_cli_repo, clnts_momento_emision_factura, clnts_forma_pago," +
                "clnts_fecha_alta, clnts_fecha_actualizacion, clnts_clave_precio," +
                "clnts_contacto_apellido_paterno, clnts_contacto_apellido_materno, clnts_contacto_nombre," +
                "clnts_contacto_correo, clnts_contacto_telefono1, clnts_contacto_telefono2," +
                "clnts_domicilio_calle, clnts_domicilio_numero_exterior, clnts_domicilio_numero_interior," +
                "clnts_domicilio_colonia, clnts_domicilio_municipio, clnts_domicilio_estado," +
                "clnts_domicilio_codigo_postal, clnts_domicillio_rfc, clnts_domicilio_fiscal_calle," +
                "clnts_domicilio_fiscal_numero_exterior, clnts_domicilio_fiscal_numero_interior, clnts_domicilio_fiscal_colonia," +
                "clnts_domicilio_fiscal_municipio, clnts_domicilio_fiscal_estado, clnts_domicilio_fiscal_codigo_postal," +
                "clnts_correo_facturas, clnts_fecha_ultima_compra, clnts_observaciones," +
                "clnts_gps_latitud, clnts_gps_longitud)" +
                " values " +
                "(?, ?, " +
                "?, ?, ?," +
                "?, ?, ?," +
                "?, ?, ?," +
                "?, ?, ?," +
                "?, ?, ?," +
                "?, ?, ?," +
                "?, ?, ?," +
                "?, ?, ?," +
                "?, ?, ?," +
                "?, ?, ?," +
                "?, ?, ?)";

        PreparedStatement instruccionConValores = this.db.getConexion().prepareCall(instruccionSTR);

        instruccionConValores.setString(1,clienteNuevo.getNombreClave());
        instruccionConValores.setString(2,clienteNuevo.getStatus());
        instruccionConValores.setString(3,clienteNuevo.getTipoFactura());
        instruccionConValores.setString(4,clienteNuevo.getCliRepo());
        instruccionConValores.setString(5,clienteNuevo.getMomentoEmisionFactura());

        instruccionConValores.setString(6,clienteNuevo.getFormaPago());
        instruccionConValores.setDate(7, (Date) clienteNuevo.getFechaAlta());
        instruccionConValores.setDate(8,(Date) clienteNuevo.getFechaModificacion());
        instruccionConValores.setString(9,clienteNuevo.getClavePrecio());
        instruccionConValores.setString(10,clienteNuevo.getContacto().getApellidoPaterno());
        instruccionConValores.setString(11,clienteNuevo.getContacto().getApellidoMaterno());

        instruccionConValores.setString(12,clienteNuevo.getContacto().getNombre());
        instruccionConValores.setString(13,clienteNuevo.getContacto().getCorreo());
        instruccionConValores.setString(14,clienteNuevo.getContacto().getTelefono1());
        instruccionConValores.setString(15,clienteNuevo.getContacto().getTelefono2());
        instruccionConValores.setString(16,clienteNuevo.getDomicilio().getCalle());
        instruccionConValores.setString(17,clienteNuevo.getDomicilio().getNumeroExterior());

        instruccionConValores.setString(18,clienteNuevo.getDomicilio().getNumeroInterior());
        instruccionConValores.setString(19,clienteNuevo.getDomicilio().getColonia());
        instruccionConValores.setString(20,clienteNuevo.getDomicilio().getMunicipio());
        instruccionConValores.setString(21,clienteNuevo.getDomicilio().getEstado());
        instruccionConValores.setString(22,clienteNuevo.getDomicilio().getCodigoPostal());
        instruccionConValores.setString(23,clienteNuevo.getDomicilio().getRfc());

        instruccionConValores.setString(24,clienteNuevo.getDomicilioFiscal().getCalle());
        instruccionConValores.setString(25,clienteNuevo.getDomicilioFiscal().getNumeroExterior());
        instruccionConValores.setString(26,clienteNuevo.getDomicilioFiscal().getNumeroInterior());
        instruccionConValores.setString(27,clienteNuevo.getDomicilioFiscal().getColonia());
        instruccionConValores.setString(28,clienteNuevo.getDomicilioFiscal().getMunicipio());
        instruccionConValores.setString(29,clienteNuevo.getDomicilioFiscal().getEstado());

        instruccionConValores.setString(30,clienteNuevo.getDomicilioFiscal().getCodigoPostal());
        instruccionConValores.setString(31,clienteNuevo.getCorreoFacturas());
        instruccionConValores.setDate(32, (Date) clienteNuevo.getFechaUltimaCompra());
        instruccionConValores.setString(33,clienteNuevo.getObservaciones());
        instruccionConValores.setString(34,clienteNuevo.getLatitud());
        instruccionConValores.setString(35, clienteNuevo.getLongitud());

        instruccionConValores.execute();
    }

    public ResultSet recuperarTodosClientes() throws SQLException {
        String instruccionSTR = "select * from clientes";
        Statement instruccion = this.db.getConexion().createStatement();
        ResultSet resultados = instruccion.executeQuery(instruccionSTR);

        return resultados;
    }

    public ResultSet recuperarClienteEspecifico(String nombreCliente) throws SQLException {
        String instruccionSTR = "select * from clientes where clnts_nombre_corto = \"" + nombreCliente +"\"";
        Statement instruccion = this.db.getConexion().createStatement();
        ResultSet resultados = instruccion.executeQuery(instruccionSTR);

        return resultados;
    }

    public void actualizarCliente(Cliente clienteEditar) throws SQLException {
        String instruccionSTR = "update clientes set clnts_status = ?, clnts_tipo_factura = ?, clnts_cli_repo = ?, clnts_momento_emision_factura = ?, clnts_forma_pago = ?, clnts_fecha_actualizacion = ?, " +
        "clnts_clave_precio = ?, clnts_contacto_apellido_paterno = ?, clnts_contacto_apellido_materno = ?, clnts_contacto_nombre = ?, clnts_contacto_correo = ?, clnts_contacto_telefono1 = ?, " +
        "clnts_contacto_telefono2 = ?, clnts_domicilio_calle = ?, clnts_domicilio_numero_exterior = ?, clnts_domicilio_numero_interior = ?, clnts_domicilio_colonia = ?, clnts_domicilio_municipio = ?, " +
        "clnts_domicilio_estado = ?, clnts_domicilio_codigo_postal = ?, clnts_domicillio_rfc = ?, clnts_domicilio_fiscal_calle = ?, clnts_domicilio_fiscal_numero_exterior = ?, clnts_domicilio_fiscal_numero_interior = ?," +
        " clnts_domicilio_fiscal_colonia = ?, clnts_domicilio_fiscal_municipio = ?, clnts_domicilio_fiscal_estado = ?, clnts_domicilio_fiscal_codigo_postal = ?, clnts_correo_facturas = ?, clnts_observaciones = ?," +
        "clnts_gps_latitud = ?, clnts_gps_longitud = ? where clnts_clave = ?";
        PreparedStatement instruccionConValores = this.db.getConexion().prepareCall(instruccionSTR);

        instruccionConValores.setString(1,clienteEditar.getStatus());
        instruccionConValores.setString(2,clienteEditar.getTipoFactura());
        instruccionConValores.setString(3, clienteEditar.getCliRepo());
        instruccionConValores.setString(4,clienteEditar.getMomentoEmisionFactura());
        instruccionConValores.setString(5,clienteEditar.getFormaPago());
        instruccionConValores.setDate(6, (Date) clienteEditar.getFechaModificacion());

        instruccionConValores.setString(7,clienteEditar.getClavePrecio());
        instruccionConValores.setString(8,clienteEditar.getContacto().getApellidoPaterno());
        instruccionConValores.setString(9, clienteEditar.getContacto().getApellidoMaterno());
        instruccionConValores.setString(10,clienteEditar.getContacto().getNombre());
        instruccionConValores.setString(11,clienteEditar.getContacto().getCorreo());
        instruccionConValores.setString(12,clienteEditar.getContacto().getTelefono1());

        instruccionConValores.setString(13,clienteEditar.getContacto().getTelefono2());
        instruccionConValores.setString(14,clienteEditar.getDomicilio().getCalle());
        instruccionConValores.setString(15, clienteEditar.getDomicilio().getNumeroExterior());
        instruccionConValores.setString(16,clienteEditar.getDomicilio().getNumeroInterior());
        instruccionConValores.setString(17,clienteEditar.getDomicilio().getColonia());
        instruccionConValores.setString(18,clienteEditar.getDomicilio().getMunicipio());

        instruccionConValores.setString(19,clienteEditar.getDomicilio().getEstado());
        instruccionConValores.setString(20,clienteEditar.getDomicilio().getCodigoPostal());
        instruccionConValores.setString(21,clienteEditar.getDomicilio().getRfc());
        instruccionConValores.setString(22,clienteEditar.getDomicilioFiscal().getCalle());
        instruccionConValores.setString(23,clienteEditar.getDomicilioFiscal().getNumeroExterior());
        instruccionConValores.setString(24,clienteEditar.getDomicilioFiscal().getNumeroInterior());

        instruccionConValores.setString(25,clienteEditar.getDomicilioFiscal().getColonia());
        instruccionConValores.setString(26,clienteEditar.getDomicilioFiscal().getMunicipio());
        instruccionConValores.setString(27,clienteEditar.getDomicilioFiscal().getEstado());
        instruccionConValores.setString(28,clienteEditar.getDomicilioFiscal().getCodigoPostal());
        instruccionConValores.setString(29,clienteEditar.getCorreoFacturas());
        instruccionConValores.setString(30,clienteEditar.getObservaciones());

        instruccionConValores.setString(31,clienteEditar.getLatitud());
        instruccionConValores.setString(32,clienteEditar.getLongitud());

        instruccionConValores.setInt(33,clienteEditar.getClave());

        instruccionConValores.execute();
        
    }

    public boolean clienteExiste(String nombreCliente) throws SQLException {
        String instruccionSTR = "select * from clientes where clnts_nombre_corto = \""+ nombreCliente +"\"";
        Statement  instruccion = this.db.getConexion().createStatement();
        ResultSet resultados = instruccion.executeQuery(instruccionSTR);

        boolean clienteYaExiste = false;

        if(resultados.next())
        {
            clienteYaExiste = true;
        }

        return clienteYaExiste;
    }
}
