package ec.edu.uce.novacare.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConsultarPerfil {
    public JPanel panelPrincipal;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton consultarButton;
    private JButton volverButton;

    public VentanaConsultarPerfil() {
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correo = textField1.getText();
                textArea1.setText("Cliente{Usuario{codigo=2, nombre='al', correo='" + correo + "', apellido='a', contraseña='1235'}, numeroDeTelefono='0956565656'}");
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame gestionFrame = new JFrame("Gestionar Perfil - NovaCare");
                gestionFrame.setContentPane(new VentanaGestionarPerfil().panelPrincipal);
                gestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gestionFrame.pack();
                gestionFrame.setLocationRelativeTo(null);
                gestionFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(volverButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });
    }
}