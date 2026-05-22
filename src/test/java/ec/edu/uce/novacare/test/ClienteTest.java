package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.dominio.Cita;
import ec.edu.uce.novacare.dominio.Cliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void constructorConParametros() {

        Cita[] citas = new Cita[2];

        Cliente cliente = new Cliente("Kimberly", "Cuvi", "kim123", "kim@gmail.com", "0999999999",
                citas);

        assertEquals("Kimberly", cliente.getNombre());
        assertEquals("Cuvi", cliente.getApellido());
        assertEquals("kim123", cliente.getContrasena());
        assertEquals("kim@gmail.com", cliente.getCorreo());
        assertEquals("0999999999", cliente.getNumeroDeTelefono());
        assertEquals(citas, cliente.getCitas());

        System.out.println(cliente);

        System.out.println("El metodo constructorConParametros funciona correctamente✅");
    }

    @Test
    void getNumeroDeTelefono() {
        Cliente cliente = new Cliente();
        cliente.setNumeroDeTelefono("0999999999");
        assertEquals("0999999999", cliente.getNumeroDeTelefono());
        System.out.println("El metodo getNumeroDeTelefono funciona correctamente✅");
    }

    @Test
    void setNumeroDeTelefono() {
        Cliente cliente = new Cliente();
        cliente.setNumeroDeTelefono("0988888888");
        assertEquals("0988888888", cliente.getNumeroDeTelefono());
        System.out.println("El metodo setNumeroDeTelefono funciona correctamente✅");
    }

    @Test
    void setNumeroDeTelefonoInvalido() {
        Cliente cliente = new Cliente();
        cliente.setNumeroDeTelefono("12345");
        assertEquals("Sin numero de telefono", cliente.getNumeroDeTelefono());
        System.out.println("El metodo setNumeroDeTelefonoInvalido funciona correctamente✅");
    }

    @Test
    void getCitas() {
    }

    @Test
    void setCitas() {
    }

    @Test
    void validarTelefono() {
            assertTrue(Cliente.validarTelefono("0999999999"));
            System.out.println("El metodo validarTelefono funciona correctamente✅");

    }

    @Test
    void testToString() {
        Cliente cliente = new Cliente();
        cliente.setNumeroDeTelefono("0999999999");
        String esperado = "Cliente{" +
                "numeroDeTelefono='0999999999'" +
                ", citas=null" +
                '}';
        assertEquals(esperado, cliente.toString());
        System.out.println("El metodo toString funciona correctamente✅");
    }
}
