package ec.edu.uce.novacare.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGestionarServicios {
    public JPanel panelPrincipal;
    private JButton crearServiciosButton;
    private JButton actualizarServiciosButton;
    private JButton consultarServiciosButton;
    private JButton eliminarServicioButton;
    private JButton volverAlMenuPrincipalButton;

    public VentanaGestionarServicios() {
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

        crearServiciosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame crearServicioFrame = new JFrame("Crear Servicio - NovaCare");
                crearServicioFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaCrearServicio().panelPrincipal);
                crearServicioFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                crearServicioFrame.pack();
                crearServicioFrame.setLocationRelativeTo(null);
                crearServicioFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(crearServiciosButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });

        actualizarServiciosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        consultarServiciosButton.addActionListener(e -> {

            JFrame consultarFrame =
                    new JFrame("Catálogo de Servicios - NovaCare");

            VentanaConsultarServicios ventana =
                    new VentanaConsultarServicios();

            consultarFrame.setContentPane(
                    ventana.panelPrincipal
            );

            consultarFrame.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );

            consultarFrame.pack();
            consultarFrame.setLocationRelativeTo(null);
            consultarFrame.setVisible(true);

            JFrame ventanaActual =
                    (JFrame) SwingUtilities.getWindowAncestor(
                            consultarServiciosButton
                    );

            if (ventanaActual != null) {
                ventanaActual.dispose();
            }
        });

        eliminarServicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}