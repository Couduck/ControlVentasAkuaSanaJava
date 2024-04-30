package Models;

public class Domicilio extends DomicilioFiscal
{
    String rfc;

    public Domicilio() {
        super(null, null, null, null, null, null, null);
        this.rfc = null;
    }

    public Domicilio(String calle, String numeroExterior, String numeroInterior, String colonia, String municipio, String estado, String codigoPostal, String rfc) {
        super(calle, numeroExterior, numeroInterior, colonia, municipio, estado, codigoPostal);
        this.rfc = rfc;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
}
