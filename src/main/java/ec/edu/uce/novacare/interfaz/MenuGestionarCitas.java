package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

public class MenuGestionarCitas {

    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("===== GESTIONAR CITAS =====");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrar un nuevo usuario");
            System.out.println("0. Volver al menú principal");

            System.out.println("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Error: solo puede ingresar números");
                scanner.next();
                System.out.print("Seleccione una opcion: ");
            }

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:

                    System.out.println("Iniciando sesión...");
                    break;

                case 2:

                    System.out.println("Registrando usuario...");
                    break;

                case 0:

                    System.out.println("Regresando al menú principal...");
                    return;

                default:

                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);


    }
}
