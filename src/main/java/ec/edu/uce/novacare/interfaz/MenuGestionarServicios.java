package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ec.edu.uce.novacare.util.Validaciones;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.TipoServicio;



public class MenuGestionarServicios {

    private Scanner scanner = new Scanner(System.in);
    public String nombreServicio="Corte de cabello";
    public String descripcion="Corte en capas ";
    public String duracion="45";



    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("===== GESTIONAR SERVICIOS =====");
            System.out.println("1. Crear servicio");
            System.out.println("2. Actualizar servicio");
            System.out.println("3. Consultar servicios");
            System.out.println("4. Eliminar servicio");
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
                    crearServicio();
                    break;

                case 2:
                    actualizarServicio();
                    break;

                case 3:
                    consultarServicio();
                    break;

                case 4:
                    eliminarServicio();
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

    public void crearServicio() {
        System.out.println("\t\n--- Nuevo Servicio ---");
        ingresarDatosServicio();
        System.out.println("Servicio creado con éxito.");
    }

    public void consultarServicio() {
        if (nombreServicio.isEmpty()) {
            System.out.println("\t\nNo hay servicios registrados.");
        } else {
            System.out.println("\t\n===== DETALLES DEL SERVICIO =====");
            System.out.println("Nombre: " + nombreServicio);
            System.out.println("Descripción: " + descripcion);
            System.out.println("Duración: " + duracion + " min");

            System.out.println("\n--- RELACIÓN CON CLASE DOMINIO (POJO) ---");

            int minutos = Integer.parseInt(duracion);
            Servicio servicioIndividual = new Servicio(minutos, true);

            Servicio[] arregloServicios = new Servicio[]{ servicioIndividual };

            TipoServicio tipo = new TipoServicio("Peluquería", "Servicios de estilismo", arregloServicios);

            System.out.println("Categoría Asignada: " + tipo.getNombreTipoServicio());
            System.out.println("Detalle Categoría : " + tipo.getDescripcion());

            System.out.println("Estructura en Memoria: " + tipo.toString());
        }
    }

    public void actualizarServicio() {
        if (nombreServicio.isEmpty()) {
            System.out.println("\t\nNo existe un servicio para actualizar.");
            return;
        }
        System.out.println("\t\n--- Actualizar Datos del Servicio ---");
        ingresarDatosServicio();
        System.out.println("Servicio actualizado correctamente.");
    }

    public void eliminarServicio() {
        String confirmacion;
        do {
            System.out.print("¿Desea eliminar el servicio? (si/no): ");
            confirmacion = scanner.nextLine();

            if (!confirmacion.equalsIgnoreCase("si") && !confirmacion.equalsIgnoreCase("no")) {
                System.out.println("Error: solo puede ingresar si o no.");
            }
        } while (!confirmacion.equalsIgnoreCase("si") && !confirmacion.equalsIgnoreCase("no"));

        if (confirmacion.equalsIgnoreCase("si")) {
            nombreServicio = "";
            descripcion = "";
            duracion = "";
            System.out.println("Servicio eliminado correctamente.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    private void ingresarDatosServicio() {
        // Validar Nombre del Servicio
        do {
            System.out.print("Ingrese nombre del servicio: ");
            nombreServicio = scanner.nextLine();
            if (!Validaciones.validarLetras(nombreServicio)) {
                System.out.println("Error: Nombre inválido (solo letras).");
            }
        } while (!Validaciones.validarLetras(nombreServicio));

        // Validar Descripción
        do {
            System.out.print("Ingrese descripción: ");
            descripcion = scanner.nextLine();
            if (descripcion.trim().isEmpty()) {
                System.out.println("Error: La descripción no puede estar vacía.");
            }
        } while (descripcion.trim().isEmpty());

        // Validar Duración (Números enteros)
        do {
            System.out.print("Ingrese duración en minutos: ");
            duracion = scanner.nextLine();
            if (!validarNumero(duracion)) {
                System.out.println("Error: Ingrese solo números enteros.");
            }
        } while (!validarNumero(duracion));
    }

    public boolean validarNumero(String numero) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(numero);
        return matcher.matches();
    }
}