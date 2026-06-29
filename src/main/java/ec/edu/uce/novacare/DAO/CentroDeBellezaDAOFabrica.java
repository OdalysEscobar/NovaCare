package ec.edu.uce.novacare.DAO;

public class CentroDeBellezaDAOFabrica {
    public CRUD crearCentroDeBellezaDAO() {
        return new CentroDeBellezaDAOMemoriaImpl();
    }

}
