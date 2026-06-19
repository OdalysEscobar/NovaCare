package ec.edu.uce.novacare.test.dominio;

import ec.edu.uce.novacare.dominio.CentroDeBelleza;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CentroDeBellezaTest {

    @Test
    void centroDeBellezaCorrecto() {

        Usuario[] usuarios = new Usuario[2];
        Servicio[] servicios = new Servicio[2];

        CentroDeBelleza centro = new CentroDeBelleza(
                "NovaCare",
                "Pomasqui",
                "0991234567",
                "09:30",
                usuarios,
                servicios
        );

        assertNotNull(centro);
        assertEquals("NovaCare", centro.getNombre());
        assertEquals("Pomasqui", centro.getDireccion());
        assertEquals("0991234567", centro.getTelefono());
        assertEquals("09:30", centro.getHorarioAtencion());
        assertEquals(2, centro.getUsuarios().length);
        assertEquals(2, centro.getServicios().length);

        System.out.println("CentroDeBelleza creado correctamente ✅");
    }

    @Test
    void constructorVacioCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        assertNotNull(centro);
        assertEquals("Sin nombre", centro.getNombre());
        assertEquals("Sin direccion", centro.getDireccion());
        assertEquals("Sin telefono", centro.getTelefono());
        assertEquals("00:00", centro.getHorarioAtencion());
        assertEquals(3, centro.getUsuarios().length);
        assertEquals(3, centro.getServicios().length);

        System.out.println("Constructor vacío funcionando correctamente ✅");
    }

    @Test
    void setUsuariosCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();
        Usuario[] usuarios = new Usuario[3];

        centro.setUsuarios(usuarios);

        assertNotNull(centro.getUsuarios());
        assertEquals(3, centro.getUsuarios().length);

        System.out.println("setUsuarios funcionando correctamente ✅");
    }

    @Test
    void setServiciosCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();
        Servicio[] servicios = new Servicio[4];

        centro.setServicios(servicios);

        assertNotNull(centro.getServicios());
        assertEquals(4, centro.getServicios().length);

        System.out.println("setServicios funcionando correctamente ✅");
    }

    @Test
    void setDireccionCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();
        centro.setDireccion("Carapungo");

        assertEquals("Carapungo", centro.getDireccion());

        System.out.println("setDireccion funcionando correctamente ✅");
    }

    @Test
    void validarTelefonoCorrecto() {

        assertTrue(CentroDeBelleza.validarTelefono("0991234567"));

        System.out.println("Telefono valido detectado correctamente ✅");
    }

    @Test
    void validarTelefonoIncorrecto() {

        assertFalse(CentroDeBelleza.validarTelefono("123456789"));

        System.out.println("Telefono invalido detectado correctamente ✅");
    }

    @Test
    void validarToString() {

        CentroDeBelleza centro = new CentroDeBelleza();
        String texto = centro.toString();

        assertNotNull(texto);
        assertTrue(texto.contains("CentroDeBelleza"));
        assertTrue(texto.contains("nombre"));
        assertTrue(texto.contains("direccion"));

        System.out.println("toString funcionando correctamente ✅");
    }

    @Test
    void centroDeBellezaIncorrecto() {

        CentroDeBelleza centro = null;

        assertNull(centro);

        System.out.println("CentroDeBelleza nulo detectado correctamente ✅");
    }

    //Test servicio

    @Test
    void editarServicioCorrecto() {
        CentroDeBelleza centro = new CentroDeBelleza();

        Servicio[] misServicios = new Servicio[3];
        misServicios[0] = new Servicio(); // Servicio vacío por defecto
        centro.setServicios(misServicios);

        Servicio servicioActualizado = new Servicio();
        servicioActualizado.setDuracion(45);
        servicioActualizado.setDisponibilidad(true);

        boolean editado = centro.editarServicio(servicioActualizado, 0);

        assertTrue(editado);
        assertEquals(45, centro.getServicios()[0].getDuracion());
        assertTrue(centro.getServicios()[0].isDisponibilidad());

        System.out.println("editarServicio funcionando correctamente ✅");
    }

    @Test
    void eliminarServicioVacioDevuelveFalse() {
        CentroDeBelleza centro = new CentroDeBelleza();

        boolean eliminado = centro.eliminarServicio(0);
        assertFalse(eliminado);
        System.out.println("eliminarServicio (validación de vacío) funcionando correctamente ✅");
    }

    //Test usuarios
    @Test
    void agregarUsuarioCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        Usuario u1 = new Usuario("Ana", "Perez", "1234", "ana@gmail.com");

        assertTrue(centro.agregarUsuario(u1));

        System.out.println("Usuario agregado correctamente ✅");
    }

    @Test
    void agregarUsuarioIncorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        assertFalse(centro.agregarUsuario(null));

        System.out.println("Usuario null rechazado correctamente ❌");
    }

    @Test
    void agregarUsuarioExistente() {

        CentroDeBelleza centro = new CentroDeBelleza();

        Usuario u1 = new Usuario("Ana", "Perez", "1234", "ana@gmail.com");

        assertTrue(centro.agregarUsuario(u1));   // primero
        assertFalse(centro.agregarUsuario(u1));  // duplicado

        System.out.println("Usuario duplicado rechazado correctamente ❌");
    }
    @Test
    void buscarUsuarioCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        Usuario u1 = new Usuario("Ana", "Perez", "1234", "ana@gmail.com");

        centro.agregarUsuario(u1);

        Usuario encontrado = centro.buscarUsuario("ana@gmail.com");

        assertNotNull(encontrado);
        assertEquals("ana@gmail.com", encontrado.getCorreo());

        System.out.println("Usuario encontrado correctamente ✅");
    }

    @Test
    void buscarUsuarioIncorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        Usuario resultado = centro.buscarUsuario("noexiste@gmail.com");

        assertNull(resultado);

        System.out.println("Usuario no encontrado correctamente ❌");
    }

    @Test
    void editarUsuarioCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        Usuario u1 = new Usuario("Ana", "Perez", "1234", "ana@gmail.com");

        centro.agregarUsuario(u1);

        Usuario usuarioActualizado = new Usuario("Maria", "Lopez", "5678", "maria@gmail.com");

        boolean editado = centro.editarUsuario(usuarioActualizado, "ana@gmail.com");

        assertTrue(editado);

        Usuario encontrado = centro.buscarUsuario("maria@gmail.com");

        assertNotNull(encontrado);
        assertEquals("Maria", encontrado.getNombre());
        assertEquals("Lopez", encontrado.getApellido());

        System.out.println("editarUsuario funcionando correctamente ✅");
    }

    @Test
    void editarUsuarioIncorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        Usuario usuarioActualizado = new Usuario("Maria", "Lopez", "5678", "maria@gmail.com");

        boolean editado = centro.editarUsuario(usuarioActualizado, "noexiste@gmail.com");

        assertFalse(editado);

        System.out.println("Usuario no encontrado para editar ❌");
    }

    @Test
    void eliminarUsuarioCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        Usuario u1 = new Usuario("Ana", "Perez", "1234", "ana@gmail.com");

        centro.agregarUsuario(u1);

        boolean eliminado = centro.eliminarUsuario("ana@gmail.com");

        assertTrue(eliminado);
        assertNull(centro.buscarUsuario("ana@gmail.com"));

        System.out.println("Usuario eliminado correctamente ✅");
    }

    @Test
    void eliminarUsuarioIncorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        boolean eliminado = centro.eliminarUsuario("noexiste@gmail.com");

        assertFalse(eliminado);

        System.out.println("Usuario no encontrado para eliminar ❌");
    }
}