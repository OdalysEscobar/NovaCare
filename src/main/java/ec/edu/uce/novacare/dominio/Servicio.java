package ec.edu.uce.novacare.dominio;
import ec.edu.uce.novacare.persistencia.Persistencia;

import java.io.Serializable;

/**
 * Clase que representa un servicio dentro del sistema NovaCare.
 */
public class Servicio implements Serializable {
    private int duracion;
    private Disponibilidad disponibilidad;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor vacio.
     * Inicializa la duración en 0 y la disponibilidad en false.
     */
    public Servicio() {
        this.duracion = 0 ;
        this.disponibilidad = Disponibilidad.NO_DISPONIBLE;
    }

    public Servicio(String nombre, Disponibilidad disponibilidad, int duracion) {
        this.nombre = nombre;
        this.disponibilidad = disponibilidad;
        this.duracion = duracion;
    }

    /**
     * Constructor con parámetros.
     * @param duracion duración del servicio
     * @param disponibilidad disponibilidad del servicio
     */
    public Servicio(int duracion, Disponibilidad disponibilidad) {
        setDuracion(duracion);
        setDisponibilidad(disponibilidad);
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
    public Disponibilidad getDisponibilidad() {
        return disponibilidad;
    }
    /**
     * Modifica la disponibilidad del servicio.
     * @param disponibilidad nueva disponibilidad del servicio
     */
    public void setDisponibilidad(Disponibilidad disponibilidad) {

        if(disponibilidad != null){
            this.disponibilidad = disponibilidad;
        }
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

}