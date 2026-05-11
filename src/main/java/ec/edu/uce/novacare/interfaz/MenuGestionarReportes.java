package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

public class MenuGestionarReportes {

    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("===== GESTIONAR REPORTES DE CITAS =====");
            System.out.println("1. Consultar reporte diario");
            System.out.println("2. Consultar reporte semanal");
            System.out.println("3. Consultar reporte mensual");
            System.out.println("4. Consultar reporte de citas canceladas");
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

                    System.out.println("Consultando reporte diario...");
                    break;

                case 2:

                    System.out.println("Consultando reporte semanal...");
                    break;

                case 3:

                    System.out.println("Consultando reporte mensual...");
                    break;

                case 4:

                    System.out.println("Consultando reporte de citas canceladas...");
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