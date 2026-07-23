package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.dominio.Cita;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaGestionarAgenda {
    public JPanel panelPrincipal;
    private JButton consultarAgendaButton;
    private JButton volverAlMenuPrincipalButton;
    private JTable table1;
    private JButton regresarButton;

    public VentanaGestionarAgenda() {
        consultarAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarAgenda();
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

    private void consultarAgenda() {
        List<Cita> listaCitas = null;

        if (listaCitas == null || listaCitas.isEmpty()) {
            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "No hay citas creadas.",
                    "Agenda Vacía",
                    JOptionPane.WARNING_MESSAGE
            );

            table1.setModel(new DefaultTableModel(
                    new Object[][]{},
                    new String[]{"N°", "Cliente", "Servicio", "Fecha", "Hora"}
            ));
            return;
        }

        String[] columnas = {"N°", "Cliente", "Servicio", "Fecha", "Hora"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        int index = 1;
        for (Cita c : listaCitas) {
            Object[] fila = {
                    index++,
                    c.getCliente(),
                    c.getServicio(),
                    c.getFecha(),
                    c.getHora()
            };
            modelo.addRow(fila);
        }

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