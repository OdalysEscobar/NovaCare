package ec.edu.uce.novacare.DAO;

public class CitaDAOFabrica {
    public DAO crearCitaDAO() {
        return new CitaDAOMemoriaImpl();
    }
}
