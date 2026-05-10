package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

public class MenuIngresarSistema {

    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {

        int opcion;
        String nomU;
        int numCon;

        do {
            System.out.println("===== BIENVENIDO A NOVACARE APP =====");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrar usuario");
            System.out.println("0. Salir");

            System.out.println("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Error: solo puede ingresar números");
                scanner.next();
                System.out.print("Seleccione una opcion: ");
            }

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:

                    System.out.println(" === Iniciar sesión ===");

                    System.out.println("Ingrese su usuario: ");

                    scanner.nextLine();

                    nomU = scanner.nextLine();

                    System.out.println("Ingrese su contraseña: ");

                    numCon = scanner.nextInt();

                    System.out.println("Iniciando sesión...");

                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.mostrarMenu();

                    break;

                case 2:

                    System.out.println("Registrando usuario...");

                    MenuPrincipal menuprincipal = new MenuPrincipal();
                    menuprincipal.mostrarMenu();

                    break;

                case 0:

                    System.out.println("Salir");
                    scanner.close();
                    System.exit(0);
                    return;

                default:

                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);
    }
}
