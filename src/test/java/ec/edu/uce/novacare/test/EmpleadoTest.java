package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.dominio.Agenda;
import ec.edu.uce.novacare.dominio.Empleado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {

    @Test
    void constructorConParametros() {

        Agenda agenda = new Agenda();
        Empleado empleado = new Empleado("Odalys", "Escobar", "oda123", "odalys@gmail.com", "Manicure",
                agenda);
        assertEquals("Odalys", empleado.getNombre());
        assertEquals("Escobar", empleado.getApellido());
        assertEquals("oda123", empleado.getContrasena());
        assertEquals("odalys@gmail.com", empleado.getCorreo());
        assertEquals("Manicure", empleado.getEspecialidad());
        assertEquals(agenda, empleado.getAgenda());

        System.out.println(empleado);

        System.out.println("El metodo constructorConParametros funciona correctamente✅");
    }

    @Test
    void getEspecialidad() {
        Empleado empleado = new Empleado();
        empleado.setEspecialidad("Depilacion");
        assertEquals("Depilacion", empleado.getEspecialidad());
        System.out.println("El metodo getEspecialidad funciona correctamente✅");
    }

    @Test
    void setEspecialidad() {
        Empleado empleado = new Empleado();
        empleado.setEspecialidad("Cejas");
        assertEquals("Cejas", empleado.getEspecialidad());
        System.out.println("El metodo setEspecialidad funciona correctamente✅");
    }

    @Test
    void setEspecialidadInvalida() {
        Empleado empleado = new Empleado();
        empleado.setEspecialidad("Manicure123");
        assertEquals("Sin especialidad", empleado.getEspecialidad());
        System.out.println("El metodo setEspecialidadInvalida funciona correctamente✅");
    }

    @Test
    void getAgenda() {
    }

    @Test
    void setAgenda() {
    }

    @Test
    void testToString() {
        Agenda agenda = new Agenda();
        Empleado empleado = new Empleado("Odalys", "Escobar", "oda123", "odalys@gmail.com", "Manicure",
                agenda);

        String esperado = "Empleado{" +
                "nombre='Odalys'" +
                ", apellido='Escobar'" +
                ", especialidad='Manicure'" +
                ", correo='odalys@gmail.com'" +
                ", agenda=" + agenda +
                '}';
        assertEquals(esperado, empleado.toString());
        System.out.println("El metodo toString funciona correctamente✅");
    }
}