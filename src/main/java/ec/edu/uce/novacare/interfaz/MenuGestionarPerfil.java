package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

public class MenuGestionarPerfil {

    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("===== MENU: GESTIONAR PERFIL =====");
            System.out.println("1. Crear perfil de usuario");
            System.out.println("2. Actualizar perfil de usuario");
            System.out.println("3. Consultar perfil de usuario");
            System.out.println("4. Eliminar perfil de usuario");
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

                case 3:
                    System.out.println("Registrando usuario...");
                    break;

                case 4:

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
