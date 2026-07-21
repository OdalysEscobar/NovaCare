package ec.edu.uce.novacare.GUI;

import javax.swing.*;

public class VentanaLogin {
    JPanel panelPrincipal;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    public VentanaLogin() {
        ingresarButton.addActionListener(e -> {
            JFrame menuFrame = new JFrame("Menú Principal - NovaCare");
            menuFrame.setContentPane(new VentanaMenu().panelPrincipal);
            menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            menuFrame.pack();
            menuFrame.setLocationRelativeTo(null);
            menuFrame.setVisible(true);

            JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(ingresarButton);
            if (ventanaActual != null) {
                ventanaActual.dispose();
            }
        });
    }
}
