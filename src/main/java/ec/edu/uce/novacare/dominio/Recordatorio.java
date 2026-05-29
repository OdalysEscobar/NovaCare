package ec.edu.uce.novacare.dominio;

import ec.edu.uce.novacare.util.Validaciones;

public class Recordatorio {
    private String informacionCita;
    private String correo;
    private Cita cita;

    public Recordatorio() {
        this.informacionCita="Sin informacion";
        this.correo="Sin correo";
    }

    public Recordatorio(String informacionCita, String correo, Cita cita) {
        setInformacionCita(informacionCita);
        setCorreo(correo);
        this.cita = cita;
    }

    public String getInformacionCita() {
        return informacionCita;
    }

    public void setInformacionCita(String informacionCita) {
        if(Validaciones.validarLetras(informacionCita)) {
            this.informacionCita = informacionCita;
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (Validaciones.validarCorreo(correo)) {
            this.correo = correo;
        }
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    @Override
    public String toString() {
        return "Recordatorio{" +
                "informacionCita='" + informacionCita + '\'' +
                ", correo='" + correo + '\'' +
                ", cita=" + cita +
                '}';
    }
}
