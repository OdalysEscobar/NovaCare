package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

import ec.edu.uce.novacare.util.Validaciones;

public class MenuGestionarCitas {

    private Scanner scanner = new Scanner(System.in);

    String nombreUsuario = "";
    String tipoServicio = "";
    String fecha = "";
    String hora = "";

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("===== GESTIONAR CITAS =====");
            System.out.println("1. Crear Cita");
            System.out.println("2. Actualizar Cita");
            System.out.println("3. Consultar Cita");
            System.out.println("4. Cancelar Cita");
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

                    crearCita();
                    break;

                case 2:

                    actualizarCita();
                    break;

                case 3:

                    consultarCita();
                    break;

                case 4:

                    cancelarCita();
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

    // Crear Cita
    public void crearCita(){

        // Nombre
        do{
            System.out.println("Ingrese su nombre de usuario");
            nombreUsuario = scanner.nextLine();

            if (!Validaciones.validarLetras(nombreUsuario)){
                System.out.println("Error: solo letras.");
            }
        } while (!Validaciones.validarLetras(nombreUsuario));

        // tipoServicio
        do{
            System.out.println("Ingrese el servicio que desea: ");
            tipoServicio = scanner.nextLine();

            if (!Validaciones.validarLetras(tipoServicio)){
                System.out.println("Error: solo letras.");
            }
        } while (!Validaciones.validarLetras(tipoServicio));

        //fecha
        do{
            System.out.println("Ingrese la fecha (AAAA-MM-DD)");
            fecha = scanner.next();

            if (!Validaciones.validarFecha(fecha)){
                System.out.println("Fecha inválida.");
            }
        } while (!Validaciones.validarFecha(fecha));

        //hora
        do{
            System.out.println("Ingrese la hora (HH:MM): ");
            hora = scanner.next();

            if (!Validaciones.validarHora(hora)){
                System.out.println("Hora inválida.");
            }
        } while(!Validaciones.validarHora(hora));

        System.out.println("Cita creada correctamente.");

    }

    // Actualizar Cita
    public void actualizarCita(){

        if (nombreUsuario.equals("")){
            System.out.println("No existe una cita resgitrada.");
            return;
        }

        System.out.println("==== ACTUALIZAR CITA ====");
        crearCita();
        consultarCita();

        System.out.println("\nCita actualizada correctamente.");


    }

    // Consultar Cita
    public void consultarCita(){

        if(nombreUsuario.equals("")){

            System.out.println("No existe una cita registrada.");
            return;
        }

        System.out.println("\n===== DATOS DE LA CITA =====");
        System.out.println("Nombre: " + nombreUsuario);
        System.out.println("Servicio: " + tipoServicio);
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);

    }

    // Cancelar Cita
    public void cancelarCita(){

        String confirmacion;

        if (nombreUsuario.equals("")){

            System.out.println("No existe una cita registrada ");
            return;
        }
        do{
            System.out.println("¿Desea cancelar la cita? (si/no): ");
            confirmacion = scanner.next();

            if (!confirmacion.equalsIgnoreCase("si") && !confirmacion.equalsIgnoreCase("no")){

                System.out.println("Error: solo puede ingresar si o no.");
            }
        } while (!confirmacion.equalsIgnoreCase("si") && !confirmacion.equalsIgnoreCase("no"));

            if(confirmacion.equalsIgnoreCase("si")){
                nombreUsuario = "";
                tipoServicio = "";
                fecha = "";
                hora = "";

                System.out.println("Cita cancelada correctamente.");
            } else {
                System.out.println("Operación cancelada.");
            }
    }

}
