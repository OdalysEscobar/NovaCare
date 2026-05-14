package ec.edu.uce.novacare.interfaz;

import ec.edu.uce.novacare.dominio.Agenda;
import ec.edu.uce.novacare.dominio.Cita;
import ec.edu.uce.novacare.dominio.Cliente;
import ec.edu.uce.novacare.dominio.Servicio;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuGestionarAgenda {

    private final Scanner scanner = new Scanner(System.in);
    private final List<Cita> listaCitas = new ArrayList<>();
    private Agenda agenda;

    public MenuGestionarAgenda() {
        // Datos de muestra usando los constructores exactos del dominio
        Cliente c1 = new Cliente("Ana", "Torres", "1234", "ana@email.com", new ArrayList<>());
        Servicio s1 = new Servicio("Corte de cabello", 30, true);
        Cita cita1 = new Cita("10/05/2026", agenda, c1, s1, "09:00");
        listaCitas.add(cita1);

        Cliente c2 = new Cliente("Luis", "Mora", "4321", "luis@email.com", new ArrayList<>());
        Servicio s2 = new Servicio("Tinte completo", 120, true);
        Cita cita2 = new Cita("10/05/2026", agenda, c2, s2, "11:00");
        listaCitas.add(cita2);

        agenda = new Agenda("2 citas pendientes", listaCitas);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== GESTIONAR AGENDA DE CITAS =====");
            System.out.println("1. Crear nueva cita");
            System.out.println("2. Consultar todas las citas");
            System.out.println("3. Consultar citas pendientes");
            System.out.println("4. Actualizar estado de cita");
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
                case 1: crearCita(); break;
                case 2: consultarAgenda(); break;
                case 3: consultarCitasPendientes(); break;
                case 4: actualizarCita(); break;
                case 0: System.out.println("Volviendo al menu principal..."); break;
                default: System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private void crearCita() {
        System.out.println("\n--- Crear Nueva Cita ---");

        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine().trim();
        if (nombre.isEmpty()) {
            System.out.println("Error: el nombre es obligatorio.");
            return;
        }

        System.out.print("Apellido del cliente: ");
        String apellido = scanner.nextLine().trim();
        if (apellido.isEmpty()) {
            System.out.println("Error: el apellido es obligatorio.");
            return;
        }

        System.out.print("Correo del cliente: ");
        String correo = scanner.nextLine().trim();
        if (correo.isEmpty()) {
            System.out.println("Error: el correo es obligatorio.");
            return;
        }

        // Fecha con formato DD/MM/AAAA (validado por setFecha en Cita)
        System.out.print("Fecha de la cita (DD/MM/AAAA): ");
        String fecha = scanner.nextLine().trim();
        if (fecha.isEmpty()) {
            System.out.println("Error: la fecha es obligatoria.");
            return;
        }

        // Hora con formato HH:MM (validado por setHora en Cita)
        System.out.print("Hora de la cita (HH:MM): ");
        String hora = scanner.nextLine().trim();
        if (hora.isEmpty()) {
            System.out.println("Error: la hora es obligatoria.");
            return;
        }

        // Verificar conflicto de horario
        for (Cita c : listaCitas) {
            if (c.getFecha() != null && c.getHora() != null
                    && c.getFecha().equals(fecha) && c.getHora().equals(hora)) {
                System.out.println("Error: ya existe una cita en ese horario (" + fecha + " " + hora + ").");
                return;
            }
        }

        System.out.print("Tipo de servicio (ej. Corte, Tinte, Manicure): ");
        String tipoServicio = scanner.nextLine().trim();
        if (tipoServicio.isEmpty()) {
            System.out.println("Error: el servicio es obligatorio.");
            return;
        }

        System.out.print("Duracion del servicio (minutos): ");
        while (!scanner.hasNextInt()) { scanner.next(); }
        int duracion = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, "sin-clave", correo, new ArrayList<>());
        Servicio servicio = new Servicio(tipoServicio, duracion, true);
        Cita nuevaCita = new Cita(fecha, agenda, cliente, servicio, hora);

        listaCitas.add(nuevaCita);
        agenda.setCitas(listaCitas);
        agenda.setCitasPendiente(listaCitas.size() + " citas pendientes");
        System.out.println("Cita registrada: " + nuevaCita);
    }

    private void consultarAgenda() {
        System.out.println("\n--- Agenda: " + agenda + " ---");
        if (listaCitas.isEmpty()) {
            System.out.println("No hay citas programadas.");
            return;
        }
        for (int i = 0; i < listaCitas.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaCitas.get(i));
        }
    }

    private void consultarCitasPendientes() {
        System.out.println("\n--- Citas Pendientes ---");
        System.out.println("Estado: " + agenda.getCitasPendiente());
        if (listaCitas.isEmpty()) {
            System.out.println("No hay citas programadas.");
            return;
        }
        for (int i = 0; i < listaCitas.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + listaCitas.get(i));
        }
    }

    private void actualizarCita() {
        consultarAgenda();
        if (listaCitas.isEmpty()) return;

        System.out.print("Numero de cita a actualizar: ");
        while (!scanner.hasNextInt()) { scanner.next(); }
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx < 0 || idx >= listaCitas.size()) {
            System.out.println("Error: numero de cita invalido.");
            return;
        }

        Cita cita = listaCitas.get(idx);

        System.out.print("Nueva fecha DD/MM/AAAA (Enter para mantener '" + cita.getFecha() + "'): ");
        String nuevaFecha = scanner.nextLine().trim();
        if (!nuevaFecha.isEmpty()) {
            cita.setFecha(nuevaFecha); // usa la validacion del dominio
        }

        System.out.print("Nueva hora HH:MM (Enter para mantener '" + cita.getHora() + "'): ");
        String nuevaHora = scanner.nextLine().trim();
        if (!nuevaHora.isEmpty()) {
            // Verificar conflicto con nueva hora
            boolean conflicto = false;
            for (int i = 0; i < listaCitas.size(); i++) {
                if (i != idx && listaCitas.get(i).getFecha() != null
                        && listaCitas.get(i).getFecha().equals(cita.getFecha())
                        && listaCitas.get(i).getHora() != null
                        && listaCitas.get(i).getHora().equals(nuevaHora)) {
                    conflicto = true;
                    break;
                }
            }
            if (conflicto) {
                System.out.println("Error: conflicto de horario, ya existe una cita en ese horario.");
                return;
            }
            cita.setHora(nuevaHora); // usa la validacion del dominio
        }

        System.out.print("Nuevo tipo de servicio (Enter para mantener '" + cita.getServicio().getTipoServicio() + "'): ");
        String nuevoServicio = scanner.nextLine().trim();
        if (!nuevoServicio.isEmpty()) {
            cita.getServicio().setTipoServicio(nuevoServicio);
        }

        System.out.println("Cita actualizada: " + cita);
    }
}