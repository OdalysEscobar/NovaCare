package ec.edu.uce.novacare.dominio;
import ec.edu.uce.novacare.util.Validaciones;

/**
 * Representa una cita dentro del sistema.
 */
public class Cita {
    private String fecha;
    private String hora;
    private Servicio servicio;
    private Cliente cliente;
    private Agenda agenda;

    /**
     * Constructor por defecto.
     * Inicializa la cita con valores por defecto.
     */
    public Cita() {
        this.fecha="Sin fecha";
        this.hora= "Sin hora";
    }

    /**
     * Constructor que inicializa una cita con sus datos principales.
     *
     * @param fecha fecha de la cita
     * @param agenda agenda donde se registra la cita
     * @param cliente cliente asociado a la cita
     * @param servicio servicio que se realizará en la cita
     * @param hora hora de la cita
     */
    public Cita(String fecha, Agenda agenda, Cliente cliente, Servicio servicio, String hora) {
        setFecha(fecha);
        this.agenda = agenda;
        this.cliente = cliente;
        this.servicio = servicio;
        setHora(hora);
    }

    /**
     * Retorna una representación en texto de la cita.
     *
     * @return cadena con los datos de la cita
     */
    @Override
    public String toString() {
        return "Cita{" +
                "fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", servicio=" + servicio +
                ", cliente=" + cliente +
                ", agenda=" + agenda +
                '}';
    }

    /**
     * Obtiene la fecha de la cita.
     * @return fecha de la cita
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la cita si es válida.
     * @param fecha nueva fecha
     */
    public void setFecha(String fecha) {
        if (Validaciones.validarFecha(fecha)) {
        this.fecha = fecha;
        }
    }

    /**
     * Obtiene la hora de la cita.
     * @return hora de la cita
     */
    public String getHora() {
        return hora;
    }

    /**
     * Establece la hora de la cita si es válida.
     * @param hora nueva hora
     */
    public void setHora(String hora) {
        if (Validaciones.validarHora(hora)) {
            this.hora = hora;
        }
    }

    /**
     * Obtiene el servicio asociado a la cita.
     * @return servicio de la cita
     */
    public Servicio getServicio() {
        return servicio;
    }

    /**
     * Asigna el servicio de la cita.
     * @param servicio servicio a asignar
     */
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    /**
     * Obtiene la agenda asociada a la cita.
     * @return agenda de la cita
     */
    public Agenda getAgenda() {
        return agenda;
    }

    /**
     * Asigna la agenda de la cita.
     * @param agenda agenda a asignar
     */
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    /**
     * Obtiene el cliente asociado a la cita.
     * @return cliente de la cita
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Asigna el cliente de la cita.
     * @param cliente cliente a asignar
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
