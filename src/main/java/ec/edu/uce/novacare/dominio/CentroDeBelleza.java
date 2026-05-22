package ec.edu.uce.novacare.dominio;

import ec.edu.uce.novacare.util.Validaciones;

public class CentroDeBelleza {
    private String nombre;
    private String direccion;
    private String telefono;
    private String horarioAtencion;
    private Usuario[] usuarios;
    private Servicio[] servicios;

    public CentroDeBelleza() {
        this.nombre = "Sin nombre";
        this.direccion = "Sin direccion";
        this.telefono = "Sin telefono";
        this.horarioAtencion = "00:00";
        this.usuarios = new Usuario[0];
        this.servicios = new Servicio[0];
    }

    public CentroDeBelleza(String nombre, String direccion, String telefono, String horarioAtencion, Usuario[] usuarios, Servicio[] servicios) {
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        setHorarioAtencion(horarioAtencion);
        this.usuarios = usuarios;
        this.servicios = servicios;
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
        if (validarTelefono(telefono)) {
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

    public static boolean validarTelefono(String telefono) {
        return telefono != null && telefono.matches("^09\\d{8}$");
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
}