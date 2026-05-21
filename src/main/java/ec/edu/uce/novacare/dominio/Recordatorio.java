package ec.edu.uce.novacare.dominio;
import ec.edu.uce.novacare.util.Validaciones;

public class Recordatorio {

    private String correo;
    private Cita cita;

    public Recordatorio() {
    }

    public Recordatorio(String correo, Cita cita) {
        setCorreo(correo);
        this.cita = cita;
    }

    @Override
    public String toString() {
        return "Recordatorio{" +
                "correo='" + correo + '\'' +
                ", cita=" + cita +
                '}';
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (Validaciones.validarCorreo(correo)) {
            this.correo = correo;
        }
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}
