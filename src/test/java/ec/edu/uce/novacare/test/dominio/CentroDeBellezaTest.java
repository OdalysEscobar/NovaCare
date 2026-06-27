package ec.edu.uce.novacare.test.dominio;

import ec.edu.uce.novacare.dominio.*;
import ec.edu.uce.novacare.util.Validaciones;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CentroDeBellezaTest {

    @Test
    void singletonCorrecto() {

        CentroDeBelleza centro1 = CentroDeBelleza.getCentro();
        CentroDeBelleza centro2 = CentroDeBelleza.getCentro();

        assertSame(centro1, centro2);

        System.out.println("Singleton funcionando correctamente ✅");
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
    void agregarServicioCorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();
        System.out.println(centro);
        System.out.println("---------------------------------------------------------");

        Servicio s1 = new Servicio(60, true);
        Servicio s2 = new Servicio(45, false);

        assertTrue(centro.agregarServicio(s1));
        assertTrue(centro.agregarServicio(s2));

        System.out.println("Lista de servicios:");
        System.out.println(centro.consultarServicio());

        System.out.println("Servicio agregado correctamente ✅");
        System.out.println("---------------------------------------------------------");
    }

    @Test
    void agregarServicioIncorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();

        assertFalse(centro.agregarServicio(null));

        System.out.println("Servicio null rechazado correctamente ❌");
    }

    @Test
    void agregarServicioExistente() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();
        System.out.println(centro);
        System.out.println("---------------------------------------------------------");

        Servicio s1 = new Servicio(60, true);

        assertTrue(centro.agregarServicio(s1));
        assertFalse(centro.agregarServicio(s1));

        System.out.println("Lista de servicios:");
        System.out.println(centro.consultarServicio());

        System.out.println("Servicio duplicado rechazado correctamente ❌");
        System.out.println("---------------------------------------------------------");
    }

    @Test
    void buscarServicioCorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();
        System.out.println(centro);
        System.out.println("---------------------------------------------------------");

        Servicio s1 = new Servicio(60, true);
        Servicio s2 = new Servicio(45, false);

        centro.agregarServicio(s1);
        centro.agregarServicio(s2);

        Servicio encontrado = centro.buscarServicio(60);

        System.out.println("Lista de servicios:");
        System.out.println(centro.consultarServicio());

        assertNotNull(encontrado);
        assertEquals(60, encontrado.getDuracion());

        System.out.println("Servicio encontrado:");
        System.out.println(encontrado);

        System.out.println("Servicio encontrado correctamente ✅");
        System.out.println("---------------------------------------------------------");
    }

    @Test
    void buscarServicioIncorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();

        Servicio resultado = centro.buscarServicio(999);

        assertNull(resultado);

        System.out.println("Servicio no encontrado correctamente ❌");
    }

    @Test
    void editarServicioCorrecto() {
        CentroDeBelleza centro = CentroDeBelleza.getCentro();
        System.out.println(centro);
        System.out.println("---------------------------------------------------------");

        System.out.println("=== Servicio antes de editar ===");

        Servicio s1 = new Servicio(60, true);

        centro.agregarServicio(s1);

        System.out.println(centro.consultarServicio());

        Servicio actualizado = new Servicio(45, false);

        boolean editado = centro.editarServicio(actualizado, 0);

        assertTrue(editado);

        assertEquals(45, centro.getServicios()[0].getDuracion());
        assertFalse(centro.getServicios()[0].isDisponibilidad());

        System.out.println("=== Servicio actualizado ===");
        System.out.println(centro.consultarServicio());

        System.out.println("editarServicio funcionando correctamente ✅");
        System.out.println("---------------------------------------------------------");
    }

    @Test
    void eliminarServicioCorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();
        System.out.println(centro);
        System.out.println("---------------------------------------------------------");

        System.out.println("=== Servicios antes de eliminar ===");

        Servicio s1 = new Servicio(60, true);
        Servicio s2 = new Servicio(45, false);

        centro.agregarServicio(s1);
        centro.agregarServicio(s2);

        System.out.println(centro.consultarServicio());

        boolean eliminado = centro.eliminarServicio(0);

        assertTrue(eliminado);
        assertNull(centro.buscarServicio(60));

        System.out.println("=== Servicios después de eliminar ===");
        System.out.println(centro.consultarServicio());

        System.out.println("Servicio eliminado correctamente ✅");
        System.out.println("---------------------------------------------------------");
    }

    @Test
    void eliminarServicioIncorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();

        boolean eliminado = centro.eliminarServicio(100);

        assertFalse(eliminado);

        System.out.println("Servicio no encontrado para eliminar ❌");
    }

    //Test usuarios
    @Test
    void agregarUsuarioCorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();
        System.out.println(centro);
        System.out.println("---------------------------------------------------------");

        Usuario u1 = new Empleado("Ana", "Perez", "1234", "ana@gmail.com",Especialidad.MAQUILLAJE,null);
        Usuario u2 = new Cliente ("Juana", "Pacheco", "12346", "juana@hola.com", "0999999999");

        assertTrue(centro.agregarUsuario(u1));
        assertTrue(centro.agregarUsuario(u2));
        centro.agregarUsuario("Mario", "Castro", "123546", "mario@uce.com", Especialidad.PEINADO, null);

        System.out.println("Lista de usuarios:");
        System.out.println(centro.consultarUsario());
        System.out.println("Usuario agregado correctamente ✅");
        System.out.println("---------------------------------------------------------");

    }

    @Test
    void agregarUsuarioIncorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();

        assertFalse(centro.agregarUsuario(null));

        System.out.println("Usuario null rechazado correctamente ❌");
    }

    @Test
    void agregarUsuarioExistente() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();
        System.out.println(centro);
        System.out.println("---------------------------------------------------------");


        Usuario u1 = new Cliente("Ana", "Perez", "1234", "ana@gmail.com","098985242");

        assertTrue(centro.agregarUsuario(u1));   // primero
        assertFalse(centro.agregarUsuario(u1));  // duplicado

        System.out.println(centro.consultarUsario());

        System.out.println("Usuario duplicado rechazado correctamente ❌");
        System.out.println("---------------------------------------------------------");

    }
    @Test
    void buscarUsuarioCorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();
        System.out.println(centro);
        System.out.println("---------------------------------------------------------");

        Usuario u1 = new Empleado("Ana", "Perez", "1234", "ana@gmail.com",Especialidad.PEDICURA, null);
        Usuario u2 = new Cliente ("Juana", "Pacheco", "12346", "juana@hola.com", "0999999999");

        centro.agregarUsuario(u1);
        centro.agregarUsuario(u2);

        Usuario encontrado = centro.buscarUsuario("ana@gmail.com");
        System.out.println("Lista de usuarios:");
        System.out.println(centro.consultarUsario());

        assertNotNull(encontrado);
        System.out.println("Usuario encontrado:");
        assertEquals("ana@gmail.com", encontrado.getCorreo());

        System.out.println(encontrado);

        System.out.println("Usuario encontrado correctamente ✅");
        System.out.println("---------------------------------------------------------");
    }

    @Test
    void buscarUsuarioIncorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();

        Usuario resultado = centro.buscarUsuario("noexiste@gmail.com");

        assertNull(resultado);

        System.out.println("Usuario no encontrado correctamente ❌");
    }

    @Test
    void editarUsuarioCorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();
        System.out.println(centro);
        System.out.println("---------------------------------------------------------");

        System.out.println("=== Usuario a editar ====");
        Usuario u1 = new Cliente("Ana", "Perez", "1234", "ana@gmail.com","099888328");
        centro.agregarUsuario(u1);
        System.out.println(centro.consultarUsario());

        System.out.println("=== Usuario actualizado ===");
        Usuario usuarioActualizado = new Cliente("Maria", "Lopez", "5678", "maria@gmail.com", "098520339");

        boolean editado = centro.editarUsuario(usuarioActualizado, "ana@gmail.com");

        assertTrue(editado);

        Usuario encontrado = centro.buscarUsuario("maria@gmail.com");

        assertNotNull(encontrado);
        assertEquals("Maria", encontrado.getNombre());
        assertEquals("Lopez", encontrado.getApellido());
        System.out.println(centro.consultarUsario());

        System.out.println("editarUsuario funcionando correctamente ✅");
        System.out.println("---------------------------------------------------------");

    }

    @Test
    void editarUsuarioIncorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();

        Usuario usuarioActualizado = new Cliente("Maria", "Lopez", "5678", "maria@gmail.com","099888318");

        boolean editado = centro.editarUsuario(usuarioActualizado, "noexiste@gmail.com");

        assertFalse(editado);

        System.out.println("Usuario no encontrado para editar ❌");
    }

    @Test
    void eliminarUsuarioCorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();
        System.out.println(centro);
        System.out.println("---------------------------------------------------------");

        System.out.println("=== Usuarios antes de eliminar ===");
        Usuario u1 = new Empleado("Ana", "Perez", "1234", "ana@gmail.com", Especialidad.MANICURA,null);
        Usuario u2 = new Cliente ("Juana", "Pacheco", "12346", "juana@hola.com", "0999999999");

        centro.agregarUsuario(u1);
        centro.agregarUsuario(u2);
        centro.agregarUsuario("Mario", "Castro", "123546", "mario@uce.com", Especialidad.PEINADO, null);
        System.out.println(centro.consultarUsario());

        boolean eliminado = centro.eliminarUsuario("ana@gmail.com");

        assertTrue(eliminado);
        assertNull(centro.buscarUsuario("ana@gmail.com"));
        System.out.println("=== Usuarios despues de elimianr ===");
        System.out.println(centro.consultarUsario());
        System.out.println("Usuario eliminado correctamente ✅");
        System.out.println("---------------------------------------------------------");
    }

    @Test
    void eliminarUsuarioIncorrecto() {

        CentroDeBelleza centro = CentroDeBelleza.getCentro();

        boolean eliminado = centro.eliminarUsuario("noexiste@gmail.com");

        assertFalse(eliminado);

        System.out.println("Usuario no encontrado para eliminar ❌");
    }
}