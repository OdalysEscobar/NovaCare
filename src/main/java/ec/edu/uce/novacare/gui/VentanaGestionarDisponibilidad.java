package ec.edu.uce.novacare.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionarDisponibilidad {
    public JPanel panelPrincipal;
    private JButton crearDisponibilidadButton;
    private JButton actualizarDisponibilidadButton;
    private JButton consultarDisponibilidadButton;
    private JButton eliminarDisponibilidadButton;
    private JButton volverAlMenuPrincipalButton;

    public VentanaGestionarDisponibilidad() {

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

        crearDisponibilidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aquí va la ventana para crear disponibilidad.");
            }
        });

        actualizarDisponibilidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aquí va la ventana para actualizar disponibilidad.");
            }
        });

        consultarDisponibilidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aquí va la ventana para consultar disponibilidad.");
            }
        });

        eliminarDisponibilidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aquí va la ventana para eliminar disponibilidad.");
            }
        });
    }
}