package ec.edu.uce.novacare.dominio;

import java.util.List;

public class Cliente extends Usuario {
    private List <Cita> citas;

    public Cliente(List<Cita> citas) {
        this.citas = citas;
    }

    public Cliente(String nombre, String apellido, String contrasena, String correo, List<Cita> citas) {
        super(nombre, apellido, contrasena, correo);
        this.citas = citas;
    }
}
