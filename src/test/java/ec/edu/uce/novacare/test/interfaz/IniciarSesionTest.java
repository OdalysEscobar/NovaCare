package ec.edu.uce.novacare.test.interfaz;

import ec.edu.uce.novacare.interfaz.IniciarSesion;
import org.junit.jupiter.api.Test;
import ec.edu.uce.novacare.util.Validaciones;

import static org.junit.jupiter.api.Assertions.*;

class IniciarSesionTest {

    @Test
    void loginValido(){
        IniciarSesion login = new IniciarSesion();
        assertTrue(login.validarLogin("odalys@uce.ec", "oda123"));
    }

    @Test
    void loginInvalido(){
        IniciarSesion login = new IniciarSesion();
        assertFalse(login.validarLogin("odalys@","??"));
    }

    @Test
    void correoInvalido(){
        IniciarSesion correo = new IniciarSesion();
        assertFalse(correo.validarLogin("oda", "123oda"));
    }

    @Test
    void contrasenaInvalida(){
        IniciarSesion contrasena = new IniciarSesion();
        assertFalse(contrasena.validarLogin("oda@uce.ec","??"));
    }
}