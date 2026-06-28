package ec.edu.uce.novacare.test.dominio;

import ec.edu.uce.novacare.dominio.Disponibilidad;
import ec.edu.uce.novacare.dominio.Servicio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioTest {

    @Test
    void constructorConParametros(){
        Servicio servicio = new Servicio (200, Disponibilidad.NO_DISPONIBLE);
        assertEquals(200, servicio.getDuracion());
        assertEquals(Disponibilidad.NO_DISPONIBLE, servicio.getDisponibilidad());
        System.out.println("El metodo constructorConParametros funciona correctamente✅");
    }

    @Test
    void testToString() {
        Servicio servicio = new Servicio(123, Disponibilidad.DISPONIBLE);
        String textoEsperado = "Servicio{" +
                " duracion=123"+
                ", disponibilidad=true" +
                '}';
        assertEquals(textoEsperado, servicio.toString());
        System.out.println("El metodo toString funciona correctamente✅");
    }

    @Test
    void getDuracion() {
        Servicio servicio = new Servicio(200, Disponibilidad.DISPONIBLE);
        assertEquals(200, servicio.getDuracion());
        System.out.println("El metodo getDuracion funciona correctamente✅");
    }

    @Test
    void setDuracion() {
        Servicio servicio = new Servicio();
        servicio.setDuracion(120);
        assertEquals(120, servicio.getDuracion());
        System.out.println("El metodo setDuracion funciona correctamente✅");
    }
    @Test
    void setDuracionInvalida(){
        Servicio servicio = new Servicio();
        servicio.setDuracion(-120);
        assertEquals(0, servicio.getDuracion());
        System.out.println("El metodo setDuracionInvalida funciona correctamente✅");
    }

    @Test
    void setDisponibilidad() {
        Servicio servicio = new Servicio();
        servicio.setDisponibilidad(Disponibilidad.DISPONIBLE);
        assertEquals(Disponibilidad.DISPONIBLE, servicio.getDisponibilidad());
        System.out.println("El metodo isDisponibilidad funciona correctamente✅");
    }

    @Test
    void setDisponibilidadNull() {
        Servicio servicio = new Servicio();
            servicio.setDisponibilidad(null);
            assertEquals(Disponibilidad.NO_DISPONIBLE, servicio.getDisponibilidad());
        System.out.println("El metodo setDisponibilidad funciona correctamente✅");
    }
}