package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

public class MenuGestionarDisponibilidad {

    private final Scanner scanner = new Scanner(System.in);
    private final boolean[] horariosDisponibles = {
            true, true, false, true, true, false, true, false, true, true
    };
    private final String[] etiquetasHorario = {
            "08:00", "09:00", "10:00", "11:00", "12:00",
            "13:00", "14:00", "15:00", "16:00", "17:00"
    };


    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== GESTIONAR DISPONIBILIDAD DE CITAS =====");
            System.out.println("1. Consultar disponibilidad de horarios");
            System.out.println("2. Filtrar por hora");
            System.out.println("3. Activar / Desactivar horario (Dueno)");
            System.out.println("0. Volver al menu principal");
            System.out.print("Seleccione una opcion: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Error: solo puede ingresar numeros.");
                scanner.next();
                System.out.print("Seleccione una opcion: ");
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: consultarDisponibilidad(); break;
                case 2: filtrarPorHora(); break;
                case 3: gestionarHorario(); break;
                case 0: System.out.println("Volviendo al menu principal..."); break;
                default: System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private void consultarDisponibilidad() {
        System.out.println("\n--- Horarios del Dia ---");
        boolean hayDisponible = false;
        for (int i = 0; i < etiquetasHorario.length; i++) {
            String estado = horariosDisponibles[i] ? "[DISPONIBLE]" : "[OCUPADO]   ";
            System.out.println("[" + (i + 1) + "] " + etiquetasHorario[i] + "  " + estado);
            if (horariosDisponibles[i]) hayDisponible = true;
        }
        if (!hayDisponible) System.out.println("No hay horarios disponibles.");
    }

    private void filtrarPorHora() {
        System.out.print("Ingrese la hora a consultar (ej. 09:00): ");
        String hora = scanner.nextLine().trim();
        if (hora.isEmpty()) {
            System.out.println("Error: ingrese una hora.");
            return;
        }
        boolean encontrado = false;
        for (int i = 0; i < etiquetasHorario.length; i++) {
            if (etiquetasHorario[i].equals(hora)) {
                String estado = horariosDisponibles[i] ? "DISPONIBLE" : "OCUPADO";
                System.out.println("Horario " + hora + ": " + estado);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) System.out.println("No hay resultados para la hora '" + hora + "'.");
    }

    private void gestionarHorario() {
        consultarDisponibilidad();
        System.out.print("Numero del horario a modificar: ");
        while (!scanner.hasNextInt()) { scanner.next(); }
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx < 0 || idx >= etiquetasHorario.length) {
            System.out.println("Error: numero de horario invalido.");
            return;
        }
        horariosDisponibles[idx] = !horariosDisponibles[idx];
        String nuevoEstado = horariosDisponibles[idx] ? "DISPONIBLE" : "OCUPADO";
        System.out.println("Horario " + etiquetasHorario[idx] + " actualizado a: " + nuevoEstado);
    }
}