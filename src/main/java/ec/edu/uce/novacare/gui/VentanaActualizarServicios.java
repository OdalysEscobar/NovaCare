package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.DAO;
import ec.edu.uce.novacare.DAO.TipoServicioDAOMemoriaImpl;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.TipoServicio;
import ec.edu.uce.novacare.dominio.Disponibilidad;
import ec.edu.uce.novacare.util.Validaciones;

import javax.swing.*;
import java.util.List;

public class VentanaActualizarServicios {

    private JComboBox<String> tipoServicioComboBox;
    private JComboBox<String> accionComboBox;
    private JComboBox<String> servicioComboBox;

    private JTextField nombreServicioTextField;
    private JTextField duracionTextField;

    private JComboBox<String> disponibilidadComboBox;

    private JButton guardarButton;
    private JButton volverButton;

    public JPanel panelPrincipal;

    private final DAO tipoServicioDAO;
    private List<TipoServicio> tiposServicio;

    public VentanaActualizarServicios() {

        tipoServicioDAO = new TipoServicioDAOMemoriaImpl();

        configurarComboBox();
        cargarTiposServicio();
        tipoServicioComboBox.addActionListener(e -> cargarServicios());
        accionComboBox.addActionListener(e -> cambiarModo());
        cambiarModo();
        volverButton.addActionListener(e -> volverAGestionarServicios());
        guardarButton.addActionListener(e -> guardarCambios());
    }

    private void configurarComboBox() {

        // Opciones de acción
        accionComboBox.removeAllItems();
        accionComboBox.addItem("Modificar servicio existente");
        accionComboBox.addItem("Agregar nuevo servicio");

        // Opciones de disponibilidad
        disponibilidadComboBox.removeAllItems();
        disponibilidadComboBox.addItem("Disponible");
        disponibilidadComboBox.addItem("No disponible");
    }

    private void cargarTiposServicio() {

        tiposServicio =
                (List<TipoServicio>) tipoServicioDAO.listarTodos();

        tipoServicioComboBox.removeAllItems();

        if (tiposServicio == null || tiposServicio.isEmpty()) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "No existen tipos de servicio registrados.",
                    "Sin servicios",
                    JOptionPane.WARNING_MESSAGE
            );

            guardarButton.setEnabled(false);
            return;
        }

        for (TipoServicio tipoServicio : tiposServicio) {

            tipoServicioComboBox.addItem(
                    tipoServicio.getNombreTipoServicio()
            );
        }

        if (tipoServicioComboBox.getItemCount() > 0) {
            tipoServicioComboBox.setSelectedIndex(0);
            cargarServicios();
        }
    }

    private void cargarServicios() {

        servicioComboBox.removeAllItems();

        int posicionTipo = tipoServicioComboBox.getSelectedIndex();

        if (posicionTipo < 0 || posicionTipo >= tiposServicio.size()) {
            return;
        }

        TipoServicio tipoSeleccionado =
                tiposServicio.get(posicionTipo);

        if (tipoSeleccionado.getServicios() == null
                || tipoSeleccionado.getServicios().isEmpty()) {

            servicioComboBox.addItem("No existen servicios");
            servicioComboBox.setEnabled(false);

            nombreServicioTextField.setText("");
            duracionTextField.setText("");

            return;
        }

        servicioComboBox.setEnabled(true);

        for (Servicio servicio : tipoSeleccionado.getServicios()) {
            servicioComboBox.addItem(servicio.getNombre());
        }
    }

    private void cambiarModo() {

        boolean modificar =
                accionComboBox.getSelectedIndex() == 0;

        servicioComboBox.setEnabled(modificar);

        if (modificar) {
            cargarServicios();
        } else {
            servicioComboBox.setSelectedIndex(-1);
            nombreServicioTextField.setText("");
            duracionTextField.setText("");
            disponibilidadComboBox.setSelectedIndex(0);
        }
    }

    private void volverAGestionarServicios() {

        JFrame frame = new JFrame("Gestionar Servicios - NovaCare");

        VentanaGestionarServicios ventanaGestionar =
                new VentanaGestionarServicios();

        frame.setContentPane(
                ventanaGestionar.panelPrincipal
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

    private void guardarCambios() {

        if (accionComboBox.getSelectedIndex() == 0) {
            modificarServicio();
        } else {
            agregarServicio();
        }
    }

    private void modificarServicio() {

        int posicionTipo = tipoServicioComboBox.getSelectedIndex();
        int posicionServicio = servicioComboBox.getSelectedIndex();

        if (posicionTipo < 0 || posicionServicio < 0) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Seleccione un tipo y un servicio.",
                    "Datos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String nuevoNombre =
                nombreServicioTextField.getText().trim();

        String duracionTexto =
                duracionTextField.getText().trim();

        if (!validarCampos(nuevoNombre, duracionTexto)) {
            return;
        }

        int nuevaDuracion =
                Integer.parseInt(duracionTexto);

        TipoServicio tipoSeleccionado =
                tiposServicio.get(posicionTipo);

        Servicio servicioSeleccionado =
                tipoSeleccionado.getServicios().get(posicionServicio);

        servicioSeleccionado.setNombre(nuevoNombre);
        servicioSeleccionado.setDuracion(nuevaDuracion);
        servicioSeleccionado.setDisponibilidad(
                obtenerDisponibilidad()
        );

        boolean actualizado =
                tipoServicioDAO.editar(
                        posicionTipo,
                        tipoSeleccionado
                );

        if (actualizado) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Servicio actualizado correctamente.",
                    "Actualización exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );

            cargarTiposServicio();

        } else {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "No se pudo actualizar el servicio.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void agregarServicio() {

        int posicionTipo =
                tipoServicioComboBox.getSelectedIndex();

        if (posicionTipo < 0) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Seleccione un tipo de servicio.",
                    "Datos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String nombre =
                nombreServicioTextField.getText().trim();

        String duracionTexto =
                duracionTextField.getText().trim();

        if (!validarCampos(nombre, duracionTexto)) {
            return;
        }

        TipoServicio tipoSeleccionado =
                tiposServicio.get(posicionTipo);

        for (Servicio servicioExistente :
                tipoSeleccionado.getServicios()) {

            if (servicioExistente.getNombre()
                    .equalsIgnoreCase(nombre)) {

                JOptionPane.showMessageDialog(
                        panelPrincipal,
                        "Ya existe un servicio con ese nombre.",
                        "Servicio repetido",
                        JOptionPane.WARNING_MESSAGE
                );

                return;
            }
        }

        int duracion =
                Integer.parseInt(duracionTexto);

        Servicio nuevoServicio =
                new Servicio(
                        nombre,
                        obtenerDisponibilidad(),
                        duracion
                );

        tipoSeleccionado.getServicios().add(nuevoServicio);

        boolean guardado =
                tipoServicioDAO.editar(
                        posicionTipo,
                        tipoSeleccionado
                );

        if (guardado) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Servicio agregado correctamente.",
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            cargarTiposServicio();
            accionComboBox.setSelectedIndex(0);

        } else {

            tipoSeleccionado.getServicios().remove(nuevoServicio);

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "No se pudo agregar el servicio.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private boolean validarCampos(
            String nombre,
            String duracionTexto) {

        if (nombre.isEmpty() || duracionTexto.isEmpty()) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Complete el nombre y la duración.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        if (!Validaciones.validarLetras(nombre)) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "El nombre del servicio solo puede contener letras.",
                    "Nombre inválido",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        try {

            int duracion =
                    Integer.parseInt(duracionTexto);

            if (duracion <= 0) {

                JOptionPane.showMessageDialog(
                        panelPrincipal,
                        "La duración debe ser mayor que cero.",
                        "Duración inválida",
                        JOptionPane.WARNING_MESSAGE
                );

                return false;
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "La duración debe ser un número entero.",
                    "Duración inválida",
                    JOptionPane.ERROR_MESSAGE
            );

            return false;
        }

        return true;
    }

    private Disponibilidad obtenerDisponibilidad() {

        if (disponibilidadComboBox.getSelectedIndex() == 0) {
            return Disponibilidad.DISPONIBLE;
        }

        return Disponibilidad.NO_DISPONIBLE;
    }
}
