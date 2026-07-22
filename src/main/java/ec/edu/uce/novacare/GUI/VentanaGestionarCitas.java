package ec.edu.uce.novacare.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionarCitas {
    public JPanel panelPrincipal;
    private JButton crearCitaButton;
    private JButton consultarCitaButton;
    private JButton actualizarCitaButton;
    private JButton cancelarCitaButton;
    private JButton volverAlMenuPrincipalButton;

    public VentanaGestionarCitas() {
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

        crearCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame crearCitaFrame = new JFrame("Crear Cita - NovaCare");
                crearCitaFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanCrearCita().panelPrincipal);
                crearCitaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                crearCitaFrame.pack();
                crearCitaFrame.setLocationRelativeTo(null);
                crearCitaFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(crearCitaButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

        consultarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        actualizarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        cancelarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}