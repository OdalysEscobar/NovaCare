package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

public class MenuPrincipal {

    private Scanner scanner = new Scanner(System.in);

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

            switch (opcion) {

                case 1:
                    System.out.println("Gestionando perfil de usuario...");

                    MenuGestionarPerfil menuPerfil = new MenuGestionarPerfil();
                    menuPerfil.mostrarMenu();

                    break;

                case 2:
                    System.out.println("Gestionando citas...");

                    MenuGestionarCitas menuCitas = new MenuGestionarCitas();
                    menuCitas.mostrarMenu();

                    break;

                case 3:
                    System.out.println("Gestionando servicios...");
                    break;

                case 4:
                    System.out.println("Gestionando disponibilidad de citas...");
                    break;

                case 5:
                    System.out.println("Gestionando agenda de citas...");
                    break;

                case 6:
                    System.out.println("Gestionando reportes de citas...");
                    break;

                case 0:
                    System.out.println("Regresando a pantalla de inicio...");
                    MenuIngresarSistema menuIngresarSistema = new MenuIngresarSistema();
                    menuIngresarSistema.mostrarMenu();
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
