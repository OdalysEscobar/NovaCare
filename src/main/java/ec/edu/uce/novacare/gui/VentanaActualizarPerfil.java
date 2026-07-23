package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.DAO.UsuarioDAOFabrica;
import ec.edu.uce.novacare.dominio.Cliente;
import ec.edu.uce.novacare.dominio.Usuario;
import ec.edu.uce.novacare.util.Validaciones;

import javax.swing.*;

public class VentanaActualizarPerfil {

    public JPanel panelPrincipal;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField6;
    private JPasswordField passwordField1;

    private JButton ACTUALIZARButton;
    private JButton volverButton;

    private final UsuarioDAO dao;

    public VentanaActualizarPerfil() {

        dao = new UsuarioDAOFabrica().crearUsuarioDAO();

        ACTUALIZARButton.addActionListener(e -> actualizarPerfil());

        volverButton.addActionListener(e -> volverAGestionarPerfil());
    }

    private void actualizarPerfil() {

        String correoBuscar = textField1.getText().trim();

        String nombre = textField2.getText().trim();
        String apellido = textField3.getText().trim();
        String correoNuevo = textField4.getText().trim();

        String contrasena =
                new String(passwordField1.getPassword()).trim();

        String telefono = textField6.getText().trim();

        // Validar campos vacíos
        if (correoBuscar.isEmpty()
                || nombre.isEmpty()
                || apellido.isEmpty()
                || correoNuevo.isEmpty()
                || contrasena.isEmpty()
                || telefono.isEmpty()) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Debe completar todos los campos.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Validar el correo utilizado para buscar
        if (!Validaciones.validarCorreo(correoBuscar)) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Ingrese correctamente el correo actual del usuario.",
                    "Correo inválido",
                    JOptionPane.WARNING_MESSAGE
            );

            textField1.requestFocus();
            return;
        }

        // Buscar al usuario
        Usuario usuario = dao.buscarPorCorreo(correoBuscar);

        if (usuario == null) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "No se encontró un usuario con ese correo.",
                    "Usuario no encontrado",
                    JOptionPane.WARNING_MESSAGE
            );

            textField1.requestFocus();
            return;
        }

        // Validar nombre
        if (!Validaciones.validarLetras(nombre)) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "El nombre solo puede contener letras.",
                    "Nombre inválido",
                    JOptionPane.WARNING_MESSAGE
            );

            textField2.requestFocus();
            return;
        }

        // Validar apellido
        if (!Validaciones.validarLetras(apellido)) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "El apellido solo puede contener letras.",
                    "Apellido inválido",
                    JOptionPane.WARNING_MESSAGE
            );

            textField3.requestFocus();
            return;
        }

        // Validar correo nuevo
        if (!Validaciones.validarCorreo(correoNuevo)) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Ingrese un correo nuevo válido.",
                    "Correo inválido",
                    JOptionPane.WARNING_MESSAGE
            );

            textField4.requestFocus();
            return;
        }

        // Validar contraseña
        if (!Validaciones.validarContrasena(contrasena)) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "La contraseña solo puede contener letras y números.",
                    "Contraseña inválida",
                    JOptionPane.WARNING_MESSAGE
            );

            passwordField1.requestFocus();
            return;
        }

        // Validar teléfono
        if (!Validaciones.validarTelefono(telefono)) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "El teléfono debe tener 10 dígitos y comenzar con 09.",
                    "Teléfono inválido",
                    JOptionPane.WARNING_MESSAGE
            );

            textField6.requestFocus();
            return;
        }

        Cliente clienteActualizado = new Cliente(
                nombre,
                apellido,
                contrasena,
                correoNuevo,
                telefono
        );

        boolean actualizado =
                dao.editar(clienteActualizado, correoBuscar);

        if (actualizado) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Perfil actualizado correctamente.",
                    "Actualización exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );

            volverAGestionarPerfil();

        } else {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "No fue posible actualizar el perfil.\n"
                            + "Verifique que el nuevo correo no pertenezca a otro usuario.",
                    "Error al actualizar",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void volverAGestionarPerfil() {

        JFrame gestionFrame =
                new JFrame("Gestionar Perfil - NovaCare");

        gestionFrame.setContentPane(
                new VentanaGestionarPerfil().panelPrincipal
        );

        gestionFrame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        gestionFrame.pack();
        gestionFrame.setLocationRelativeTo(null);
        gestionFrame.setVisible(true);

        JFrame ventanaActual =
                (JFrame) SwingUtilities.getWindowAncestor(
                        panelPrincipal
                );

        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
    }
}