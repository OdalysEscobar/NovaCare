package ec.edu.uce.novacare.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenu {
    public JPanel panelPrincipal;
    private JButton gestionarPerfilDeUsuarioButton;
    private JButton gestionarCitasButton;
    private JButton gestionarServiciosButton;
    private JButton gestionarDisponibilidadDeCitasButton;
    private JButton gestionarAgendaDeCitasButton;
    private JButton gestionarReportesDeCitasButton;

    public VentanaMenu() {
        gestionarPerfilDeUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame gestionFrame = new JFrame("Gestionar Perfil - NovaCare");
                gestionFrame.setContentPane(new VentanaGestionarPerfil().panelPrincipal);
                gestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gestionFrame.pack();
                gestionFrame.setLocationRelativeTo(null);
                gestionFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(gestionarPerfilDeUsuarioButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

        gestionarCitasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame citasFrame = new JFrame("Gestionar Citas - NovaCare");
                citasFrame.setContentPane(new VentanaGestionarCitas().panelPrincipal);
                citasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                citasFrame.pack();
                citasFrame.setLocationRelativeTo(null);
                citasFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(gestionarCitasButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

        gestionarServiciosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame serviciosFrame = new JFrame("Gestionar Servicios - NovaCare");
                serviciosFrame.setContentPane(new VentanaGestionarServicios().panelPrincipal);
                serviciosFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                serviciosFrame.pack();
                serviciosFrame.setLocationRelativeTo(null);
                serviciosFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(gestionarServiciosButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });
    }
}