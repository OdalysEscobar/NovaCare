package ec.edu.uce.novacare.dominio;
import ec.edu.uce.novacare.util.Validaciones;

/**
 * Clase que representa a un usuario del sistema NovaCare.
 */
public class Usuario {

    private String nombre;
    private String correo;
    private String apellido;
    private String contrasena;

    /**
     * Constructor vacio.
     * Inicializa los atributos con valores predeterminados.
     */
    public Usuario() {
        this.nombre= "Sin nombre";
        this.apellido="Sin apellido";
        this.correo="Sin correo";
        this.contrasena="Sin contrasena";
    }

    /**
     * Constructor con parámetros.
     * @param nombre nombre del usuario
     * @param apellido apellido del usuario
     * @param contrasena contraseña del usuario
     * @param correo correo electrónico del usuario
     */
    public Usuario(String nombre, String apellido, String contrasena, String correo) {
        setNombre(nombre);
        setApellido(apellido);
        setContrasena(contrasena);
        setCorreo(correo);
    }

    /**
     * Devuelve la información del usuario en formato texto.
     * @return información del usuario
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", apellido='" + apellido + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }

    /**
     * Obtiene el nombre del usuario.
     * @return nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre del usuario.
     * @param nombre nuevo nombre del usuario
     */
    public void setNombre(String nombre) {
        if (Validaciones.validarLetras(nombre)) {
            this.nombre = nombre;
        }
    }

    /**
     * Obtiene el correo del usuario.
     * @return correo del usuario
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Modifica el correo del usuario.
     * @param correo nuevo correo del usuario
     */
    public void setCorreo(String correo) {
        if (Validaciones.validarCorreo(correo)) {
            this.correo = correo;
        }
    }

    /**
     * Obtiene el apellido del usuario.
     * @return apellido del usuario
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Modifica el apellido del usuario.
     * @param apellido nuevo apellido del usuario
     */
    public void setApellido(String apellido) {
        if (Validaciones.validarLetras(apellido)) {
            this.apellido = apellido;
        }
    }

    /**
     * Obtiene la contraseña del usuario.
     * @return contraseña del usuario
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Modifica la contraseña del usuario.
     * @param contrasena nueva contraseña del usuario
     */
    public void setContrasena(String contrasena) {
        if(Validaciones.validarContrasena(contrasena)){
            this.contrasena=contrasena;
        }
    }

}
