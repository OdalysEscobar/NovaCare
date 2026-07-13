package ec.edu.uce.novacare.interfaz;

import ec.edu.uce.novacare.DAO.CitaDAOMemoriaImpl;
import ec.edu.uce.novacare.DAO.DAO;
import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.dominio.Cita;
import ec.edu.uce.novacare.util.Validaciones;

import java.util.List;
import java.util.Scanner;

public class MenuGestionarAgenda {

    private Scanner scanner = new Scanner(System.in);
    private UsuarioDAO usuarioDAO;
    private DAO dao;
    public MenuGestionarAgenda(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
        this.dao = new CitaDAOMemoriaImpl();
    }

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n===== GESTIONAR AGENDA DE CITAS =====");
            System.out.println("1. Consultar agenda");
            System.out.println("0. Volver al menú principal");

            System.out.println("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Error: solo puede ingresar números");
                scanner.next();
                System.out.print("Seleccione una opción: ");
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    consultarAgenda();
                    break;

                case 0:
                    System.out.println("Regresando al menú principal...");
                    MenuPrincipal menuPrincipal = new MenuPrincipal(usuarioDAO);
                    menuPrincipal.mostrarMenu();
                    return;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    // Consultar Agenda
    public void consultarAgenda() {
        List<Cita> citas = (List<Cita>) dao.listarTodos();

        if (citas.isEmpty()) {
            System.out.println("No existen citas agendadas.");
            return;
        }

        System.out.println("\n========== AGENDA DE CITAS ==========");

        System.out.printf("%-5s %-20s %-20s %-15s %-10s%n",
                "N°", "Cliente", "Servicio", "Fecha", "Hora");

        System.out.println("-----------------------------------------------------------------------");

        int contador = 1;

        for (Cita cita : citas) {

            System.out.printf("%-5d %-20s %-20s %-15s %-10s%n",
                    contador,
                    cita.getCliente().getNombre(),
                    cita.getServicio().getNombre(),
                    cita.getFecha(),
                    cita.getHora());

            contador++;
        }
    }

}