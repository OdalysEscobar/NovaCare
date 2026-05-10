package ec.edu.uce.novacare;

import ec.edu.uce.novacare.interfaz.MenuIngresarSistema;
import ec.edu.uce.novacare.interfaz.MenuPrincipal;

public class Launcher {

    public static void main(String[] args) {

        MenuIngresarSistema menu1 = new MenuIngresarSistema();

        menu1.mostrarMenu();

        MenuPrincipal menu = new MenuPrincipal();

        menu.mostrarMenu();


    }

}
