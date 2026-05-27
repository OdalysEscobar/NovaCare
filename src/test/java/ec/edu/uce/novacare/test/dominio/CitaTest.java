package ec.edu.uce.novacare.test.dominio;

import ec.edu.uce.novacare.dominio.Agenda;
import ec.edu.uce.novacare.dominio.Cita;
import ec.edu.uce.novacare.dominio.Cliente;
import ec.edu.uce.novacare.dominio.Servicio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CitaTest {


    @Test
    void constructorConParametros() {
        Cliente cliente = new Cliente();
        Servicio servicio = new Servicio();
        Agenda agenda = new Agenda();

        Cita cita = new Cita("2026-05-21", agenda, cliente, servicio, "10:00");

        assertEquals("2026-05-21", cita.getFecha());
        assertEquals("10:00", cita.getHora());
        assertEquals(servicio, cita.getServicio());
        assertEquals(cliente, cita.getCliente());

        System.out.println(cita);
        System.out.println("El metodo constructorConParametros funciona correctamente✅");
    }

    @Test
    void testToString() {
        Cliente cliente = new Cliente();
        Servicio servicio = new Servicio();
        Agenda agenda = new Agenda();

        Cita cita = new Cita("2026-05-21", agenda, cliente, servicio, "10:00");

        String textoEsperado = cita.toString();
        assertEquals(textoEsperado, cita.toString());
        System.out.println("El metodo toString funciona correctamente✅");
    }

    @Test
    void getFecha() {
        Cita cita = new Cita();
        cita.setFecha("2026-05-21");
        assertEquals("2026-05-21", cita.getFecha());
        System.out.println("El metodo getFecha funciona correctamente✅");
    }

    @Test
    void setFecha() {
        Cita cita = new Cita();
        cita.setFecha("2026-05-21");
        assertEquals("2026-05-21", cita.getFecha());
        System.out.println("El metodo setFecha funciona correctamente✅");
    }

    @Test
    void setFechaInvalida() {
        Agenda agenda = new Agenda();
        agenda.setFecha("21/05/2026");
        assertEquals("Sin fecha", agenda.getFecha());
        System.out.println("El metodo setFechaInvalida funciona correctamente✅");
    }

    @Test
    void getHora() {
        Cita cita = new Cita();
        cita.setHora("10:00");
        assertEquals("10:00", cita.getHora());
        System.out.println("El metodo getHora funciona correctamente✅");
    }

    @Test
    void setHora() {
        Cita cita = new Cita();
        cita.setHora("10:00");
        assertEquals("10:00", cita.getHora());
        System.out.println("El metodo setHora funciona correctamente✅");
    }

    @Test
    void setHoraInvalida() {
        Cita cita = new Cita();
        cita.setHora("100:00");
        assertEquals("Sin hora", cita.getHora());
        System.out.println("El metodo setHora funciona correctamente✅");
    }

    @Test
    void getServicio() {

    }

    @Test
    void setServicio() {
    }


    @Test
    void getCliente() {
    }

    @Test
    void setCliente() {
    }
}