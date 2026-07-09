package ec.edu.uce.novacare.interfaz;

import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.DAO.UsuarioDAOMemoriaImpl;
import ec.edu.uce.novacare.dominio.Usuario;

import java.util.Scanner;

import ec.edu.uce.novacare.util.Validaciones;

public class IniciarSesion {
    Scanner scanner = new Scanner(System.in);
    private UsuarioDAO usuarioDAO;

    public IniciarSesion(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public boolean validarLogin(String correo, String contrasena){

        boolean checkCorreo = Validaciones.validarCorreo(correo);
        boolean checkContrasena =  Validaciones.validarContrasena(contrasena);
        return checkCorreo && checkContrasena;

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

        Usuario usuario = usuarioDAO.buscarPorCorreo(correo);


        if(usuario == null){
            System.out.println("Usuario no registrado.");
            return false;
        }



        // NUEVA PARTE: verificar contraseña

        if(!usuario.getContrasena().equals(contrasena)){
            System.out.println("Contraseña incorrecta.");
            return false;
        }




        System.out.println("==============================");
        System.out.println("Bienvenido(a) "
                + usuario.getNombre()
                + " "
                + usuario.getApellido());
        System.out.println("==============================");


        return true;
    }
}

