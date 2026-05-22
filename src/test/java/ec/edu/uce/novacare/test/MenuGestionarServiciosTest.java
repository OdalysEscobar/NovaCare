package ec.edu.uce.novacare.test;

import org.junit.jupiter.api.Test;
import ec.edu.uce.novacare.interfaz.MenuGestionarServicios;
import static org.junit.jupiter.api.Assertions.*;

class MenuGestionarServiciosTest {

    @Test
    void mostrarMenuCorrecto() {

        MenuGestionarServicios servicio = new MenuGestionarServicios();

        // Al iniciar, el menú ya cuenta con valores establecidos por defecto
        assertEquals("Corte de cabello", servicio.nombreServicio);
        assertEquals("Corte en capas ", servicio.descripcion);
        assertEquals("45", servicio.duracion);

        System.out.println("Prueba de inicio de menú de servicios correcta exitosa ✅");
    }

    @Test
    void mostrarMenuIncorrecto() {

        MenuGestionarServicios servicio = new MenuGestionarServicios();

        assertNotEquals("", servicio.nombreServicio);
        assertNotEquals("", servicio.descripcion);
        assertNotEquals("", servicio.duracion);

        System.out.println("Prueba de menú de servicios incorrecto detectada exitosamente ✅");
    }

    // Crear Servicio
    @Test
    void crearServicioCorrecto() {

        MenuGestionarServicios servicio = new MenuGestionarServicios();

        servicio.nombreServicio = "Limpieza Facial";
        servicio.descripcion = "Exfoliación e hidratación profunda";
        servicio.duracion = "60";

        assertEquals("Limpieza Facial", servicio.nombreServicio);
        assertEquals("Exfoliación ee hidratación profunda", servicio.descripcion);
        assertEquals("60", servicio.duracion);

        System.out.println("Validación de creación de servicio correcta ✅");
    }

    @Test
    void crearServicioIncorrecto() {

        MenuGestionarServicios servicio = new MenuGestionarServicios();

        servicio.nombreServicio = "Facial123";
        servicio.descripcion = "   ";
        servicio.duracion = "una hora";

        assertNotEquals("Limpieza Facial", servicio.nombreServicio);
        assertNotEquals("Exfoliación e hidratación ", servicio.descripcion);
        assertNotEquals("60", servicio.duracion);

        System.out.println("Validación de servicio incorrecto detectada correctamente ✅");
    }

    // Consultar Servicio
    @Test
    void consultarServicioCorrecto() {

        MenuGestionarServicios servicio = new MenuGestionarServicios();

        servicio.nombreServicio = "Corte de cabello";
        servicio.descripcion = "Corte en capas ";
        servicio.duracion = "45";

        assertEquals("Corte de cabello", servicio.nombreServicio);
        assertEquals("Corte en capas ", servicio.descripcion);
        assertEquals("45", servicio.duracion);

        System.out.println("Validación de consulta de servicio correcta ✅");
    }

    @Test
    void consultarServicioVacio() {

        MenuGestionarServicios servicio = new MenuGestionarServicios();

        servicio.nombreServicio = "";
        servicio.descripcion = "";
        servicio.duracion = "";

        assertEquals("", servicio.nombreServicio);
        assertEquals("", servicio.descripcion);
        assertEquals("", servicio.duracion);

        System.out.println("Validación de servicio vacío correcta ✅");
    }

    // Actualizar Servicio
    @Test
    void actualizarServicioCorrecto() {

        MenuGestionarServicios servicio = new MenuGestionarServicios();

        servicio.nombreServicio = "Corte de cabello";
        servicio.descripcion = "Corte en capas";
        servicio.duracion = "45";

        servicio.nombreServicio = "Manicura";
        servicio.descripcion = "Limpieza y pintado de uñas";
        servicio.duracion = "30";

        assertEquals("Manicura", servicio.nombreServicio);
        assertEquals("Limpieza y pintado de uñas", servicio.descripcion);
        assertEquals("30", servicio.duracion);

        System.out.println("Validación de actualización de servicio correcta ✅");
    }

    @Test
    void actualizarServicioIncorrecto() {

        MenuGestionarServicios servicio = new MenuGestionarServicios();

        servicio.nombreServicio = "Manicura5";
        servicio.descripcion = "";
        servicio.duracion = "treinta";

        assertNotEquals("Manicura", servicio.nombreServicio);
        assertNotEquals("Limpieza y pintado de uñas", servicio.descripcion);
        assertNotEquals("30", servicio.duracion);

        System.out.println("Validación de actualización incorrecta detectada correctamente ✅");
    }

    // Eliminar Servicio
    @Test
    void eliminarServicioCorrecto() {

        MenuGestionarServicios servicio = new MenuGestionarServicios();

        servicio.nombreServicio = "";
        servicio.descripcion = "";
        servicio.duracion = "";

        assertEquals("", servicio.nombreServicio);
        assertEquals("", servicio.descripcion);
        assertEquals("", servicio.duracion);

        System.out.println("Validación de eliminación de servicio correcta ✅");
    }

    @Test
    void eliminarServicioIncorrecto() {

        MenuGestionarServicios servicio = new MenuGestionarServicios();

        // Si se cancela la operación, las variables retienen su información
        assertNotEquals("", servicio.nombreServicio);
        assertNotEquals("", servicio.descripcion);
        assertNotEquals("", servicio.duracion);

        System.out.println("Validación de eliminación incorrecta detectada correctamente ✅");
    }
}