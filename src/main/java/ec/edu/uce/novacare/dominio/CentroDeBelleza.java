package ec.edu.uce.novacare.dominio;

import ec.edu.uce.novacare.DAO.*;
import ec.edu.uce.novacare.util.Validaciones;
import java.util.ArrayList;
import java.util.List;

public  class CentroDeBelleza {

    private static final CentroDeBelleza centro = new CentroDeBelleza("Nova Care");

    private static String nombre;
    private static String direccion;
    private static String telefono;
    private static String horarioAtencion;
    private static List <Usuario> usuarios;
    private static List<TipoServicio> tipoServicios = new ArrayList<>();
    private static int numUsuarios;
    private  Agenda agenda;

    public static CentroDeBelleza getCentro(){

        return centro;
    }

    public CentroDeBelleza() {
        this("Sin nombre");
    }

    private CentroDeBelleza(String nombre) {
        this.nombre = nombre;
        this.direccion = "Av. Amazonas y Naciones Unidas";
        this.telefono = "0998765432";
        this.horarioAtencion = "08:00-18:00";
        usuarios = new ArrayList<>(3);
        tipoServicios = new ArrayList<>(3);
        this.agenda = new Agenda();
    }

    public CentroDeBelleza(String nombre, String direccion, String telefono, String horarioAtencion, List<Usuario> usuarios, List<Servicio>servicios) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horarioAtencion = horarioAtencion;
        this.usuarios = usuarios;
        this.agenda = new Agenda();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (Validaciones.validarLetras(nombre)) {
            this.nombre = nombre;
        }
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        if (direccion != null && !direccion.trim().isEmpty()) {
            this.direccion = direccion;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (Validaciones.validarTelefono(telefono)) {
            this.telefono = telefono;
        }
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        if (Validaciones.validarHora(horarioAtencion)) {
            this.horarioAtencion = horarioAtencion;
        }
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List <Usuario> usuarios) {
        this.usuarios = usuarios;
    }


    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public static List<TipoServicio> getTipoServicios() {
        return tipoServicios;
    }

    public static void setTipoServicios(List<TipoServicio> tipoServicios) {
        CentroDeBelleza.tipoServicios = tipoServicios;
    }

    @Override
    public String toString() {
        return "CentroDeBelleza{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", horarioAtencion='" + horarioAtencion + '\'' +
                ", usuarios=" + (usuarios != null ? usuarios.size() : 0) +
                '}';
    }

    public void inicializar (){
        // USUARIOS
        UsuarioDAO usuarioDAO = new UsuarioDAOFabrica().crearUsuarioDAO();

        if(usuarioDAO.listar().isEmpty()){

            usuarioDAO.nuevo(new Cliente("Maria", "Alvarez", "1235", "maria@uce.com", "0995631247"));

            usuarioDAO.nuevo(new Empleado(
                    "Juan", "Estrada", "14897", "juan@hotmail.com", Especialidad.BARBERIA));

            usuarioDAO.nuevo(new Cliente("Sofia", "Moran", "65423", "sofi@uce.com", "0995631756"));

        }

        //TIPOS DE SERVICIO
        DAO tipoServicioDAO = new TipoServicioDAOFabrica().crearTipoServicioDAO();

        if (tipoServicioDAO.listarTodos().isEmpty()) {
            // Manicura
            TipoServicio manicura = new TipoServicio();
            manicura.setNombreTipoServicio("Manicura");
            manicura.setDescripcion("Servicios para uñas");

            Servicio acrilicas = new Servicio();
            acrilicas.setNombre("Acrílicas");
            acrilicas.setDuracion(60);
            acrilicas.setDisponibilidad(Disponibilidad.DISPONIBLE);

            Servicio normales = new Servicio();
            normales.setNombre("Normales");
            normales.setDuracion(40);
            normales.setDisponibilidad(Disponibilidad.DISPONIBLE);

            manicura.getServicios().add(acrilicas);
            manicura.getServicios().add(normales);

            tipoServicioDAO.nuevo(manicura);

            // Peinados
            TipoServicio peinados = new TipoServicio();
            peinados.setNombreTipoServicio("Peinados");
            peinados.setDescripcion("Servicios de peinado");

            Servicio novia = new Servicio();
            novia.setNombre("Novia");
            novia.setDuracion(120);
            novia.setDisponibilidad(Disponibilidad.DISPONIBLE);

            peinados.getServicios().add(novia);

            tipoServicioDAO.nuevo(peinados);
        }
    }
}