package ec.edu.uce.novacare.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionarPerfil {
    public JPanel panelPrincipal;
    private JButton crearPerfilButton;
    private JButton consultarPerfilButton;
    private JButton actualizarPerfilButton;
    private JButton eliminarPerfilButton;
    private JButton volverAlMenuPrincipalButton;

    public VentanaGestionarPerfil() {
        volverAlMenuPrincipalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame menuFrame = new JFrame("Menú Principal - NovaCare");
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
        });

        crearPerfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame crearFrame = new JFrame("Crear Perfil - NovaCare");
                crearFrame.setContentPane(new VentanaCrearPerfil().panelPrincipal);
                crearFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                crearFrame.pack();
                crearFrame.setLocationRelativeTo(null);
                crearFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(crearPerfilButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

        consultarPerfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame consultarFrame = new JFrame("Consultar Perfil - NovaCare");
                consultarFrame.setContentPane(new VentanaConsultarPerfil().panelPrincipal);
                consultarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                consultarFrame.pack();
                consultarFrame.setLocationRelativeTo(null);
                consultarFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(consultarPerfilButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

        actualizarPerfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame actualizarFrame = new JFrame("Actualizar Perfil - NovaCare");
                actualizarFrame.setContentPane(new VentanaActualizarPerfil().panelPrincipal);
                actualizarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                actualizarFrame.pack();
                actualizarFrame.setLocationRelativeTo(null);
                actualizarFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(actualizarPerfilButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

        eliminarPerfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame eliminarFrame = new JFrame("Eliminar Perfil - NovaCare");
                eliminarFrame.setContentPane(new VentanaEliminarPerfil().panelPrincipal);
                eliminarFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                eliminarFrame.pack();
                eliminarFrame.setLocationRelativeTo(null);
                eliminarFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(eliminarPerfilButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });
    }
}