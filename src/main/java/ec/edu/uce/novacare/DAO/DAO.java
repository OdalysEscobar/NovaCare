package ec.edu.uce.novacare.DAO;
import java.util.List;
public interface DAO {

    //interfaz para todos los DAOS
    public boolean nuevo(Object objeto);
    public boolean editar (int pos, Object objeto);
    public boolean eliminar(int pos);
    public Object buscarPorId (int id);
    public List listarTodos();
    public boolean existe(Object objeto);
}
