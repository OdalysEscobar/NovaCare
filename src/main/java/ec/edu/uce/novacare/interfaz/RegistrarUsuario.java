package ec.edu.uce.novacare.interfaz;

import ec.edu.uce.novacare.util.Validaciones;

import java.util.Scanner;

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
            checkNombre = Validaciones.validarLetras(nombre);
            if (checkNombre == false) {
                System.out.println("El nombre no cumple con los parámetros. Solo se permiten letras.");
            }
        } while (checkNombre==false);

        do{
            System.out.println("Ingresa tu apellido: ");
            apellido = scanner.nextLine();
            checkApellido = Validaciones.validarLetras(apellido);
            if(checkApellido ==false){
                System.out.println("El apellido no cumple con los parametros");
            }
        }while(checkApellido ==false);

        do{
            System.out.println("Ingresa tu correo: ");
            correo = scanner.nextLine();
            checkCorreo= Validaciones.validarCorreo(correo);
            if (checkCorreo==false){
                System.out.println("Formato de correo inválido.");
            }
        }while(checkCorreo==false);

        do{
            System.out.println("Ingresa tu contraseña: ");
            contrasena = scanner.nextLine();
            checkContrasena=Validaciones.validarContrasena(contrasena);
            if(checkContrasena==false){
                System.out.println("La contraseña solo puede tener números y letras");
            }
        }while(checkContrasena==false);

        System.out.println("Registrando ususario...");

    }


}
