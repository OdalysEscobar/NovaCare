package ec.edu.uce.novacare.dominio;

public class Cita {
    private String fecha;
    private String hora;
    private Servicio servicio;
    private Cliente cliente;
    private Agenda agenda;

    public Cita() {
    }

    public Cita(String fecha, Agenda agenda, Cliente cliente, Servicio servicio, String hora) {
        this.fecha = fecha;
        this.agenda = agenda;
        this.cliente = cliente;
        this.servicio = servicio;
        this.hora = hora;
    }

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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
