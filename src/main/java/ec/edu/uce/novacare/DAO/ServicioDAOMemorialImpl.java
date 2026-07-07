package ec.edu.uce.novacare.DAO;

import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.CentroDeBelleza;

import java.util.List;

public class ServicioDAOMemorialImpl implements ServicioDAO {

    CentroDeBelleza centro = CentroDeBelleza.getCentro();
    private static List<Servicio> servicios = CentroDeBelleza.getServicios();

    private boolean existeServicio(Servicio servicio){

        for (Servicio s : servicios){

            if (servicio != null &&
                    s != null &&
                    s.getDuracion() == servicio.getDuracion()){

                return true;
            }
        }

        return false;
    }

    @Override
    public boolean nuevo(Servicio nuevoServicio){

        if(nuevoServicio == null){
            return false;
        }

        if(!existeServicio(nuevoServicio)){
            servicios.add(nuevoServicio);
            return true;
        }

        return false;
    }

    @Override
    public Servicio buscar(int duracion){

        if(duracion <= 0){
            return null;
        }

        for(Servicio servicio : servicios){

            if(servicio.getDuracion() == duracion){
                return servicio;
            }

        }

        return null;
    }

    @Override
    public boolean editar(Servicio nuevoServicio, int pos) {

        if (pos >= 0 && pos < servicios.size() && servicios.get(pos) != null) {

            servicios.get(pos).setDuracion(nuevoServicio.getDuracion());
            servicios.get(pos).setDisponibilidad(nuevoServicio.getDisponibilidad());

            return true;
        }

        return false;
    }

    @Override
    public boolean eliminar(int pos) {

        if (pos >= 0 && pos < servicios.size() && servicios.get(pos) != null) {

            servicios.remove(pos);

            return true;
        }

        return false;
    }

    @Override
    public List<Servicio> listar() {
        return servicios;
    }
}
