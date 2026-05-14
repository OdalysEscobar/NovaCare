package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuIngresarSistema {

    private Scanner scanner = new Scanner(System.in);
    private IniciarSesion iniciarSesion = new IniciarSesion();
    private RegistrarUsuario registrarUsuario = new RegistrarUsuario();

    public void mostrarMenu() {

        int opcion;
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
                     if(iniciarSesion.login()==true){
                         System.out.println("Iniciando sesión...");
                         MenuPrincipal menuPrincipal = new MenuPrincipal();
                         menuPrincipal.mostrarMenu();
                     }
                    break;

                case 2:

                    registrarUsuario.guardarUsuario();
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
