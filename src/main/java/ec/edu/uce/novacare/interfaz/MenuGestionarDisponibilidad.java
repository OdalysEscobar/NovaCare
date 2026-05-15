package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

import ec.edu.uce.novacare.util.Validaciones;


public class MenuGestionarDisponibilidad {

    private Scanner scanner = new Scanner(System.in);
    String fecha = "2026-05-20";
    String horaInicio = "09:00";
    String horaFin = "17:00";
    String estado = "Disponible";


    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("===== GESTIONAR DISPONIBILIDAD DE CITAS =====");
            System.out.println("1. Crear disponibilidad");
            System.out.println("2. Actualizar disponibilidad");
            System.out.println("3. Consultar disponibilidad");
            System.out.println("4. Eliminar disponibilidad");
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
                    crearDisponibilidad();
                    break;

                case 2:
                    actualizarDisponibilidad();
                    break;

                case 3:
                    consultarDisponibilidad();
                    break;

                case 4:
                    eliminarDisponibilidad();
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

    public void crearDisponibilidad() {
        System.out.println("\n--- Nueva Disponibilidad ---");
        ingresarDatosDisponibilidad();
        System.out.println("Disponibilidad registrada correctamente.");
    }

    public void consultarDisponibilidad() {
        if (fecha.isEmpty()) {
            System.out.println("\nNo hay horarios de disponibilidad registrados.");
        } else {
            System.out.println("\n===== DISPONIBILIDAD ACTUAL =====");
            System.out.println("Fecha: " + fecha);
            System.out.println("Hora Inicio: " + horaInicio);
            System.out.println("Hora Fin: " + horaFin);
            System.out.println("Estado: " + estado);
        }
    }

    public void actualizarDisponibilidad() {
        if (fecha.isEmpty()) {
            System.out.println("\nNo existe registro para actualizar.");
            return;
        }
        System.out.println("\n--- Actualizar Horarios ---");
        ingresarDatosDisponibilidad();
        System.out.println("Horarios actualizados correctamente.");
    }

    public void eliminarDisponibilidad() {
        String confirmacion;
        do {
            System.out.print("¿Desea eliminar esta disponibilidad? (si/no): ");
            confirmacion = scanner.nextLine();
            if (!confirmacion.equalsIgnoreCase("si") && !confirmacion.equalsIgnoreCase("no")) {
                System.out.println("Error: solo puede ingresar si o no.");
            }
        } while (!confirmacion.equalsIgnoreCase("si") && !confirmacion.equalsIgnoreCase("no"));

        if (confirmacion.equalsIgnoreCase("si")) {
            fecha = "";
            horaInicio = "";
            horaFin = "";
            estado = "";
            System.out.println("Disponibilidad eliminada correctamente.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    private void ingresarDatosDisponibilidad() {
        // Validar Fecha (AAAA-MM-DD)
        do {
            System.out.print("Ingrese fecha (AAAA-MM-DD): ");
            fecha = scanner.nextLine();
            if (!Validaciones.validarFecha(fecha)) {
                System.out.println("Error: Formato de fecha inválido.");
            }
        } while (!Validaciones.validarFecha(fecha));

        // Validar Horas (HH:MM)
        do {
            System.out.print("Ingrese hora de inicio (HH:MM): ");
            horaInicio = scanner.nextLine();
            if (!Validaciones.validarHora(horaInicio)) {
                System.out.println("Error: Formato de hora inválido.");
            }
        } while (!Validaciones.validarHora(horaInicio));

        do {
            System.out.print("Ingrese hora de fin (HH:MM): ");
            horaFin = scanner.nextLine();
            if (!Validaciones.validarHora(horaFin)) {
                System.out.println("Error: Formato de hora inválido.");
            }
        } while (!Validaciones.validarHora(horaFin));

        // Estado (Disponible/Ocupado)
        do {
            System.out.print("Ingrese estado (Disponible/Ocupado): ");
            estado = scanner.nextLine();
            if (estado.trim().isEmpty()) {
                System.out.println("Error: El estado no puede estar vacío.");
            }
        } while (estado.trim().isEmpty());
    }



}