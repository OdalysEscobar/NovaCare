package ec.edu.uce.novacare.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionarReportes {
    public JPanel panelPrincipal;
    private JButton consultarReportesButton;
    private JButton volverAlMenuPrincipalButton;
    private JTable table1;
    private JButton regresarButton;

    public VentanaGestionarReportes() {
        consultarReportesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarReportes();
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

    private void consultarReportes() {
        Object[][] datos = {
                {"1", "María", "Corte de cabello", "2026-07-20", "Atendida"},
                {"2", "Juan", "Manicure", "2026-07-21", "Pendiente"},
                {"3", "Ana", "Peinado", "2026-07-22", "Atendida"}
        };

        String[] columnas = {"N°", "Cliente", "Servicio", "Fecha", "Estado"};

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