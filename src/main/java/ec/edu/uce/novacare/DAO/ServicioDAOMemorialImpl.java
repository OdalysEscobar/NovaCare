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

            try{
                servicios.set(pos,nuevoServicio);
                return true;
            }catch(IndexOutOfBoundsException ex){
                System.out.println("No existe el servicio.");
                return false;
            }
        }

        return false;
    }

    @Override
    public boolean eliminar(int pos) {

            try{

                servicios.remove(pos);
                return true;

            }catch(IndexOutOfBoundsException ex){

                System.out.println("No existe el servicio.");
                return false;

            }
    }

    @Override
    public Object buscarPorId(int id) {
        try {
            return servicios.get(id);

        } catch (IndexOutOfBoundsException ex) {

            System.out.println("Error: no existe un servicio en la posición " + id + ".");
            return null;

        }
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