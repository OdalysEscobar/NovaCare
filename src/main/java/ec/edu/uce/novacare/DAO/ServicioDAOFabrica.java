package ec.edu.uce.novacare.DAO;

public class ServicioDAOFabrica {
    public DAO crearServicioDAO(){
        return new ServicioDAOMemorialImpl();
    }
}
