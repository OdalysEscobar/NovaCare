package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MenuGestionarReportes {

    private Scanner scanner = new Scanner(System.in);

    int numeroCitasPorDia = 5;
    int numeroCitasPorSemana = 20;
    int numeroCitasPorMes = 80;
    int numeroCitasCanceladas = 3;

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("\n===== GESTIONAR REPORTES DE CITAS =====");
            System.out.println("1. Consultar reporte diario");
            System.out.println("2. Consultar reporte semanal");
            System.out.println("3. Consultar reporte mensual");
            System.out.println("4. Consultar reporte de citas canceladas");
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
                    consultarReporteDiario();
                    break;

                case 2:
                    consultarReporteSemanal();
                    break;

                case 3:
                    consultarReporteMensual();
                    break;

                case 4:
                    consultarReporteCanceladas();
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

    // Consultar Reporte Diario
    public void consultarReporteDiario() {
        String fecha;

        scanner.nextLine();

        do {
            System.out.println("Ingrese la fecha del reporte (DD/MM/AAAA): ");
            fecha = scanner.nextLine();

            if (!validarFecha(fecha)) {
                System.out.println("Error: formato de fecha inválido. Use DD/MM/AAAA");
            }
        } while (!validarFecha(fecha));

        System.out.println("\n===== REPORTE DIARIO =====");
        System.out.println("Fecha: " + fecha);
        System.out.println("Total de citas del día: " + numeroCitasPorDia);
    }

    // Consultar Reporte Semanal
    public void consultarReporteSemanal() {
        String semana;

        scanner.nextLine();

        do {
            System.out.println("Ingrese la semana del reporte (DD/MM/AAAA): ");
            semana = scanner.nextLine();

            if (!validarFecha(semana)) {
                System.out.println("Error: formato de fecha inválido. Use DD/MM/AAAA");
            }
        } while (!validarFecha(semana));

        System.out.println("\n===== REPORTE SEMANAL =====");
        System.out.println("Semana desde: " + semana);
        System.out.println("Total de citas de la semana: " + numeroCitasPorSemana);
    }

    // Consultar Reporte Mensual
    public void consultarReporteMensual() {
        String mes;

        scanner.nextLine();

        do {
            System.out.println("Ingrese el mes del reporte (MM/AAAA): ");
            mes = scanner.nextLine();

            if (!validarMes(mes)) {
                System.out.println("Error: formato de mes inválido. Use MM/AAAA");
            }
        } while (!validarMes(mes));

        System.out.println("\n===== REPORTE MENSUAL =====");
        System.out.println("Mes: " + mes);
        System.out.println("Total de citas del mes: " + numeroCitasPorMes);
    }

    // Consultar Reporte de Citas Canceladas
    public void consultarReporteCanceladas() {
        System.out.println("\n===== REPORTE DE CITAS CANCELADAS =====");
        System.out.println("Total de citas canceladas: " + numeroCitasCanceladas);
    }

    // Validar fecha DD/MM/AAAA
    public boolean validarFecha(String fecha) {
        Pattern pattern = Pattern.compile("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");
        Matcher matcher = pattern.matcher(fecha);
        return matcher.matches();
    }

    // Validar mes MM/AAAA
    public boolean validarMes(String mes) {
        Pattern pattern = Pattern.compile("^[0-9]{2}/[0-9]{4}$");
        Matcher matcher = pattern.matcher(mes);
        return matcher.matches();
    }
}