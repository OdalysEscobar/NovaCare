package ec.edu.uce.novacare.dominio;

/**
 * Clase que representa un servicio dentro del sistema NovaCare.
 */
public class Servicio {
    private int duracion;
    private boolean disponibilidad;
    /**
     * Constructor vacio.
     * Inicializa la duración en 0 y la disponibilidad en false.
     */
    public Servicio() {
        this.duracion = 0 ;
        this.disponibilidad = false;
    }

    /**
     * Constructor con parámetros.
     * @param duracion duración del servicio
     * @param disponibilidad disponibilidad del servicio
     */
    public Servicio(int duracion, boolean disponibilidad) {
        setDuracion(duracion);
        setDisponibilidad(disponibilidad);
    }

    /**
     * Devuelve la información del servicio en formato texto.
     * @return información del servicio
     */
    @Override
    public String toString() {
        return "Servicio{" +
                " duracion=" + duracion +
                ", disponibilidad=" + disponibilidad +
                '}';
    }

    /**
     * Obtiene la duración del servicio.
     * @return duración del servicio
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Modifica la duración del servicio.
     * @param duracion nueva duración del servicio
     */
    public void setDuracion(int duracion) {
        if (duracion > 0) {
            this.duracion = duracion;
        }
    }

    /**
     * Obtiene la disponibilidad del servicio.
     * @return true si el servicio está disponible,
     * false en caso contrario
     */
    public boolean isDisponibilidad() {
        return disponibilidad;
    }
    /**
     * Modifica la disponibilidad del servicio.
     * @param disponibilidad nueva disponibilidad del servicio
     */
    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}