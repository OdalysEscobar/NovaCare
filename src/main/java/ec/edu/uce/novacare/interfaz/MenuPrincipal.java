package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

import ec.edu.uce.novacare.DAO.*;

public class MenuPrincipal {

    private Scanner scanner = new Scanner(System.in);
    private UsuarioDAO usuarioDAO;
    private DAO dao;
    public MenuPrincipal(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
        this.dao = new TipoServicioDAOMemoriaImpl();
    }
    public MenuPrincipal(DAO dao){
        this.dao = dao;
    }

    public void mostrarMenu() {

        int opcion;

        do {

            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Gestionar perfil de usuario");
            System.out.println("2. Gestionar citas");
            System.out.println("3. Gestionar servicios");
            System.out.println("4. Gestionar disponibilidad de citas");
            System.out.println("5. Gestionar agenda de citas");
            System.out.println("6. Gestionar reportes de citas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Error: solo puede ingresar números");
                scanner.next();
                System.out.print("Seleccione una opcion: ");
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:
                    System.out.println("Gestionando perfil de usuario...");

                    MenuGestionarPerfil menuPerfil = new MenuGestionarPerfil(usuarioDAO);
                    menuPerfil.mostrarMenu();

                    break;

                case 2:
                    System.out.println("Gestionando citas...");

                    MenuGestionarCitas menuCitas = new MenuGestionarCitas(usuarioDAO);
                    menuCitas.mostrarMenu();

                    break;

                case 3:
                    System.out.println("Gestionando servicios...");

                    MenuGestionarServicios menuServicios = new MenuGestionarServicios(dao);
                    menuServicios.mostrarMenu();

                    break;

                case 4:
                    System.out.println("Gestionando disponibilidad de citas...");

                    MenuGestionarDisponibilidad menuDisp = new MenuGestionarDisponibilidad(usuarioDAO);
                    menuDisp.mostrarMenu();
                    break;

                case 5:
                    System.out.println("Gestionando agenda de citas...");

                    MenuGestionarAgenda menuAgenda = new MenuGestionarAgenda(usuarioDAO);
                    menuAgenda.mostrarMenu();
                    break;

                case 6:
                    System.out.println("Gestionando reportes de citas...");

                    MenuGestionarReportes menuReportes = new MenuGestionarReportes(usuarioDAO);
                    menuReportes.mostrarMenu();
                    break;

                case 0:
                    System.out.println("Regresando a pantalla de inicio...");
                    MenuIngresarSistema menuIngresarSistema = new MenuIngresarSistema(usuarioDAO);
                    menuIngresarSistema.mostrarMenu();
                    break;


                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }
}
