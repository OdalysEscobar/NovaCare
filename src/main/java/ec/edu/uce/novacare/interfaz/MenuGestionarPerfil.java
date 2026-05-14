package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuGestionarPerfil {

    private Scanner scanner = new Scanner(System.in);

    String nombre = "Cristhian";
    String apellido = "Vinueza";
    String correo = "cristhian12@gmail.com";
    String contrasena = "cv0319";

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n===== GESTIONAR PERFIL =====");
            System.out.println("1. Consultar perfil");
            System.out.println("2. Actualizar perfil");
            System.out.println("3. Eliminar perfil");
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

                    consultarPerfil();
                    break;

                case 2:

                    actualizarPerfil();
                    break;

                case 3:
                    eliminarPerfil();
                    break;

                case 4:

                    System.out.println("Eliminando perfil de usuario...");
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
    // Consultar perfil
    public void consultarPerfil(){
        System.out.println("\n===== PERFIL =====");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Correo: " + correo);
    }

    // Actualizar Perfil
    public void actualizarPerfil(){
        String nuevoNombre;
        String nuevoApellido;
        String nuevoCorreo;
        String nuevaContrasena;

        // Nombre
        do{
            System.out.println("Ingrese nuevo nombre: ");
            nuevoNombre = scanner.nextLine();

            if (!validarNombre(nuevoNombre)){
                System.out.println("Error: solo letras.");
            }
        } while(!validarNombre(nuevoNombre));

        // Apellido
        do{
            System.out.println("Ingrese nuevo apellido: ");
            nuevoApellido = scanner.nextLine();

            if (!validarNombre(nuevoApellido)){
                System.out.println("Error: solo letras.");
            }
        } while(!validarApellido(nuevoApellido));

        // Correo
        do{
            System.out.println("Ingrese nuevo correo: ");
            nuevoCorreo = scanner.nextLine();

            if (!validarCorreo(nuevoCorreo)){
                System.out.println("Correo inválido.");
            }

        } while(!validarCorreo(nuevoCorreo));

        // Contraseña
        do{
            System.out.println("Ingrese nueva contraseña: ");
            nuevaContrasena = scanner.nextLine();

            if(!validarContrasena(nuevaContrasena)){
                System.out.println("Contraseña inválida, solo letras y números");
            }

        } while(!validarContrasena(nuevaContrasena));

        nombre = nuevoNombre;
        apellido = nuevoApellido;
        correo = nuevoCorreo;
        contrasena = nuevaContrasena;

        System.out.println("\nPerfil actualizado correctamente.");
    }

    // Eliminar Perfil
    public void eliminarPerfil(){
        String confirmacion;

        do{
            System.out.println("¿Desea eliminar el perfil? (si/no): ");
            confirmacion = scanner.nextLine();

            if(!confirmacion.equalsIgnoreCase("si") && !confirmacion.equalsIgnoreCase("no")){
                System.out.println("Error: solo puede ingresar si o no.");
            }
        }while (!confirmacion.equalsIgnoreCase("si") && !confirmacion.equalsIgnoreCase("no"));

        if (confirmacion.equalsIgnoreCase("si")){
            nombre = "";
            apellido = "";
            correo = "";
            contrasena = "";

            System.out.println("Perfil eliminado correctamente.");
        } else{
            System.out.println("Operación cancelada");
        }
    }

    // Validar Nombre
    public boolean validarNombre(String nombre) {
        Pattern pattern = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚ]+");

        Matcher matcher = pattern.matcher(nombre);

        return matcher.matches();
    }

    // Validar Apellido
    public boolean validarApellido(String apellido) {
        Pattern pattern = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚ]+");

        Matcher matcher = pattern.matcher(apellido);

        return matcher.matches();
    }


    // Validar Correo
    public boolean validarCorreo(String correo){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

        Matcher matcher = pattern.matcher(correo);

        return matcher.matches();
    }

    // Validar Contraseña
    public boolean validarContrasena(String contrasena){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");

        Matcher matcher = pattern.matcher(contrasena);

        return matcher.matches();
    }
}

