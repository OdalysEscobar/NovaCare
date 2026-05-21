package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.dominio.Servicio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioTest {

    @Test
    void constructorConParametros(){
        Servicio servicio = new Servicio (200, false);
        assertEquals(200, servicio.getDuracion());
        assertEquals(false, servicio.isDisponibilidad());
        System.out.println("El metodo constructorConParametros funciona correctamente✅");
    }

    @Test
    void testToString() {
        Servicio servicio = new Servicio(123, true);
        String textoEsperado = "Servicio{" +
                " duracion=123"+
                ", disponibilidad=true" +
                '}';
        assertEquals(textoEsperado, servicio.toString());
        System.out.println("El metodo toString funciona correctamente✅");
    }

    @Test
    void getDuracion() {
        Servicio servicio = new Servicio(200, true);
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
    void isDisponibilidad() {
        Servicio servicio = new Servicio(200, true);
        assertEquals(true, servicio.isDisponibilidad());
        System.out.println("El metodo isDisponibilidad funciona correctamente✅");
    }

    @Test
    void setDisponibilidad() {
        Servicio servicio = new Servicio();
            servicio.setDisponibilidad(false);
            assertEquals(false, servicio.isDisponibilidad());
        System.out.println("El metodo setDisponibilidad funciona correctamente✅");
    }
}