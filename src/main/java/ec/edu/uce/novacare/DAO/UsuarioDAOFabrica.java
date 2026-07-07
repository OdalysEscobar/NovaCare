package ec.edu.uce.novacare.DAO;

public class UsuarioDAOFabrica {
    public UsuarioDAO crearUsuarioDAO(){
        return new UsuarioDAOMemoriaImpl();
    }
}
