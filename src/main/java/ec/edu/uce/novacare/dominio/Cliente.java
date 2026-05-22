package ec.edu.uce.novacare.dominio;

import java.util.List;

public class Cliente extends Usuario {
    private int numeroDeTelefono;
    private Cita[] citas;

    public Cliente() {
        this.citas = new Cita[0];
    }

    public Cliente(String nombre, String apellido, String contrasena, String correo, Cita[] citas) {
        super(nombre, apellido, contrasena, correo);
        this.citas = citas;
    }
}
