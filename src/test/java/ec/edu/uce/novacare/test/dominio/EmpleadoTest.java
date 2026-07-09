package ec.edu.uce.novacare.test.dominio;

import ec.edu.uce.novacare.dominio.Agenda;
import ec.edu.uce.novacare.dominio.Empleado;
import ec.edu.uce.novacare.dominio.Especialidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void constructorConParametros() {

        Agenda agenda = new Agenda();
        Empleado empleado = new Empleado("Odalys", "Escobar", "oda123", "odalys@gmail.com", Especialidad.PEINADO);
        assertEquals("Odalys", empleado.getNombre());
        assertEquals("Escobar", empleado.getApellido());
        assertEquals("oda123", empleado.getContrasena());
        assertEquals("odalys@gmail.com", empleado.getCorreo());
        assertEquals(Especialidad.PEINADO, empleado.getEspecialidad());

        System.out.println(empleado);

        System.out.println("El metodo constructorConParametros funciona correctamente✅");
    }

    @Test
    void getEspecialidad() {
        Empleado empleado = new Empleado();
        empleado.setEspecialidad(Especialidad.SPA);
        assertEquals(Especialidad.SPA, empleado.getEspecialidad());
        System.out.println("El metodo getEspecialidad funciona correctamente✅");
    }

    @Test
    void setEspecialidad() {
        Empleado empleado = new Empleado();
        empleado.setEspecialidad(Especialidad.MANICURA);
        assertEquals(Especialidad.MANICURA, empleado.getEspecialidad());
        System.out.println("El metodo setEspecialidad funciona correctamente✅");
    }

    @Test
    void setEspecialidadInvalida() {
        Empleado empleado = new Empleado();

        Especialidad anterior = empleado.getEspecialidad();
        empleado.setEspecialidad(null);
        assertEquals(anterior, empleado.getEspecialidad());
        System.out.println("El metodo setEspecialidadInvalida funciona correctamente✅");
    }


    @Test
    void testToString() {
        Agenda agenda = new Agenda();
        Empleado empleado = new Empleado("Odalys", "Escobar", "oda123", "odalys@gmail.com", Especialidad.SPA);

        String resultado = empleado.toString();

        assertNotNull(resultado);
        assertTrue(resultado.contains("Empleado"));
        assertTrue(resultado.contains("Odalys"));
        assertTrue(resultado.contains("Escobar"));
        assertTrue(resultado.contains(Especialidad.SPA.getDescripcion()) || resultado.contains("MANICURA"));
        assertTrue(resultado.contains("odalys@gmail.com"));
        System.out.println("El metodo toString funciona correctamente✅");
    }
}