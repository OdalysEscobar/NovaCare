package ec.edu.uce.novacare.dominio;

import ec.edu.uce.novacare.util.Validaciones;

public  class CentroDeBelleza {

    private static final CentroDeBelleza centro = new CentroDeBelleza("Nova Care");

    private static String nombre;
    private static String direccion;
    private static String telefono;
    private static String horarioAtencion;
    private static Usuario[] usuarios;
    private static Servicio[] servicios;
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
        this.usuarios = new Usuario[3];
        this.servicios = new Servicio[3];

        numUsuarios=0;
        numServicios=0;
    }

    public CentroDeBelleza(String nombre, String direccion, String telefono, String horarioAtencion, Usuario[] usuarios, Servicio[] servicios) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horarioAtencion = horarioAtencion;
        this.usuarios = usuarios;
        this.servicios = servicios;
        this.numUsuarios = 0;
        this.numServicios = 0;
    }

    //Metodos CRUD para  usuario.

    public static boolean validarDuplicado(Object o){
        if (!(o instanceof Usuario)) {
            return false;
        }

        Usuario usuario = (Usuario)o;

        for (int i=0; i<numUsuarios; i++){
            if (usuarios[i] !=null && usuarios[i].equals(usuario)){
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
            if (numUsuarios == usuarios.length) {
                Usuario[] auxUsuario = new Usuario[usuarios.length + 1];
                System.arraycopy(usuarios, 0, auxUsuario, 0, usuarios.length);
                usuarios = auxUsuario;
            }

            usuarios[numUsuarios] = nuevoUsuario;
            numUsuarios++;

            return true;
        }

        return false;
    }

    public static boolean agregarUsuario (String nombre, String apellido, String contrasena, String correo, String numeroDeTelefono){
        boolean resp=false;

        Cliente cliente = new Cliente(nombre, apellido, contrasena, correo, numeroDeTelefono);
        if(!validarDuplicado(cliente)){
            if(numUsuarios == usuarios.length){
                Usuario [] auxUsuario = new Usuario[usuarios.length+1];
                System.arraycopy(usuarios,0, auxUsuario,0, usuarios.length);
                usuarios=auxUsuario;
            }

            usuarios [numUsuarios]=cliente;
            numUsuarios++;

            return true;
        }
        return false;
    }

    public static boolean agregarUsuario (String nombre, String apellido, String contrasena, String correo, Especialidad especialidad, Agenda agenda){
        Empleado emp = new Empleado (nombre, apellido, contrasena, correo, especialidad, agenda);
        return agregarUsuario(emp);
    }

    public static Usuario buscarUsuario(String correo){

        if (correo == null){
            return null;
        }
        for (int i = 0; i < numUsuarios; i++){
            if (usuarios[i] != null){
                if(usuarios[i].getCorreo().equals(correo)){

                    return usuarios[i];
                }

            }

        }

        return null;
    }

    public boolean editarUsuario(Usuario nuevoUsuario, String correo) {
        for (int i = 0; i < numUsuarios; i++) {
            if (usuarios[i]!=null && usuarios[i].getCorreo().equals(correo)){
                usuarios [i].setNombre(nuevoUsuario.getNombre());
                usuarios [i].setApellido(nuevoUsuario.getApellido());
                usuarios [i].setCorreo(nuevoUsuario.getCorreo());
                usuarios[i].setContrasena(nuevoUsuario.getContrasena());
                return true;
            }

        }
        return false;
    }


    public boolean eliminarUsuario(String correo) {

        for (int i = 0; i < numUsuarios; i++) {

            if (usuarios[i] != null && usuarios[i].getCorreo().equals(correo)) {

                for (int j = i; j < numUsuarios - 1; j++) {
                    usuarios[j] = usuarios[j + 1];
                }

                usuarios[numUsuarios - 1] = null;
                numUsuarios--;

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
        for (int i = 0; i < numServicios; i++) {
            if (s != null && servicios[i] != null &&
                    servicios[i].getDuracion() == s.getDuracion()) {
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
            if (numServicios == servicios.length) {
                Servicio[] auxServicio = new Servicio[servicios.length + 1];
                System.arraycopy(servicios, 0, auxServicio, 0, servicios.length);
                servicios = auxServicio;
            }
            servicios[numServicios] = nuevoServicio;
            numServicios++;
            return true;
        }
        return false;
    }

    // buscarServicio
    public static Servicio buscarServicio(int duracion) {
        if (duracion <= 0) {
            return null;
        }
        for (int i = 0; i < numServicios; i++) {
            if (servicios[i] != null) {
                if (servicios[i].getDuracion() == duracion) {
                    return servicios[i];
                }
            }
        }
        return null;
    }


    public boolean editarServicio(Servicio nuevoServicio, int pos) {
        if (pos >= 0 && pos < servicios.length && servicios[pos] != null) {
            servicios[pos].setDuracion(nuevoServicio.getDuracion());
            servicios[pos].setDisponibilidad(nuevoServicio.isDisponibilidad());
            return true;
        }
        return false;
    }

    public boolean eliminarServicio(int pos) {
        if (pos >= 0 && pos < numServicios && servicios[pos] != null) {

            for (int i = pos; i < numServicios - 1; i++) {
                servicios[i] = servicios[i + 1];
            }

            servicios[numServicios - 1] = null;
            numServicios--;
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

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public Servicio[] getServicios() {
        return servicios;
    }

    public void setServicios(Servicio[] servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "CentroDeBelleza{" +
                "nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", horarioAtencion='" + horarioAtencion + '\'' +
                ", usuarios=" + (usuarios != null ? usuarios.length : 0) +
                ", servicios=" + (servicios != null ? servicios.length : 0) +
                '}';
    }

    public void inicializar (){
        //Para usuarios
        agregarUsuario("Maria", "Alvarez", "1235", "maria@uce.com", "0995631247");
        agregarUsuario("Juan", "Estrada", "14897", "juan@hotmail.com", Especialidad.BARBERIA, new Agenda());
        agregarUsuario("Sofia", "Moran", "65423", "sofi@uce.com", "0995631756");
        //Para servicios
        Servicio servicio1 = new Servicio (20,true);
        Servicio servicio2 = new Servicio (60,false);

        agregarServicio(servicio1);
        agregarServicio(servicio2);
    }
}