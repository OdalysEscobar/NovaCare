package ec.edu.uce.novacare.dominio;

public class Servicio {
    private int duracion;
    private boolean disponibilidad;

    public Servicio() {
        this.duracion = 0 ;
        this.disponibilidad = false;
    }

    public Servicio(int duracion, boolean disponibilidad) {
        setDuracion(duracion);
        setDisponibilidad(disponibilidad);
    }

    @Override
    public String toString() {
        return "Servicio{" +
                " duracion=" + duracion +
                ", dispoinibilidad=" + disponibilidad +
                '}';
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion > 0) {
            this.duracion = duracion;
        }
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}