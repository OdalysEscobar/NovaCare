package ec.edu.uce.novacare.dominio;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(correo);

        if (m.matches()) {
            this.correo = correo;
        } else {
            System.out.println("Error: El formato del correo '" + correo + "' no es válido.");
        }
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }
}
