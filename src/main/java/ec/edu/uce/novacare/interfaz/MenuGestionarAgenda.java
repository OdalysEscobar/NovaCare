package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

public class MenuGestionarAgenda {

    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("===== GESTIONAR AGENDA DE CITAS =====");
            System.out.println("1. Crear cita en agenda");
            System.out.println("2. Actualizar cita en agenda");
            System.out.println("3. Consultar agenda");
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

                    System.out.println("Creando cita en agenda...");
                    break;

                case 2:

                    System.out.println("Actualizando cita en agenda...");
                    break;

                case 3:

                    System.out.println("Consultando agenda...");
                    break;

                case 0:

                    System.out.println("Regresando al menú principal...");
                    MenuPrincipal menuPrincipal = new MenuPrincipal();
                    menuPrincipal.mostrarMenu();
                    return;

                default:

                    System.out.println("Opción inválida.");
                    break;
            }

        } while (opcion != 0);
    }
}