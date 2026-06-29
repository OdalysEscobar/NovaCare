package ec.edu.uce.novacare.interfaz;

import ec.edu.uce.novacare.DAO.CentroDeBellezaDAO;
import ec.edu.uce.novacare.dominio.CentroDeBelleza;
import ec.edu.uce.novacare.dominio.Cliente;
import ec.edu.uce.novacare.dominio.Usuario;

import javax.swing.*;
import java.awt.*;

public class FrmCliente extends JFrame {

    // Campos del formulario
    private JTextField txtNombre, txtApellido, txtCorreo, txtContrasena, txtTelefono;
    // Campo para buscar/editar/eliminar por correo
    private JTextField txtBuscar;
    // Área donde se muestran los resultados
    private JTextArea txtArea;
    // Etiqueta para mensajes de validación
    private JLabel lblMensaje;

    public FrmCliente() {
        initComponents();
    }

    private void initComponents() {
        setTitle("NovaCare — Gestión de Clientes");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(530, 540);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel lblTitulo = new JLabel("Gestión de Clientes", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(lblTitulo, gbc);

        // Creación dinámica de etiquetas y campos de texto
        gbc.gridwidth = 1;
        String[] etiquetas = {"Nombre:", "Apellido:", "Correo:", "Contraseña:", "Teléfono:"};
        JTextField[] campos = {
                txtNombre     = new JTextField(18),
                txtApellido   = new JTextField(18),
                txtCorreo     = new JTextField(18),
                txtContrasena = new JTextField(18),
                txtTelefono   = new JTextField(18)
        };
        for (int i = 0; i < etiquetas.length; i++) {
            gbc.gridx = 0; gbc.gridy = i + 1; panel.add(new JLabel(etiquetas[i]), gbc);
            gbc.gridx = 1; panel.add(campos[i], gbc);
        }

        // Etiqueta de validación visual (mensajes de error/éxito)
        lblMensaje = new JLabel("", SwingConstants.CENTER);
        lblMensaje.setForeground(Color.RED);
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 2;
        panel.add(lblMensaje, gbc);

        // Botones CRUD
        JPanel pBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 8, 0));
        JButton btnAgregar  = new JButton("Agregar");
        JButton btnEditar   = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnLimpiar  = new JButton("Limpiar");
        pBotones.add(btnAgregar); pBotones.add(btnEditar);
        pBotones.add(btnEliminar); pBotones.add(btnLimpiar);
        gbc.gridy = 7; panel.add(pBotones, gbc);

        // Panel de búsqueda por correo
        JPanel pBuscar = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        txtBuscar = new JTextField(16);
        JButton btnBuscar   = new JButton("Buscar");
        JButton btnVerTodos = new JButton("Ver Todos");
        pBuscar.add(new JLabel("Buscar correo:"));
        pBuscar.add(txtBuscar); pBuscar.add(btnBuscar); pBuscar.add(btnVerTodos);
        gbc.gridy = 8; panel.add(pBuscar, gbc);

        // Área de texto para mostrar resultados (no editable)
        txtArea = new JTextArea(5, 38);
        txtArea.setEditable(false);
        txtArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
        gbc.gridy = 9; panel.add(new JScrollPane(txtArea), gbc);

        // Botón para regresar al menú principal
        JButton btnVolver = new JButton("← Volver al Menú");
        gbc.gridy = 10; panel.add(btnVolver, gbc);

        add(panel);

        // Asignación de acciones a cada botón
        btnAgregar.addActionListener(e  -> agregarCliente());
        btnEditar.addActionListener(e   -> editarCliente());
        btnEliminar.addActionListener(e -> eliminarCliente());
        btnLimpiar.addActionListener(e  -> limpiar());
        btnBuscar.addActionListener(e   -> buscarCliente());
        // Muestra todos los usuarios registrados en el sistema
        btnVerTodos.addActionListener(e -> txtArea.setText(CentroDeBelleza.getCentro().consultarUsario()));
        btnVolver.addActionListener(e   -> { new FrmMenu().setVisible(true); dispose(); });
    }

    private void agregarCliente() {
        // Primero valida que los campos no estén vacíos
        if (!validarCampos()) return;

        // Conexión GUI → Dominio via DAO (patrón requerido por la persona 3)
        CentroDeBellezaDAO dao = new CentroDeBellezaDAO();
        Cliente c = new Cliente(
                txtNombre.getText().trim(),
                txtApellido.getText().trim(),
                txtContrasena.getText().trim(),
                txtCorreo.getText().trim(),
                txtTelefono.getText().trim()
        );

        // El DAO llama internamente a CentroDeBelleza.agregarUsuario()
        boolean ok = dao.agregar(c);

        if (ok) { mostrarMensaje("✔ Cliente agregado.", new Color(0, 128, 0)); limpiar(); }
        else    { mostrarMensaje("✘ El cliente ya existe.", Color.RED); }
    }

    private void editarCliente() {
        // El correo original se toma del campo Buscar
        String correoOriginal = txtBuscar.getText().trim();
        if (correoOriginal.isEmpty()) {
            mostrarMensaje("⚠ Escriba el correo actual en Buscar.", Color.ORANGE); return;
        }
        if (!validarCampos()) return;

        // Crea un cliente con los nuevos datos del formulario
        Cliente actualizado = new Cliente(
                txtNombre.getText().trim(),
                txtApellido.getText().trim(),
                txtContrasena.getText().trim(),
                txtCorreo.getText().trim(),
                txtTelefono.getText().trim()
        );

        // Busca por correo original y reemplaza los datos
        boolean ok = CentroDeBelleza.getCentro().editarUsuario(actualizado, correoOriginal);
        if (ok) { mostrarMensaje("✔ Cliente editado.", new Color(0, 128, 0)); limpiar(); }
        else    { mostrarMensaje("✘ Cliente no encontrado.", Color.RED); }
    }

    private void eliminarCliente() {
        String correo = txtBuscar.getText().trim();
        if (correo.isEmpty()) {
            mostrarMensaje("⚠ Ingrese correo en Buscar.", Color.ORANGE); return;
        }

        // Confirmación antes de eliminar para evitar errores
        int conf = JOptionPane.showConfirmDialog(this,
                "¿Eliminar cliente: " + correo + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION) {
            boolean ok = CentroDeBelleza.getCentro().eliminarUsuario(correo);
            if (ok) { mostrarMensaje("✔ Cliente eliminado.", new Color(0, 128, 0)); limpiar(); }
            else    { mostrarMensaje("✘ Cliente no encontrado.", Color.RED); }
        }
    }

    private void buscarCliente() {
        String correo = txtBuscar.getText().trim();
        if (correo.isEmpty()) {
            mostrarMensaje("⚠ Ingrese un correo.", Color.ORANGE); return;
        }

        // Busca directamente en CentroDeBelleza por correo
        Usuario u = CentroDeBelleza.buscarUsuario(correo);
        if (u != null) {
            // Si encuentra al usuario, muestra sus datos en el área de resultados
            // y también llena los campos para facilitar la edición
            txtArea.setText(u.toString());
            txtNombre.setText(u.getNombre());
            txtApellido.setText(u.getApellido());
            txtCorreo.setText(u.getCorreo());
            mostrarMensaje("✔ Cliente encontrado.", new Color(0, 128, 0));
        } else {
            txtArea.setText("");
            mostrarMensaje("✘ Cliente no encontrado.", Color.RED);
        }
    }

    // Validaciones visuales: verifica campos vacíos, correo y teléfono
    private boolean validarCampos() {
        if (txtNombre.getText().trim().isEmpty()     ||
                txtApellido.getText().trim().isEmpty()   ||
                txtCorreo.getText().trim().isEmpty()     ||
                txtContrasena.getText().trim().isEmpty() ||
                txtTelefono.getText().trim().isEmpty()) {
            mostrarMensaje("⚠ Complete todos los campos.", Color.ORANGE);
            return false;
        }
        // Valida formato básico de correo
        if (!txtCorreo.getText().contains("@")) {
            mostrarMensaje("⚠ Correo inválido.", Color.RED); return false;
        }
        // Valida formato de teléfono ecuatoriano: 09XXXXXXXX
        if (!txtTelefono.getText().matches("^09\\d{8}$")) {
            mostrarMensaje("⚠ Teléfono inválido. Formato: 09XXXXXXXX", Color.RED); return false;
        }
        return true;
    }

    // Limpia todos los campos del formulario
    private void limpiar() {
        txtNombre.setText(""); txtApellido.setText(""); txtCorreo.setText("");
        txtContrasena.setText(""); txtTelefono.setText(""); txtBuscar.setText("");
        txtArea.setText(""); lblMensaje.setText("");
    }

    private void mostrarMensaje(String msg, Color color) {
        lblMensaje.setForeground(color); lblMensaje.setText(msg);
    }
}