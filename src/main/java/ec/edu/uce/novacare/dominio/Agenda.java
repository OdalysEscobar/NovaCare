package ec.edu.uce.novacare.dominio;

public class Agenda {
    private String citasPendiente;

    public Agenda() {
    }

    public Agenda(String citasPendiente) {
        this.citasPendiente = citasPendiente;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "citasPendiente='" + citasPendiente + '\'' +
                '}';
    }

    public String getCitasPendiente() {
        return citasPendiente;
    }

    public void setCitasPendiente(String citasPendiente) {
        this.citasPendiente = citasPendiente;
    }
}
