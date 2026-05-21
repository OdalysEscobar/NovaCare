package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

import ec.edu.uce.novacare.util.Validaciones;

public class MenuGestionarPerfil {

    private Scanner scanner = new Scanner(System.in);

    public String nombre = "";
    public String apellido = "";
    public String correo = "";
    public String contrasena = "";

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n===== GESTIONAR PERFIL =====");
            System.out.println("1. Crear perfil");
            System.out.println("2. Consultar perfil");
            System.out.println("3. Actualizar perfil");
            System.out.println("4. Eliminar perfil");
            System.out.println("0. Volver al menú principal");

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

                    crearPerfil();
                    break;

                case 2:

                    consultarPerfil();
                    break;

                case 3:

                    actualizarPerfil();
                    break;

                case 4:
                    eliminarPerfil();
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

    // Crear perfil
    public void crearPerfil(){

        System.out.println("=== CREAR PERFIL ===");

        // Nombre
        do{
            System.out.println("Ingrese nuevo nombre: ");

            nombre = scanner.nextLine();

            if (!Validaciones.validarLetras(nombre)){
                System.out.println("Error: solo letras.");
            }
            ///

        } while(!Validaciones.validarLetras(nombre));

        // Apellido
        do{
            System.out.println("\nIngrese nuevo apellido: ");
            apellido = scanner.nextLine();

            if (!Validaciones.validarLetras(apellido)){
                System.out.println("Error: solo letras.");
            }
        } while(!Validaciones.validarLetras(apellido));

        // Correo
        do{
            System.out.println("Ingrese nuevo correo: ");
            correo = scanner.nextLine();

            if (!Validaciones.validarCorreo(correo)){
                System.out.println("Correo inválido.");
            }

        } while(!Validaciones.validarCorreo(correo));

        // Contraseña
        do{
            System.out.println("Ingrese nueva contraseña: ");
            contrasena = scanner.nextLine();

            if(!Validaciones.validarContrasena(contrasena)){
                System.out.println("Contraseña inválida, solo letras y números");
            }

        } while(!Validaciones.validarContrasena(contrasena));


    }

    // Consultar perfil
    public void consultarPerfil(){

        if (nombre.equals("")){

            System.out.println("No existe un perfil registrado.");
            return;
        }

        System.out.println("\n===== PERFIL =====");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Correo: " + correo);
    }

    // Actualizar Perfil
    public void actualizarPerfil(){

        if (nombre.equals("")){

            System.out.println("No existe un perfil registrado.");
            return;
        }

        System.out.println("=== ACTUALIZAR PERFIL ===");
        crearPerfil();
        System.out.println("Perfil actualizado correctamente.");
    }

    // Eliminar Perfil
    public void eliminarPerfil(){
        String confirmacion;

        if (nombre.equals("")){

            System.out.println("No existe un perfil registrado.");
            return;
        }

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
}

