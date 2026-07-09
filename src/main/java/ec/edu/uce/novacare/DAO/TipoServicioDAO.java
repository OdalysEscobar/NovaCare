package ec.edu.uce.novacare.DAO;

import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.TipoServicio;
import ec.edu.uce.novacare.dominio.Usuario;

import java.util.List;

public interface TipoServicioDAO {
    public boolean nuevo(TipoServicio tipoServicio);
    public boolean editar(TipoServicio tipoServicio, String nombreTipoServicio);
    public boolean eliminar (String nombreTipoServicio);
    TipoServicio buscarPorNombre(String nombreTipoServicio);
    List<TipoServicio> listar();
    public boolean existe (String nombreTipoServicio);
}
