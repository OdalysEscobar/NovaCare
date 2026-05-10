package ec.edu.uce.novacare;

import ec.edu.uce.novacare.interfaz.MenuIngresarSistema;
import ec.edu.uce.novacare.interfaz.MenuPrincipal;
import ec.edu.uce.novacare.interfaz.MenuIngresarSistema;

public class Launcher {

    public static void main(String[] args) {


        MenuPrincipal menu = new MenuPrincipal();

        menu.mostrarMenu();

        MenuIngresarSistema menu1 = new MenuIngresarSistema();

        menu1.mostrarMenu();
    }

}
