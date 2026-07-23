package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.DAO.UsuarioDAOMemoriaImpl;
import ec.edu.uce.novacare.dominio.Usuario;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEliminarPerfil {
    public JPanel panelPrincipal;
    private JTextField textField1; // Correo del usuario
    private JTextField textField2; // Ingresar 'si' o 'no'
    private JButton ELIMINARPERFILButton;
    private JButton volverButton;

    private UsuarioDAO dao = new UsuarioDAOMemoriaImpl();

    public VentanaEliminarPerfil() {
        ELIMINARPERFILButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String correo = textField1.getText().trim();

                // 1. Validar que ingresó un correo
                if (correo.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            panelPrincipal,
                            "Por favor, ingrese el correo del usuario.",
                            "Campo incompleto",
                            JOptionPane.WARNING_MESSAGE
                    );
                    return;
                }

                // 2. Buscar si el usuario existe en la base de datos / memoria
                Usuario usuario = dao.buscarPorCorreo(correo);

                if (usuario == null) {
                    JOptionPane.showMessageDialog(
                            panelPrincipal,
                            "No existe un usuario registrado con ese correo.",
                            "Usuario no encontrado",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return;
                }

                // 3. Mostrar ventana emergente de confirmación (Sí / No)
                int respuesta = JOptionPane.showConfirmDialog(
                        panelPrincipal,
                        "¿Está seguro de que desea eliminar el perfil?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                // 4. Si presiona "Sí"
                if (respuesta == JOptionPane.YES_OPTION) {

                    // Elimina del DAO usando el código del usuario encontrado
                    dao.eliminar(correo);

                    JOptionPane.showMessageDialog(null, "Perfil eliminado correctamente.");

                    JFrame gestionFrame = new JFrame("Gestionar Perfil - NovaCare");
                    gestionFrame.setContentPane(new ec.edu.uce.novacare.gui.VentanaGestionarPerfil().panelPrincipal);
                    gestionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    gestionFrame.pack();
                    gestionFrame.setLocationRelativeTo(null);
                    gestionFrame.setVisible(true);

                    JFrame ventanaActual = (JFrame) SwingUtilities.getWindowAncestor(ELIMINARPERFILButton);
                    if (ventanaActual != null) {
                        ventanaActual.dispose();
                    }
                } else {
                    // Si presiona "No" o cierra la ventanita
                    JOptionPane.showMessageDialog(null, "Operación cancelada.");
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