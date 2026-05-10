package ec.edu.uce.novacare.dominio;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cita {
    private String fecha;
    private String hora;
    private Servicio servicio;
    private Cliente cliente;
    private Agenda agenda;

    public Cita() {
    }

    public Cita(String fecha, Agenda agenda, Cliente cliente, Servicio servicio, String hora) {
        setFecha(fecha);
        this.fecha = fecha;
        this.agenda = agenda;
        this.cliente = cliente;
        this.servicio = servicio;
        this.hora = hora;
        setHora(hora);
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
    String regex = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(fecha);

    if (m.matches()) {
        this.fecha = fecha;
    } else {
        System.out.println("Error: La fecha debe tener el formato DD/MM/AAAA");
    }
    }


    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        String regex = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(hora);

        if (m.matches()) {
            this.hora = hora;
        } else {
            System.out.println("Error: La hora '" + hora + "' debe tener el formato HH:MM (24h)");
        }
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
