package ec.edu.uce.novacare.DAO;

import ec.edu.uce.novacare.dominio.CentroDeBelleza;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.TipoServicio;
import ec.edu.uce.novacare.dominio.Usuario;

import java.util.List;

public class TipoServicioDAOMemoriaImpl implements DAO{
    private static List<TipoServicio> tipoServicios = CentroDeBelleza.getTipoServicios();

    @Override
    public boolean nuevo(Object objeto) {

        if (objeto != null && objeto instanceof TipoServicio) {
            TipoServicio tipoServicio = (TipoServicio) objeto;

            if (!existe(tipoServicio)) {
                tipoServicios.add(tipoServicio);
                return true;
            }
        }
        return false;

    }

    @Override
    public boolean editar(int pos, Object objeto) {
        if (objeto != null && objeto instanceof TipoServicio) {
            TipoServicio nuevoTipoServicio = (TipoServicio) objeto;

            // Verificamos que la posición sea válida en la lista
            if (pos >= 0 && pos < tipoServicios.size()) {
                TipoServicio tipoServicioOriginal = tipoServicios.get(pos);

                // Actualizamos los datos básicos
                tipoServicioOriginal.setNombreTipoServicio(nuevoTipoServicio.getNombreTipoServicio());
                tipoServicioOriginal.setDescripcion(nuevoTipoServicio.getDescripcion());

                // Actualizamos sus servicios internos usando la nueva estructura de la fábrica DAO
                ServicioDAOFabrica servicioDAOFabrica = new ServicioDAOFabrica();
                DAO servicioDAO = servicioDAOFabrica.crearServicioDAO(); // Usa la interfaz genérica DAO

                if (nuevoTipoServicio.getServicios() != null) {
                    for (Servicio servicio : nuevoTipoServicio.getServicios()) {
                        // Como tu servicioDAO ahora usa editar(int pos, Object), le pasamos la posición
                        if (!servicioDAO.editar(pos, servicio)) {
                            servicioDAO.nuevo(servicio);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(int pos) {
        if (pos >= 0 && pos < tipoServicios.size()) {
            tipoServicios.remove(pos);
            return true;
        }
        return false;
    }

    @Override
    public Object buscarPorId(int id) {
        if (id >= 0 && id < tipoServicios.size()) {
            return tipoServicios.get(id);
        }
        return null;
    }

    @Override
    public List listarTodos() {
        return tipoServicios;
    }

    @Override
    public boolean existe(Object objeto) {
        if (objeto != null && objeto instanceof TipoServicio) {
            TipoServicio tipoServicio = (TipoServicio) objeto;

            for (TipoServicio s : tipoServicios) {
                if (s != null && s.getNombreTipoServicio() != null && tipoServicio.getNombreTipoServicio() != null
                        && s.getNombreTipoServicio().equalsIgnoreCase(tipoServicio.getNombreTipoServicio())) {
                    return true;
                }
            }
        }
        return false;
    }
//    private boolean validarDuplicado(Object o){
//        if (!(o instanceof TipoServicio)) {
//            return false;
//        }
//
//        TipoServicio tipoServicio = (TipoServicio) o;
//
//        for (TipoServicio s: tipoServicios){
//            if (s!=null && s.getNombreTipoServicio().equals(tipoServicio.getNombreTipoServicio())){
//                return true;
//            }
//        }
//
//        return false;
//    }
//
//    @Override
//    public boolean nuevo(TipoServicio tipoServicio) {
//        if(tipoServicio == null){
//            return false;
//        }
//
//        if(tipoServicio == null){
//            return false;
//        }
//
//        if(!validarDuplicado(tipoServicio)) {
//            tipoServicios.add(tipoServicio);
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public boolean editar(TipoServicio tipoServicio, String nombreTipoServicio) {
//        ServicioDAOFabrica servicioDAOFabrica = new ServicioDAOFabrica();
//        ServicioDAO servicioDAO = servicioDAOFabrica.crearServicioDAO();
//        for (TipoServicio tipoServicio1: tipoServicios){
//            if(tipoServicio1!=null && tipoServicio1.getNombreTipoServicio().equals(nombreTipoServicio)){
//                tipoServicio1.setNombreTipoServicio(tipoServicio.getNombreTipoServicio());
//                tipoServicio1.setDescripcion(tipoServicio.getDescripcion());
//
//                for(Servicio servicio: tipoServicio.getServicios()){
//
//                    if(!servicioDAO.editar(servicio, servicio.getNombre())){
//                        servicioDAO.nuevo(servicio);
//                    }
//                }
//                return  true;
//            }
//        }
//
//        return false;
//    }
//
//    @Override
//    public boolean eliminar(String nombreTipoServicio) {
//        return false;
//    }
//
//    @Override
//    public TipoServicio buscarPorNombre(String nombreTipoServicio) {
//        return null;
//    }
//
//    @Override
//    public List<TipoServicio> listar() {
//        return tipoServicios;
//    }
//
//    @Override
//    public boolean existe(String nombreTipoServicio) {
//        return false;
//    }


}
