package ec.edu.uce.novacare.dominio;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        // Regla: Solo letras y espacios
        String regex = "^[a-zA-Z\\sÁÉÍÓÚáéíóúñÑ]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(especialidad);

        if (m.matches()) {
            this.especialidad = especialidad;
        } else {
            System.out.println("Error: La especialidad '" + especialidad + "' no es válida.");
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
