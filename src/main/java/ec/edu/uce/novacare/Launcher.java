package ec.edu.uce.novacare;

import ec.edu.uce.novacare.dominio.CentroDeBelleza;
import ec.edu.uce.novacare.interfaz.MenuIngresarSistema;
import ec.edu.uce.novacare.interfaz.MenuPrincipal;
import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.DAO.UsuarioDAOMemoriaImpl;

public class Launcher {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAOMemoriaImpl();

        MenuIngresarSistema menu1 = new MenuIngresarSistema(usuarioDAO);
        CentroDeBelleza centroDeBelleza = new CentroDeBelleza();
        centroDeBelleza.inicializar();


        menu1.mostrarMenu();

        MenuPrincipal menu = new MenuPrincipal(usuarioDAO);

        menu.mostrarMenu();
    }
}
