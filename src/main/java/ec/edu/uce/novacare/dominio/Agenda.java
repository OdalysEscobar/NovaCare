package ec.edu.uce.novacare.dominio;

import java.util.List;

public class Agenda {
    private String citasPendiente;
    private List<Cita> citas;

    public Agenda() {
    }

    public Agenda(String citasPendiente, List<Cita> citas) {
        this.citasPendiente = citasPendiente;
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "citasPendiente='" + citasPendiente + '\'' +
                ", citas=" + citas +
                '}';
    }

    public String getCitasPendiente() {
        return citasPendiente;
    }

    public void setCitasPendiente(String citasPendiente) {
        this.citasPendiente = citasPendiente;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }



}
