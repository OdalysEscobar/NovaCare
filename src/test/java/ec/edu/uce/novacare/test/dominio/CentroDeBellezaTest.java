package ec.edu.uce.novacare.test.dominio;

import ec.edu.uce.novacare.dominio.*;
import ec.edu.uce.novacare.util.Validaciones;
import ec.edu.uce.novacare.dominio.Disponibilidad;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CentroDeBellezaTest {

    @Test
    void centroDeBellezaCorrecto() {

        List<Usuario> usuarios = new ArrayList<>();
        List<Servicio> servicios = new ArrayList<>();

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
        assertEquals(0, centro.getUsuarios().size());
        assertEquals(0, centro.getServicios().size());

        System.out.println("CentroDeBelleza creado correctamente ✅");
    }

    @Test
    void constructorVacioCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        assertNotNull(centro);
        assertEquals("Sin nombre", centro.getNombre());
        assertEquals("Av. Amazonas y Naciones Unidas", centro.getDireccion());
        assertEquals("0998765432", centro.getTelefono());
        assertEquals("08:00-18:00", centro.getHorarioAtencion());
        assertEquals(0, centro.getUsuarios().size());
        assertEquals(0, centro.getServicios().size());

        System.out.println("Constructor vacío funcionando correctamente ✅");
    }

    @Test
    void setUsuariosCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();
        List<Usuario> usuarios = new ArrayList<>();

        centro.setUsuarios(usuarios);

        assertNotNull(centro.getUsuarios());
        assertEquals(0, centro.getUsuarios().size());

        System.out.println("setUsuarios funcionando correctamente ✅");
    }

    @Test
    void setServiciosCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();
        List<Servicio> servicios = new ArrayList<>();

        centro.setServicios(servicios);

        assertNotNull(centro.getServicios());
        assertEquals(0, centro.getServicios().size());

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

        assertTrue(Validaciones.validarTelefono("0991234567"));

        System.out.println("Telefono valido detectado correctamente ✅");
    }

    @Test
    void validarTelefonoIncorrecto() {

        assertFalse(Validaciones.validarTelefono("123456789"));

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
    void agregarServicioCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        Servicio s1 = new Servicio(60, Disponibilidad.DISPONIBLE);

        assertTrue(centro.agregarServicio(s1));

        System.out.println("Servicio agregado correctamente ✅");
    }

    @Test
    void agregarServicioIncorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        assertFalse(centro.agregarServicio(null));

        System.out.println("Servicio null rechazado correctamente ❌");
    }

    @Test
    void agregarServicioExistente() {

        CentroDeBelleza centro = new CentroDeBelleza();

        Servicio s1 = new Servicio(60, Disponibilidad.DISPONIBLE);

        assertTrue(centro.agregarServicio(s1));   // primero
        assertFalse(centro.agregarServicio(s1));  // duplicado

        System.out.println("Servicio duplicado rechazado correctamente ❌");
    }

    @Test
    void buscarServicioCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        Servicio s1 = new Servicio(60, Disponibilidad.DISPONIBLE);
        centro.agregarServicio(s1);

        Servicio encontrado = centro.buscarServicio(60);

        assertNotNull(encontrado);
        assertEquals(60, encontrado.getDuracion());

        System.out.println("Servicio encontrado correctamente ✅");
    }

    @Test
    void buscarServicioIncorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        Servicio resultado = centro.buscarServicio(999);

        assertNull(resultado);

        System.out.println("Servicio no encontrado correctamente ❌");
    }

    @Test
    void editarServicioCorrecto() {
        CentroDeBelleza centro = new CentroDeBelleza();

        List<Servicio> misServicios = new ArrayList<>();
        Servicio servicio = new Servicio();
        misServicios.add(0,servicio) ; // Servicio vacío por defecto
        centro.setServicios(misServicios);

        Servicio servicioActualizado = new Servicio();
        servicioActualizado.setDuracion(45);
        servicioActualizado.setDisponibilidad(Disponibilidad.DISPONIBLE);

        boolean editado = centro.editarServicio(servicioActualizado, 0);

        assertTrue(editado);
        assertEquals(45, centro.getServicios().get(0).getDuracion());
        assertEquals(Disponibilidad.DISPONIBLE, centro.getServicios().get(0).getDisponibilidad());

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

        Usuario u1 = new Empleado("Ana", "Perez", "1234", "ana@gmail.com",Especialidad.MAQUILLAJE,null);

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

        Usuario u1 = new Cliente("Ana", "Perez", "1234", "ana@gmail.com","098985242");

        assertTrue(centro.agregarUsuario(u1));   // primero
        assertFalse(centro.agregarUsuario(u1));  // duplicado

        System.out.println("Usuario duplicado rechazado correctamente ❌");
    }
    @Test
    void buscarUsuarioCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        Usuario u1 = new Empleado("Ana", "Perez", "1234", "ana@gmail.com",Especialidad.PEDICURA, null);

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

        Usuario u1 = new Cliente("Ana", "Perez", "1234", "ana@gmail.com","099888328");

        centro.agregarUsuario(u1);

        Usuario usuarioActualizado = new Cliente("Maria", "Lopez", "5678", "maria@gmail.com", "098520339");

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

        Usuario usuarioActualizado = new Cliente("Maria", "Lopez", "5678", "maria@gmail.com","099888318");

        boolean editado = centro.editarUsuario(usuarioActualizado, "noexiste@gmail.com");

        assertFalse(editado);

        System.out.println("Usuario no encontrado para editar ❌");
    }

    @Test
    void eliminarUsuarioCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();

        Usuario u1 = new Empleado("Ana", "Perez", "1234", "ana@gmail.com", Especialidad.MANICURA,null);

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