package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.DAO;
import ec.edu.uce.novacare.DAO.TipoServicioDAOMemoriaImpl;
import ec.edu.uce.novacare.dominio.Disponibilidad;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.TipoServicio;

import javax.swing.*;
import java.util.List;

public class VentanaEliminarServicio {

    public JPanel panelPrincipal;

    private JComboBox<String> tipoServicioBox;
    private JComboBox<String> servicioBox;

    private JButton eliminarButton;
    private JButton volverButton;

    private JLabel nombreValorLabel;
    private JLabel duracionValorLabel;
    private JLabel estadoValorLabel;

    private final DAO tipoServicioDAO;
    private List<TipoServicio> tiposServicio;

    public VentanaEliminarServicio() {

        tipoServicioDAO = new TipoServicioDAOMemoriaImpl();

        cargarTiposServicio();

        tipoServicioBox.addActionListener(e -> cargarServicios());

        servicioBox.addActionListener(e -> mostrarDatosServicio());

        volverButton.addActionListener(e -> volverAGestionarServicios());

        eliminarButton.addActionListener(e -> eliminarServicio());
    }

    private void cargarTiposServicio() {

        tiposServicio =
                (List<TipoServicio>) tipoServicioDAO.listarTodos();

        tipoServicioBox.removeAllItems();

        if (tiposServicio == null || tiposServicio.isEmpty()) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "No existen tipos de servicio.",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE
            );

            eliminarButton.setEnabled(false);
            return;
        }

        for (TipoServicio tipo : tiposServicio) {

            tipoServicioBox.addItem(
                    tipo.getNombreTipoServicio()
            );
        }

        if (tipoServicioBox.getItemCount() > 0) {
            tipoServicioBox.setSelectedIndex(0);
            cargarServicios();
        }
    }
    private void cargarServicios() {
        servicioBox.removeAllItems();

        int posicionTipo = tipoServicioBox.getSelectedIndex();

        if (posicionTipo < 0 || posicionTipo >= tiposServicio.size()) {
            return;
        }

        TipoServicio tipoSeleccionado =
                tiposServicio.get(posicionTipo);

        if (tipoSeleccionado.getServicios() == null
                || tipoSeleccionado.getServicios().isEmpty()) {

            servicioBox.addItem("No existen servicios");
            servicioBox.setEnabled(false);

            nombreValorLabel.setText("");
            duracionValorLabel.setText("");
            estadoValorLabel.setText("");

            return;
        }

        servicioBox.setEnabled(true);

        for (Servicio servicio : tipoSeleccionado.getServicios()) {

            servicioBox.addItem(servicio.getNombre());

        }

        if (servicioBox.getItemCount() > 0) {
            servicioBox.setSelectedIndex(0);
            mostrarDatosServicio();
        }
    }
    private void mostrarDatosServicio() {
        int posicionTipo = tipoServicioBox.getSelectedIndex();
        int posicionServicio = servicioBox.getSelectedIndex();

        if (posicionTipo < 0 || posicionServicio < 0) {
            return;
        }

        TipoServicio tipoSeleccionado =
                tiposServicio.get(posicionTipo);

        if (posicionServicio >= tipoSeleccionado.getServicios().size()) {
            return;
        }

        Servicio servicio =
                tipoSeleccionado.getServicios().get(posicionServicio);

        nombreValorLabel.setText(servicio.getNombre());

        duracionValorLabel.setText(
                servicio.getDuracion() + " minutos"
        );

        if (servicio.getDisponibilidad() == Disponibilidad.DISPONIBLE) {

            estadoValorLabel.setText("Disponible");

        } else {

            estadoValorLabel.setText("No disponible");
        }

    }
    private void eliminarServicio() {
        int posicionTipo = tipoServicioBox.getSelectedIndex();
        int posicionServicio = servicioBox.getSelectedIndex();

        if (posicionTipo < 0 || posicionServicio < 0) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Seleccione un tipo y un servicio.",
                    "Datos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        TipoServicio tipoSeleccionado =
                tiposServicio.get(posicionTipo);

        Servicio servicioSeleccionado =
                tipoSeleccionado.getServicios().get(posicionServicio);

        Object[] opciones = {"Sí", "No"};

        int respuesta = JOptionPane.showOptionDialog(
                panelPrincipal,
                "¿Está seguro de eliminar el servicio \""
                        + servicioSeleccionado.getNombre()
                        + "\"?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                opciones,
                opciones[1]
        );

        if (respuesta != 0) {
            return;
        }

        tipoSeleccionado.getServicios().remove(posicionServicio);

        boolean actualizado =
                tipoServicioDAO.editar(
                        posicionTipo,
                        tipoSeleccionado
                );

        if (actualizado) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Servicio eliminado correctamente.",
                    "Eliminación exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );

            cargarTiposServicio();

        } else {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "No se pudo eliminar el servicio.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
    private void volverAGestionarServicios() {
        JFrame frame =
                new JFrame("Gestionar Servicios - NovaCare");

        frame.setContentPane(
                new VentanaGestionarServicios().panelPrincipal
        );

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        JFrame ventanaActual =
                (JFrame) SwingUtilities.getWindowAncestor(
                        panelPrincipal
                );

        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
    }
}
