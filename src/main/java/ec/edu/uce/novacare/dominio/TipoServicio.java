package ec.edu.uce.novacare.dominio;
import ec.edu.uce.novacare.util.Validaciones;
import java.util.Arrays;


public class TipoServicio {
    private String nombreTipoServicio;
    private String descripcion;
    private Servicio[] servicios;

    public TipoServicio() {
        this.nombreTipoServicio = "Corte de cabello";
        this.descripcion = "Corte en capas";
        this.servicios = new Servicio[0];
    }

    public TipoServicio(String nombreTipoServicio, String descripcion, Servicio[] servicios) {
        setNombreTipoServicio(nombreTipoServicio);
        setDescripcion(descripcion);
        this.servicios = servicios;
    }

    public String getNombreTipoServicio() {
        return nombreTipoServicio;
    }

    public void setNombreTipoServicio(String nombreTipoServicio) {
        if (Validaciones.validarLetras(nombreTipoServicio)) {
            this.nombreTipoServicio = nombreTipoServicio;
        }
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        if (Validaciones.validarLetras(descripcion)) {
            this.descripcion = descripcion;
        }
    }

    public Servicio[] getServicios() {
        return servicios;
    }

    public void setServicios(Servicio[] servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "\n  ----------------------------------------" +
                "\n  [Tipo de Servicio en Memoria]" +
                "\n  Nombre Tipo: '" + nombreTipoServicio + '\'' +
                "\n  Descripción: '" + descripcion + '\'' +
                "\n  Arreglo Servicios: " + java.util.Arrays.toString(servicios) +
                "\n  ----------------------------------------";
    }
}
