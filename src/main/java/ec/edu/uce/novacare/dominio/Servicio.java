package ec.edu.uce.novacare.dominio;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Servicio {
    private String tipoServicio;
    private int duracion;
    private boolean dispoinibilidad;

    public Servicio() {
    }

    public Servicio(String tipoServicio, int duracion, boolean dispoinibilidad) {
        setTipoServicio(tipoServicio);
        this.duracion = duracion;
        this.dispoinibilidad = dispoinibilidad;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "tipoServicio='" + tipoServicio + '\'' +
                ", duracion=" + duracion +
                ", dispoinibilidad=" + dispoinibilidad +
                '}';
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        String regex = "^[a-zA-Z\\sÁÉÍÓÚáéíóúñÑ]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(tipoServicio);

        if (m.matches()) {
            this.tipoServicio = tipoServicio;
        }
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion > 0) {
            this.duracion = duracion;
        }
    }

    public boolean isDispoinibilidad() {
        return dispoinibilidad;
    }

    public void setDispoinibilidad(boolean dispoinibilidad) {
        this.dispoinibilidad = dispoinibilidad;
    }
}

