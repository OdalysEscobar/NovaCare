package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.UsuarioDAOMemoriaImpl;
import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.dominio.Usuario;
import ec.edu.uce.novacare.dominio.Cliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaConsultarPerfil {
    public JPanel panelPrincipal;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton consultarButton;
    private JButton volverButton;

    private UsuarioDAO dao = new UsuarioDAOMemoriaImpl();


    public VentanaConsultarPerfil() {

        textArea1.setEditable(false);
        textArea1.setLineWrap(true);
        textArea1.setWrapStyleWord(true);
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correo = textField1.getText().trim();
                if (correo.isEmpty()) {
                    JOptionPane.showMessageDialog(panelPrincipal,
                            "Por favor, ingrese el correo del usuario.",
                            "Campo Vacío",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                // Búsqueda real en la lista/memoria
                Usuario usuario = dao.buscarPorCorreo(correo);

                if (usuario != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("\n    DATOS DEL USUARIO    \n\n");
                    sb.append(" • Código: ").append(usuario.getCodigo()).append("\n");
                    sb.append(" • Nombre: ").append(usuario.getNombre()).append(" ").append(usuario.getApellido()).append("\n");
                    sb.append(" • Correo: ").append(usuario.getCorreo()).append("\n");

                    // Verificamos si el usuario es un Cliente para obtener sus datos específicos
                    if (usuario instanceof ec.edu.uce.novacare.dominio.Cliente) {
                        ec.edu.uce.novacare.dominio.Cliente cliente = (ec.edu.uce.novacare.dominio.Cliente) usuario;
                        sb.append(" • Teléfono: ").append(cliente.getNumeroDeTelefono()).append("\n");
                    }

                    textArea1.setText(sb.toString());
                } else {
                    textArea1.setText("");
                    JOptionPane.showMessageDialog(panelPrincipal,
                            "Usuario no encontrado con el correo: " + correo,
                            "Sin Resultados",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame gestionFrame = new JFrame("Gestionar Perfil - NovaCare");
                gestionFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaGestionarPerfil().panelPrincipal);
                gestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                gestionFrame.pack();
                gestionFrame.setLocationRelativeTo(null);
                gestionFrame.setVisible(true);

                JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(volverButton);
                if (ventanaActual != null) {
                    ventanaActual.dispose();
                }
            }
        });
    }
}