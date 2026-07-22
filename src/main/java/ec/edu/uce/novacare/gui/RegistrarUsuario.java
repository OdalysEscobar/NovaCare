package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.UsuarioDAO;
import ec.edu.uce.novacare.DAO.UsuarioDAOFabrica;
import ec.edu.uce.novacare.dominio.Cliente;
import ec.edu.uce.novacare.dominio.Usuario;
import ec.edu.uce.novacare.util.Validaciones;

import javax.swing.*;

public class RegistrarUsuario {

    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JPasswordField passwordField1;
    private JButton registrarButton;
    private JButton regresarAlInicioButton;

    public RegistrarUsuario() {

        registrarButton.addActionListener(e -> guardarUsuario());
        regresarAlInicioButton.addActionListener(e -> regresarAlInicio());
    }

    public JPanel getPanel1() {
        return panel1;
    }

    private void guardarUsuario() {

        // Obtener datos de los campos
        String nombre = textField1.getText().trim();
        String apellido = textField2.getText().trim();
        String correo = textField3.getText().trim();

        // Para un JPasswordField se utiliza getPassword()
        String contrasena = new String(passwordField1.getPassword());

        // Comprobar campos vacíos
        if (nombre.isEmpty()
                || apellido.isEmpty()
                || correo.isEmpty()
                || contrasena.isEmpty()) {

            JOptionPane.showMessageDialog(
                    panel1,
                    "Debe completar todos los campos.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Validar nombre
        if (!Validaciones.validarLetras(nombre)) {

            JOptionPane.showMessageDialog(
                    panel1,
                    "El nombre solo puede contener letras.",
                    "Nombre incorrecto",
                    JOptionPane.WARNING_MESSAGE
            );

            textField1.requestFocus();
            return;
        }

        // Validar apellido
        if (!Validaciones.validarLetras(apellido)) {

            JOptionPane.showMessageDialog(
                    panel1,
                    "El apellido solo puede contener letras.",
                    "Apellido incorrecto",
                    JOptionPane.WARNING_MESSAGE
            );

            textField2.requestFocus();
            return;
        }

        // Validar correo
        if (!Validaciones.validarCorreo(correo)) {

            JOptionPane.showMessageDialog(
                    panel1,
                    "El formato del correo es incorrecto.",
                    "Correo incorrecto",
                    JOptionPane.WARNING_MESSAGE
            );

            textField3.requestFocus();
            return;
        }

        // Validar contraseña
        if (!Validaciones.validarContrasena(contrasena)) {

            JOptionPane.showMessageDialog(
                    panel1,
                    "La contraseña solo puede contener números y letras.",
                    "Contraseña incorrecta",
                    JOptionPane.WARNING_MESSAGE
            );

            passwordField1.requestFocus();
            return;
        }

        // Crear el DAO
        UsuarioDAOFabrica usuarioDAOFabrica =
                new UsuarioDAOFabrica();

        UsuarioDAO usuarioDAO =
                usuarioDAOFabrica.crearUsuarioDAO();

        // Crear el cliente
        Usuario usuario = new Cliente(
                nombre,
                apellido,
                contrasena,
                correo,
                "0985587800"
        );

        // Guardar el usuario
        boolean guardado = usuarioDAO.nuevo(usuario);

        if (guardado) {

            JOptionPane.showMessageDialog(
                    panel1,
                    "Usuario registrado correctamente.",
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            limpiarCampos();

        } else {

            JOptionPane.showMessageDialog(
                    panel1,
                    "No se pudo registrar el usuario.\n"
                            + "Es posible que el correo ya esté registrado.",
                    "Error de registro",
                    JOptionPane.ERROR_MESSAGE
            );
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

    private void limpiarCampos() {
        textField1.setText("");
        textField2.setText("");
        textField3.setText("");
        passwordField1.setText("");

        textField1.requestFocus();
    }
}