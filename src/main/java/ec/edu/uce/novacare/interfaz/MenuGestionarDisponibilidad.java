package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

public class MenuGestionarDisponibilidad {

    private Scanner scanner = new Scanner(System.in);


    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("===== GESTIONAR DISPONIBILIDAD DE CITAS =====");
            System.out.println("1. Crear disponibilidad");
            System.out.println("2. Actualizar disponibilidad");
            System.out.println("3. Consultar disponibilidad");
            System.out.println("4. Eliminar disponibilidad");
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

                    System.out.println("Creando disponibilidad...");
                    break;

                case 2:

                    System.out.println("Actualizando disponibilidad...");
                    break;

                case 3:

                    System.out.println("Consultando disponibilidad...");
                    break;

                case 4:

                    System.out.println("Eliminando disponibilidad...");
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