package ec.edu.uce.novacare.DAO;

import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.CentroDeBelleza;

import java.util.List;

public class ServicioDAOMemorialImpl {

    CentroDeBelleza centro = CentroDeBelleza.getCentro();
    private static List<Servicio> servicios = CentroDeBelleza.getServicios();

}
