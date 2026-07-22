package ec.edu.uce.novacare.gui;

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
    private JButton salirButton;

    public VentanaMenu() {
        gestionarPerfilDeUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame gestionFrame = new JFrame("Gestionar Perfil - NovaCare");
                gestionFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaGestionarPerfil().panelPrincipal);
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
                citasFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaGestionarCitas().panelPrincipal);
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
                serviciosFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaGestionarServicios().panelPrincipal);
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
        gestionarDisponibilidadDeCitasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame disponibilidadFrame = new JFrame("Gestionar Disponibilidad - NovaCare");
                disponibilidadFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaGestionarDisponibilidad().panelPrincipal);
                disponibilidadFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                disponibilidadFrame.pack();
                disponibilidadFrame.setLocationRelativeTo(null);
                disponibilidadFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(gestionarDisponibilidadDeCitasButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

        gestionarAgendaDeCitasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame agendaFrame = new JFrame("Gestionar Agenda - NovaCare");
                agendaFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaGestionarAgenda().panelPrincipal);
                agendaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                agendaFrame.pack();
                agendaFrame.setLocationRelativeTo(null);
                agendaFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(gestionarAgendaDeCitasButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

        gestionarReportesDeCitasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame reportesFrame = new JFrame("Gestionar Reportes - NovaCare");
                reportesFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaGestionarReportes().panelPrincipal);
                reportesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                reportesFrame.pack();
                reportesFrame.setLocationRelativeTo(null);
                reportesFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(gestionarReportesDeCitasButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame inicioFrame = new JFrame("NovaCare");

                NovaCare ventanaInicio = new NovaCare();

                inicioFrame.setContentPane(ventanaInicio.getPanelPrincipal());

                inicioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                inicioFrame.pack();
                inicioFrame.setLocationRelativeTo(null);
                inicioFrame.setVisible(true);

                JFrame ventanaActual =
                        (JFrame) SwingUtilities.getWindowAncestor(salirButton);

                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });
    }
}