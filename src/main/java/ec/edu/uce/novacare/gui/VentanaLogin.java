package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.DAO.UsuarioDAOFabrica;
import ec.edu.uce.novacare.dominio.Usuario;

import javax.swing.*;

public class VentanaLogin {

    JPanel panelPrincipal;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton ingresarButton;
    private JButton regresarAlInicioButton;

    public VentanaLogin() {

        ingresarButton.addActionListener(e -> iniciarSesion());
        regresarAlInicioButton.addActionListener(e -> regresarAlInicio());
    }

    private void iniciarSesion() {

        String correo = textField1.getText().trim();
        String contrasena =
                new String(passwordField1.getPassword());

        if (correo.isEmpty() || contrasena.isEmpty()) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Debe completar el correo y la contraseña.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        UsuarioDAOFabrica fabrica =
                new UsuarioDAOFabrica();

        UsuarioDAO usuarioDAO =
                fabrica.crearUsuarioDAO();

        Usuario usuario =
                usuarioDAO.buscarPorCorreo(correo);

        if (usuario == null) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "No existe un usuario registrado con ese correo.",
                    "Usuario no encontrado",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        if (!usuario.getContrasena().equals(contrasena)) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "La contraseña es incorrecta.",
                    "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE
            );

            passwordField1.setText("");
            passwordField1.requestFocus();

            return;
        }

        JOptionPane.showMessageDialog(
                panelPrincipal,
                "Inicio de sesión correcto.",
                "Bienvenido",
                JOptionPane.INFORMATION_MESSAGE
        );

        abrirMenu();
    }

    private void abrirMenu() {

        JFrame menuFrame =
                new JFrame("Menú Principal - NovaCare");

        menuFrame.setContentPane(
                new VentanaMenu().panelPrincipal
        );

        menuFrame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        menuFrame.pack();
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);

        JFrame ventanaActual =
                (JFrame) SwingUtilities.getWindowAncestor(
                        ingresarButton
                );

        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
    }

    private void regresarAlInicio() {

        JFrame inicioFrame =
                new JFrame("NovaCare");

        inicioFrame.setContentPane(
                new NovaCare().getPanelPrincipal()
        );

        inicioFrame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        inicioFrame.pack();
        inicioFrame.setLocationRelativeTo(null);
        inicioFrame.setVisible(true);

        JFrame ventanaActual =
                (JFrame) SwingUtilities.getWindowAncestor(
                        regresarAlInicioButton
                );

        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
    }
}
