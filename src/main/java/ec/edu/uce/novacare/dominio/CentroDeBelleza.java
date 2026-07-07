package ec.edu.uce.novacare.dominio;

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
    private static List<Servicio> servicios;
    private static int numUsuarios;
    private static int numServicios;

    public static CentroDeBelleza getCentro(){

        return centro;
    }

    public CentroDeBelleza() {
        this("Sin nombre");
    }

    public CentroDeBelleza(String nombre) {
        this.nombre = nombre;
        this.direccion = "Av. Amazonas y Naciones Unidas";
        this.telefono = "0998765432";
        this.horarioAtencion = "08:00-18:00";
        usuarios = new ArrayList<>();
        servicios = new ArrayList<>();

        //numUsuarios=0;
        //numServicios=0;
    }

    public CentroDeBelleza(String nombre, String direccion, String telefono, String horarioAtencion, List<Usuario> usuarios, List<Servicio>servicios) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horarioAtencion = horarioAtencion;
        this.usuarios = usuarios;
        this.servicios = servicios;
        //this.numUsuarios = 0;
        //this.numServicios = 0;
    }

    //Metodos CRUD para  usuario.

    public static boolean validarDuplicado(Object o){
        if (!(o instanceof Usuario)) {
            return false;
        }

        Usuario usuario = (Usuario)o;

        for (Usuario u:usuarios){
            if (u!=null && u.equals(usuario)){
                return true;
            }
        }

        return false;
    }

    public static boolean agregarUsuario (Usuario nuevoUsuario){

        if(nuevoUsuario == null){
            return false;
        }

        if(!validarDuplicado(nuevoUsuario)) {
            usuarios.add(nuevoUsuario);
            return true;
        }

        return false;
    }

    public static boolean agregarUsuario (String nombre, String apellido, String contrasena, String correo, String numeroDeTelefono){
        boolean resp=false;

        Cliente cliente = new Cliente(nombre, apellido, contrasena, correo, numeroDeTelefono);
        if(!validarDuplicado(cliente)){
            usuarios.add(cliente);
            resp= true;
            return resp;
        }
        return resp;
    }

    public static boolean agregarUsuario (String nombre, String apellido, String contrasena, String correo, Especialidad especialidad, Agenda agenda){
        Empleado emp = new Empleado (nombre, apellido, contrasena, correo, especialidad, agenda);
        return agregarUsuario(emp);
    }

    public static Usuario buscarUsuario(String correo){

        if (correo == null){
            return null;
        }
        for (Usuario u:usuarios){
            if (u.getCorreo().equals(correo)){
                return u;
            }
        }

        return null;
    }

    public boolean editarUsuario(Usuario nuevoUsuario, String correo) {
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.getCorreo().equals(correo)){
                usuario.setNombre(nuevoUsuario.getNombre());
                usuario.setApellido(nuevoUsuario.getApellido());
                usuario.setCorreo(nuevoUsuario.getCorreo());
                usuario.setContrasena(nuevoUsuario.getContrasena());
                return true;
            }

        }
        return false;
    }


    public boolean eliminarUsuario(String correo) {

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getCorreo().equals(correo)) {

                usuarios.remove(i);

                return true;
            }
        }

        return false;
    }

    public String consultarUsario(){
        String texto="";
        for (Usuario u: usuarios){
            if (u!=null){
                texto += u+"\r\n";
            }
        }
        return texto;
    }

    //Metodos CRUD para servicio

    public static boolean existeServicio(Servicio s) {
        for (int i = 0; i < servicios.size(); i++) {
            if (s != null && servicios.get(i)!= null && servicios.get(i).getDuracion() == s.getDuracion()) {
                return true;
            }
        }
        return false;
    }

    // agregarServicio
    public static boolean agregarServicio(Servicio nuevoServicio) {
        if (nuevoServicio == null) {
            return false;
        }
        if (!existeServicio(nuevoServicio)) {
           servicios.add(nuevoServicio);
            return true;
        }
        return false;
    }

    // buscarServicio
    public static Servicio buscarServicio(int duracion) {
        if (duracion <= 0) {
            return null;
        }
        for (int i = 0; i < servicios.size(); i++) {
            if (servicios.get(i).getDuracion() == duracion) {
                    return servicios.get(i);
            }
        }
        return null;
    }


    public boolean editarServicio(Servicio nuevoServicio, int pos) {
        if (pos >= 0 && pos < servicios.size() && servicios.get(pos) != null) {
            servicios.get(pos).setDuracion(nuevoServicio.getDuracion());
            servicios.get(pos).setDisponibilidad(nuevoServicio.getDisponibilidad());
            return true;
        }
        return false;
    }

    public boolean eliminarServicio(int pos) {
        if (pos >= 0 && pos < servicios.size() && servicios.get(pos) != null) {
            servicios.remove(pos);
            return true;
        }
        return false;
    }

    public String consultarServicio(){
        String texto="";
        for (Servicio s: servicios){
            if (s!=null){
                texto += s+"\r\n";
            }
        }
        return texto;
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

    public static List<Servicio> getServicios() {
        return servicios;
    }

    public static void setServicios(List<Servicio> servicios) {
        CentroDeBelleza.servicios = servicios;
    }

    @Override
    public String toString() {
        return "CentroDeBelleza{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", horarioAtencion='" + horarioAtencion + '\'' +
                ", usuarios=" + (usuarios != null ? usuarios.size() : 0) +
                ", servicios=" + (servicios != null ? servicios.size() : 0) +
                '}';
    }

    public void inicializar (){
        //Para usuarios
        agregarUsuario("Maria", "Alvarez", "1235", "maria@uce.com", "0995631247");
        agregarUsuario("Juan", "Estrada", "14897", "juan@hotmail.com", Especialidad.BARBERIA, new Agenda());
        agregarUsuario("Sofia", "Moran", "65423", "sofi@uce.com", "0995631756");
        //Para servicios
        Servicio servicio1 = new Servicio (20,Disponibilidad.DISPONIBLE);
        Servicio servicio2 = new Servicio (60,Disponibilidad.NO_DISPONIBLE);

        agregarServicio(servicio1);
        agregarServicio(servicio2);
    }
}