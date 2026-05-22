package ec.edu.uce.novacare.dominio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente extends Usuario {
    private String numeroDeTelefono;
    private Cita[] citas;

    public Cliente() {
        super ();
        this.numeroDeTelefono="Sin numero de telefono";
        //this.citas = new Cita[0];
    }

    public Cliente(String nombre, String apellido, String contrasena, String correo, Cita[] citas) {
        super(nombre, apellido, contrasena, correo);
        this.citas = citas;
    }

    public String getNumeroDeTelefono() {
        return numeroDeTelefono;
    }

    public void setNumeroDeTelefono(String numeroDeTelefono) {
        if (validarTelefono(numeroDeTelefono)) {
            this.numeroDeTelefono = numeroDeTelefono;
        }
    }

    public Cita[] getCitas() {
        return citas;
    }

    public void setCitas(Cita[] citas) {
        this.citas = citas;
    }

    public static boolean validarTelefono (String telefono){
        Pattern pattern = Pattern.compile("^09\\d{8}$");
        Matcher matcher= pattern.matcher(telefono);
        return matcher.matches();
    }
}
