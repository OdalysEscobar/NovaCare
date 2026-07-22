package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.DAO;
import ec.edu.uce.novacare.DAO.TipoServicioDAOMemoriaImpl;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.TipoServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VentanaConsultarServicios {

    public JPanel panelPrincipal;
    private JTable tablaServicios;
    private JButton regresarButton;

    public VentanaConsultarServicios() {

        cargarServicios();

        regresarButton.addActionListener(e -> regresarGestionServicios());
    }

    private void cargarServicios() {

        String[] columnas = {
                "Tipo de servicio",
                "Servicio",
                "Duración",
                "Estado"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        DAO tipoServicioDAO = new TipoServicioDAOMemoriaImpl();

        List<TipoServicio> tiposServicio =
                (List<TipoServicio>) tipoServicioDAO.listarTodos();

        for (TipoServicio tipoServicio : tiposServicio) {

            if (tipoServicio == null) {
                continue;
            }

            List<Servicio> servicios =
                    tipoServicio.getServicios();

            if (servicios == null || servicios.isEmpty()) {
                continue;
            }

            for (Servicio servicio : servicios) {

                if (servicio == null) {
                    continue;
                }

                modelo.addRow(new Object[]{
                        tipoServicio.getNombreTipoServicio(),
                        servicio.getNombre(),
                        servicio.getDuracion() + " min",
                        convertirDisponibilidad(servicio)
                });
            }
        }

        tablaServicios.setModel(modelo);

        tablaServicios.setRowHeight(25);
        tablaServicios.getTableHeader().setReorderingAllowed(false);
        tablaServicios.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION
        );
    }

    private String convertirDisponibilidad(Servicio servicio) {

        if (servicio.getDisponibilidad() == null) {
            return "Sin estado";
        }

        return switch (servicio.getDisponibilidad()) {

            case DISPONIBLE -> "Disponible";

            case NO_DISPONIBLE -> "No disponible";
        };
    }

    private void regresarGestionServicios() {

        JFrame gestionFrame =
                new JFrame("Gestionar Servicios - NovaCare");

        gestionFrame.setContentPane(
                new VentanaGestionarServicios().panelPrincipal
        );

        gestionFrame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        gestionFrame.pack();
        gestionFrame.setLocationRelativeTo(null);
        gestionFrame.setVisible(true);

        JFrame ventanaActual =
                (JFrame) SwingUtilities.getWindowAncestor(
                        regresarButton
                );

        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
    }
}
