package ec.edu.uce.novacare.DAO;

import ec.edu.uce.novacare.dominio.CentroDeBelleza;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.Usuario;

public class CentroDeBellezaDAOMemoriaImpl implements CRUD {

    private CentroDeBelleza centro = CentroDeBelleza.getCentro();

    @Override
    public boolean agregar(Object o) {
        if (o instanceof Servicio) {
            Servicio s = (Servicio) o;
            return centro.agregarServicio(s);
        } else if (o instanceof Usuario) {
            return true;
        }
        return false;
    }

    @Override
    public boolean editar(Object o) {
        if (o instanceof Servicio) {
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminar(Object o) {
        if (o instanceof Integer) {
            return centro.eliminarServicio((Integer) o);
        }
        return false;
    }

    @Override
    public Object buscar(Object o) {
        if (o instanceof Integer) {
            return centro.buscarServicio((Integer) o);
        }
        return null;
    }
}
