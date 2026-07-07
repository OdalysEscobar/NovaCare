package ec.edu.uce.novacare;
import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.DAO.UsuarioDAOFabrica;
import ec.edu.uce.novacare.dominio.*;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class TestUsuarioDAO {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);

        UsuarioDAOFabrica fabrica = new UsuarioDAOFabrica();
        UsuarioDAO dao = fabrica.crearUsuarioDAO();
        CentroDeBelleza.getCentro().inicializar();


        String accion;
        Usuario usuario;
        String correo;

        do{
            System.out.println("Ingrese \nC: para crear, \nB: reporte, \nE: editar, \nD: eliminar, \nL: listar, \nS:Salir");
            System.out.println("Ingrese una opcion: ");
            accion = sc.nextLine();

            switch (accion){
                case "C":
                    usuario = new Cliente("Marta", "Espinoza", "1236", "marta@uce.com", "0999999999");
                    dao.nuevo(usuario);
                    usuario = new Empleado("Javier", "Rivera", "123", "javi@hotmail.com", Especialidad.SPA, new Agenda());
                    dao.nuevo(usuario);

                    System.out.println("=======================================");
                    for (Usuario u : dao.listar()){
                        System.out.println(u);
                        System.out.println("Agregado exitosamente.");
                    }
                    System.out.println("=======================================");
                    break;

                case "B":
                    System.out.println("Ingrese el correo:");

                    correo = sc.nextLine();

                    usuario = dao.buscarPorCorreo(correo);

                    if(usuario != null){
                        System.out.println(usuario);
                    }else{
                        System.out.println("Usuario no encontrado.");
                    }

                    break;

                case "E":
                    System.out.println("Ingrese el correo:");

                    correo = sc.nextLine();

                    usuario = dao.buscarPorCorreo(correo);

                    if(usuario == null){
                        System.out.println("Usuario no encontrado.");
                        break;
                    }

                    Usuario nuevo = new Cliente("Ana", "Lopez", "9999", "ana@gmail.com", "0988888888");

                    dao.editar(nuevo, correo);

                    System.out.println("Usuario actualizado.");

                    break;

                case "D":
                    System.out.println("Ingrese el correo:");

                    correo = sc.nextLine();

                    usuario = dao.buscarPorCorreo(correo);

                    if(usuario == null){
                        System.out.println("Usuario no encontrado.");
                        break;
                    }

                    dao.eliminar(correo);

                    System.out.println("Usuario eliminado.");

                    break;

                case "L":
                    for(Usuario u : dao.listar()){
                        if(u != null){
                            System.out.println(u);
                        }
                    }

                    break;

                case "S":
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        }while(!accion.equals("S"));

    }
}
