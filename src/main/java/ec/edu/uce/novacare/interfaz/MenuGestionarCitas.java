package ec.edu.uce.novacare.interfaz;

import java.util.List;
import java.util.Scanner;

import ec.edu.uce.novacare.DAO.CitaDAOMemoriaImpl;
import ec.edu.uce.novacare.DAO.DAO;
import ec.edu.uce.novacare.DAO.TipoServicioDAOFabrica;
import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.dominio.TipoServicio;
import ec.edu.uce.novacare.util.Validaciones;
import ec.edu.uce.novacare.dominio.Cita;
import ec.edu.uce.novacare.dominio.Cliente;
import ec.edu.uce.novacare.dominio.Servicio;

public class MenuGestionarCitas {

    private Scanner scanner = new Scanner(System.in);
    private UsuarioDAO usuarioDAO;
    private DAO dao;
    private DAO servicioDAO;

    public String nombreUsuario = "";
    public String tipoServicio = "";
    public String fecha = "";
    public String hora = "";

    public MenuGestionarCitas(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
        this.dao = new CitaDAOMemoriaImpl();
        this.servicioDAO = new TipoServicioDAOFabrica().crearTipoServicioDAO();

    }

    public void mostrarMenu() {

        int opcion;

        do {
            System.out.println("===== GESTIONAR CITAS =====");
            System.out.println("1. Crear Cita");
            System.out.println("2. Consultar Cita");
            System.out.println("3. Actualizar Cita");
            System.out.println("4. Cancelar Cita");
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

                    crearCita();
                    break;

                case 2:

                    consultarCita();
                    break;

                case 3:

                    actualizarCita();
                    break;
                case 4:

                    cancelarCita();
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

    // Crear Cita
    public void crearCita(){

        // Nombre
        do{
            System.out.println("Ingrese su nombre de usuario:");
            nombreUsuario = scanner.nextLine();

            if (!Validaciones.validarLetras(nombreUsuario)){
                System.out.println("Error: solo letras.");
            }
        } while (!Validaciones.validarLetras(nombreUsuario));

        // Mostrar tipos de servicio
        List<TipoServicio> tipos = (List<TipoServicio>) servicioDAO.listarTodos();

        if (tipos.isEmpty()) {
            System.out.println("No existen tipos de servicio registrados.");
            return;
        }

        System.out.println("\n===== TIPOS DE SERVICIO =====");

        for (int i = 0; i < tipos.size(); i++) {
            System.out.println((i + 1) + ". " + tipos.get(i).getNombreTipoServicio());
        }

        System.out.print("Seleccione un tipo de servicio: ");
        int opcionTipo = Integer.parseInt(scanner.nextLine());

        if (opcionTipo < 1 || opcionTipo > tipos.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        TipoServicio tipoSeleccionado = tipos.get(opcionTipo - 1);
        List<Servicio> servicios = tipoSeleccionado.getServicios();

        if (servicios.isEmpty()) {
            System.out.println("Este tipo de servicio no tiene servicios.");
            return;
        }

        System.out.println("\n===== SERVICIOS =====");

        for (int i = 0; i < servicios.size(); i++) {
            System.out.println((i + 1) + ". " + servicios.get(i).getNombre());
        }

        System.out.print("Seleccione un servicio: ");
        int opcionServicio = Integer.parseInt(scanner.nextLine());

        if (opcionServicio < 1 || opcionServicio > servicios.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        Servicio servicio = servicios.get(opcionServicio - 1);

        //fecha
        do{
            System.out.println("Ingrese la fecha (AAAA-MM-DD)");
            fecha = scanner.next();

            if (!Validaciones.validarFecha(fecha)){
                System.out.println("Fecha inválida.");
            }
        } while (!Validaciones.validarFecha(fecha));

        //hora
        do{
            System.out.println("Ingrese la hora (HH:MM): ");
            hora = scanner.next();

            if (!Validaciones.validarHora(hora)){
                System.out.println("Hora inválida.");
            }
        } while(!Validaciones.validarHora(hora));

        // Crear el cliente
        Cliente cliente = new Cliente();
        cliente.setNombre(nombreUsuario);

        // Crear la cita
        Cita cita = new Cita();
        cita.setCliente(cliente);
        cita.setServicio(servicio);
        cita.setFecha(fecha);
        cita.setHora(hora);

         // Guardar la cita
        if (dao.nuevo(cita)) {
            System.out.println("Cita creada correctamente.");
        } else {
            System.out.println("No se pudo crear la cita.");
        }

    }

    // Consultar Cita
    public void consultarCita() {


        List<Cita> citas = (List<Cita>) dao.listarTodos();

        if (citas.isEmpty()) {
            System.out.println("No existen citas registradas.");
            return;
        }

        for (Cita cita : citas) {

            System.out.println("\n===== DATOS DE LA CITA =====");
            System.out.println("Nombre: " + cita.getCliente().getNombre());
            System.out.println("Servicio: " + cita.getServicio().getNombre());
            System.out.println("Fecha: " + cita.getFecha());
            System.out.println("Hora: " + cita.getHora());

        }
    }

    // Actualizar Cita
    public void actualizarCita(){

        List<Cita> citas = (List<Cita>) dao.listarTodos();

        if (citas.isEmpty()) {
            System.out.println("No existen citas registradas.");
            return;
        }

        System.out.println("==== ACTUALIZAR CITA ====");

        for (int i = 0; i < citas.size(); i++) {
            Cita cita = citas.get(i);

            System.out.println((i + 1) + ". "
                    + cita.getCliente().getNombre()
                    + " | "
                    + cita.getServicio().getNombre()
                    + " | "
                    + cita.getFecha()
                    + " | "
                    + cita.getHora());
        }
        System.out.print("\nSeleccione la cita que desea actualizar: ");
        int opcion = Integer.parseInt(scanner.nextLine());

        if (opcion < 1 || opcion > citas.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        Cita citaSeleccionada = citas.get(opcion - 1);
        System.out.println("Seleccionó la cita de: "
                + citaSeleccionada.getCliente().getNombre());

        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();

        List<TipoServicio> tipos = (List<TipoServicio>) servicioDAO.listarTodos();

        if (tipos.isEmpty()) {
            System.out.println("No existen tipos de servicio registrados.");
            return;
        }

        System.out.println("\n===== TIPOS DE SERVICIO =====");

        for (int i = 0; i < tipos.size(); i++) {
            System.out.println((i + 1) + ". " + tipos.get(i).getNombreTipoServicio());
        }

        System.out.print("Seleccione un tipo de servicio: ");
        int opcionTipo = Integer.parseInt(scanner.nextLine());

        if (opcionTipo < 1 || opcionTipo > tipos.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        TipoServicio tipoSeleccionado = tipos.get(opcionTipo - 1);
        // Mostrar servicios
        List<Servicio> servicios = tipoSeleccionado.getServicios();

        if (servicios.isEmpty()) {
            System.out.println("Este tipo de servicio no tiene servicios.");
            return;
        }

        System.out.println("\n===== SERVICIOS =====");

        for (int i = 0; i < servicios.size(); i++) {
            System.out.println((i + 1) + ". " + servicios.get(i).getNombre());
        }

        System.out.print("Seleccione un servicio: ");
        int opcionServicio = Integer.parseInt(scanner.nextLine());

        if (opcionServicio < 1 || opcionServicio > servicios.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        Servicio servicio = servicios.get(opcionServicio - 1);

        System.out.print("Nueva fecha (AAAA-MM-DD): ");
        String nuevaFecha = scanner.nextLine();

        System.out.print("Nueva hora (HH:MM): ");
        String nuevaHora = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNombre(nuevoNombre);

        Cita nuevaCita = new Cita();
        nuevaCita.setCliente(cliente);
        nuevaCita.setServicio(servicio);
        nuevaCita.setFecha(nuevaFecha);
        nuevaCita.setHora(nuevaHora);

        if (dao.editar(opcion - 1, nuevaCita)) {
            System.out.println("\nCita actualizada correctamente.");
        } else {
            System.out.println("\nNo se pudo actualizar la cita.");
        }

    }


    // Cancelar Cita
    public void cancelarCita(){

        String confirmacion;

        List<Cita> citas = (List<Cita>) dao.listarTodos();

        if (citas.isEmpty()) {
            System.out.println("No existen citas registradas.");
            return;
        }

        System.out.println("\n===== CANCELAR CITA =====");

        for (int i = 0; i < citas.size(); i++) {

            Cita cita = citas.get(i);

            System.out.println((i + 1) + ". "
                    + cita.getCliente().getNombre()
                    + " | "
                    + cita.getServicio().getNombre()
                    + " | "
                    + cita.getFecha()
                    + " | "
                    + cita.getHora());
        }

        System.out.print("\nSeleccione la cita que desea cancelar: ");
        int opcion = Integer.parseInt(scanner.nextLine());

        if (opcion < 1 || opcion > citas.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        do{
            System.out.println("¿Desea cancelar la cita? (si/no): ");
            confirmacion = scanner.next();

            if (!confirmacion.equalsIgnoreCase("si") && !confirmacion.equalsIgnoreCase("no")){

                System.out.println("Error: solo puede ingresar si o no.");
            }
        } while (!confirmacion.equalsIgnoreCase("si") && !confirmacion.equalsIgnoreCase("no"));

        if (confirmacion.equalsIgnoreCase("si")) {

            if (dao.eliminar(opcion - 1)) {
                System.out.println("Cita cancelada correctamente.");
            } else {
                System.out.println("No se pudo cancelar la cita.");
            }

        } else {
            System.out.println("Operación cancelada.");
        }
    }

}
