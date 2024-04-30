package Models;

public class Contacto
{
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String correo;
    String telefono1;
    String telefono2;

    public Contacto() {
        this.nombre = null;
        this.apellidoPaterno = null;
        this.apellidoMaterno = null;
        this.correo = null;
        this.telefono1 = null;
        this.telefono2 = null;
    }

    public Contacto(String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String telefono1, String telefono2) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }
}
