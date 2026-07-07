package ec.edu.uce.novacare.test.interfaz;

import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.DAO.UsuarioDAOMemoriaImpl;
import ec.edu.uce.novacare.interfaz.IniciarSesion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IniciarSesionTest {

    private UsuarioDAO usuarioDAO;

    @BeforeEach
    void setUp() {
        // Inicializamos una instancia limpia del DAO antes de cada test
        this.usuarioDAO = new UsuarioDAOMemoriaImpl();
    }

    @Test
    void loginValido(){
        IniciarSesion login = new IniciarSesion(usuarioDAO);
        assertTrue(login.validarLogin("odalys@uce.ec", "oda123"));
    }

    @Test
    void loginInvalido(){
        IniciarSesion login = new IniciarSesion(usuarioDAO);
        assertFalse(login.validarLogin("odalys@","??"));
    }

    @Test
    void correoInvalido(){
        IniciarSesion correo = new IniciarSesion(usuarioDAO);
        assertFalse(correo.validarLogin("oda", "123oda"));
    }

    @Test
    void contrasenaInvalida(){
        IniciarSesion contrasena = new IniciarSesion(usuarioDAO);
        assertFalse(contrasena.validarLogin("oda@uce.ec","??"));
    }
}