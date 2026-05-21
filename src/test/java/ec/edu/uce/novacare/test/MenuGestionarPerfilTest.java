package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.interfaz.MenuGestionarPerfil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuGestionarPerfilTest {

    // Mostrar Menu
    @Test
    void mostrarMenuCorrecto() {

        MenuGestionarPerfil perfil = new MenuGestionarPerfil();

        assertEquals("", perfil.nombre);
        assertEquals("", perfil.apellido);
        assertEquals("", perfil.correo);
        assertEquals("", perfil.contrasena);

        System.out.println("Prueba de inicio de menú de perfil correcta exitosa ✅");
    }
    @Test
    void mostrarMenuIncorrecto() {

        MenuGestionarPerfil perfil = new MenuGestionarPerfil();

        assertEquals("Eithan", perfil.nombre);
        assertEquals("Moran", perfil.apellido);
        assertEquals("eithan09@gmail.com", perfil.correo);
        assertEquals("ab88", perfil.contrasena);

        System.out.println("Prueba de menú de perfil incorrecto detectada exitosamente ✅");
    }

    // Crear Perfil
    @Test
    void crearPerfilCorrecto() {

        MenuGestionarPerfil perfil = new MenuGestionarPerfil();

        perfil.nombre = "Eithan";
        perfil.apellido = "Moran";
        perfil.correo = "eithan09@gmail.com";
        perfil.contrasena = "ab88";

        assertEquals("Eithan", perfil.nombre);

        assertEquals("Moran", perfil.apellido);

        assertEquals("eithan09@gmail.com", perfil.correo);

        assertEquals("ab88", perfil.contrasena);

        System.out.println("Validación de creación de perfil correcta ✅");
    }
    @Test
    void crearPerfilIncorrecto() {

        MenuGestionarPerfil perfil = new MenuGestionarPerfil();
        perfil.nombre = "Eithan6";
        perfil.apellido = "Moran5";
        perfil.correo = "eithan09@gmailcom";
        perfil.contrasena = "ab88*";

        assertNotEquals("Eithan", perfil.nombre);

        assertNotEquals("Moran", perfil.apellido);

        assertNotEquals("eithan09@gmail.com", perfil.correo);

        assertNotEquals("ab88", perfil.contrasena);

        System.out.println("Validación de nombre incorrecto detectada correctamente ✅");
    }

    // Consultar Perfil
    @Test
    void consultarPerfilCorrecto() {


        MenuGestionarPerfil perfil = new MenuGestionarPerfil();

        perfil.nombre = "Eithan";
        perfil.apellido = "Moran";
        perfil.correo = "eithan09@gmail.com";

        assertEquals("Eithan", perfil.nombre);
        assertEquals("Moran", perfil.apellido);
        assertEquals("eithan09@gmail.com", perfil.correo);

        System.out.println("Validación de consulta de perfil correcta ✅");

    }
    @Test
    void consultarPerfilVacio() {

        MenuGestionarPerfil perfil = new MenuGestionarPerfil();

        assertEquals("", perfil.nombre);
        assertEquals("", perfil.apellido);
        assertEquals("", perfil.correo);

        System.out.println("Validación de perfil vacío correcta ✅");

    }

    // Actualizar Perfil
    @Test
    void actualizarPerfilCorrecto() {

        MenuGestionarPerfil perfil = new MenuGestionarPerfil();

        perfil.nombre = "Eithan";
        perfil.apellido = "Moran";
        perfil.correo = "eithan09@gmail.com";
        perfil.contrasena = "ab88";

        // Actualización
        perfil.nombre = "Carlos";
        perfil.apellido = "Lopez";
        perfil.correo = "carlos@gmail.com";
        perfil.contrasena = "cl99";

        assertEquals("Carlos", perfil.nombre);
        assertEquals("Lopez", perfil.apellido);
        assertEquals("carlos@gmail.com", perfil.correo);
        assertEquals("cl99", perfil.contrasena);

        System.out.println("Validación de actualización de perfil correcta ✅");

    }
    @Test
    void actualizarPerfilIncorrecto() {

        MenuGestionarPerfil perfil = new MenuGestionarPerfil();

        perfil.nombre = "Carlos23";
        perfil.apellido = "Lopez45";
        perfil.correo = "carlosgmail.com";
        perfil.contrasena = "cl99*";

        assertNotEquals("Carlos", perfil.nombre);
        assertNotEquals("Lopez", perfil.apellido);
        assertNotEquals("carlos@gmail.com", perfil.correo);
        assertNotEquals("cl99", perfil.contrasena);

        System.out.println("Validación de actualización incorrecta detectada correctamente ✅");

    }

    // Eliminar Perfil
    @Test
    void eliminarPerfilCorrecto() {

        MenuGestionarPerfil perfil =
                new MenuGestionarPerfil();

        perfil.nombre = "Eithan";
        perfil.apellido = "Moran";
        perfil.correo = "eithan09@gmail.com";
        perfil.contrasena = "ab88";

        perfil.nombre = "";
        perfil.apellido = "";
        perfil.correo = "";
        perfil.contrasena = "";

        assertEquals("", perfil.nombre);

        assertEquals("", perfil.apellido);

        assertEquals("", perfil.correo);

        assertEquals("", perfil.contrasena);

        System.out.println("Validación de eliminación de perfil correcta ✅");
    }
    @Test
    void eliminarPerfilIncorrecto() {

        MenuGestionarPerfil perfil = new MenuGestionarPerfil();

        perfil.nombre = "Eithan";
        perfil.apellido = "Moran";
        perfil.correo = "eithan09@gmail.com";
        perfil.contrasena = "ab88";

        assertNotEquals("", perfil.nombre);
        assertNotEquals("", perfil.apellido);
        assertNotEquals("", perfil.correo);
        assertNotEquals("", perfil.contrasena);

        System.out.println("Validación de eliminación incorrecta detectada correctamente ✅");
    }
}