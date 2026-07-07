package ec.edu.uce.novacare.DAO;

import ec.edu.uce.novacare.dominio.Servicio;


import java.util.List;

public interface ServicioDAO {

    public boolean nuevo(Servicio servicio);
    public boolean editar(Servicio servicio, int pos);
    public boolean eliminar (int pos);
    Servicio buscar(int duracion);
    List <Servicio> listar();

}
