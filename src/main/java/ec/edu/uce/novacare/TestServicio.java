package ec.edu.uce.novacare;

import ec.edu.uce.novacare.DAO.ServicioDAO;
import ec.edu.uce.novacare.DAO.ServicioDAOFabrica;
import ec.edu.uce.novacare.dominio.*;
import java.util.Scanner;

public class TestServicio {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ServicioDAOFabrica fabrica = new ServicioDAOFabrica();
        ServicioDAO dao = fabrica.crearServicioDAO();

        CentroDeBelleza.getCentro().inicializar();

        String accion;
        Servicio servicio;
        int duracion;

        do {

            System.out.println("Ingrese");
            System.out.println("C: Crear");
            System.out.println("B: Buscar");
            System.out.println("E: Editar");
            System.out.println("D: Eliminar");
            System.out.println("L: Listar");
            System.out.println("S: Salir");

            accion = sc.nextLine();

            switch (accion) {

                case "C":

                    servicio = new Servicio(90, Disponibilidad.DISPONIBLE);

                    dao.nuevo(servicio);

                    System.out.println("Servicio agregado.");

                    break;

                case "B":

                    System.out.println("Ingrese la duración:");

                    duracion = Integer.parseInt(sc.nextLine());

                    servicio = dao.buscar(duracion);

                    if (servicio != null) {

                        System.out.println(servicio);

                    } else {

                        System.out.println("Servicio no encontrado.");

                    }

                    break;

                case "E":

                    System.out.println("Ingrese la posición:");

                    int pos = Integer.parseInt(sc.nextLine());

                    Servicio nuevo = new Servicio(120, Disponibilidad.NO_DISPONIBLE);

                    if (dao.editar(nuevo, pos)) {

                        System.out.println("Servicio actualizado.");

                    } else {

                        System.out.println("No se pudo actualizar.");

                    }

                    break;

                case "D":

                    System.out.println("Ingrese la posición:");

                    pos = Integer.parseInt(sc.nextLine());

                    if (dao.eliminar(pos)) {

                        System.out.println("Servicio eliminado.");

                    } else {

                        System.out.println("No existe esa posición.");

                    }

                    break;

                case "L":

                    for (Servicio s : dao.listar()) {

                        if (s != null) {

                            System.out.println(s);

                        }

                    }

                    break;

                case "S":

                    System.out.println("Saliendo...");

                    break;

                default:

                    System.out.println("Opción inválida.");

            }

        } while (!accion.equals("S"));

    }
}
