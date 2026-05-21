package ec.edu.uce.novacare.dominio;
import ec.edu.uce.novacare.util.Validaciones;

public class Empleado extends Usuario{
    private String especialidad;
    private  Agenda agenda;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, String contrasena, String correo, String especialidad, Agenda agenda) {
        super(nombre, apellido, contrasena, correo);
        setEspecialidad(especialidad);
        this.agenda = agenda;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (Validaciones.validarLetras(especialidad)) {
            this.especialidad = especialidad;
        }
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", correo='" + getCorreo() + '\'' +
                ", agenda=" + agenda +
                '}';
    }
}
