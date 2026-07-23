package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.CitaDAOMemoriaImpl;
import ec.edu.uce.novacare.DAO.DAO;
import ec.edu.uce.novacare.dominio.Cita;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaConsultarCita {
    public JPanel panelPrincipal;
    private JTextArea textArea1;
    private JButton VOLVERButton;
    private JLabel listadoDeCitas;

    private DAO citaDAO;

    public VentanaConsultarCita() {
        // Inicializamos el DAO
        this.citaDAO = new CitaDAOMemoriaImpl();

        if (textArea1 != null) {
            textArea1.setEditable(false);
            textArea1.setLineWrap(true);
            textArea1.setWrapStyleWord(true);
        }

        // Cargar citas en el JTextArea
        mostrarCitas();

        VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volverAMenuCitas();
            }
        });
    }

    private void mostrarCitas() {
        List<Cita> citas = (List<Cita>) citaDAO.listarTodos();

        if (citas == null || citas.isEmpty()) {
            textArea1.setText("No existen citas registradas actualmente.");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < citas.size(); i++) {
            Cita cita = citas.get(i);

            String nombreCliente = (cita.getCliente() != null) ? cita.getCliente().getNombre() : "Sin cliente";
            String nombreServicio = (cita.getServicio() != null) ? cita.getServicio().getNombre() : "Sin servicio";

            sb.append("Cita ").append(i + 1).append(":\n");
            sb.append("• Cliente: ").append(nombreCliente).append("\n");
            sb.append("• Servicio: ").append(nombreServicio).append("\n");
            sb.append("• Fecha: ").append(cita.getFecha()).append("\n");
            sb.append("• Hora: ").append(cita.getHora()).append("\n\n");
        }

        textArea1.setText(sb.toString());
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