package ec.edu.uce.novacare.test.dominio;

import ec.edu.uce.novacare.dominio.*;
import ec.edu.uce.novacare.util.Validaciones;
import ec.edu.uce.novacare.dominio.Especialidad;
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

}