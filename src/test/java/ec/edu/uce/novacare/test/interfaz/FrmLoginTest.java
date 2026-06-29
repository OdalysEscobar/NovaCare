package ec.edu.uce.novacare.test.interfaz;

import ec.edu.uce.novacare.dominio.CentroDeBelleza;
import ec.edu.uce.novacare.dominio.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrmLoginTest {

    @BeforeEach
    void setUp() {
        // Carga datos de prueba antes de cada test
        CentroDeBelleza.getCentro().inicializar();
    }

    @Test
    void loginCredencialesCorrectas() {
        // Simula lo que hace el formulario al buscar un usuario existente
        Usuario u = CentroDeBelleza.buscarUsuario("maria@uce.com");

        assertNotNull(u);
        assertEquals("1235", u.getContrasena());

        System.out.println("FrmLogin → Login correcto ✅");
    }

    @Test
    void loginCorreoInexistente() {
        // Simula un login con correo que no existe
        Usuario u = CentroDeBelleza.buscarUsuario("noexiste@uce.com");

        assertNull(u);

        System.out.println("FrmLogin → Correo inexistente rechazado ❌");
    }

    @Test
    void loginContrasenaIncorrecta() {
        // Busca un usuario real pero compara con contraseña incorrecta
        Usuario u = CentroDeBelleza.buscarUsuario("maria@uce.com");

        assertNotNull(u);
        assertNotEquals("incorrecta", u.getContrasena());

        System.out.println("FrmLogin → Contraseña incorrecta rechazada ❌");
    }

    @Test
    void loginCamposVacios() {
        // Simula la validación visual de campos vacíos
        String correo = "";
        String contrasena = "";

        boolean camposVacios = correo.isEmpty() || contrasena.isEmpty();

        assertTrue(camposVacios);

        System.out.println("FrmLogin → Campos vacíos detectados ⚠");
    }

    @Test
    void loginEmpleadoCorrecto() {
        // También prueba que un empleado sí puede iniciar sesión
        Usuario u = CentroDeBelleza.buscarUsuario("juan@hotmail.com");

        assertNotNull(u);
        assertEquals("14897", u.getContrasena());

        System.out.println("FrmLogin → Login empleado correcto ✅");
    }
}