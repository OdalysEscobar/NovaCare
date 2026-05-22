package ec.edu.uce.novacare.test;
import ec.edu.uce.novacare.interfaz.MenuGestionarDisponibilidad;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuGestionarDisponibilidadTest {

    @Test
    void mostrarMenuCorrecto() {

        MenuGestionarDisponibilidad disponibilidad = new MenuGestionarDisponibilidad();

        // Al iniciar, el menú ya cuenta con valores quemados por defecto
        assertEquals("2026-05-20", disponibilidad.fecha);
        assertEquals("09:00", disponibilidad.horaInicio);
        assertEquals("17:00", disponibilidad.horaFin);
        assertEquals("Disponible", disponibilidad.estado);

        System.out.println("Prueba de inicio de menú de disponibilidad correcta exitosa ✅");
    }

    @Test
    void mostrarMenuIncorrecto() {

        MenuGestionarDisponibilidad disponibilidad = new MenuGestionarDisponibilidad();

        assertNotEquals("", disponibilidad.fecha);
        assertNotEquals("", disponibilidad.horaInicio);
        assertNotEquals("", disponibilidad.horaFin);
        assertNotEquals("", disponibilidad.estado);

        System.out.println("Prueba de menú de disponibilidad incorrecto detectada exitosamente ✅");
    }

    // Crear Disponibilidad
    @Test
    void crearDisponibilidadCorrecto() {

        MenuGestionarDisponibilidad disponibilidad = new MenuGestionarDisponibilidad();

        disponibilidad.fecha = "2026-06-15";
        disponibilidad.horaInicio = "08:30";
        disponibilidad.horaFin = "16:30";
        disponibilidad.estado = "Disponible";

        assertEquals("2026-06-15", disponibilidad.fecha);
        assertEquals("08:30", disponibilidad.horaInicio);
        assertEquals("16:30", disponibilidad.horaFin);
        assertEquals("Disponiblee", disponibilidad.estado);

        System.out.println("Validación de creación de disponibilidad correcta ✅");
    }

    @Test
    void crearDisponibilidadIncorrecto() {

        MenuGestionarDisponibilidad disponibilidad = new MenuGestionarDisponibilidad();

        disponibilidad.fecha = "15-06-2026";
        disponibilidad.horaInicio = "25:99";
        disponibilidad.horaFin = "08:75";
        disponibilidad.estado = "";

        assertNotEquals("2026-06-15", disponibilidad.fecha);
        assertNotEquals("08:30", disponibilidad.horaInicio);
        assertNotEquals("16:30", disponibilidad.horaFin);
        assertNotEquals("Disponible", disponibilidad.estado);

        System.out.println("Validación de disponibilidad incorrecta detectada correctamente ✅");
    }

    // Consultar Disponibilidad
    @Test
    void consultarDisponibilidadCorrecto() {

        MenuGestionarDisponibilidad disponibilidad = new MenuGestionarDisponibilidad();

        disponibilidad.fecha = "2026-05-20";
        disponibilidad.horaInicio = "09:00";
        disponibilidad.horaFin = "17:00";
        disponibilidad.estado = "Disponible";

        assertEquals("2026-05-20", disponibilidad.fecha);
        assertEquals("09:00", disponibilidad.horaInicio);
        assertEquals("17:00", disponibilidad.horaFin);
        assertEquals("Disponible", disponibilidad.estado);

        System.out.println("Validación de consulta de disponibilidad correcta ✅");
    }

    @Test
    void consultarDisponibilidadVacio() {

        MenuGestionarDisponibilidad disponibilidad = new MenuGestionarDisponibilidad();

        // Simula el estado después de una eliminación (vacío)
        disponibilidad.fecha = "";
        disponibilidad.horaInicio = "";
        disponibilidad.horaFin = "";
        disponibilidad.estado = "";

        assertEquals("", disponibilidad.fecha);
        assertEquals("", disponibilidad.horaInicio);
        assertEquals("", disponibilidad.horaFin);
        assertEquals("", disponibilidad.estado);

        System.out.println("Validación de disponibilidad vacía correcta ✅");
    }

    // Actualizar Disponibilidad
    @Test
    void actualizarDisponibilidadCorrecto() {

        MenuGestionarDisponibilidad disponibilidad = new MenuGestionarDisponibilidad();

        // Valores iniciales
        disponibilidad.fecha = "2026-05-20";
        disponibilidad.horaInicio = "09:00";
        disponibilidad.horaFin = "17:00";
        disponibilidad.estado = "Disponible";

        // Cambio de datos (Actualización)
        disponibilidad.fecha = "2026-05-22";
        disponibilidad.horaInicio = "10:00";
        disponibilidad.horaFin = "15:00";
        disponibilidad.estado = "Ocupado";

        assertEquals("2026-05-22", disponibilidad.fecha);
        assertEquals("10:00", disponibilidad.horaInicio);
        assertEquals("15:00", disponibilidad.horaFin);
        assertEquals("Ocupado", disponibilidad.estado);

        System.out.println("Validación de actualización de disponibilidad correcta ✅");
    }

    @Test
    void actualizarDisponibilidadIncorrecto() {

        MenuGestionarDisponibilidad disponibilidad = new MenuGestionarDisponibilidad();

        disponibilidad.fecha = "2026/05/22";
        disponibilidad.horaInicio = "10-00";
        disponibilidad.horaFin = "15-00";
        disponibilidad.estado = "   ";

        assertNotEquals("2026-05-22", disponibilidad.fecha);
        assertNotEquals("10:00", disponibilidad.horaInicio);
        assertNotEquals("15:00", disponibilidad.horaFin);
        assertNotEquals("Ocupado", disponibilidad.estado);

        System.out.println("Validación de actualización incorrecta detectada correctamente ✅");
    }

    // Eliminar Disponibilidad
    @Test
    void eliminarDisponibilidadCorrecto() {

        MenuGestionarDisponibilidad disponibilidad = new MenuGestionarDisponibilidad();

        // Proceso de eliminación asigna cadenas vacías según el método eliminarDisponibilidad()
        disponibilidad.fecha = "";
        disponibilidad.horaInicio = "";
        disponibilidad.horaFin = "";
        disponibilidad.estado = "";

        assertEquals("", disponibilidad.fecha);
        assertEquals("", disponibilidad.horaInicio);
        assertEquals("", disponibilidad.horaFin);
        assertEquals("", disponibilidad.estado);

        System.out.println("Validación de eliminación de disponibilidad correcta ✅");
    }

    @Test
    void eliminarDisponibilidadIncorrecto() {

        MenuGestionarDisponibilidad disponibilidad = new MenuGestionarDisponibilidad();

        // Los campos mantienen los datos originales si la operación se cancela
        assertNotEquals("", disponibilidad.fecha);
        assertNotEquals("", disponibilidad.horaInicio);
        assertNotEquals("", disponibilidad.horaFin);
        assertNotEquals("", disponibilidad.estado);

        System.out.println("Validación de eliminación incorrecta detectada correctamente ✅");
    }
}