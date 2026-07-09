package ec.edu.uce.novacare.DAO;

import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.CentroDeBelleza;

import java.util.ArrayList;
import java.util.List;

public class ServicioDAOMemorialImpl implements DAO {

    CentroDeBelleza centro = CentroDeBelleza.getCentro();
    private static List<Servicio> servicios = new ArrayList<>();


    @Override
    public boolean nuevo(Object objeto) {
        if(objeto != null && objeto instanceof Servicio){
            Servicio nuevoServicio = (Servicio) objeto;

            if(!existe(nuevoServicio)){
                servicios.add(nuevoServicio);
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean editar(int pos, Object objeto) {
        if(objeto != null && objeto instanceof Servicio){
            Servicio nuevoServicio = (Servicio) objeto;

            if(!existe(nuevoServicio)){
                servicios.add(pos,nuevoServicio);
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean eliminar(int pos) {
        Servicio servicio = servicios.get(pos);

        if (servicio != null) {
            servicios.remove(pos);
            return true;
        }

        return false;

    }

    @Override
    public Object buscarPorId(int id) {
        return servicios.get(id);
    }

    @Override
    public List listarTodos() {

        return servicios;
    }

    @Override
    public boolean existe(Object objeto) {
        if (objeto != null && objeto instanceof Servicio) {
            Servicio servicio = (Servicio) objeto;

            for (Servicio s : servicios) {
                if (s != null && s.getNombre() != null && servicio.getNombre() != null
                        && s.getNombre().equalsIgnoreCase(servicio.getNombre())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}