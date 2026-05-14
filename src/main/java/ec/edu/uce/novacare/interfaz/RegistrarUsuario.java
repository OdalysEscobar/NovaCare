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
        boolean checkNombre;
        boolean checkApellido;

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
            if(checkApellido==false){
                System.out.println("El apellido no cumple con los parametros");
            }
        }while(checkApellido==false);

        System.out.println("Ingresa tu correo: ");
        correo = scanner.nextLine();

        System.out.println("Ingresa tu contraseña: ");
        contrasena = scanner.nextLine();

    }

    public boolean validarLetras(String info){
        Pattern pattern = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ]+$");
        Matcher matcher = pattern.matcher(info);
        return matcher.matches();
    }
}
