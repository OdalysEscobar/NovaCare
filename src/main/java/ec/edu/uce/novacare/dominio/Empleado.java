package ec.edu.uce.novacare.dominio;
import ec.edu.uce.novacare.util.Validaciones;

public class Empleado extends Usuario{
    private Especialidad especialidad;
    private  Agenda agenda;

    public Empleado() {
        super ();
        this.especialidad = Especialidad.MANICURA;
        this.agenda = new Agenda();
    }

    public Empleado( String nombre, String apellido, String contrasena, String correo, Especialidad especialidad, Agenda agenda) {
        super( nombre, apellido, contrasena, correo);
        this.especialidad = especialidad;
        this.agenda = agenda;
    }

    public Especialidad getEspecialidad() {

        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        if (especialidad != null) {
            this.especialidad = especialidad;
        }
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        if (agenda != null){
            this.agenda = agenda;
        }
    }
    @Override
    public String toString() {
        return "Empleado{" + super.toString()+
                ", especialidad='" + especialidad.getDescripcion() + '\'' +
                ", agenda=" + agenda +
                '}';
    }
}
