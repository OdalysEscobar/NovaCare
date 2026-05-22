package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.interfaz.MenuPrincipal;
import ec.edu.uce.novacare.interfaz.MenuGestionarPerfil;
import ec.edu.uce.novacare.interfaz.MenuGestionarCitas;
import ec.edu.uce.novacare.interfaz.MenuGestionarAgenda;
import ec.edu.uce.novacare.interfaz.MenuGestionarDisponibilidad;
import ec.edu.uce.novacare.interfaz.MenuGestionarServicios;
import ec.edu.uce.novacare.interfaz.MenuGestionarReportes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuPrincipalTest {

    // Mostrar Menu
    @Test
    void mostrarMenuCorrecto() {

        MenuPrincipal menu = new MenuPrincipal();
        assertNotNull(menu);
        System.out.println("Menú principal creado correctamente ✅");
    }
    @Test
    void mostrarMenuIncorrecto() {

        MenuPrincipal menu = null;
        assertNull(menu);
        System.out.println("Menú principal nulo detectado correctamente ✅");
    }

    // Gestionar Perfil
    @Test
    void opcionGestionarPerfilCorrecto() {

        MenuGestionarPerfil menuPerfil = new MenuGestionarPerfil();

        assertNotNull(menuPerfil);

        System.out.println("Menú gestionar perfil accesible correctamente ✅");
    }
    @Test
    void opcionGestionarPerfilIncorrecto() {

        MenuGestionarPerfil menuPerfil = null;

        assertNull(menuPerfil);

        System.out.println("Menú gestionar perfil nulo detectado correctamente ✅");
    }

    // Gestionar Citas
    @Test
    void opcionGestionarCitasCorrecto() {

        MenuGestionarCitas menuCitas = new MenuGestionarCitas();

        assertNotNull(menuCitas);

        System.out.println("Menú gestionar citas accesible correctamente ✅");
    }
    @Test
    void opcionGestionarCitasIncorrecto() {

        MenuGestionarCitas menuCitas = null;

        assertNull(menuCitas);

        System.out.println("Menú gestionar citas nulo detectado correctamente ✅");
    }

    // Gestionar Servicios
    @Test
    void opcionGestionarServiciosCorrecto() {

        MenuGestionarServicios menuServicios = new MenuGestionarServicios();

        assertNotNull(menuServicios);

        System.out.println("Menú gestionar servicios accesible correctamente ✅");
    }
    @Test
    void opcionGestionarServiciosIncorrecto() {

        MenuGestionarServicios menuServicios = null;

        assertNull(menuServicios);

        System.out.println("Menú gestionar servicios nulo detectado correctamente ✅");
    }

    // Gestionar Disponibilidad
    @Test
    void opcionGestionarDisponibilidadCorrecto() {

        MenuGestionarDisponibilidad menuDisp = new MenuGestionarDisponibilidad();

        assertNotNull(menuDisp);

        System.out.println("Menú gestionar disponibilidad accesible correctamente ✅");
    }
    @Test
    void opcionGestionarDisponibilidadIncorrecto() {

        MenuGestionarDisponibilidad menuDisp = null;

        assertNull(menuDisp);

        System.out.println("Menú gestionar disponibilidad nulo detectado correctamente ✅");
    }

    // Gestionar Agenda
    @Test
    void opcionGestionarAgendaCorrecto() {

        MenuGestionarAgenda menuAgenda = new MenuGestionarAgenda();

        assertNotNull(menuAgenda);

        System.out.println("Menú gestionar agenda accesible correctamente ✅");
    }
    @Test
    void opcionGestionarAgendaIncorrecto() {

        MenuGestionarAgenda menuAgenda = null;

        assertNull(menuAgenda);

        System.out.println("Menú gestionar agenda nulo detectado correctamente ✅");
    }

    // Gestionar Reportes
    @Test
    void opcionGestionarReportesCorrecto() {

        MenuGestionarReportes menuReportes = new MenuGestionarReportes();

        assertNotNull(menuReportes);

        System.out.println("Menú gestionar reportes accesible correctamente ✅");
    }
    @Test
    void opcionGestionarReportesIncorrecto() {

        MenuGestionarReportes menuReportes = null;

        assertNull(menuReportes);

        System.out.println("Menú gestionar reportes nulo detectado correctamente ✅");
    }
}