package ec.edu.uce.novacare.DAO;

public class TipoServicioDAOFabrica {
    public DAO crearTipoServicioDAO(){
        return new TipoServicioDAOMemoriaImpl();
    }
}
