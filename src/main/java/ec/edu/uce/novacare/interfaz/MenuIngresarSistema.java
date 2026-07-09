package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

import ec.edu.uce.novacare.DAO.UsuarioDAO;

public class MenuIngresarSistema {

    private UsuarioDAO usuarioDAO;
    private Scanner scanner = new Scanner(System.in);

    private IniciarSesion iniciarSesion;
    private RegistrarUsuario registrarUsuario;

    public MenuIngresarSistema(UsuarioDAO usuarioDAO){
        this.usuarioDAO = usuarioDAO;
        this.iniciarSesion = new IniciarSesion(usuarioDAO);
        this.registrarUsuario = new RegistrarUsuario();
    }

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
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    if(iniciarSesion.login()==true){
                        System.out.println("Iniciando sesión...");
                        MenuPrincipal menuPrincipal = new MenuPrincipal(usuarioDAO);
                        menuPrincipal.mostrarMenu();
                    }
                    break;

                case 2:

                    if(registrarUsuario.guardarUsuario()){
                        System.out.println("Usuario creado exitosamente2");
                        MenuPrincipal menuprincipal = new MenuPrincipal(usuarioDAO);
                        menuprincipal.mostrarMenu();
                    }else{
                        System.out.println("No pude hacer Magea, su usuario ya existe...");

                    }


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
