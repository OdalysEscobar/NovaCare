package ec.edu.uce.novacare.dominio;
import ec.edu.uce.novacare.util.Validaciones;

public class Empleado extends Usuario{
    private Especialidad especialidad;

    public Empleado() {
        super ();
        this.especialidad = Especialidad.MANICURA;
    }

    public Empleado( String nombre, String apellido, String contrasena, String correo, Especialidad especialidad) {
        super( nombre, apellido, contrasena, correo);
        this.especialidad = especialidad;
    }

    public Especialidad getEspecialidad() {

        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        if (especialidad != null) {
            this.especialidad = especialidad;
        }
    }


    @Override
    public String toString() {
        return "Empleado{" + super.toString()+
                ", especialidad='" + especialidad.getDescripcion() + '\'' +
                '}';
    }
}
