package ec.edu.uce.novacare.interfaz;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

import ec.edu.uce.novacare.DAO.DAO;
import ec.edu.uce.novacare.DAO.ServicioDAOFabrica;
import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.dominio.Disponibilidad;
import ec.edu.uce.novacare.util.Validaciones;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.TipoServicio;
import ec.edu.uce.novacare.dominio.CentroDeBelleza;

public class MenuGestionarServicios {


    private Scanner scanner = new Scanner(System.in);
    private DAO dao;
    private UsuarioDAO usuarioDAO;
    private CentroDeBelleza centro = CentroDeBelleza.getCentro();

    public String nombreServicio="Corte de cabello";
    public String descripcion="Corte en capas ";
    public String duracion="45";

    public MenuGestionarServicios(DAO dao) {
        this.dao= dao;
    }

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
                    MenuPrincipal menuPrincipal = new MenuPrincipal(usuarioDAO);
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

        List<TipoServicio> tiposServicios = (List<TipoServicio>) dao.listarTodos();

        if (tiposServicios.isEmpty()) {
            System.out.println("\n No hay servicios registrados.");
            return;
        }

        System.out.println("\n╔══════════════════════════════════════════╗");
        System.out.println("║          CATÁLOGO DE SERVICIOS           ║");
        System.out.println("╚══════════════════════════════════════════╝");


        for (TipoServicio tipoServicio : tiposServicios) {

            System.out.println("\n╭──────────────────────────────────────────╮");
            System.out.println("  TIPO DE SERVICIO: " + tipoServicio.getNombreTipoServicio());
            System.out.println("╰──────────────────────────────────────────╯");


            if (tipoServicio.getServicios() == null || tipoServicio.getServicios().isEmpty()) {

                System.out.println("  No tiene servicios asignados.");

            } else {

                System.out.printf("%-5s %-25s %-15s %-15s%n",
                        "N°", "Servicio", "Duración", "Estado");

                System.out.println("------------------------------------------------");


                int contador = 1;

                for (Servicio servicio : tipoServicio.getServicios()) {

                    System.out.printf("%-5d %-25s %-15s %-15s%n",
                            contador,
                            servicio.getNombre(),
                            servicio.getDuracion() + " min",
                            servicio.getDisponibilidad()
                    );

                    contador++;
                }
            }

            System.out.println();
        }
    }

    public void actualizarServicio() {

        System.out.println("\n========== ACTUALIZAR SERVICIO ==========");

        List<TipoServicio> tipos = (List<TipoServicio>) dao.listarTodos();

        if (tipos.isEmpty()) {
            System.out.println("No existen tipos de servicio registrados.");
            return;
        }

        // Mostrar los tipos de servicio
        System.out.println("\nTipos de Servicio:");
        for (int i = 0; i < tipos.size(); i++) {
            System.out.println((i + 1) + ". " + tipos.get(i).getNombreTipoServicio());
        }

        System.out.print("\nSeleccione una opción: ");

        int opcionTipo;

        try {
            opcionTipo = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Error: debe ingresar un número.");
            return;
        }

        if (opcionTipo < 1 || opcionTipo > tipos.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        if (opcionTipo < 1 || opcionTipo > tipos.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        TipoServicio tipoServicio = tipos.get(opcionTipo - 1);

        // Verificar que tenga servicios
        if (tipoServicio.getServicios() == null || tipoServicio.getServicios().isEmpty()) {
            System.out.println("Este tipo de servicio no tiene servicios registrados.");
            return;
        }

        // Mostrar los servicios
        System.out.println("\nServicios de " + tipoServicio.getNombreTipoServicio() + ":");

        List<Servicio> servicios = tipoServicio.getServicios();

        for (int i = 0; i < servicios.size(); i++) {
            Servicio s = servicios.get(i);

            System.out.println((i + 1) + ". " + s.getNombre()
                    + " | Duración: " + s.getDuracion() + " min"
                    + " | Estado: " + s.getDisponibilidad());
        }

        System.out.print("\nSeleccione el servicio que desea modificar: ");
        int opcionServicio;

        try {
            opcionServicio = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Error: debe ingresar un número.");
            return;
        }
        if (opcionServicio < 1 || opcionServicio > servicios.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        Servicio servicioSeleccionado = servicios.get(opcionServicio - 1);
        String nombreAnterior = servicioSeleccionado.getNombre();

        // Nuevos datos
        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Nueva duración: ");
        int nuevaDuracion;

        try {
            nuevaDuracion = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Error: la duración debe ser un número.");
            return;
        }

        System.out.print("¿Disponible? (S/N): ");
        boolean disponible = scanner.nextLine().equalsIgnoreCase("S");

        Servicio nuevoServicio = new Servicio();
        nuevoServicio.setNombre(nuevoNombre);
        nuevoServicio.setDuracion(nuevaDuracion);
        nuevoServicio.setDisponibilidad(disponible ? Disponibilidad.DISPONIBLE: Disponibilidad.NO_DISPONIBLE);
        DAO servicioDAO = new ServicioDAOFabrica().crearServicioDAO();

        servicioSeleccionado.setNombre(nuevoNombre);
        servicioSeleccionado.setDuracion(nuevaDuracion);
        servicioSeleccionado.setDisponibilidad( disponible ? Disponibilidad.DISPONIBLE : Disponibilidad.NO_DISPONIBLE
        );

        System.out.println("Servicio actualizado correctamente.");
    }

    public void eliminarServicio() {
        List<TipoServicio> tipos = (List<TipoServicio>) dao.listarTodos();

        if (tipos.isEmpty()) {
            System.out.println("No existen tipos de servicio.");
            return;
        }

        System.out.println("\n===== TIPOS DE SERVICIO =====");

        for (int i = 0; i < tipos.size(); i++) {
            System.out.println((i + 1) + ". " +
                    tipos.get(i).getNombreTipoServicio());
        }

        System.out.print("Seleccione un tipo: ");
        int opcionTipo;

        try {
            opcionTipo = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Error: debe ingresar un número.");
            return;
        }

        if(opcionTipo <1 || opcionTipo>tipos.size()){
            System.out.println("Opción inválida.");
            return;
        }

        TipoServicio tipo = tipos.get(opcionTipo-1);

        List<Servicio> servicios = tipo.getServicios();

        if(servicios.isEmpty()){
            System.out.println("No existen servicios.");
            return;
        }

        System.out.println("\n===== SERVICIOS =====");

        for(int i=0;i<servicios.size();i++){

            System.out.println((i+1)+". "+servicios.get(i).getNombre());

        }

        System.out.print("Seleccione el servicio: ");
        int opcionServicio;

        try {
            opcionServicio = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Error: debe ingresar un número.");
            return;
        }

        if(opcionServicio<1 || opcionServicio>servicios.size()){
            System.out.println("Opción inválida.");
            return;
        }

        Servicio servicio=servicios.get(opcionServicio-1);

        System.out.print("¿Eliminar "+servicio.getNombre()+"? (S/N): ");

        if(scanner.nextLine().equalsIgnoreCase("S")){

            servicios.remove(servicio);

            System.out.println("Servicio eliminado correctamente.");

        }else{

            System.out.println("Operación cancelada.");

        }
    }

    private void ingresarDatosServicio() {

        // Validar Nombre del Tipo de Servicio
        do {
            System.out.print("Ingrese nombre del tipo de servicio: ");
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

        TipoServicio tipoServicio = new TipoServicio();
        tipoServicio.setNombreTipoServicio(nombreServicio);
        tipoServicio.setDescripcion(descripcion);

        DAO servicioDAO = new ServicioDAOFabrica().crearServicioDAO();
        String respuesta;

        do {

            Servicio servicio = new Servicio();

            // Validar nombre del servicio
            String nombre;
            do {
                System.out.print("Ingrese nombre del servicio: ");
                nombre = scanner.nextLine();

                if (!Validaciones.validarLetras(nombre)) {
                    System.out.println("Error: Nombre inválido (solo letras).");
                }

            } while (!Validaciones.validarLetras(nombre));

            servicio.setNombre(nombre);

            // Validar duración
            String duracionTexto;
            do {
                System.out.print("Ingrese duración en minutos: ");
                duracionTexto = scanner.nextLine();

                if (!validarNumero(duracionTexto)) {
                    System.out.println("Error: Ingrese solo números enteros.");
                }

            } while (!validarNumero(duracionTexto));

            servicio.setDuracion(Integer.parseInt(duracionTexto));

            servicio.setDisponibilidad(Disponibilidad.DISPONIBLE);

            // Agregar el servicio al tipo
            tipoServicio.getServicios().add(servicio);

            // Guardar el servicio
            servicioDAO.nuevo(servicio);

            // Preguntar si desea agregar otro servicio
            do {
                System.out.print("¿Desea agregar otro servicio? (S/N): ");
                respuesta = scanner.nextLine().trim();

                if (!respuesta.equalsIgnoreCase("S") &&
                        !respuesta.equalsIgnoreCase("N")) {
                    System.out.println("Error: Opción inválida.");
                }

            } while (!respuesta.equalsIgnoreCase("S") &&
                    !respuesta.equalsIgnoreCase("N"));

        } while (respuesta.equalsIgnoreCase("S"));

        if(dao.nuevo(tipoServicio)){
            System.out.println("Tipo de servicio registrado correctamente.");
        }else{
            System.out.println("No se pudo registrar.");
        }
    }
    public boolean validarNumero(String numero) {
        Pattern pattern = Pattern.compile("^[0-9]+$");
        Matcher matcher = pattern.matcher(numero);
        return matcher.matches();
    }
}