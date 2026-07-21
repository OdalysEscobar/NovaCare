package ec.edu.uce.novacare.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionarReportes {
    public JPanel panelPrincipal;
    private JButton generarReporteButton;
    private JButton consultarReporteButton;
    private JButton exportarReporteButton;
    private JButton volverAlMenuPrincipalButton;

    public VentanaGestionarReportes() {

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

        generarReporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aquí va la generación del reporte.");
            }
        });

        consultarReporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aquí va la consulta del reporte.");
            }
        });

        exportarReporteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Aquí va la exportación del reporte.");
            }
        });
    }
}