package ec.edu.uce.novacare.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrearPerfil {
    public JPanel panelPrincipal;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField1;
    private JTextField textField4;
    private JButton crearPerfilButton;

    public VentanaCrearPerfil() {
        crearPerfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Perfil creado exitosamente");

                JFrame gestionFrame = new JFrame("Gestionar Perfil - NovaCare");
                gestionFrame.setContentPane(new VentanaGestionarPerfil().panelPrincipal);
                gestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gestionFrame.pack();
                gestionFrame.setLocationRelativeTo(null);
                gestionFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(crearPerfilButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });
    }
}