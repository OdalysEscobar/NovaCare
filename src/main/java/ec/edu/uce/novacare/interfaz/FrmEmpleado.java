package ec.edu.uce.novacare.interfaz;

import ec.edu.uce.novacare.DAO.CentroDeBellezaDAO;
import ec.edu.uce.novacare.dominio.*;

import javax.swing.*;
import java.awt.*;

public class FrmEmpleado extends JFrame {

    // Campos del formulario
    private JTextField txtNombre, txtApellido, txtCorreo, txtContrasena;
    // Campo para buscar/editar/eliminar
    private JTextField txtBuscar;
    // ComboBox con los valores del enum Especialidad
    private JComboBox<Especialidad> cmbEspecialidad;
    // Área de resultados
    private JTextArea txtArea;
    // Etiqueta de mensajes
    private JLabel lblMensaje;

    public FrmEmpleado() {
        initComponents();
    }

    private void initComponents() {
        setTitle("NovaCare — Gestión de Empleados");
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
        JLabel lblTitulo = new JLabel("Gestión de Empleados", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        panel.add(lblTitulo, gbc);

        // Campos de texto
        gbc.gridwidth = 1;
        String[] etiquetas = {"Nombre:", "Apellido:", "Correo:", "Contraseña:"};
        JTextField[] campos = {
                txtNombre     = new JTextField(18),
                txtApellido   = new JTextField(18),
                txtCorreo     = new JTextField(18),
                txtContrasena = new JTextField(18)
        };
        for (int i = 0; i < etiquetas.length; i++) {
            gbc.gridx = 0; gbc.gridy = i + 1; panel.add(new JLabel(etiquetas[i]), gbc);
            gbc.gridx = 1; panel.add(campos[i], gbc);
        }

        // ComboBox con todos los valores del enum Especialidad
        gbc.gridx = 0; gbc.gridy = 5; panel.add(new JLabel("Especialidad:"), gbc);
        cmbEspecialidad = new JComboBox<>(Especialidad.values());
        gbc.gridx = 1; panel.add(cmbEspecialidad, gbc);

        // Etiqueta de mensajes de validación
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

        // Panel de búsqueda
        JPanel pBuscar = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        txtBuscar = new JTextField(16);
        JButton btnBuscar   = new JButton("Buscar");
        JButton btnVerTodos = new JButton("Ver Todos");
        pBuscar.add(new JLabel("Buscar correo:"));
        pBuscar.add(txtBuscar); pBuscar.add(btnBuscar); pBuscar.add(btnVerTodos);
        gbc.gridy = 8; panel.add(pBuscar, gbc);

        // Área de resultados
        txtArea = new JTextArea(5, 38);
        txtArea.setEditable(false);
        txtArea.setFont(new Font("Monospaced", Font.PLAIN, 11));
        gbc.gridy = 9; panel.add(new JScrollPane(txtArea), gbc);

        JButton btnVolver = new JButton("← Volver al Menú");
        gbc.gridy = 10; panel.add(btnVolver, gbc);

        add(panel);

        btnAgregar.addActionListener(e  -> agregarEmpleado());
        btnEditar.addActionListener(e   -> editarEmpleado());
        btnEliminar.addActionListener(e -> eliminarEmpleado());
        btnLimpiar.addActionListener(e  -> limpiar());
        btnBuscar.addActionListener(e   -> buscarEmpleado());
        btnVerTodos.addActionListener(e -> txtArea.setText(CentroDeBelleza.getCentro().consultarUsario()));
        btnVolver.addActionListener(e   -> { new FrmMenu().setVisible(true); dispose(); });
    }

    private void agregarEmpleado() {
        if (!validarCampos()) return;

        // Conexión GUI → Dominio via DAO
        CentroDeBellezaDAO dao = new CentroDeBellezaDAO();
        Empleado emp = new Empleado(
                txtNombre.getText().trim(),
                txtApellido.getText().trim(),
                txtContrasena.getText().trim(),
                txtCorreo.getText().trim(),
                (Especialidad) cmbEspecialidad.getSelectedItem(), // obtiene el enum seleccionado
                new Agenda() // crea una agenda vacía por defecto
        );

        boolean ok = dao.agregar(emp);

        if (ok) { mostrarMensaje("✔ Empleado agregado.", new Color(0, 128, 0)); limpiar(); }
        else    { mostrarMensaje("✘ El empleado ya existe.", Color.RED); }
    }

    private void editarEmpleado() {
        String correoOriginal = txtBuscar.getText().trim();
        if (correoOriginal.isEmpty()) {
            mostrarMensaje("⚠ Ingrese correo en Buscar.", Color.ORANGE); return;
        }
        if (!validarCampos()) return;

        Empleado actualizado = new Empleado(
                txtNombre.getText().trim(),
                txtApellido.getText().trim(),
                txtContrasena.getText().trim(),
                txtCorreo.getText().trim(),
                (Especialidad) cmbEspecialidad.getSelectedItem(),
                new Agenda()
        );

        boolean ok = CentroDeBelleza.getCentro().editarUsuario(actualizado, correoOriginal);
        if (ok) { mostrarMensaje("✔ Empleado editado.", new Color(0, 128, 0)); limpiar(); }
        else    { mostrarMensaje("✘ Empleado no encontrado.", Color.RED); }
    }

    private void eliminarEmpleado() {
        String correo = txtBuscar.getText().trim();
        if (correo.isEmpty()) {
            mostrarMensaje("⚠ Ingrese correo en Buscar.", Color.ORANGE); return;
        }

        // Confirmación antes de eliminar
        int conf = JOptionPane.showConfirmDialog(this,
                "¿Eliminar empleado: " + correo + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION) {
            boolean ok = CentroDeBelleza.getCentro().eliminarUsuario(correo);
            if (ok) { mostrarMensaje("✔ Empleado eliminado.", new Color(0, 128, 0)); limpiar(); }
            else    { mostrarMensaje("✘ Empleado no encontrado.", Color.RED); }
        }
    }

    private void buscarEmpleado() {
        String correo = txtBuscar.getText().trim();
        if (correo.isEmpty()) {
            mostrarMensaje("⚠ Ingrese un correo.", Color.ORANGE); return;
        }

        Usuario u = CentroDeBelleza.buscarUsuario(correo);
        // Verifica que el usuario encontrado sea específicamente un Empleado
        if (u instanceof Empleado emp) {
            txtArea.setText(emp.toString());
            txtNombre.setText(emp.getNombre());
            txtApellido.setText(emp.getApellido());
            txtCorreo.setText(emp.getCorreo());
            // Selecciona automáticamente la especialidad del empleado en el ComboBox
            cmbEspecialidad.setSelectedItem(emp.getEspecialidad());
            mostrarMensaje("✔ Empleado encontrado.", new Color(0, 128, 0));
        } else {
            txtArea.setText("");
            mostrarMensaje("✘ Empleado no encontrado.", Color.RED);
        }
    }

    // Validaciones: campos vacíos y formato de correo
    private boolean validarCampos() {
        if (txtNombre.getText().trim().isEmpty()   ||
                txtApellido.getText().trim().isEmpty()  ||
                txtCorreo.getText().trim().isEmpty()    ||
                txtContrasena.getText().trim().isEmpty()) {
            mostrarMensaje("⚠ Complete todos los campos.", Color.ORANGE); return false;
        }
        if (!txtCorreo.getText().contains("@")) {
            mostrarMensaje("⚠ Correo inválido.", Color.RED); return false;
        }
        return true;
    }

    private void limpiar() {
        txtNombre.setText(""); txtApellido.setText(""); txtCorreo.setText("");
        txtContrasena.setText(""); txtBuscar.setText("");
        txtArea.setText(""); lblMensaje.setText("");
    }

    private void mostrarMensaje(String msg, Color color) {
        lblMensaje.setForeground(color); lblMensaje.setText(msg);
    }
}