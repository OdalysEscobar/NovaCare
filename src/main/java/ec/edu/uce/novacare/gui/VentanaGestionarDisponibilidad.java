package ec.edu.uce.novacare.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionarDisponibilidad {
    public JPanel panelPrincipal;
    private JButton consultarDisponibilidadButton;
    private JButton volverAlMenuPrincipalButton;
    private JTable table1;
    private JButton regresarButton;

    public VentanaGestionarDisponibilidad() {
        consultarDisponibilidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarDisponibilidad();
            }
        });

        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarAGestionarCitas();
            }
        });

        volverAlMenuPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarMenuPrincipal();
            }
        });
    }

    private void consultarDisponibilidad() {
        Object[][] datos = {
                {"1", "09:00", "Disponible"},
                {"2", "10:00", "Ocupado"},
                {"3", "11:00", "Disponible"},
                {"4", "12:00", "Disponible"}
        };

        String[] columnas = {"N°", "Hora", "Estado"};

        DefaultTableModel modelo = new DefaultTableModel(datos, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table1.setModel(modelo);
    }

    private void regresarAGestionarCitas() {
        JFrame gestionarCitasFrame = new JFrame("Gestionar Citas - NovaCare");
        gestionarCitasFrame.setContentPane(new VentanaGestionarCitas().panelPrincipal);
        gestionarCitasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gestionarCitasFrame.pack();
        gestionarCitasFrame.setLocationRelativeTo(null);
        gestionarCitasFrame.setVisible(true);

        JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(regresarButton);
        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
    }

    private void regresarMenuPrincipal() {
        JFrame menuFrame = new JFrame("NovaCare - Menú Principal");
        menuFrame.setContentPane(new VentanaMenu().panelPrincipal);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.pack();
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);

        JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(volverAlMenuPrincipalButton);
        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
    }
}
