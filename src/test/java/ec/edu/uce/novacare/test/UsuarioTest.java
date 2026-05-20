package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.dominio.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UsuarioTest {

    @Test
    void testToString() {
        Usuario usuario= new Usuario ("Odalys", "Escobar", "oda123", "odalys@gmail.com");
        String textoEsperado="Usuario{" +
                "nombre='Odalys'" +
                ", correo='odalys@gmail.com'" +
                ", apellido='Escobar'" +
                ", contrasena='oda123'"+
                '}';;
        assertEquals(textoEsperado, usuario.toString());
    }

    @Test
    void getNombre() {
        Usuario usuario = new Usuario ("Ana", "Quezada", "ana125", "anita@hotmail.com");
        assertEquals("Ana", usuario.getNombre());
    }

    @Test
    void setNombre() {
        Usuario usuario = new Usuario ();
        usuario.setNombre("Shirley");
        assertEquals("Shirley",usuario.getNombre());
    }

    @Test
    void getCorreo() {
    }

    @Test
    void setCorreo() {
    }

    @Test
    void getApellido() {
    }

    @Test
    void setApellido() {
    }

    @Test
    void getContrasena() {
    }

    @Test
    void setContrasena() {
    }
}