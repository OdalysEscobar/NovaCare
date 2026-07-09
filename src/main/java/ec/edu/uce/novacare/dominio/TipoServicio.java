package ec.edu.uce.novacare.dominio;

import ec.edu.uce.novacare.DAO.DAO; // Usamos la interfaz única DAO
import ec.edu.uce.novacare.DAO.ServicioDAOMemorialImpl;
import ec.edu.uce.novacare.util.Validaciones;
import java.util.List;
import java.util.ArrayList;


public class TipoServicio {
    private String nombreTipoServicio;
    private String descripcion;
    private List<Servicio> servicios;

    public TipoServicio() {
        this.nombreTipoServicio = "Corte de cabello";
        this.descripcion = "Corte en capas";
        this.servicios = new ArrayList<>();

    }

    public TipoServicio(String nombreTipoServicio, String descripcion, List<Servicio> servicios) {
        setNombreTipoServicio(nombreTipoServicio);
        setDescripcion(descripcion);
        this.servicios = servicios;
    }

    public boolean existeServicio(Servicio s) {
        for (int i = 0; i < servicios.size(); i++) {
            if (s != null && servicios.get(i) != null && servicios.get(i).getDuracion() == s.getDuracion()) {
                return true;
            }
        }
        return false;
    }

    public boolean agregarServicio(Servicio nuevoServicio) {
        if (nuevoServicio == null || existeServicio(nuevoServicio)) {
            return false;
        }

        DAO dao = new ServicioDAOMemorialImpl();

        boolean creacion = dao.nuevo(nuevoServicio);
        if (creacion) {
            servicios.add(nuevoServicio);
        }
        return creacion;
    }

    public Servicio buscarServicio(int duracion) {
        if (duracion <= 0) {
            return null;
        }
        for (int i = 0; i < servicios.size(); i++) {
            if (servicios.get(i).getDuracion() == duracion) {
                return servicios.get(i);
            }
        }
        return null;
    }

    public boolean editarServicio(Servicio nuevoServicio, int pos) {
        if (pos >= 0 && pos < servicios.size() && servicios.get(pos) != null) {
            servicios.get(pos).setDuracion(nuevoServicio.getDuracion());
            servicios.get(pos).setDisponibilidad(nuevoServicio.getDisponibilidad());
            return true;
        }
        return false;
    }

    public boolean eliminarServicio(int pos) {
        if (pos >= 0 && pos < servicios.size() && servicios.get(pos) != null) {
            servicios.remove(pos);
            return true;
        }
        return false;
    }

    public String consultarServicio() {
        String texto = "";
        for (Servicio s : servicios) {
            if (s != null) {
                texto += s + "\r\n";
            }
        }
        return texto;
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

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "TipoServicio{" +
                "nombreTipoServicio='" + nombreTipoServicio + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", servicios=" + servicios +
                '}';
    }
}
