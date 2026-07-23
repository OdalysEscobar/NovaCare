package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.CitaDAOMemoriaImpl;
import ec.edu.uce.novacare.DAO.DAO;
import ec.edu.uce.novacare.DAO.TipoServicioDAOFabrica;
import ec.edu.uce.novacare.dominio.Cita;
import ec.edu.uce.novacare.dominio.Cliente;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.TipoServicio;
import ec.edu.uce.novacare.util.Validaciones;

import javax.swing.*;
import java.util.List;

public class VentanaActualizarCita {

    public JPanel panelPrincipal;
    private JTextArea textArea1;

    private JTextField textNumeroCita;
    private JTextField textNombre;
    private JTextField textFecha;
    private JTextField textHora;

    private JComboBox<TipoServicio> comboTipoServicio;
    private JComboBox<Servicio> comboServicio;

    private JButton buscarButton;
    private JButton ACTUALIZARButton;
    private JButton VOLVERButton;

    private DAO citaDAO;
    private DAO tipoServicioDAO;

    private int indiceSeleccionado = -1;

    public VentanaActualizarCita() {

        citaDAO = new CitaDAOMemoriaImpl();
        tipoServicioDAO = new TipoServicioDAOFabrica().crearTipoServicioDAO();

        textArea1.setEditable(false);

        listarCitas();

        cargarTiposServicio();

        bloquearCampos();

        comboTipoServicio.addActionListener(e -> cargarServicios());

        buscarButton.addActionListener(e -> buscarCita());

        ACTUALIZARButton.addActionListener(e -> actualizarCita());

        VOLVERButton.addActionListener(e -> volverAMenuCitas());
    }

    private void bloquearCampos() {

        textNombre.setEnabled(false);
        textFecha.setEnabled(false);
        textHora.setEnabled(false);

        comboTipoServicio.setEnabled(false);
        comboServicio.setEnabled(false);

        ACTUALIZARButton.setEnabled(false);
    }

    private void habilitarCampos() {

        textNombre.setEnabled(true);
        textFecha.setEnabled(true);
        textHora.setEnabled(true);

        comboTipoServicio.setEnabled(true);
        comboServicio.setEnabled(true);

        ACTUALIZARButton.setEnabled(true);
    }

    private void listarCitas() {

        List<Cita> citas = (List<Cita>) citaDAO.listarTodos();

        if (citas.isEmpty()) {

            textArea1.setText("No existen citas registradas.");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < citas.size(); i++) {

            Cita c = citas.get(i);

            sb.append(i + 1)
                    .append(". ")
                    .append(c.getCliente().getNombre())
                    .append(" | ")
                    .append(c.getServicio().getNombre())
                    .append(" | ")
                    .append(c.getFecha())
                    .append(" | ")
                    .append(c.getHora())
                    .append("\n");

        }

        textArea1.setText(sb.toString());

    }

    private void cargarTiposServicio() {

        comboTipoServicio.removeAllItems();

        List<TipoServicio> tipos =
                (List<TipoServicio>) tipoServicioDAO.listarTodos();

        for (TipoServicio tipo : tipos) {

            comboTipoServicio.addItem(tipo);

        }

    }

    private void cargarServicios() {

        comboServicio.removeAllItems();

        TipoServicio tipo =
                (TipoServicio) comboTipoServicio.getSelectedItem();

        if (tipo != null) {

            for (Servicio servicio : tipo.getServicios()) {

                comboServicio.addItem(servicio);

            }

        }

    }

    private void buscarCita() {

        if (textNumeroCita.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(panelPrincipal,
                    "Ingrese el número de la cita.");

            return;
        }

        int numero;

        try {

            numero = Integer.parseInt(textNumeroCita.getText());

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(panelPrincipal,
                    "Ingrese un número válido.");

            return;
        }

        List<Cita> citas = (List<Cita>) citaDAO.listarTodos();

        if (numero < 1 || numero > citas.size()) {

            JOptionPane.showMessageDialog(panelPrincipal,
                    "La cita no existe.");

            return;
        }

        indiceSeleccionado = numero - 1;

        Cita cita = citas.get(indiceSeleccionado);

        habilitarCampos();

        textNombre.setText(cita.getCliente().getNombre());

        textFecha.setText(cita.getFecha());

        textHora.setText(cita.getHora());

        TipoServicio tipoEncontrado = null;

        List<TipoServicio> tipos =
                (List<TipoServicio>) tipoServicioDAO.listarTodos();

        for (TipoServicio tipo : tipos) {

            if (tipo.getServicios().contains(cita.getServicio())) {

                tipoEncontrado = tipo;
                break;

            }

        }

        if (tipoEncontrado != null) {

            comboTipoServicio.setSelectedItem(tipoEncontrado);

            cargarServicios();

            comboServicio.setSelectedItem(cita.getServicio());

        }

        JOptionPane.showMessageDialog(panelPrincipal,
                "Cita encontrada correctamente.");

    }
    private void actualizarCita() {

        if (indiceSeleccionado == -1) {
            JOptionPane.showMessageDialog(panelPrincipal,
                    "Primero busque una cita.");
            return;
        }

        String nombre = textNombre.getText().trim();
        String fecha = textFecha.getText().trim();
        String hora = textHora.getText().trim();

        if (nombre.isEmpty() || fecha.isEmpty() || hora.isEmpty()) {
            JOptionPane.showMessageDialog(panelPrincipal,
                    "Complete todos los campos.");
            return;
        }

        if (!Validaciones.validarLetras(nombre)) {
            JOptionPane.showMessageDialog(panelPrincipal,
                    "El nombre solo debe contener letras.");
            return;
        }

        if (!Validaciones.validarFecha(fecha)) {
            JOptionPane.showMessageDialog(panelPrincipal,
                    "Fecha inválida. Formato: AAAA-MM-DD");
            return;
        }

        if (!Validaciones.validarHora(hora)) {
            JOptionPane.showMessageDialog(panelPrincipal,
                    "Hora inválida. Formato: HH:MM");
            return;
        }

        Servicio servicio = (Servicio) comboServicio.getSelectedItem();

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);

        Cita citaActualizada = new Cita();
        citaActualizada.setCliente(cliente);
        citaActualizada.setServicio(servicio);
        citaActualizada.setFecha(fecha);
        citaActualizada.setHora(hora);

        boolean actualizado = citaDAO.editar(indiceSeleccionado, citaActualizada);

        if (actualizado) {

            JOptionPane.showMessageDialog(panelPrincipal,
                    "Cita actualizada correctamente.");

            listarCitas();

            textNumeroCita.setText("");
            textNombre.setText("");
            textFecha.setText("");
            textHora.setText("");

            comboTipoServicio.setSelectedIndex(0);
            cargarServicios();
            comboServicio.setSelectedIndex(0);

            indiceSeleccionado = -1;

            bloquearCampos();

        } else {

            JOptionPane.showMessageDialog(panelPrincipal,
                    "No se pudo actualizar la cita.");

        }

    }

    private void volverAMenuCitas() {

        JFrame citasFrame = new JFrame("Gestionar Citas - NovaCare");
        citasFrame.setContentPane(new VentanaGestionarCitas().panelPrincipal);
        citasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        citasFrame.pack();
        citasFrame.setLocationRelativeTo(null);
        citasFrame.setVisible(true);

        JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(panelPrincipal);

        if (ventanaActual != null) {
            ventanaActual.dispose();
        }

    }

}