package ec.edu.uce.novacare.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminarPerfil {
    public JPanel panelPrincipal;
    private JTextField textField1; // Correo del usuario
    private JTextField textField2; // Ingresar 'si' o 'no'
    private JButton ELIMINARPERFILButton;
    private JButton volverButton;

    public VentanaEliminarPerfil() {
        ELIMINARPERFILButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String confirmacion = textField2.getText().trim().toLowerCase();

                if (confirmacion.equals("si") || confirmacion.equals("sí")) {
                    JOptionPane.showMessageDialog(null, "Perfil eliminado correctamente.");

                    JFrame gestionFrame = new JFrame("Gestionar Perfil - NovaCare");
                    gestionFrame.setContentPane(new VentanaGestionarPerfil().panelPrincipal);
                    gestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gestionFrame.pack();
                    gestionFrame.setLocationRelativeTo(null);
                    gestionFrame.setVisible(true);

                    JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(ELIMINARPERFILButton);
                    if (ventanaActual != null) {
                        ventanaActual.dispose();
                    }
                } else if (confirmacion.equals("no")) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error: solo puede ingresar 'si' o 'no'.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                }
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