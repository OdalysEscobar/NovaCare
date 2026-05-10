package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuIngresarSistema {

    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {

        int opcion;
        String correo;
        String contrasena;

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

                    System.out.println("Ingrese su correo: ");

                    scanner.nextLine();


                    correo = scanner.nextLine();


                    System.out.println("Ingrese su contraseña: ");

                    contrasena = scanner.nextLine();

                    boolean checkCorreo= validarCorreo(correo);
                    boolean checkContrasena= validarContrasena(contrasena);

                    if(!checkContrasena || !checkCorreo){
                        if(!checkContrasena && !checkCorreo){
                            System.out.println("Contrasena y correo, no cumplen con los formatos.");
                            break;
                        }
                        if(!checkCorreo){
                            System.out.println("Correo con formato incorrecto ");
                            break;
                        }
                        if(!checkContrasena){
                            System.out.println("Contraseña inválida, solo se permmite numeros y letras");
                            break;
                        }


                    }
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


    public boolean validarContrasena(String contrasena){

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");

        Matcher matcher = pattern.matcher(contrasena);

        return matcher.matches();
    }

    public boolean validarCorreo (String correo){
        Pattern pattern = Pattern.compile(
                "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"
        );

        Matcher matcher = pattern.matcher(correo);

        return  matcher.matches();
    }
}
