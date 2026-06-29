package ec.edu.uce.novacare.test.interfaz;

import ec.edu.uce.novacare.DAO.CentroDeBellezaDAO;
import ec.edu.uce.novacare.dominio.Agenda;
import ec.edu.uce.novacare.dominio.CentroDeBelleza;
import ec.edu.uce.novacare.dominio.Empleado;
import ec.edu.uce.novacare.dominio.Especialidad;
import ec.edu.uce.novacare.dominio.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrmEmpleadoTest {

    private CentroDeBellezaDAO dao;

    @BeforeEach
    void setUp() {
        // Se prepara el DAO y se cargan datos iniciales
        dao = new CentroDeBellezaDAO();
        CentroDeBelleza.getCentro().inicializar();
    }

    @Test
    void agregarEmpleadoDesdeFormulario() {
        // Simula el botón Agregar del formulario de empleados
        Empleado emp = new Empleado(
                "Carlos",
                "Vera",
                "emp123",
                "carlos@novacare.com",
                Especialidad.BARBERIA,
                new Agenda()
        );

        boolean ok = dao.agregar(emp);

        assertTrue(ok);

        System.out.println("FrmEmpleado → Agregar empleado ✅");
    }

    @Test
    void agregarEmpleadoNuloDesdeFormulario() {
        // Simula que el objeto empleado no se generó correctamente
        boolean ok = dao.agregar(null);

        assertFalse(ok);

        System.out.println("FrmEmpleado → Agregar null rechazado ❌");
    }

    @Test
    void agregarEmpleadoDuplicadoDesdeFormulario() {
        // Agrega un empleado y vuelve a intentar agregarlo
        Empleado emp = new Empleado(
                "Carlos",
                "Vera",
                "emp123",
                "carlos2@novacare.com",
                Especialidad.BARBERIA,
                new Agenda()
        );

        dao.agregar(emp);
        boolean ok = dao.agregar(emp);

        assertFalse(ok);

        System.out.println("FrmEmpleado → Empleado duplicado rechazado ❌");
    }

    @Test
    void buscarEmpleadoDesdeFormulario() {
        // Busca al empleado creado por inicializar()
        Usuario u = CentroDeBelleza.buscarUsuario("juan@hotmail.com");

        assertNotNull(u);
        assertInstanceOf(Empleado.class, u);

        System.out.println("FrmEmpleado → Buscar empleado ✅");
    }

    @Test
    void buscarEmpleadoInexistenteDesdeFormulario() {
        // Busca un correo inexistente
        Usuario u = CentroDeBelleza.buscarUsuario("noexiste@novacare.com");

        assertNull(u);

        System.out.println("FrmEmpleado → Buscar empleado inexistente ❌");
    }

    @Test
    void editarEmpleadoDesdeFormulario() {
        // Agrega primero un empleado
        dao.agregar(new Empleado(
                "Luis",
                "Mora",
                "pass",
                "luis@novacare.com",
                Especialidad.MANICURA,
                new Agenda()
        ));

        // Luego lo edita
        Empleado actualizado = new Empleado(
                "LuisEditado",
                "Mora",
                "newpass",
                "luis_nuevo@novacare.com",
                Especialidad.BARBERIA,
                new Agenda()
        );

        boolean ok = CentroDeBelleza.getCentro().editarUsuario(actualizado, "luis@novacare.com");

        assertTrue(ok);
        assertNotNull(CentroDeBelleza.buscarUsuario("luis_nuevo@novacare.com"));

        System.out.println("FrmEmpleado → Editar empleado ✅");
    }

    @Test
    void editarEmpleadoInexistenteDesdeFormulario() {
        // Intenta editar un empleado no existente
        Empleado actualizado = new Empleado(
                "X",
                "Y",
                "000",
                "nuevo@novacare.com",
                Especialidad.MANICURA,
                new Agenda()
        );

        boolean ok = CentroDeBelleza.getCentro().editarUsuario(actualizado, "noexiste@novacare.com");

        assertFalse(ok);

        System.out.println("FrmEmpleado → Editar empleado inexistente ❌");
    }

    @Test
    void eliminarEmpleadoDesdeFormulario() {
        // Agrega un empleado y luego lo elimina
        dao.agregar(new Empleado(
                "Rosa",
                "Lima",
                "r123",
                "rosa@novacare.com",
                Especialidad.MANICURA,
                new Agenda()
        ));

        boolean ok = CentroDeBelleza.getCentro().eliminarUsuario("rosa@novacare.com");

        assertTrue(ok);
        assertNull(CentroDeBelleza.buscarUsuario("rosa@novacare.com"));

        System.out.println("FrmEmpleado → Eliminar empleado ✅");
    }

    @Test
    void eliminarEmpleadoInexistenteDesdeFormulario() {
        // Intenta eliminar un empleado que no existe
        boolean ok = CentroDeBelleza.getCentro().eliminarUsuario("fantasma@novacare.com");

        assertFalse(ok);

        System.out.println("FrmEmpleado → Eliminar empleado inexistente ❌");
    }
}