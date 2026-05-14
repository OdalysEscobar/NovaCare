package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ec.edu.uce.novacare.util.Validaciones;

public class IniciarSesion {
    Scanner scanner = new Scanner(System.in);

    public IniciarSesion() {
    }

    public boolean login(){
        String correo;
        String contrasena;
        System.out.println(" === Iniciar sesión ===");

        System.out.println("Ingrese su correo: ");
        correo = scanner.nextLine();
        System.out.println("Ingrese su contraseña: ");
        contrasena = scanner.nextLine();
        boolean checkCorreo= Validaciones.validarCorreo(correo);
        boolean checkContrasena= Validaciones.validarContrasena(contrasena);

        if(checkCorreo==false|| checkContrasena==false){
            if (checkContrasena==false && checkCorreo==false) {
                System.out.println("Contrasena y correo, no cumplen con los formatos.");
                return false;
            }


            if(checkCorreo==false){
                System.out.println("Correo con formato incorrecto ");
                return false;
            }
            if(checkContrasena==false){
                System.out.println("Contraseña inválida, solo se permmite numeros y letras");
                return false;
            }
        }

        return true;
    }
}
