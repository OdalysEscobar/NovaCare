package ec.edu.uce.novacare.interfaz;

import ec.edu.uce.novacare.dominio.CentroDeBelleza;
import ec.edu.uce.novacare.dominio.Usuario;

import javax.swing.*;
import java.awt.*;

public class FrmLogin extends JFrame {

    // Campos de texto del formulario
    private JTextField txtCorreo;
    private JPasswordField txtContrasena;
    // Etiqueta para mostrar mensajes de error o éxito
    private JLabel lblMensaje;

    public FrmLogin() {
        // Carga los datos iniciales del sistema (usuarios y servicios de prueba)
        CentroDeBelleza.getCentro().inicializar();
        initComponents();
    }

    private void initComponents() {
        setTitle("NovaCare — Iniciar Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 280);
        setLocationRelativeTo(null); // Centra la ventana en pantalla
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título del formulario
        JLabel lblTitulo = new JLabel("NovaCare", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(lblTitulo, gbc);

        // Campo correo
        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Correo:"), gbc);
        txtCorreo = new JTextField(18);
        gbc.gridx = 1;
        panel.add(txtCorreo, gbc);

        // Campo contraseña (oculta los caracteres)
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Contraseña:"), gbc);
        txtContrasena = new JPasswordField(18);
        gbc.gridx = 1;
        panel.add(txtContrasena, gbc);

        // Etiqueta para mensajes de validación
        lblMensaje = new JLabel("", SwingConstants.CENTER);
        lblMensaje.setForeground(Color.RED);
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        panel.add(lblMensaje, gbc);

        // Botones
        JPanel pBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        JButton btnIngresar = new JButton("Ingresar");
        JButton btnSalir    = new JButton("Salir");
        pBotones.add(btnIngresar);
        pBotones.add(btnSalir);
        gbc.gridy = 4;
        panel.add(pBotones, gbc);

        add(panel);

        // Cuando se presiona "Ingresar" llama al método iniciarSesion()
        btnIngresar.addActionListener(e -> iniciarSesion());
        // Cuando se presiona "Salir" cierra la aplicación
        btnSalir.addActionListener(e -> System.exit(0));
    }

    private void iniciarSesion() {
        String correo     = txtCorreo.getText().trim();
        String contrasena = new String(txtContrasena.getPassword()).trim();

        // Validación visual: campos vacíos
        if (correo.isEmpty() || contrasena.isEmpty()) {
            mostrarMensaje("⚠ Complete todos los campos.", Color.ORANGE);
            return;
        }

        // Conexión GUI → Dominio: busca el usuario por correo en CentroDeBelleza
        Usuario u = CentroDeBelleza.buscarUsuario(correo);

        // Verifica que existe y que la contraseña coincide
        if (u != null && u.getContrasena().equals(contrasena)) {
            mostrarMensaje("✔ Bienvenido, " + u.getNombre(), new Color(0, 128, 0));
            new FrmMenu().setVisible(true); // Abre el menú principal
            dispose(); // Cierra esta ventana
        } else {
            mostrarMensaje("✘ Correo o contraseña incorrectos.", Color.RED);
        }
    }

    // Método reutilizable para mostrar mensajes con color
    private void mostrarMensaje(String msg, Color color) {
        lblMensaje.setForeground(color);
        lblMensaje.setText(msg);
    }

    // Punto de entrada — lanza la ventana de login
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FrmLogin().setVisible(true));
    }
}