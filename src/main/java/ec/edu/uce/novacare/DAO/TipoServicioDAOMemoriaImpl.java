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

            try{

            // Verificamos que la posición sea válida en la lista
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
            }catch (IndexOutOfBoundsException ex) {

                System.out.println("No existe el tipo de servicio.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(int pos) {
        try {

            tipoServicios.remove(pos);
            return true;

        } catch (IndexOutOfBoundsException ex) {

            System.out.println("No existe el tipo de servicio.");
            return false;
        }
    }

    @Override
    public Object buscarPorId(int id) {
        try {

            return tipoServicios.get(id);

        } catch (IndexOutOfBoundsException ex) {

            System.out.println("No existe el tipo de servicio.");
            return null;
        }
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

}
