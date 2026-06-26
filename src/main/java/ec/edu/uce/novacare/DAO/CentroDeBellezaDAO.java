package ec.edu.uce.novacare.DAO;

import ec.edu.uce.novacare.dominio.CentroDeBelleza;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.Usuario;

public class CentroDeBellezaDAO implements CRUD {

    private CentroDeBelleza centro = CentroDeBelleza.getCentro();

    @Override
    public boolean agregar(Object o) {
        if (o instanceof Servicio) {
            Servicio s = (Servicio) o;
            return centro.agregarServicio(s);
        } else if (o instanceof Usuario) {
            Usuario u = (Usuario) o;
            return true;
        }
        return false;
    }

    @Override
    public boolean editar(Object o) {
        if (o instanceof Servicio) {
            Servicio s = (Servicio) o;
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminar(Object o) {
        if (o instanceof Integer) {
            int pos = (Integer) o;
            return centro.eliminarServicio(pos);
        }
        return false;
    }

    @Override
    public Object buscar(Object o) {
        if (o instanceof Integer) {
            int pos = (Integer) o;
        }
        return null;
    }
}
