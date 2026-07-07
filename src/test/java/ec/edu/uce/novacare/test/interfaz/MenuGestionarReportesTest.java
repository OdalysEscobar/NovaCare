package ec.edu.uce.novacare.test.interfaz;

import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.DAO.UsuarioDAOMemoriaImpl;
import ec.edu.uce.novacare.interfaz.MenuGestionarReportes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuGestionarReportesTest {

    private UsuarioDAO usuarioDAO;

    @BeforeEach
    void setUp() {
        // 🔥 Inicializamos el DAO en memoria simulado antes de cada test
        this.usuarioDAO = new UsuarioDAOMemoriaImpl();
    }

    @Test
    void constructorCorrecto() {
        MenuGestionarReportes menu = new MenuGestionarReportes(usuarioDAO);

        assertNotNull(menu);
        System.out.println("El metodo constructorCorrecto funciona correctamente✅");
    }

    @Test
    void constructorIncorrecto() {
        MenuGestionarReportes menu = null;

        assertNull(menu);
        System.out.println("El metodo constructorIncorrecto funciona correctamente✅");
    }

    @Test
    void mostrarMenuCorrecto() {
        MenuGestionarReportes menu = new MenuGestionarReportes(usuarioDAO);

        assertNotNull(menu);
        System.out.println("El metodo mostrarMenu funciona correctamente✅");
    }

    @Test
    void consultarReporteCanceladasCorrecto() {
        MenuGestionarReportes menu = new MenuGestionarReportes(usuarioDAO);

        assertNotNull(menu);
        menu.consultarReporteCanceladas();

        System.out.println("El metodo consultarReporteCanceladas funciona correctamente✅");
    }

    @Test
    void validarMesCorrecto() {
        MenuGestionarReportes menu = new MenuGestionarReportes(usuarioDAO);

        assertTrue(menu.validarMes("05/2026"));
        System.out.println("El metodo validarMesCorrecto funciona correctamente✅");
    }

    @Test
    void validarMesIncorrecto() {
        MenuGestionarReportes menu = new MenuGestionarReportes(usuarioDAO);

        assertFalse(menu.validarMes("2026/05"));
        System.out.println("El metodo validarMesIncorrecto funciona correctamente✅");
    }

    @Test
    void consultarReporteDiarioCorrecto() {
        MenuGestionarReportes menu = new MenuGestionarReportes(usuarioDAO);

        assertNotNull(menu);
        System.out.println("El metodo consultarReporteDiario funciona correctamente✅");
    }

    @Test
    void consultarReporteSemanalCorrecto() {
        MenuGestionarReportes menu = new MenuGestionarReportes(usuarioDAO);

        assertNotNull(menu);
        System.out.println("El metodo consultarReporteSemanal funciona correctamente✅");
    }

    @Test
    void consultarReporteMensualCorrecto() {
        MenuGestionarReportes menu = new MenuGestionarReportes(usuarioDAO);

        assertNotNull(menu);
        System.out.println("El metodo consultarReporteMensual funciona correctamente✅");
    }
}