package ec.edu.uce.novacare.DAO;

import ec.edu.uce.novacare.dominio.Usuario;
import java.util.List;

public interface UsuarioDAO {
    public boolean nuevo(Usuario usuario);
    public boolean editar(Usuario usuario, String correo);
    public boolean eliminar (String correo);
    Usuario buscarPorCorreo(String correo);
    List <Usuario> listar();
}
