package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuGestionarAgenda {

    private Scanner scanner = new Scanner(System.in);

    String nombreCliente = "Ana Torres";
    String fecha = "10/05/2026";
    String hora = "09:00";
    String servicio = "Corte de cabello";

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
    }

    // Crear Cita en Agenda
    public void crearCitaAgenda() {
        String nuevoCliente;
        String nuevaFecha;
        String nuevaHora;
        String nuevoServicio;

        scanner.nextLine();

        // Nombre cliente
        do {
            System.out.println("Ingrese el nombre del cliente: ");
            nuevoCliente = scanner.nextLine();

            if (!validarTexto(nuevoCliente)) {
                System.out.println("Error: el nombre solo puede contener letras.");
            }
        } while (!validarTexto(nuevoCliente));

        // Fecha
        do {
            System.out.println("Ingrese la fecha (DD/MM/AAAA): ");
            nuevaFecha = scanner.nextLine();

            if (!validarFecha(nuevaFecha)) {
                System.out.println("Error: formato de fecha inválido. Use DD/MM/AAAA");
            }
        } while (!validarFecha(nuevaFecha));

        // Hora
        do {
            System.out.println("Ingrese la hora (HH:MM): ");
            nuevaHora = scanner.nextLine();

            if (!validarHora(nuevaHora)) {
                System.out.println("Error: formato de hora inválido. Use HH:MM");
            }
        } while (!validarHora(nuevaHora));

        // Servicio
        do {
            System.out.println("Ingrese el servicio: ");
            nuevoServicio = scanner.nextLine();

            if (!validarTexto(nuevoServicio)) {
                System.out.println("Error: el servicio solo puede contener letras.");
            }
        } while (!validarTexto(nuevoServicio));

        nombreCliente = nuevoCliente;
        fecha = nuevaFecha;
        hora = nuevaHora;
        servicio = nuevoServicio;

        System.out.println("\nCita creada en agenda correctamente.");
    }

    // Actualizar Cita en Agenda
    public void actualizarCitaAgenda() {
        String nuevaFecha;
        String nuevaHora;
        String nuevoServicio;

        scanner.nextLine();

        // Fecha
        do {
            System.out.println("Ingrese nueva fecha (DD/MM/AAAA): ");
            nuevaFecha = scanner.nextLine();

            if (!validarFecha(nuevaFecha)) {
                System.out.println("Error: formato de fecha inválido. Use DD/MM/AAAA");
            }
        } while (!validarFecha(nuevaFecha));

        // Hora
        do {
            System.out.println("Ingrese nueva hora (HH:MM): ");
            nuevaHora = scanner.nextLine();

            if (!validarHora(nuevaHora)) {
                System.out.println("Error: formato de hora inválido. Use HH:MM");
            }
        } while (!validarHora(nuevaHora));

        // Servicio
        do {
            System.out.println("Ingrese nuevo servicio: ");
            nuevoServicio = scanner.nextLine();

            if (!validarTexto(nuevoServicio)) {
                System.out.println("Error: el servicio solo puede contener letras.");
            }
        } while (!validarTexto(nuevoServicio));

        fecha = nuevaFecha;
        hora = nuevaHora;
        servicio = nuevoServicio;

        System.out.println("\nCita en agenda actualizada correctamente.");
    }

    // Validar texto (solo letras y espacios)
    public boolean validarTexto(String texto) {
        Pattern pattern = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚ ]+");
        Matcher matcher = pattern.matcher(texto);
        return matcher.matches();
    }

    // Validar fecha DD/MM/AAAA
    public boolean validarFecha(String fecha) {
        Pattern pattern = Pattern.compile("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");
        Matcher matcher = pattern.matcher(fecha);
        return matcher.matches();
    }

    // Validar hora HH:MM
    public boolean validarHora(String hora) {
        Pattern pattern = Pattern.compile("^([01]?[0-9]|2[0-3]):[0-5][0-9]$");
        Matcher matcher = pattern.matcher(hora);
        return matcher.matches();
    }
}