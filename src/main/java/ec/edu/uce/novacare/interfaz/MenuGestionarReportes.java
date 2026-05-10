package ec.edu.uce.novacare.interfaz;

import ec.edu.uce.novacare.dominio.Agenda;
import ec.edu.uce.novacare.dominio.Cita;
import ec.edu.uce.novacare.dominio.Cliente;
import ec.edu.uce.novacare.dominio.Empleado;
import ec.edu.uce.novacare.dominio.Reporte;
import ec.edu.uce.novacare.dominio.Servicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuGestionarReportes {

    private final Scanner scanner = new Scanner(System.in);
    private final List<Cita> todasLasCitas = new ArrayList<>();
    private final Empleado empleado = new Empleado();

    public MenuGestionarReportes() {
        // Datos de muestra usando los constructores exactos del dominio
        Cliente c1 = new Cliente("Ana", "Torres", "1234", "ana@email.com", new ArrayList<>());
        Cliente c2 = new Cliente("Luis", "Mora", "4321", "luis@email.com", new ArrayList<>());
        Servicio s1 = new Servicio("Corte de cabello", 30, true);
        Servicio s2 = new Servicio("Tinte completo", 120, true);

        todasLasCitas.add(new Cita("10/05/2026", null, c1, s1, "09:00"));
        todasLasCitas.add(new Cita("10/05/2026", null, c2, s2, "11:00"));
        todasLasCitas.add(new Cita("09/05/2026", null, c1, s2, "10:00"));
        todasLasCitas.add(new Cita("01/05/2026", null, c2, s1, "14:00"));
        todasLasCitas.add(new Cita("03/05/2026", null, c1, s1, "16:00"));
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== GESTIONAR REPORTES DE CITAS =====");
            System.out.println("1. Reporte diario");
            System.out.println("2. Reporte semanal");
            System.out.println("3. Reporte mensual");
            System.out.println("4. Reporte de citas canceladas");
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
                case 1: generarReporteDiario(); break;
                case 2: generarReporteSemanal(); break;
                case 3: generarReporteMensual(); break;
                case 4: generarReporteCanceladas(); break;
                case 0: System.out.println("Volviendo al menu principal..."); break;
                default: System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private void generarReporteDiario() {
        System.out.print("Ingrese la fecha (DD/MM/AAAA): ");
        String fecha = scanner.nextLine().trim();
        if (fecha.isEmpty()) {
            System.out.println("Error: la fecha es obligatoria.");
            return;
        }

        List<Cita> citasDia = new ArrayList<>();
        for (Cita c : todasLasCitas) {
            if (c.getFecha() != null && c.getFecha().equals(fecha)) {
                citasDia.add(c);
            }
        }

        Reporte reporte = new Reporte(empleado, citasDia, citasDia.size(), 0, 0, 0);
        System.out.println("\n--- REPORTE DIARIO: " + fecha + " ---");
        mostrarReporte(reporte);
    }

    private void generarReporteSemanal() {
        System.out.print("Ingrese el mes de la semana (MM/AAAA): ");
        String mesAnio = scanner.nextLine().trim();
        if (mesAnio.isEmpty()) {
            System.out.println("Error: el mes es obligatorio.");
            return;
        }

        List<Cita> citasSemana = new ArrayList<>();
        for (Cita c : todasLasCitas) {
            // fecha formato DD/MM/AAAA — extraer MM/AAAA desde indice 3
            if (c.getFecha() != null && c.getFecha().length() >= 7
                    && c.getFecha().substring(3).equals(mesAnio)) {
                citasSemana.add(c);
            }
        }

        Reporte reporte = new Reporte(empleado, citasSemana, 0, citasSemana.size(), 0, 0);
        System.out.println("\n--- REPORTE SEMANAL: " + mesAnio + " ---");
        mostrarReporte(reporte);
    }

    private void generarReporteMensual() {
        System.out.print("Ingrese el mes (MM/AAAA): ");
        String mesAnio = scanner.nextLine().trim();
        if (mesAnio.isEmpty()) {
            System.out.println("Error: el mes es obligatorio.");
            return;
        }

        List<Cita> citasMes = new ArrayList<>();
        for (Cita c : todasLasCitas) {
            // fecha formato DD/MM/AAAA — extraer MM/AAAA desde indice 3
            if (c.getFecha() != null && c.getFecha().length() >= 7
                    && c.getFecha().substring(3).equals(mesAnio)) {
                citasMes.add(c);
            }
        }

        Reporte reporte = new Reporte(empleado, citasMes, 0, 0, citasMes.size(), 0);
        System.out.println("\n--- REPORTE MENSUAL: " + mesAnio + " ---");
        mostrarReporte(reporte);
    }

    private void generarReporteCanceladas() {
        // En este modelo no hay campo "estado" en Cita,
        // se muestra el reporte con el contador numeroCitasCancelas
        System.out.print("Ingrese numero de citas canceladas a registrar: ");
        while (!scanner.hasNextInt()) { scanner.next(); }
        int canceladas = scanner.nextInt();
        scanner.nextLine();

        Reporte reporte = new Reporte(empleado, new ArrayList<>(), 0, 0, 0, canceladas);
        System.out.println("\n--- REPORTE DE CITAS CANCELADAS ---");
        System.out.println(reporte);
    }

    private void mostrarReporte(Reporte reporte) {
        if (reporte.getCitas() == null || reporte.getCitas().isEmpty()) {
            System.out.println("No hay datos disponibles para este reporte.");
            return;
        }
        for (int i = 0; i < reporte.getCitas().size(); i++) {
            System.out.println((i + 1) + ". " + reporte.getCitas().get(i));
        }
        System.out.println("-----------------------------------");
        System.out.println(reporte);
    }
}