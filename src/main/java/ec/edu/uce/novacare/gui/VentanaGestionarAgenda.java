package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.CitaDAOMemoriaImpl;
import ec.edu.uce.novacare.DAO.DAO;
import ec.edu.uce.novacare.dominio.Cita;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VentanaGestionarAgenda {

    public JPanel panelPrincipal;

    private JButton consultarAgendaButton;
    private JButton volverAlMenuPrincipalButton;
    private JTable table1;
    private JButton regresarButton;

    private DAO dao;

    public VentanaGestionarAgenda() {

        dao = new CitaDAOMemoriaImpl();

        consultarAgendaButton.addActionListener(e -> consultarAgenda());

        regresarButton.addActionListener(e -> regresarAGestionarCitas());

        volverAlMenuPrincipalButton.addActionListener(
                e -> regresarMenuPrincipal()
        );
    }

    private void consultarAgenda() {

        List<Cita> listaCitas =
                (List<Cita>) dao.listarTodos();

        String[] columnas = {
                "N°",
                "Cliente",
                "Servicio",
                "Fecha",
                "Hora"
        };

        DefaultTableModel modelo =
                new DefaultTableModel(columnas, 0) {

                    @Override
                    public boolean isCellEditable(
                            int row,
                            int column
                    ) {
                        return false;
                    }
                };

        if (listaCitas == null || listaCitas.isEmpty()) {

            table1.setModel(modelo);

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "No hay citas creadas.",
                    "Agenda vacía",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int contador = 1;

        for (Cita cita : listaCitas) {

            String nombreCliente = "";

            if (cita.getCliente() != null) {
                nombreCliente =
                        cita.getCliente().getNombre();
            }

            String nombreServicio = "";

            if (cita.getServicio() != null) {
                nombreServicio =
                        cita.getServicio().getNombre();
            }

            Object[] fila = {
                    contador,
                    nombreCliente,
                    nombreServicio,
                    cita.getFecha(),
                    cita.getHora()
            };

            modelo.addRow(fila);

            contador++;
        }

        table1.setModel(modelo);

        JOptionPane.showMessageDialog(
                panelPrincipal,
                "Agenda cargada correctamente.",
                "Consultar agenda",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    private void regresarAGestionarCitas() {

        JFrame gestionarCitasFrame =
                new JFrame("Gestionar Citas - NovaCare");

        gestionarCitasFrame.setContentPane(
                new VentanaGestionarCitas().panelPrincipal
        );

        gestionarCitasFrame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        gestionarCitasFrame.pack();
        gestionarCitasFrame.setLocationRelativeTo(null);
        gestionarCitasFrame.setVisible(true);

        JFrame ventanaActual =
                (JFrame) SwingUtilities.getWindowAncestor(
                        panelPrincipal
                );

        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
    }

    private void regresarMenuPrincipal() {

        JFrame menuFrame =
                new JFrame("NovaCare - Menú Principal");

        menuFrame.setContentPane(
                new VentanaMenu().panelPrincipal
        );

        menuFrame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        menuFrame.pack();
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);

        JFrame ventanaActual =
                (JFrame) SwingUtilities.getWindowAncestor(
                        panelPrincipal
                );

        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
    }
}