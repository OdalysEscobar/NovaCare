package ec.edu.uce.novacare.dominio;

public class Servicio {
    private String tipoServicio;
    private int duracion;
    private boolean dispoinibilidad;

    public Servicio() {
    }

    public Servicio(String tipoServicio, int duracion, boolean dispoinibilidad) {
        this.tipoServicio = tipoServicio;
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
        this.tipoServicio = tipoServicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public boolean isDispoinibilidad() {
        return dispoinibilidad;
    }

    public void setDispoinibilidad(boolean dispoinibilidad) {
        this.dispoinibilidad = dispoinibilidad;
    }
}

