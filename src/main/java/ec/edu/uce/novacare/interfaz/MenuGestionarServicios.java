package ec.edu.uce.novacare.interfaz;

import ec.edu.uce.novacare.dominio.Servicio;
import java.util.Scanner;

public class MenuGestionarServicios {

    private final Scanner scanner = new Scanner(System.in);
    private final Servicio[] catalogo = new Servicio[50];
    private int totalServicios = 0;

    public MenuGestionarServicios() {
        catalogo[0] = new Servicio("Corte de cabello", 30, true);
        catalogo[1] = new Servicio("Tinte completo", 120, true);
        catalogo[2] = new Servicio("Manicure", 45, false);
        totalServicios = 3;
    }


    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n===== GESTIONAR SERVICIOS =====");
            System.out.println("1. Crear servicio");
            System.out.println("2. Consultar catalogo");
            System.out.println("3. Actualizar servicio");
            System.out.println("4. Eliminar servicio");
            System.out.println("5. Filtrar disponibles");
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
                case 1: crearServicio(); break;
                case 2: consultarCatalogo(); break;
                case 3: actualizarServicio(); break;
                case 4: eliminarServicio(); break;
                case 5: filtrarDisponibles(); break;
                case 0: System.out.println("Volviendo al menu principal..."); break;
                default: System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private void crearServicio() {
        System.out.println("\n--- Crear Servicio ---");
        if (totalServicios >= catalogo.length) {
            System.out.println("Error: el catalogo esta lleno.");
            return;
        }

        System.out.print("Nombre del servicio: ");
        String tipo = scanner.nextLine().trim();
        if (tipo.isEmpty()) {
            System.out.println("Error: el nombre es obligatorio.");
            return;
        }

        System.out.print("Duracion (minutos): ");
        while (!scanner.hasNextInt()) {
            System.out.print("Ingrese un numero: ");
            scanner.next();
        }
        int duracion = scanner.nextInt();
        scanner.nextLine();
        if (duracion <= 0) {
            System.out.println("Error: la duracion debe ser mayor a 0.");
            return;
        }

        System.out.print("Disponible? (s/n): ");
        String d = scanner.nextLine().trim().toLowerCase();
        if (!d.equals("s") && !d.equals("n")) {
            System.out.println("Error: ingrese s o n.");
            return;
        }

        Servicio nuevo = new Servicio(tipo, duracion, d.equals("s"));
        catalogo[totalServicios++] = nuevo;
        System.out.println("Servicio creado: " + nuevo);
    }

    private void consultarCatalogo() {
        System.out.println("\n--- Catalogo de Servicios ---");
        if (totalServicios == 0) {
            System.out.println("No hay servicios registrados.");
            return;
        }
        for (int i = 0; i < totalServicios; i++) {
            System.out.println("[" + (i + 1) + "] " + catalogo[i]);
        }
    }

    private void actualizarServicio() {
        consultarCatalogo();
        if (totalServicios == 0) return;

        System.out.print("Numero del servicio a actualizar: ");
        while (!scanner.hasNextInt()) { scanner.next(); }
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx < 0 || idx >= totalServicios) {
            System.out.println("Error: numero invalido.");
            return;
        }

        System.out.print("Nuevo nombre (Enter para mantener '" + catalogo[idx].getTipoServicio() + "'): ");
        String nombre = scanner.nextLine().trim();
        if (!nombre.isEmpty()) catalogo[idx].setTipoServicio(nombre);

        System.out.print("Nueva duracion en minutos (Enter para mantener " + catalogo[idx].getDuracion() + "): ");
        String durStr = scanner.nextLine().trim();
        if (!durStr.isEmpty()) {
            try {
                int dur = Integer.parseInt(durStr);
                if (dur > 0) catalogo[idx].setDuracion(dur);
                else System.out.println("Duracion no valida, se mantiene la anterior.");
            } catch (NumberFormatException e) {
                System.out.println("Valor no valido, se mantiene la anterior.");
            }
        }

        System.out.print("Disponible? s/n (Enter para mantener): ");
        String dStr = scanner.nextLine().trim().toLowerCase();
        if (dStr.equals("s")) catalogo[idx].setDispoinibilidad(true);
        else if (dStr.equals("n")) catalogo[idx].setDispoinibilidad(false);

        System.out.println("Servicio actualizado: " + catalogo[idx]);
    }

    private void eliminarServicio() {
        consultarCatalogo();
        if (totalServicios == 0) return;

        System.out.print("Numero del servicio a eliminar: ");
        while (!scanner.hasNextInt()) { scanner.next(); }
        int idx = scanner.nextInt() - 1;
        scanner.nextLine();
        if (idx < 0 || idx >= totalServicios) {
            System.out.println("Error: numero invalido.");
            return;
        }

        System.out.print("Confirma eliminar '" + catalogo[idx].getTipoServicio() + "'? (s/n): ");
        String conf = scanner.nextLine().trim().toLowerCase();
        if (conf.equals("s")) {
            for (int i = idx; i < totalServicios - 1; i++) catalogo[i] = catalogo[i + 1];
            catalogo[--totalServicios] = null;
            System.out.println("Servicio eliminado correctamente.");
        } else {
            System.out.println("Eliminacion cancelada.");
        }
    }

    private void filtrarDisponibles() {
        System.out.println("\n--- Servicios Disponibles ---");
        boolean encontrado = false;
        for (int i = 0; i < totalServicios; i++) {
            if (catalogo[i].isDispoinibilidad()) {
                System.out.println("- " + catalogo[i]);
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("No hay servicios disponibles en este momento.");
    }
}