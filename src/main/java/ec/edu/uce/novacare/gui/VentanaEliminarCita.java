package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.CitaDAOMemoriaImpl;
import ec.edu.uce.novacare.DAO.DAO;
import ec.edu.uce.novacare.dominio.Cita;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaEliminarCita {
    public JPanel panelPrincipal; // Coincide exactamente con tu .form
    private JTextArea textArea1;
    private JTextField textField1;
    private JButton CANCELARButton;
    private JButton VOLVERButton;

    private DAO citaDAO;

    public VentanaEliminarCita() {
        this.citaDAO = new CitaDAOMemoriaImpl();

        // Configurar el área de texto para que no sea editable
        if (textArea1 != null) {
            textArea1.setEditable(false);
            textArea1.setLineWrap(true);
            textArea1.setWrapStyleWord(true);
        }

        // Cargar las citas al iniciar la ventana
        listarCitas();

        CANCELARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarCita();
            }
        });

        VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAMenuCitas();
            }
        });
    }

    private void listarCitas() {
        List<Cita> citas = (List<Cita>) citaDAO.listarTodos();

        if (citas == null || citas.isEmpty()) {
            textArea1.setText("No hay citas disponibles para cancelar.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < citas.size(); i++) {
            Cita c = citas.get(i);
            String nombreCliente = (c.getCliente() != null) ? c.getCliente().getNombre() : "Sin nombre";
            String nombreServicio = (c.getServicio() != null) ? c.getServicio().getNombre() : "Sin servicio";

            // Formato exacto idéntico al de tu consola
            sb.append(i + 1).append(". ")
                    .append(nombreCliente).append(" | ")
                    .append(nombreServicio).append(" | ")
                    .append(c.getFecha()).append(" | ")
                    .append(c.getHora()).append("\n");
        }

        textArea1.setText(sb.toString());
    }

    private void cancelarCita() {
        String input = textField1.getText().trim();

        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(panelPrincipal, "Ingrese el número de la cita que desea cancelar.", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int opcion = Integer.parseInt(input);
            List<Cita> citas = (List<Cita>) citaDAO.listarTodos();

            if (citas == null || citas.isEmpty()) {
                JOptionPane.showMessageDialog(panelPrincipal, "No existen citas para cancelar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (opcion < 1 || opcion > citas.size()) {
                JOptionPane.showMessageDialog(panelPrincipal, "Número de cita inválido. Seleccione un número de la lista.", "Error de Selección", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Diálogo de confirmación simulando el (si/no) de consola
            int confirmacion = JOptionPane.showConfirmDialog(
                    panelPrincipal,
                    "¿Desea cancelar la cita #" + opcion + "?",
                    "Confirmar cancelación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                int posicionEnLista = opcion - 1;

                if (citaDAO.eliminar(posicionEnLista)) {
                    JOptionPane.showMessageDialog(panelPrincipal, "Cita cancelada correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    volverAMenuCitas();
                } else {
                    JOptionPane.showMessageDialog(panelPrincipal, "No se pudo cancelar la cita.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(panelPrincipal, "Por favor, ingrese únicamente el número de la cita.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void volverAMenuCitas() {
        JFrame citasFrame = new JFrame("Gestionar Citas - NovaCare");
        citasFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaGestionarCitas().panelPrincipal);
        citasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        citasFrame.pack();
        citasFrame.setLocationRelativeTo(null);
        citasFrame.setVisible(true);

        JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(VOLVERButton);
        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
    }
}