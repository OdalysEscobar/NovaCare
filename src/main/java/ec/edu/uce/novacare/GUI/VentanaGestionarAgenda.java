package ec.edu.uce.novacare.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionarAgenda {
    public JPanel panelPrincipal;
    private JButton crearAgendaButton;
    private JButton actualizarAgendaButton;
    private JButton consultarAgendaButton;
    private JButton eliminarAgendaButton;
    private JButton volverAlMenuPrincipalButton;

    public VentanaGestionarAgenda() {

        volverAlMenuPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame menuFrame = new JFrame("Menú Principal - NovaCare");
                menuFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaMenu().panelPrincipal);
                menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                menuFrame.pack();
                menuFrame.setLocationRelativeTo(null);
                menuFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(volverAlMenuPrincipalButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

        crearAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aquí va la ventana para crear agenda.");
            }
        });

        actualizarAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aquí va la ventana para actualizar agenda.");
            }
        });

        consultarAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aquí va la ventana para consultar agenda.");
            }
        });

        eliminarAgendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aquí va la ventana para eliminar agenda.");
            }
        });
    }
}