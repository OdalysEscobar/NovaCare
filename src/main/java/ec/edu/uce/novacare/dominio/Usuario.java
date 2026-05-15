package ec.edu.uce.novacare.dominio;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Usuario {

    private String nombre;
    private String correo;
    private String apellido;
    private String contrasena;

    public Usuario() {
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
        String regex = "^[a-zA-Z\\s]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(nombre);
        if (m.matches()) {
            this.nombre = nombre;
        } else {
            System.out.println("Error: Nombre no válido.");
        }
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(correo);
        if (m.matches()) {
            this.correo = correo;
        } else {
            System.out.println("Error: Correo con formato incorrecto.");
        }
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        String regex = "^[a-zA-Z\\s]+$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(apellido);
        if (m.matches()) {
            this.apellido = apellido;
        } else {
            System.out.println("Error: Apellido no válido.");
        }
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
    }

}
