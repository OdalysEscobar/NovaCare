package ec.edu.uce.novacare.test.dominio;

import ec.edu.uce.novacare.dominio.Disponibilidad;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.TipoServicio;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TipoServicioTest {

    @Test
    void constructorConParametros() {
        List<Servicio> servicios = new ArrayList<>();
        TipoServicio tipo = new TipoServicio("Masajes", "Masaje terapeutico", servicios);

        assertEquals("Masajes", tipo.getNombreTipoServicio());
        assertEquals("Masaje terapeutico", tipo.getDescripcion());
        assertEquals(servicios, tipo.getServicios());

        System.out.println("El metodo constructorConParametros funciona correctamente✅");
    }

    @Test
    void testToString() {
        TipoServicio tipo = new TipoServicio();
        String textoEsperado = "TipoServicio{" +
                "nombreTipoServicio='Corte de cabello'" +
                ", descripcion='Corte en capas'" +
                ", servicios=[]" +
                '}';

        assertEquals(textoEsperado, tipo.toString());
        System.out.println("El metodo toString funciona correctamente✅");
    }

    @Test
    void getNombreTipoServicio() {
        List<Servicio> servicios = new ArrayList<>();
        TipoServicio tipo = new TipoServicio("Faciales", "Limpieza profunda", servicios);

        assertEquals("Faciales", tipo.getNombreTipoServicio());
        System.out.println("El metodo getNombreTipoServicio funciona correctamente✅");
    }

    @Test
    void setNombreTipoServicio() {
        TipoServicio tipo = new TipoServicio();
        tipo.setNombreTipoServicio("Depilacion");

        assertEquals("Depilacion", tipo.getNombreTipoServicio());
        System.out.println("El metodo setNombreTipoServicio funciona correctamente✅");
    }

    @Test
    void setNombreTipoServicioInvalido() {
        TipoServicio tipo = new TipoServicio();
        tipo.setNombreTipoServicio("Depilacion123");

        assertEquals("Corte de cabello", tipo.getNombreTipoServicio());
        System.out.println("El metodo setNombreTipoServicioInvalido funciona correctamente✅");
    }

    @Test
    void getDescripcion() {
        List<Servicio> servicios = new ArrayList<>();
        TipoServicio tipo = new TipoServicio("Manicura", "Diseno de unas", servicios);

        assertEquals("Diseno de unas", tipo.getDescripcion());
        System.out.println("El metodo getDescripcion funciona correctamente✅");
    }

    @Test
    void setDescripcion() {
        TipoServicio tipo = new TipoServicio();
        tipo.setDescripcion("Hidratacion con mascarilla");

        assertEquals("Hidratacion con mascarilla", tipo.getDescripcion());
        System.out.println("El metodo setDescripcion funciona correctamente✅");
    }

    @Test
    void setDescripcionInvalida() {
        TipoServicio tipo = new TipoServicio();
        tipo.setDescripcion("Capas_2026*");

        assertEquals("Corte en capas", tipo.getDescripcion());
        System.out.println("El metodo setDescripcionInvalida funciona correctamente✅");
    }

    @Test
    void getServicios() {
        TipoServicio tipo = new TipoServicio();
        List<Servicio> servicios = new ArrayList<>();
        tipo.setServicios(servicios);

        assertEquals(servicios, tipo.getServicios());
        System.out.println("El metodo getServicios funciona correctamente✅");
    }

    @Test
    void setServicios() {
        TipoServicio tipo = new TipoServicio();
        List<Servicio> servicios = new ArrayList<>();
        tipo.setServicios(servicios);

        assertEquals(servicios, tipo.getServicios());
        System.out.println("El metodo setServicios funciona correctamente✅");
    }

    // Crud Servicio
    @Test
    void agregarServicioCorrecto() {
        TipoServicio tipo = new TipoServicio();
        Servicio s1 = new Servicio("Corte Completo", Disponibilidad.DISPONIBLE, 45);

        assertTrue(tipo.agregarServicio(s1));
        System.out.println("Servicio agregado correctamente ✅");
    }

    @Test
    void agregarServicioIncorrecto() {
        TipoServicio tipo = new TipoServicio();

        assertFalse(tipo.agregarServicio(null));
        System.out.println("Servicio null rechazado correctamente ❌");
    }

    @Test
    void agregarServicioExistente() {
        TipoServicio tipo = new TipoServicio();
        Servicio s1 = new Servicio("Limpieza Facial", Disponibilidad.DISPONIBLE, 30);

        assertTrue(tipo.agregarServicio(s1));   // Primer intento exitoso
        assertFalse(tipo.agregarServicio(s1));  // Duplicado por misma duración es rechazado

        System.out.println("Servicio duplicado rechazado correctamente ❌");
    }

    @Test
    void buscarServicioCorrecto() {
        TipoServicio tipo = new TipoServicio();
        Servicio s1 = new Servicio("Pedicura Express", Disponibilidad.DISPONIBLE, 25);
        tipo.agregarServicio(s1);

        Servicio encontrado = tipo.buscarServicio(25);

        assertNotNull(encontrado);
        assertEquals(25, encontrado.getDuracion());
        System.out.println("Servicio encontrado correctamente ✅");
    }

    @Test
    void buscarServicioIncorrecto() {
        TipoServicio tipo = new TipoServicio();

        Servicio resultado = tipo.buscarServicio(999);

        assertNull(resultado);
        System.out.println("Servicio no encontrado correctamente ❌");
    }

    @Test
    void editarServicioCorrecto() {
        TipoServicio tipo = new TipoServicio();
        List<Servicio> misServicios = new ArrayList<>();
        Servicio servicioOriginal = new Servicio("Prueba Inicial", Disponibilidad.NO_DISPONIBLE, 15);
        misServicios.add(servicioOriginal);
        tipo.setServicios(misServicios);

        Servicio servicioActualizado = new Servicio("Prueba Modificada", Disponibilidad.DISPONIBLE, 40);

        boolean editado = tipo.editarServicio(servicioActualizado, 0);

        assertTrue(editado);
        assertEquals(40, tipo.getServicios().get(0).getDuracion());
        assertEquals(Disponibilidad.DISPONIBLE, tipo.getServicios().get(0).getDisponibilidad());
        System.out.println("editarServicio funcionando correctamente ✅");
    }

    @Test
    void eliminarServicioVacioDevuelveFalse() {
        TipoServicio tipo = new TipoServicio();

        boolean eliminado = tipo.eliminarServicio(0);
        assertFalse(eliminado);
        System.out.println("eliminarServicio (validación de vacío) funcionando correctamente ✅");
    }

}