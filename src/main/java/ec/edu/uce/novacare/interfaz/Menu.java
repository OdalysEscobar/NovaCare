package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

public class Menu {

    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE GESTIÓN =====");
            System.out.println("1. Ingresar al sistema");
            System.out.println("2. Gestionar perfil de usuario");
            System.out.println("3. Gestionar citas");
            System.out.println("4. Gestionar servicios");
            System.out.println("5. Gestionar disponibilidad de citas");
            System.out.println("6. Gestionar agenda de citas");
            System.out.println("7. Gestionar reportes de citas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();


            switch (opcion) {

                case 1:
                    System.out.println("Ingresando al sistema...");
                    break;

                case 2:
                    System.out.println("Gestionando perfil de usuario...");
                    break;

                case 3:
                    System.out.println("Gestionando citas...");
                    break;

                case 4:
                    System.out.println("Gestionando servicios...");
                    break;

                case 5:
                    System.out.println("Gestionando disponibilidad de citas...");
                    break;

                case 6:
                    System.out.println("Gestionando agenda de citas...");
                    break;

                case 7:
                    System.out.println("Gestionando reportes de citas...");
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}
