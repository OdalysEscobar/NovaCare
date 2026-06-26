package ec.edu.uce.novacare.DAO;

public interface CRUD {
    boolean agregar(Object o);
    boolean eliminar(Object o);
    boolean editar(Object o);
    Object buscar(Object o);
}
