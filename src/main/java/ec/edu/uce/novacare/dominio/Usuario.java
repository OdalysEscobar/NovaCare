package ec.edu.uce.novacare.dominio;
import ec.edu.uce.novacare.util.Validaciones;

public class Usuario {

    private String nombre;
    private String correo;
    private String apellido;
    private String contrasena;

    public Usuario() {
        setNombre("");
        setApellido("");
        setCorreo("");
        setContrasena("");
    }

    public Usuario(String nombre, String apellido, String contrasena, String correo) {
        setContrasena(contrasena);
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", apellido='" + apellido + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if (Validaciones.validarLetras(nombre)) {
            this.nombre = nombre;
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {

        if (Validaciones.validarCorreo(correo)) {
            this.correo = correo;
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (Validaciones.validarLetras(apellido)) {
            this.apellido = apellido;
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        if(Validaciones.validarContrasena(contrasena)){
            this.contrasena=contrasena;
        }
    }

}
