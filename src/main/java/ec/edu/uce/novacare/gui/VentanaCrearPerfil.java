package ec.edu.uce.novacare.gui;

import javax.swing.*;
import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.DAO.UsuarioDAOFabrica;
import ec.edu.uce.novacare.dominio.Cliente;
import ec.edu.uce.novacare.util.Validaciones;

public class VentanaCrearPerfil {
    public JPanel panelPrincipal;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField1;
    private JTextField textField4;
    private JButton crearPerfilButton;

    public VentanaCrearPerfil() {
        crearPerfilButton.addActionListener(e -> crearPerfil());

    }

    private void crearPerfil() {

        String nombre = textField1.getText().trim();
        String apellido = textField2.getText().trim();
        String correo = textField3.getText().trim();
        String contrasena =
                new String(passwordField1.getPassword()).trim();
        String telefono = textField4.getText().trim();

        // Validar campos vacíos
        if (nombre.isEmpty()
                || apellido.isEmpty()
                || correo.isEmpty()
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

        // Validar nombre
        if (!Validaciones.validarLetras(nombre)) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "El nombre solo puede contener letras.",
                    "Nombre inválido",
                    JOptionPane.WARNING_MESSAGE
            );

            textField1.requestFocus();
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

            textField2.requestFocus();
            return;
        }

        // Validar correo
        if (!Validaciones.validarCorreo(correo)) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Ingrese un correo válido.",
                    "Correo inválido",
                    JOptionPane.WARNING_MESSAGE
            );

            textField3.requestFocus();
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
                    "Ingrese un teléfono válido de 10 dígitos que empiece con 09.",
                    "Teléfono inválido",
                    JOptionPane.WARNING_MESSAGE
            );

            textField4.requestFocus();
            return;
        }

        Cliente cliente = new Cliente(
                nombre,
                apellido,
                contrasena,
                correo,
                telefono
        );

        UsuarioDAO usuarioDAO =
                new UsuarioDAOFabrica().crearUsuarioDAO();

        boolean guardado = usuarioDAO.nuevo(cliente);

        if (guardado) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Perfil creado correctamente.",
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            volverAGestionarPerfil();

        } else {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Ya existe un usuario con ese correo.",
                    "Usuario duplicado",
                    JOptionPane.WARNING_MESSAGE
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