package ec.edu.uce.novacare.interfaz;

import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.DAO.UsuarioDAOFabrica;
import ec.edu.uce.novacare.dominio.Usuario;
import ec.edu.uce.novacare.dominio.Cliente;
import java.util.Scanner;

import ec.edu.uce.novacare.util.Validaciones;

public class MenuGestionarPerfil {

    private Scanner scanner = new Scanner(System.in);
    private UsuarioDAO dao = new UsuarioDAOFabrica().crearUsuarioDAO();

    public String nombre = "";
    public String apellido = "";
    public String correo = "";
    public String contrasena = "";
    public String telefono = "";

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

        do{
            System.out.println("Ingrese teléfono:");
            telefono = scanner.nextLine();

            if(!Validaciones.validarTelefono(telefono)){
                System.out.println("Teléfono inválido.");
            }

        }while(!Validaciones.validarTelefono(telefono));

        Cliente cliente = new Cliente(
                nombre,
                apellido,
                contrasena,
                correo,
                telefono);

        if(dao.nuevo(cliente)){
            System.out.println("Perfil creado correctamente.");
        }else{
            System.out.println("Ya existe un usuario con ese correo.");
        }
    }

    // Consultar perfil
    public void consultarPerfil(){

        System.out.println("Ingrese el correo del usuario:");
        correo = scanner.nextLine();

        Usuario usuario = dao.buscarPorCorreo(correo);

        if(usuario != null){
            System.out.println(usuario);
        }else{
            System.out.println("Usuario no encontrado.");
        }
    }

    // Actualizar Perfil
    public void actualizarPerfil(){

        System.out.println("Ingrese el correo del usuario:");
        String correoBuscar = scanner.nextLine();

        Usuario usuario = dao.buscarPorCorreo(correoBuscar);

        if(usuario == null){
            System.out.println("Usuario no encontrado.");
            return;
        }

        do{
            System.out.println("Nuevo nombre:");
            nombre = scanner.nextLine();
        }while(!Validaciones.validarLetras(nombre));

        do{
            System.out.println("Nuevo apellido:");
            apellido = scanner.nextLine();
        }while(!Validaciones.validarLetras(apellido));

        do{
            System.out.println("Nuevo correo:");
            correo = scanner.nextLine();
        }while(!Validaciones.validarCorreo(correo));

        do{
            System.out.println("Nueva contraseña:");
            contrasena = scanner.nextLine();
        }while(!Validaciones.validarContrasena(contrasena));

        do{
            System.out.println("Nuevo teléfono:");
            telefono = scanner.nextLine();
        }while(!Validaciones.validarTelefono(telefono));

        Cliente nuevo = new Cliente(nombre, apellido, contrasena, correo, telefono);

        if(dao.editar(nuevo, correoBuscar)){
            System.out.println("Perfil actualizado correctamente.");
        }else{
            System.out.println("No fue posible actualizar.");
        }
    }

    // Eliminar Perfil
    public void eliminarPerfil(){
        String confirmacion;

        System.out.println("Ingrese el correo del usuario:");
        correo = scanner.nextLine();

        Usuario usuario = dao.buscarPorCorreo(correo);

        if (usuario == null) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        do {

            System.out.print("¿Está seguro de que desea eliminar el perfil? (si/no): ");
            confirmacion = scanner.nextLine();

            if (!confirmacion.equalsIgnoreCase("si")
                    && !confirmacion.equalsIgnoreCase("no")) {

                System.out.println("Error: solo puede ingresar 'si' o 'no'.");
            }

        } while (!confirmacion.equalsIgnoreCase("si")
                && !confirmacion.equalsIgnoreCase("no"));

        if (confirmacion.equalsIgnoreCase("si")) {

            if (dao.eliminar(correo)) {
                System.out.println("Perfil eliminado correctamente.");
            } else {
                System.out.println("No fue posible eliminar el perfil.");
            }

        } else {

            System.out.println("Operación cancelada.");

        }
    }
}

