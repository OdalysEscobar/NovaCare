package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ec.edu.uce.novacare.util.Validaciones;

public class MenuGestionarAgenda {

    private Scanner scanner = new Scanner(System.in);

    String nombreCliente = "Ana Torres";
    String fecha = "10/05/2026";
    String hora = "09:00";
    String servicio = "Corte de cabello";
    String estado = "Pendiente";

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n===== GESTIONAR AGENDA DE CITAS =====");
            System.out.println("1. Consultar agenda");
            System.out.println("2. Crear cita en agenda");
            System.out.println("3. Actualizar cita en agenda");
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
                    consultarAgenda();
                    break;

                case 2:
                    crearCitaAgenda();
                    break;

                case 3:
                    actualizarCitaAgenda();
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

    // Consultar Agenda
    public void consultarAgenda() {
        System.out.println("\n===== AGENDA =====");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
        System.out.println("Servicio: " + servicio);
        System.out.println("Estado: " + estado);
    }

    // Crear Cita en Agenda
    public void crearCitaAgenda() {
        String nuevoCliente;
        String nuevaFecha;
        String nuevaHora;
        String nuevoServicio;
        String nuevoEstado;

        scanner.nextLine();

        // Nombre cliente
        do {
            System.out.println("Ingrese el nombre del cliente: ");
            nuevoCliente = scanner.nextLine();

            if (!Validaciones.validarLetras(nuevoCliente)) {
                System.out.println("Error: el nombre solo puede contener letras.");
            }
        } while (!Validaciones.validarLetras(nuevoCliente));

        // Fecha
        do {
            System.out.println("Ingrese la fecha (AAAA/MM/DD): ");
            nuevaFecha = scanner.nextLine();

            if (!Validaciones.validarFecha(nuevaFecha)) {
                System.out.println("Error: formato de fecha inválido. Use AAAA/MM/DD");
            }
        } while (!Validaciones.validarFecha(nuevaFecha));

        // Hora
        do {
            System.out.println("Ingrese la hora (HH:MM): ");
            nuevaHora = scanner.nextLine();

            if (!Validaciones.validarHora(nuevaHora)) {
                System.out.println("Error: formato de hora inválido. Use HH:MM");
            }
        } while (!Validaciones.validarHora(nuevaHora));

        // Servicio
        do {
            System.out.println("Ingrese el servicio: ");
            nuevoServicio = scanner.nextLine();

            if (!Validaciones.validarLetras(nuevoServicio)) {
                System.out.println("Error: el servicio solo puede contener letras.");
            }
        } while (!Validaciones.validarLetras(nuevoServicio));

        // Estado
        do {
            System.out.println("Ingrese el estado (Pendiente/Confirmada/Reprogramada): ");
            nuevoEstado = scanner.nextLine();

            if (!validarEstado(nuevoEstado)) {
                System.out.println("Error: ingrese Pendiente, Confirmada o Reprogramada.");
            }
        } while (!validarEstado(nuevoEstado));

        nombreCliente = nuevoCliente;
        fecha = nuevaFecha;
        hora = nuevaHora;
        servicio = nuevoServicio;
        estado = nuevoEstado;

        System.out.println("\nCita creada en agenda correctamente.");
    }

    // Actualizar Cita en Agenda
    public void actualizarCitaAgenda() {
        String nuevaFecha;
        String nuevaHora;
        String nuevoServicio;
        String nuevoEstado;

        scanner.nextLine();

        // Fecha
        do {
            System.out.println("Ingrese nueva fecha (AAAA/MM/DD): ");
            nuevaFecha = scanner.nextLine();

            if (!Validaciones.validarFecha(nuevaFecha)) {
                System.out.println("Error: formato de fecha inválido. Use AAAA/MM/DD");
            }
        } while (!Validaciones.validarFecha(nuevaFecha));

        // Hora
        do {
            System.out.println("Ingrese nueva hora (HH:MM): ");
            nuevaHora = scanner.nextLine();

            if (!Validaciones.validarHora(nuevaHora)) {
                System.out.println("Error: formato de hora inválido. Use HH:MM");
            }
        } while (!Validaciones.validarHora(nuevaHora));

        // Servicio
        do {
            System.out.println("Ingrese nuevo servicio: ");
            nuevoServicio = scanner.nextLine();

            if (!Validaciones.validarLetras(nuevoServicio)) {
                System.out.println("Error: el servicio solo puede contener letras.");
            }
        } while (!Validaciones.validarLetras(nuevoServicio));

        // Estado
        do {
            System.out.println("Ingrese nuevo estado (Pendiente/Confirmada/Reprogramada): ");
            nuevoEstado = scanner.nextLine();

            if (!validarEstado(nuevoEstado)) {
                System.out.println("Error: ingrese Pendiente, Confirmada o Reprogramada.");
            }
        } while (!validarEstado(nuevoEstado));

        fecha = nuevaFecha;
        hora = nuevaHora;
        servicio = nuevoServicio;
        estado = nuevoEstado;

        System.out.println("\nCita en agenda actualizada correctamente.");
    }

    // Validar estado de cita
    public boolean validarEstado(String estado) {
        return estado.equalsIgnoreCase("Pendiente") ||
                estado.equalsIgnoreCase("Confirmada") ||
                estado.equalsIgnoreCase("Reprogramada");
    }
}