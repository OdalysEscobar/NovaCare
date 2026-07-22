package ec.edu.uce.novacare.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaCrearServicio {
    public JPanel panelPrincipal;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton CREARButton;
    private JButton volverButton;

    public VentanaCrearServicio() {
        CREARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String duracionStr = textField4.getText().trim();

                try {
                    int minutos = Integer.parseInt(duracionStr);

                    if (minutos > 0) {
                        JOptionPane.showMessageDialog(null, "Servicio creado con éxito.");

                        JFrame serviciosFrame = new JFrame("Gestionar Servicios - NovaCare");
                        serviciosFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaGestionarServicios().panelPrincipal);
                        serviciosFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        serviciosFrame.pack();
                        serviciosFrame.setLocationRelativeTo(null);
                        serviciosFrame.setVisible(true);

                        JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(CREARButton);
                        if (ventanaActual != null) {
                            ventanaActual.dispose();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame serviciosFrame = new JFrame("Gestionar Servicios - NovaCare");
                serviciosFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaGestionarServicios().panelPrincipal);
                serviciosFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                serviciosFrame.pack();
                serviciosFrame.setLocationRelativeTo(null);
                serviciosFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(volverButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });
    }
}