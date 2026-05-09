package ec.edu.uce.novacare.dominio;

public class Cita {
    private String fecha;
    private String hora;

    public Cita() {
    }

    public Cita(String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
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
}
