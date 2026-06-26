package ec.edu.uce.novacare.DAO;

public interface Autenticable {
    boolean iniciarSesion(String correo, String contrasena);
}
