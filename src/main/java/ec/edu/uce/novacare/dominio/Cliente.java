package ec.edu.uce.novacare.dominio;
import ec.edu.uce.novacare.util.Validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente extends Usuario {
    private String numeroDeTelefono;

    public Cliente() {
        super ();
        this.numeroDeTelefono="Sin numero de telefono";
    }

    public Cliente( String nombre, String apellido, String contrasena, String correo, String numeroDeTelefono) {
        super(nombre, apellido, contrasena, correo);
        this.numeroDeTelefono = numeroDeTelefono;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        if (Validaciones.validarTelefono(numeroDeTelefono)) {
            this.numeroDeTelefono = numeroDeTelefono;
        }else{
            this.numeroDeTelefono = "Sin numero de telefono";
        }
    }

    public static boolean validarTelefono (String telefono){
        Pattern pattern = Pattern.compile("^09\\d{8}$");
        Matcher matcher= pattern.matcher(telefono);
        return matcher.matches();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", contrasena='" + getContrasena() + '\'' +
                ", numeroDeTelefono='" + numeroDeTelefono + '\'' +
                '}';
    }
}
