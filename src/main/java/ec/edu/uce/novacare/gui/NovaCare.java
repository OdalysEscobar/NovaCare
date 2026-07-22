package ec.edu.uce.novacare.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NovaCare {
    private JButton registrarUsuarioButton;
    private JButton iniciarSesionButton;
    private JPanel panelPrincipal;

    public NovaCare() {
        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame loginFrame = new JFrame("Iniciar Sesión - NovaCare");
                loginFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaLogin().panelPrincipal);
                loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                loginFrame.pack();
                loginFrame.setLocationRelativeTo(null);
                loginFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(iniciarSesionButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

        registrarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame registroFrame =
                        new JFrame("Registrar Usuario - NovaCare");

                RegistrarUsuario formularioRegistro =
                        new RegistrarUsuario();

                registroFrame.setContentPane(
                        formularioRegistro.getPanel1()
                );

                registroFrame.setDefaultCloseOperation(
                        JFrame.DISPOSE_ON_CLOSE
                );

                registroFrame.pack();
                registroFrame.setLocationRelativeTo(null);
                registroFrame.setVisible(true);

                JFrame ventanaActual =
                        (JFrame) SwingUtilities.getWindowAncestor(
                                registrarUsuarioButton
                        );

                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NovaCare");
        frame.setContentPane(new NovaCare().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}