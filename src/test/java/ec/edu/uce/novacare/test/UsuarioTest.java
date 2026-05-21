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
    void setNombreInvalido (){
        Usuario usuario = new Usuario();
        usuario.setNombre("Shirley123");
        assertEquals("",usuario.getNombre());
    }

    @Test
    void getCorreo() {
        Usuario usuario = new Usuario ("Ana", "Quezada", "ana125", "anita@hotmail.com");
        assertEquals("anita@hotmail.com", usuario.getCorreo());
    }

    @Test
    void setCorreo() {
        Usuario usuario = new Usuario ();
        usuario.setCorreo("odalys@gmail.com");
        assertEquals("odalys@gmail.com",usuario.getCorreo());

    }

    @Test
    void setCorreoInvalido(){
        Usuario usuario = new Usuario();
        usuario.setCorreo("odalys.com");
        assertEquals("",usuario.getCorreo());
    }

    @Test
    void getApellido() {
        Usuario usuario = new Usuario ("Ana", "Quezada", "ana125", "anita@hotmail.com");
        assertEquals("Quezada", usuario.getApellido());

    }

    @Test
    void setApellido() {
        Usuario usuario= new Usuario ();
        usuario.setApellido("Mites");
        assertEquals("Mites",usuario.getApellido());
    }

    @Test
    void setApellidoInvalido(){
        Usuario usuario= new Usuario ();
        usuario.setApellido("Mite52s");
        assertEquals("",usuario.getApellido());
    }

    @Test
    void getContrasena() {
        Usuario usuario = new Usuario ("Ana", "Quezada", "ana125", "anita@hotmail.com");
        assertEquals("ana125", usuario.getContrasena());
    }

    @Test
    void setContrasena() {
        Usuario usuario = new Usuario();
        usuario.setContrasena("maria123");
        assertEquals("maria123", usuario.getContrasena());
    }

    @Test
    void SetContrasenaInvalida(){
        Usuario usuario = new Usuario();
        usuario.setContrasena("maria123?");
        assertEquals("", usuario.getContrasena());
    }
}