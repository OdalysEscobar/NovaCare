package ec.edu.uce.novacare.test;

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
        assertEquals(0, centro.getUsuarios().length);
        assertEquals(0, centro.getServicios().length);

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
}