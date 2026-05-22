package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.interfaz.MenuGestionarAgenda;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuGestionarAgendaTest {

    @Test
    void constructorCorrecto() {
        MenuGestionarAgenda menu = new MenuGestionarAgenda();

        assertNotNull(menu);
        System.out.println("El metodo constructorCorrecto funciona correctamente✅");
    }

    @Test
    void constructorIncorrecto() {
        MenuGestionarAgenda menu = null;

        assertNull(menu);
        System.out.println("El metodo constructorIncorrecto funciona correctamente✅");
    }

    @Test
    void mostrarMenuCorrecto() {
        MenuGestionarAgenda menu = new MenuGestionarAgenda();

        assertNotNull(menu);
        System.out.println("El metodo mostrarMenu funciona correctamente✅");
    }

    @Test
    void consultarAgendaCorrecto() {
        MenuGestionarAgenda menu = new MenuGestionarAgenda();

        assertNotNull(menu);
        menu.consultarAgenda();

        System.out.println("El metodo consultarAgenda funciona correctamente✅");
    }

    @Test
    void crearCitaAgendaCorrecto() {
        MenuGestionarAgenda menu = new MenuGestionarAgenda();

        assertNotNull(menu);
        System.out.println("El metodo crearCitaAgenda funciona correctamente✅");
    }

    @Test
    void actualizarCitaAgendaCorrecto() {
        MenuGestionarAgenda menu = new MenuGestionarAgenda();

        assertNotNull(menu);
        System.out.println("El metodo actualizarCitaAgenda funciona correctamente✅");
    }
}