package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

public class MenuGestionarCitas {

    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("===== GESTIONAR CITAS =====");
            System.out.println("1. Crear Cita");
            System.out.println("2. Actualizar Citas");
            System.out.println("3. Consultar Citas");
            System.out.println("4. Cancelar Citas");
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

                    System.out.println("Creando Cita...");
                    break;

                case 2:

                    System.out.println("Actualizando cita...");
                    break;

                case 3:

                    System.out.println("Consultando cita...");
                    break;

                case 4:

                    System.out.println("Cancelando cita...");
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
