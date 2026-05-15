package ec.edu.uce.novacare.util;

public class testValidaciones {

    public static void main(String[] args) {

        System.out.println("=== TEST VALIDACIONES ===");

        // Validar Letras
        System.out.println("Validar letras: ");

        if (Validaciones.validarLetras("Romy Moran")) {

            System.out.println("PASÓ ✔");

        } else {

            System.out.println("FALLÓ ❌");

        }

        // Validar Correo
        System.out.println("Validar correo: ");

        if (Validaciones.validarCorreo("romy09@gmail.com")) {

            System.out.println("PASÓ ✔");

        } else {

            System.out.println("FALLÓ ❌");

        }

        // Validar Contraseña
        System.out.println("Validar contraseña: ");

        if (Validaciones.validarContrasena("rm1214")) {

            System.out.println("PASÓ ✔");

        } else {

            System.out.println("FALLÓ ❌");

        }

        // Validar Fecha
        System.out.println("Validar fecha: ");

        if (Validaciones.validarFecha("2026-06-18")) {

            System.out.println("PASÓ ✔");

        } else {

            System.out.println("FALLÓ ❌");

        }

        // Validar Hora
        System.out.println("Validar hora: ");

        if (Validaciones.validarHora("14:30")){

            System.out.println("PASÓ ✔");

        } else {

            System.out.println("FALLÓ ❌");

        }
    }

}
