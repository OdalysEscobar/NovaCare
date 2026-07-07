package ec.edu.uce.novacare.DAO;

public class ServicioDAOFabrica {

    public ServicioDAO crearServicioDAO() {
        return new ServicioDAOMemorialImpl();
    }

}
