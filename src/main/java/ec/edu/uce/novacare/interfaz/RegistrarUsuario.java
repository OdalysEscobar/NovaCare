package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrarUsuario {
    Scanner scanner=new Scanner (System.in);

    public RegistrarUsuario () {
    }

    public void guardarUsuario () {
        System.out.println("=== Registrar Usuario ===");
        String nombre;
        String apellido;
        String correo;
        String contrasena;
        boolean checkNombre, checkApellido;
        boolean checkCorreo, checkContrasena;

        do {
            System.out.println("Ingresa tu nombre: ");
            nombre = scanner.nextLine();
            checkNombre = validarLetras(nombre);
            if (checkNombre == false) {
                System.out.println("El nombre no cumple con los parámetros. Solo se permiten letras.");
            }
        } while (checkNombre==false);

        do{
            System.out.println("Ingresa tu apellido: ");
            apellido = scanner.nextLine();
            checkApellido = validarLetras(apellido);
            if(checkApellido ==false){
                System.out.println("El apellido no cumple con los parametros");
            }
        }while(checkApellido ==false);

        do{
            System.out.println("Ingresa tu correo: ");
            correo = scanner.nextLine();
            checkCorreo=validarCorreo(correo);
            if (checkCorreo==false){
                System.out.println("Formato de correo inválido.");
            }
        }while(checkCorreo==false);

        do{
            System.out.println("Ingresa tu contraseña: ");
            contrasena = scanner.nextLine();
            checkContrasena=validarContrasena(contrasena);
            if(checkContrasena==false){
                System.out.println("La contraseña solo puede tener números y letras");
            }
        }while(checkContrasena==false);

        System.out.println("Registrando ususario...");

    }


    public boolean validarLetras(String info){
        Pattern pattern = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$");
        Matcher matcher = pattern.matcher(info);
        return matcher.matches();
    }
    public boolean validarCorreo (String correo){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher= pattern.matcher(correo);
        return matcher.matches();
    }

    public boolean validarContrasena (String numeros){
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher matcher = pattern.matcher(numeros);
        return matcher.matches();
    }

}
