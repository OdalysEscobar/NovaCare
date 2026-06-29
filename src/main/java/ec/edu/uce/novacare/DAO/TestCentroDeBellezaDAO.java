package ec.edu.uce.novacare.DAO;

import ec.edu.uce.novacare.dominio.Disponibilidad;
import ec.edu.uce.novacare.dominio.Servicio;

public class TestCentroDeBellezaDAO {
    public static void main(String[] args) {
        CentroDeBellezaDAOFabrica fabrica = new CentroDeBellezaDAOFabrica();
        CRUD dao = fabrica.crearCentroDeBellezaDAO();

        String accion = "C";
        Servicio serv;
        int id = 0;

        System.out.println("Ingrese\n C: Crear , R: Reporte, E: Editar, D: Eliminar");

        switch (accion) {

            case "C": // crear
                serv = new Servicio(60, Disponibilidad.DISPONIBLE);
                boolean creado = dao.agregar(serv);
                System.out.println("Servicio agregado con éxito: " + creado);
                break;

            case "R": // buscar
                System.out.println("Ingrese el ID del Servicio");
                id = 0;
                Object obj = dao.buscar(id);

                if (obj instanceof Servicio) {
                    serv = (Servicio) obj;
                    System.out.println("Servicio encontrado: " + serv + "\n");
                } else {
                    System.out.println("Servicio con id: " + id + " no encontrado");
                }
                break;

            case "E": // editar
                System.out.println("Ingrese el id del Servicio para editar");
                id = 0;

                Object objE = dao.buscar(id);
                if (objE instanceof Servicio) {
                    serv = new Servicio(60, Disponibilidad.DISPONIBLE);
                    boolean editado = dao.editar(serv);
                    System.out.println("Servicio actualizado con éxito: " + editado);
                } else {
                    System.out.println("No se pudo editar: Servicio no encontrado");
                }
                break;

            case "D": // eliminar
                id = 0;
                boolean eliminado = dao.eliminar(id);
                if (eliminado) {
                    System.out.println("Servicio " + id + " eliminado con éxito");
                } else {
                    System.out.println("Error al eliminar servicio");
                }
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }
    }
}