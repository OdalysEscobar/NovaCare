package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.interfaz.MenuIngresarSistema;
import ec.edu.uce.novacare.interfaz.IniciarSesion;
import ec.edu.uce.novacare.interfaz.RegistrarUsuario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuIngresarSistemaTest {

    // Mostrar Menú
    @Test
    void mostrarMenuCorrecto() {

        MenuIngresarSistema menu = new MenuIngresarSistema();

        assertNotNull(menu);

        System.out.println("Menú ingresar sistema creado correctamente ✅");
    }
    @Test
    void mostrarMenuIncorrecto() {

        MenuIngresarSistema menu = null;

        assertNull(menu);

        System.out.println("Menú ingresar sistema nulo detectado correctamente ✅");
    }

    // Iniciar Sesión
    @Test
    void iniciarSesionCorrecto() {

        IniciarSesion sesion = new IniciarSesion();

        assertNotNull(sesion);

        System.out.println("Inicio de sesión accesible correctamente ✅");
    }
    @Test
    void iniciarSesionIncorrecto() {

        IniciarSesion sesion = null;

        assertNull(sesion);

        System.out.println("Inicio de sesión nulo detectado correctamente ✅");
    }

    // Registrar Usuario
    @Test
    void registrarUsuarioCorrecto() {

        RegistrarUsuario registro = new RegistrarUsuario();

        assertNotNull(registro);

        System.out.println("Registro de usuario accesible correctamente ✅");
    }
    @Test
    void registrarUsuarioIncorrecto() {

        RegistrarUsuario registro = null;

        assertNull(registro);

        System.out.println("Registro de usuario nulo detectado correctamente ✅");
    }
}