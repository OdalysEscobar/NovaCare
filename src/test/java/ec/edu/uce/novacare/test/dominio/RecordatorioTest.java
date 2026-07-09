package ec.edu.uce.novacare.test.dominio;

import ec.edu.uce.novacare.dominio.Cita;
import ec.edu.uce.novacare.dominio.Recordatorio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordatorioTest {

    @Test
    void constructorConParametros() {

        Cita cita = new Cita();
        Recordatorio recordatorio = new Recordatorio("Cita Facial", "odalys@gmail.com", cita);
        assertEquals("Cita Facial", recordatorio.getInformacionCita());
        assertEquals("odalys@gmail.com", recordatorio.getCorreo());
        assertEquals(cita, recordatorio.getCita());
        System.out.println(recordatorio);
        System.out.println("El metodo constructorConParametros funciona correctamente✅");
    }

    @Test
    void getInformacionCita() {
        Recordatorio recordatorio = new Recordatorio();
        recordatorio.setInformacionCita("Masaje Facial");
        assertEquals("Masaje Facial", recordatorio.getInformacionCita());
        System.out.println("El metodo getInformacionCita funciona correctamente✅");
    }

    @Test
    void setInformacionCita() {
        Recordatorio recordatorio = new Recordatorio();
        recordatorio.setInformacionCita("Limpieza Facial");
        assertEquals("Limpieza Facial", recordatorio.getInformacionCita());
        System.out.println("El metodo setInformacionCita funciona correctamente✅");
    }

    @Test
    void setInformacionCitaInvalida() {
        Recordatorio recordatorio = new Recordatorio();
        recordatorio.setInformacionCita("Facial123");
        assertEquals("Sin informacion", recordatorio.getInformacionCita());
        System.out.println("El metodo setInformacionCitaInvalida funciona correctamente✅");
    }

    @Test
    void getCorreo() {
        Recordatorio recordatorio = new Recordatorio();
        recordatorio.setCorreo("ana@gmail.com");
        assertEquals("ana@gmail.com", recordatorio.getCorreo());
        System.out.println("El metodo getCorreo funciona correctamente✅");
    }

    @Test
    void setCorreo() {
        Recordatorio recordatorio = new Recordatorio();
        recordatorio.setCorreo("kim@gmail.com");
        assertEquals("kim@gmail.com", recordatorio.getCorreo());
        System.out.println("El metodo setCorreo funciona correctamente✅");
    }

    @Test
    void setCorreoInvalido() {
        Recordatorio recordatorio = new Recordatorio();
        recordatorio.setCorreo("kim.com");
        assertEquals("Sin correo", recordatorio.getCorreo());
        System.out.println("El metodo setCorreoInvalido funciona correctamente✅");
    }


    @Test
    void getCita() {

        Cita cita = new Cita();

        Recordatorio recordatorio = new Recordatorio();
        recordatorio.setCita(cita);

        assertEquals(cita, recordatorio.getCita());

        System.out.println("El metodo getCita funciona correctamente✅");
    }

    @Test
    void setCita() {
        Cita cita = new Cita();

        Recordatorio recordatorio = new Recordatorio();
        recordatorio.setCita(cita);

        assertNotNull(recordatorio.getCita());

        System.out.println("El metodo setCita funciona correctamente✅");
    }

    @Test
    void testToString() {

        Cita cita = new Cita();

        Recordatorio recordatorio = new Recordatorio();
        recordatorio.setInformacionCita("Limpieza Facial");
        recordatorio.setCorreo("odalys@gmail.com");
        recordatorio.setCita(cita);


        String esperado = "Recordatorio{" +
                "id=" + recordatorio.getId() +
                ", informacionCita='Limpieza Facial'" +
                ", correo='odalys@gmail.com'" +
                ", cita=" + cita +
                '}';


        assertEquals(esperado, recordatorio.toString());

        System.out.println("El metodo toString funciona correctamente✅");
    }
}