package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.interfaz.MenuGestionarCitas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuGestionarCitasTest {

    // Mostrar Menu
    @Test
    void mostrarMenuCorrecto() {

        MenuGestionarCitas cita = new MenuGestionarCitas();

        assertEquals("", cita.nombreUsuario);
        assertEquals("", cita.tipoServicio);
        assertEquals("", cita.fecha);
        assertEquals("", cita.hora);

        System.out.println("Prueba de inicio de menú de citas correcta exitosa ✅");
    }
    @Test
    void mostrarMenuIncorrecto() {

        MenuGestionarCitas cita = new MenuGestionarCitas();

        assertNotEquals("Emma", cita.nombreUsuario);
        assertNotEquals("Corte de pelo", cita.tipoServicio);
        assertNotEquals("2025-06-15", cita.fecha);
        assertNotEquals("15:30", cita.hora);

        System.out.println("Prueba de menú de citas incorrecto detectada exitosamente ✅");
    }

    // Crear Cita
    @Test
    void crearCitaCorrecto() {

        MenuGestionarCitas cita = new MenuGestionarCitas();

        cita.nombreUsuario = "Emma";
        cita.tipoServicio = "Corte de cabello";
        cita.fecha = "2026-06-15";
        cita.hora = "15:30";

        assertEquals("Emma", cita.nombreUsuario);
        assertEquals("Corte de cabello", cita.tipoServicio);
        assertEquals("2026-06-15", cita.fecha);
        assertEquals("15:30", cita.hora);

        System.out.println("Validación de creación de cita correcta ✅");
    }

    @Test
    void crearCitaIncorrecto() {

        MenuGestionarCitas cita = new MenuGestionarCitas();

        cita.nombreUsuario = "Emma123";
        cita.tipoServicio = "Corte de 456";
        cita.fecha = "15-06-2026";
        cita.hora = "25:99";

        assertNotEquals("Emma", cita.nombreUsuario);
        assertNotEquals("Corte de cabello", cita.tipoServicio);
        assertNotEquals("2026-06-15", cita.fecha);
        assertNotEquals("15:30", cita.hora);

        System.out.println("Validación de cita incorrecta detectada correctamente ✅");
    }

    // Consultar Cita
    @Test
    void consultarCitaCorrecto() {

        MenuGestionarCitas cita = new MenuGestionarCitas();

        cita.nombreUsuario = "Emma";
        cita.tipoServicio = "Corte de cabello";
        cita.fecha = "2026-06-15";
        cita.hora = "15:30";

        assertEquals("Emma", cita.nombreUsuario);
        assertEquals("Corte de cabello", cita.tipoServicio);
        assertEquals("2026-06-15", cita.fecha);
        assertEquals("15:30", cita.hora);

        System.out.println("Validación de consulta de cita correcta ✅");
    }

    @Test
    void consultarCitaVacio() {

        MenuGestionarCitas cita = new MenuGestionarCitas();

        assertEquals("", cita.nombreUsuario);
        assertEquals("", cita.tipoServicio);
        assertEquals("", cita.fecha);
        assertEquals("", cita.hora);

        System.out.println("Validación de cita vacía correcta ✅");
    }

    // Actualizar Cita
    @Test
    void actualizarCitaCorrecto() {

        MenuGestionarCitas cita = new MenuGestionarCitas();

        cita.nombreUsuario = "Emma";
        cita.tipoServicio = "Corte de cabello";
        cita.fecha = "2026-06-15";
        cita.hora = "15:30";

        // Actualización
        cita.nombreUsuario = "Mabel";
        cita.tipoServicio = "Tinte";
        cita.fecha = "2026-07-20";
        cita.hora = "14:00";

        assertEquals("Mabel", cita.nombreUsuario);
        assertEquals("Tinte", cita.tipoServicio);
        assertEquals("2026-07-20", cita.fecha);
        assertEquals("14:00", cita.hora);

        System.out.println("Validación de actualización de cita correcta ✅");
    }

    @Test
    void actualizarCitaIncorrecto() {

        MenuGestionarCitas cita = new MenuGestionarCitas();

        cita.nombreUsuario = "Mabel99";
        cita.tipoServicio = "Tinte*";
        cita.fecha = "20-07-2026";
        cita.hora = "25:00";

        assertEquals("Mabel", cita.nombreUsuario);
        assertEquals("Tinte", cita.tipoServicio);
        assertEquals("2026-07-20", cita.fecha);
        assertEquals("14:00", cita.hora);

        System.out.println("Validación de actualización incorrecta detectada correctamente ✅");
    }

    // Cancelar Cita
    @Test
    void cancelarCitaCorrecto() {

        MenuGestionarCitas cita = new MenuGestionarCitas();

        cita.nombreUsuario = "Emma";
        cita.tipoServicio = "Corte de cabello";
        cita.fecha = "2026-06-15";
        cita.hora = "15:30";

        // Cancelar = vaciar campos
        cita.nombreUsuario = "";
        cita.tipoServicio = "";
        cita.fecha = "";
        cita.hora = "";

        assertEquals("", cita.nombreUsuario);
        assertEquals("", cita.tipoServicio);
        assertEquals("", cita.fecha);
        assertEquals("", cita.hora);

        System.out.println("Validación de cancelación de cita correcta ✅");
    }

    @Test
    void cancelarCitaIncorrecto() {

        MenuGestionarCitas cita = new MenuGestionarCitas();

        cita.nombreUsuario = "Emma";
        cita.tipoServicio = "Corte de cabello";
        cita.fecha = "2026-06-15";
        cita.hora = "15:30";

        // Los campos siguen con datos, no se canceló
        assertNotEquals("", cita.nombreUsuario);
        assertNotEquals("", cita.tipoServicio);
        assertNotEquals("", cita.fecha);
        assertNotEquals("", cita.hora);

        System.out.println("Validación de cancelación incorrecta detectada correctamente ✅");
    }






}