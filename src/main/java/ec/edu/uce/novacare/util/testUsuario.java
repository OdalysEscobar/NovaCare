package ec.edu.uce.novacare.util;

import ec.edu.uce.novacare.dominio.Usuario;

public class testUsuario {

    public static void main(String[] args){

        System.out.println("=== TEST DE CLASE USUARIO ===");
        Usuario usuario = new Usuario("Cristhian5", "Vinueza", "cv0319", "cristhian12@gmail.com");

        // Prueba Nombre
        System.out.println("Prueba Nombre: ");

        if("Cristhian5".equals(usuario.getNombre())){

            System.out.println("PASÓ ✔");

        } else {

            System.out.println("FALLÓ ❌");
        }

        // Prueba Apellido
        System.out.println("Prueba Apellido: ");

        if ("Vinueza".equals(usuario.getApellido())){

            System.out.println("PASÓ ✔");

        } else {

            System.out.println("FALLÓ ❌");
        }

        // Prueba Correo
        System.out.println("Prueba Correo: ");

        if ("cristhian12@gmail.com".equals(usuario.getCorreo())){

            System.out.println("PASÓ ✔");
        } else {

            System.out.println("FALLÓ ❌");
        }

        // Prueba Contraseña
        System.out.println("Prueba Contraseña: ");

        if ("cv0319".equals(usuario.getContrasena())){

            System.out.println("PASÓ ✔");
        } else {

            System.out.println("FALLÓ ❌");
        }

        //Mostrar Objeto
        System.out.println("\n==== DATOS DEL USUARIO ====");
        System.out.println(usuario);
    }
}
