package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.dominio.Usuario;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class UsuarioTest {

    @Test
    void constructorConParametros(){
        Usuario usuario= new Usuario ("Kimberly", "Cuvi", "kim123", "kim@gmail.com");
        assertEquals("Kimberly", usuario.getNombre());
        assertEquals("Cuvi", usuario.getApellido());
        assertEquals("kim123", usuario.getContrasena());
        assertEquals("kim@gmail.com", usuario.getCorreo());
        System.out.println(usuario);
        System.out.println("El metodo constructorConParametros funciona correctamente✅");
    }

    @Test
    void testToString() {
        Usuario usuario= new Usuario ("Odalys", "Escobar", "oda123", "odalys@gmail.com");
        String textoEsperado="Usuario{" +
                "nombre='Odalys'" +
                ", correo='odalys@gmail.com'" +
                ", apellido='Escobar'" +
                ", contrasena='oda123'"+
                '}';
        assertEquals(textoEsperado, usuario.toString());
        System.out.println("El metodo toString funciona correctamente✅");
    }

    @Test
    void getNombre() {
        Usuario usuario = new Usuario ("Ana", "Quezada", "ana125", "anita@hotmail.com");
        assertEquals("Ana", usuario.getNombre());
        System.out.println("El metodo getNombre funciona correctamente✅");
    }

    @Test
    void setNombre() {
        Usuario usuario = new Usuario ();
        usuario.setNombre("Shirley");
        assertEquals("Shirley",usuario.getNombre());
        System.out.println("El metodo setNombre funciona correctamente✅");
    }

    @Test
    void setNombreInvalido (){
        Usuario usuario = new Usuario();
        usuario.setNombre("Shirley123");
        assertEquals("Sin nombre",usuario.getNombre());
        System.out.println("El metodo setNombreInvalido funciona correctamente✅");
    }

    @Test
    void getCorreo() {
        Usuario usuario = new Usuario ("Ana", "Quezada", "ana125", "anita@hotmail.com");
        assertEquals("anita@hotmail.com", usuario.getCorreo());
        System.out.println("El metodo getCorreo funciona correctamente✅");
    }

    @Test
    void setCorreo() {
        Usuario usuario = new Usuario ();
        usuario.setCorreo("odalys@gmail.com");
        assertEquals("odalys@gmail.com",usuario.getCorreo());
        System.out.println("El metodo setCorreo funciona correctamente✅");
    }

    @Test
    void setCorreoInvalido(){
        Usuario usuario = new Usuario();
        usuario.setCorreo("odalys.com");
        assertEquals("Sin correo",usuario.getCorreo());
        System.out.println("El metodo setCorreoInvalido funciona correctamente✅");
    }

    @Test
    void getApellido() {
        Usuario usuario = new Usuario ("Ana", "Quezada", "ana125", "anita@hotmail.com");
        assertEquals("Quezada", usuario.getApellido());
        System.out.println("El metodo getApellido funciona correctamente✅");
    }

    @Test
    void setApellido() {
        Usuario usuario= new Usuario ();
        usuario.setApellido("Mites");
        assertEquals("Mites",usuario.getApellido());
        System.out.println("El metodo setApellido funciona correctamente✅");
    }

    @Test
    void setApellidoInvalido(){
        Usuario usuario= new Usuario ();
        usuario.setApellido("Mite52s");
        assertEquals("Sin apellido",usuario.getApellido());
        System.out.println("El metodo setApellidoInvalido funciona correctamente✅");
    }

    @Test
    void getContrasena() {
        Usuario usuario = new Usuario ("Ana", "Quezada", "ana125", "anita@hotmail.com");
        assertEquals("ana125", usuario.getContrasena());
        System.out.println("El metodo getContrasena funciona correctamente✅");
    }

    @Test
    void setContrasena() {
        Usuario usuario = new Usuario();
        usuario.setContrasena("maria123");
        assertEquals("maria123", usuario.getContrasena());
        System.out.println("El metodo setContrasena funciona correctamente✅");
    }

    @Test
    void SetContrasenaInvalida(){
        Usuario usuario = new Usuario();
        usuario.setContrasena("maria123?");
        assertEquals("Sin contrasena", usuario.getContrasena());
        System.out.println("El metodo setContrasenaInvalida funciona correctamente✅");
    }
}