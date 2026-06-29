package ec.edu.uce.novacare.interfaz;

import javax.swing.*;
import java.awt.*;

public class FrmMenu extends JFrame {

    public FrmMenu() {
        setTitle("NovaCare — Menú Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(380, 280);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel lbl = new JLabel("Panel Principal", SwingConstants.CENTER);
        lbl.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(lbl, gbc);

        // Botones de navegación hacia los formularios
        JButton btnClientes  = new JButton("Gestionar Clientes");
        JButton btnEmpleados = new JButton("Gestionar Empleados");
        JButton btnSalir     = new JButton("Cerrar Sesión");

        gbc.gridy = 1; panel.add(btnClientes, gbc);
        gbc.gridy = 2; panel.add(btnEmpleados, gbc);
        gbc.gridy = 3; panel.add(btnSalir, gbc);

        add(panel);

        // Cada botón abre su formulario y cierra el menú actual
        btnClientes.addActionListener(e  -> { new FrmCliente().setVisible(true);  dispose(); });
        btnEmpleados.addActionListener(e -> { new FrmEmpleado().setVisible(true); dispose(); });
        // Cerrar sesión regresa al login
        btnSalir.addActionListener(e     -> { new FrmLogin().setVisible(true);    dispose(); });
    }
}