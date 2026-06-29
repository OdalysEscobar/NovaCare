package ec.edu.uce.novacare.test.interfaz;

import ec.edu.uce.novacare.DAO.CentroDeBellezaDAO;
import ec.edu.uce.novacare.dominio.CentroDeBelleza;
import ec.edu.uce.novacare.dominio.Cliente;
import ec.edu.uce.novacare.dominio.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrmClienteTest {

    private CentroDeBellezaDAO dao;

    @BeforeEach
    void setUp() {
        // Se crea el DAO y se inicializa el sistema antes de cada prueba
        dao = new CentroDeBellezaDAO();
        CentroDeBelleza.getCentro().inicializar();
    }

    @Test
    void agregarClienteDesdeFormulario() {
        // Simula lo que hace FrmCliente al presionar el botón Agregar
        Cliente c = new Cliente("Laura", "Torres", "pass123", "laura@gmail.com", "0991112233");

        boolean ok = dao.agregar(c);

        assertTrue(ok);

        System.out.println("FrmCliente → Agregar cliente ✅");
    }

    @Test
    void agregarClienteNuloDesdeFormulario() {
        // Simula que desde el formulario no se construyó correctamente el objeto
        boolean ok = dao.agregar(null);

        assertFalse(ok);

        System.out.println("FrmCliente → Agregar null rechazado ❌");
    }

    @Test
    void agregarClienteDuplicadoDesdeFormulario() {
        // Agrega un cliente y luego intenta agregarlo otra vez
        Cliente c = new Cliente("Laura", "Torres", "pass123", "laura2@gmail.com", "0991112234");

        dao.agregar(c);
        boolean ok = dao.agregar(c);

        assertFalse(ok);

        System.out.println("FrmCliente → Cliente duplicado rechazado ❌");
    }

    @Test
    void buscarClienteDesdeFormulario() {
        // Busca un cliente cargado en la inicialización
        Usuario u = CentroDeBelleza.buscarUsuario("maria@uce.com");

        assertNotNull(u);
        assertEquals("maria@uce.com", u.getCorreo());

        System.out.println("FrmCliente → Buscar cliente ✅");
    }

    @Test
    void buscarClienteInexistenteDesdeFormulario() {
        // Busca un correo que no existe
        Usuario u = CentroDeBelleza.buscarUsuario("noexiste@mail.com");

        assertNull(u);

        System.out.println("FrmCliente → Buscar cliente inexistente ❌");
    }

    @Test
    void editarClienteDesdeFormulario() {
        // Primero se agrega un cliente
        dao.agregar(new Cliente("Ana", "Perez", "1234", "ana@test.com", "0991111111"));

        // Luego se construye uno nuevo con los datos actualizados
        Cliente actualizado = new Cliente("AnaEditada", "Gomez", "9999", "ana_nueva@test.com", "0992222222");

        boolean ok = CentroDeBelleza.getCentro().editarUsuario(actualizado, "ana@test.com");

        assertTrue(ok);
        assertNotNull(CentroDeBelleza.buscarUsuario("ana_nueva@test.com"));

        System.out.println("FrmCliente → Editar cliente ✅");
    }

    @Test
    void editarClienteInexistenteDesdeFormulario() {
        // Intenta editar un cliente que no existe
        Cliente actualizado = new Cliente("X", "Y", "0000", "nuevo@test.com", "0990000000");

        boolean ok = CentroDeBelleza.getCentro().editarUsuario(actualizado, "noexiste@test.com");

        assertFalse(ok);

        System.out.println("FrmCliente → Editar cliente inexistente ❌");
    }

    @Test
    void eliminarClienteDesdeFormulario() {
        // Agrega un cliente y luego lo elimina
        dao.agregar(new Cliente("Pedro", "Ruiz", "abc", "pedro@test.com", "0993333333"));

        boolean ok = CentroDeBelleza.getCentro().eliminarUsuario("pedro@test.com");

        assertTrue(ok);
        assertNull(CentroDeBelleza.buscarUsuario("pedro@test.com"));

        System.out.println("FrmCliente → Eliminar cliente ✅");
    }

    @Test
    void eliminarClienteInexistenteDesdeFormulario() {
        // Intenta eliminar un cliente que no está registrado
        boolean ok = CentroDeBelleza.getCentro().eliminarUsuario("fantasma@test.com");

        assertFalse(ok);

        System.out.println("FrmCliente → Eliminar cliente inexistente ❌");
    }
}