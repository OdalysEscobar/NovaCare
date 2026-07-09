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
    private static List<TipoServicio> tipoServicios;
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

        UsuarioDAOFabrica usuarioDAOFabrica = new UsuarioDAOFabrica();
        UsuarioDAO usuarioDAO = usuarioDAOFabrica.crearUsuarioDAO();

        Cliente cliente = new Cliente(nombre, apellido, contrasena, correo, numeroDeTelefono);
        usuarioDAO.nuevo(cliente);
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


    // CRUD Tipo de Servicio

    public boolean existeTipoServicio(TipoServicio tipoServicio) {

        if (tipoServicio == null) {
            return false;
        }

        for (TipoServicio ts : tipoServicios) {

            if (ts != null && ts.getNombreTipoServicio().equalsIgnoreCase(tipoServicio.getNombreTipoServicio())) {

                return true;
            }
        }

        return false;
    }

    public boolean agregarTipoServicio(TipoServicio nuevoTipoServicio) {

        if (nuevoTipoServicio == null) {
            return false;
        }

        if (!existeTipoServicio(nuevoTipoServicio)) {
            tipoServicios.add(nuevoTipoServicio);
            return true;
        }

        return false;
    }

    public TipoServicio buscarTipoServicio(String nombre) {

        if (nombre == null) {
            return null;
        }

        for (TipoServicio ts : tipoServicios) {

            if (ts != null &&
                    ts.getNombreTipoServicio().equalsIgnoreCase(nombre)) {

                return ts;
            }
        }

        return null;
    }

    public boolean editarTipoServicio(String nombre, TipoServicio nuevoTipo) {

        TipoServicio tipo = buscarTipoServicio(nombre);

        if (tipo != null) {

            tipo.setNombreTipoServicio(nuevoTipo.getNombreTipoServicio());
            tipo.setDescripcion(nuevoTipo.getDescripcion());

            return true;
        }

        return false;
    }

    public boolean eliminarTipoServicio(String nombre) {

        for (int i = 0; i < tipoServicios.size(); i++) {

            if (tipoServicios.get(i).getNombreTipoServicio().equalsIgnoreCase(nombre)) {

                tipoServicios.remove(i);

                return true;
            }
        }

        return false;
    }

    public String consultarTipoServicio() {

        String texto = "";

        for (TipoServicio ts : tipoServicios) {

            if (ts != null) {
                texto += ts + "\n";
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


    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public static List<TipoServicio> getTipoServicios() {
        return tipoServicios;
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
        //Para usuarios
        agregarUsuario("Maria", "Alvarez", "1235", "maria@uce.com", "0995631247");
        agregarUsuario("Juan", "Estrada", "14897", "juan@hotmail.com", Especialidad.BARBERIA, new Agenda());
        agregarUsuario("Sofia", "Moran", "65423", "sofi@uce.com", "0995631756");


        //Para servicios
        Servicio servicio1 = new Servicio ("prueba1",Disponibilidad.DISPONIBLE,20);
        Servicio servicio2 = new Servicio ("prueba2",Disponibilidad.NO_DISPONIBLE,50);

//        agregarServicio(servicio1);
//        agregarServicio(servicio2);
    }
}