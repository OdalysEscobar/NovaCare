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
                JFrame consultarCitaFrame = new JFrame("Consultar Citas - NovaCare");

                // Creamos la instancia de la ventana
                VentanaConsultarCita ventana = new VentanaConsultarCita();

                // Asignamos el panel principal de esa ventana
                consultarCitaFrame.setContentPane(ventana.panelPrincipal);
                consultarCitaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                consultarCitaFrame.pack();
                consultarCitaFrame.setLocationRelativeTo(null);
                consultarCitaFrame.setVisible(true);

                // Cerramos el menú actual
                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(consultarCitaButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

        actualizarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame actualizarCitaFrame = new JFrame("Actualizar Cita - NovaCare");
                actualizarCitaFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaActualizarCita().panelPrincipal);
                actualizarCitaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                actualizarCitaFrame.pack();
                actualizarCitaFrame.setLocationRelativeTo(null);
                actualizarCitaFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(actualizarCitaButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });
        cancelarCitaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame cancelarFrame = new JFrame("Cancelar Cita - NovaCare");
                cancelarFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaEliminarCita().panelPrincipal);
                cancelarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                cancelarFrame.pack();
                cancelarFrame.setLocationRelativeTo(null);
                cancelarFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(cancelarCitaButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });
    }
}