package ec.edu.uce.novacare.interfaz;

import java.util.Scanner;

public class RegistrarUsuario {
    Scanner scanner=new Scanner (System.in);

    public RegistrarUsuario () {
    }

    public boolean guardarUsuario (){
        System.out.println("=== Registrar Usuario ===");
        String nombre;
        String apellido;
        String correo;
        String contrasena;

        System.out.println("Ingresa tu nombre: ");
        nombre = scanner.nextLine();

        System.out.println("Ingresa tu apellido: ");
        apellido = scanner.nextLine();

        System.out.println("Ingresa tu correo: ");
        correo = scanner.nextLine();

        System.out.println("Ingresa tu contraseña: ");
        contrasena = scanner.nextLine();
        return  true;
    }
}
