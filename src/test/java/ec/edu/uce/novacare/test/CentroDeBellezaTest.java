package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.dominio.CentroDeBelleza;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CentroDeBellezaTest {

    @Test
    void crearCentroDeBellezaCorrectamente() {

        Usuario[] usuarios = new Usuario[2];
        Servicio[] servicios = new Servicio[2];

        CentroDeBelleza centro = new CentroDeBelleza(
                "NovaCare",
                "Pomasqui",
                "0991234567",
                "08:00",
                usuarios,
                servicios
        );

        assertNotNull(centro);
        System.out.println("CentroDeBelleza creado correctamente ✅");
    }

    @Test
    void crearCentroDeBellezaNulo() {

        CentroDeBelleza centro = null;

        assertNull(centro);
        System.out.println("CentroDeBelleza nulo detectado correctamente ✅");
    }

    @Test
    void validarNombreCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();
        centro.setNombre("NovaCare");

        assertEquals("NovaCare", centro.getNombre());
        System.out.println("Nombre asignado correctamente ✅");
    }

    @Test
    void validarTelefonoCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();
        centro.setTelefono("0991234567");

        assertEquals("0991234567", centro.getTelefono());
        System.out.println("Telefono asignado correctamente ✅");
    }

    @Test
    void validarHorarioCorrecto() {

        CentroDeBelleza centro = new CentroDeBelleza();
        centro.setHorarioAtencion("09:30");

        assertEquals("09:30", centro.getHorarioAtencion());
        System.out.println("Horario asignado correctamente ✅");
    }

    @Test
    void asignarUsuariosCorrectamente() {

        CentroDeBelleza centro = new CentroDeBelleza();
        Usuario[] usuarios = new Usuario[3];
        centro.setUsuarios(usuarios);

        assertNotNull(centro.getUsuarios());
        assertEquals(3, centro.getUsuarios().length);
        System.out.println("Usuarios asignados correctamente ✅");
    }

    @Test
    void asignarServiciosCorrectamente() {

        CentroDeBelleza centro = new CentroDeBelleza();
        Servicio[] servicios = new Servicio[4];
        centro.setServicios(servicios);

        assertNotNull(centro.getServicios());
        assertEquals(4, centro.getServicios().length);
        System.out.println("Servicios asignados correctamente ✅");
    }

    @Test
    void validarToString() {

        CentroDeBelleza centro = new CentroDeBelleza();
        String texto = centro.toString();

        assertNotNull(texto);
        assertTrue(texto.contains("CentroDeBelleza"));
        System.out.println("toString funcionando correctamente ✅");
    }
}