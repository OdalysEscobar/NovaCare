package ec.edu.uce.novacare.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class VentanCrearCita {
    public JPanel panelPrincipal;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton CREARButton;
    private JButton VOLVERButton;

    public VentanCrearCita() {
        CREARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fechaStr = textField4.getText().trim();

                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate.parse(fechaStr, formatter);

                    JOptionPane.showMessageDialog(null, "Cita creada correctamente.");

                    JFrame citasFrame = new JFrame("Gestionar Citas - NovaCare");
                    citasFrame.setContentPane(new VentanaGestionarCitas().panelPrincipal);
                    citasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    citasFrame.pack();
                    citasFrame.setLocationRelativeTo(null);
                    citasFrame.setVisible(true);

                    JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(CREARButton);
                    if (ventanaActual != null) {
                        ventanaActual.dispose();
                    }

                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(null, "Fecha inválida.", "Error de validación", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        VOLVERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame citasFrame = new JFrame("Gestionar Citas - NovaCare");
                citasFrame.setContentPane(new VentanaGestionarCitas().panelPrincipal);
                citasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                citasFrame.pack();
                citasFrame.setLocationRelativeTo(null);
                citasFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(VOLVERButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });
    }
}