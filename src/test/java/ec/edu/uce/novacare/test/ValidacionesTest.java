package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.util.Validaciones;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidacionesTest {

    // Validar Letras
    @Test
    void validarLetrasCorrecto() {

        boolean resultado = Validaciones.validarLetras("Romy Vinueza");
        assertEquals(true, resultado);

        System.out.println("Validación de letras correcta✅");

    }
    @Test
    void validarLetrasIncorrecto() {

        boolean resultado = Validaciones.validarLetras("Romy 598");
        assertEquals(false, resultado);

        System.out.println("Validación de letras incorrecta detectada correctamente✅");


    }

    // Validar Correo
    @Test
    void validarCorreoCorrecto() {

        boolean resultado = Validaciones.validarCorreo("aromy1909@gmail.com");
        assertEquals(true, resultado);

        System.out.println("Validación de correo correcta✅");

    }
    @Test
    void validarCorreoIncorrecto() {

        boolean resultado = Validaciones.validarCorreo("aromy1909gmail.com");
        assertEquals(false, resultado);

        System.out.println("Validación de correo incorrecto detectado correctamente✅");
    }
    // Validar Contraseña
    @Test
    void validarContrasenaCorrecto() {

        boolean resultado = Validaciones.validarContrasena("123rv");
        assertEquals(true, resultado);

        System.out.println("Validación de contraseña correcta✅");

    }
    @Test
    void validarContrasenaIncorrecto() {

        boolean resultado = Validaciones.validarContrasena("123rv//");
        assertEquals(false, resultado);

        System.out.println("Validación de contraseña incorrecta detectada correctamente✅");

    }

    // Validar Fecha
    @Test
    void validarFechaCorrecto() {

        boolean resultado = Validaciones.validarFecha("2026-05-22");
        assertEquals(true, resultado);

        System.out.println("Validación de fehca correcta✅");

    }
    @Test
    void validarFechaIncorrecto() {

        boolean resultado = Validaciones.validarFecha("22/05/2026");
        assertEquals(false, resultado);

        System.out.println("Validación de fecha incorrecta detectada correctamente✅");
    }

    // Validar Hora
    @Test
    void validarHoraCorrecta() {

        boolean resultado = Validaciones.validarHora("14:25");
        assertEquals(true, resultado);

        System.out.println("Validación de hora correcta✅");

    }
    @Test
    void validarHoraIncorrecta() {
        boolean resultado = Validaciones.validarHora("25:25");
        assertEquals(false, resultado);

        System.out.println("Validación de hora incorrecta detectada correctamente✅");
    }
}












