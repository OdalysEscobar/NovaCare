package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.DAO;
import ec.edu.uce.novacare.DAO.TipoServicioDAOMemoriaImpl;
import ec.edu.uce.novacare.dominio.Disponibilidad;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.TipoServicio;
import ec.edu.uce.novacare.util.Validaciones;

import javax.swing.*;
import java.util.ArrayList;

public class VentanaCrearServicio {

    public JPanel panelPrincipal;

    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;

    private JButton CREARButton;
    private JButton volverButton;

    private TipoServicio tipoServicioTemporal;

    public VentanaCrearServicio() {

        CREARButton.addActionListener(e -> agregarServicio());

        volverButton.addActionListener(e -> volverAGestionarServicios());
    }

    private void agregarServicio() {

        String nombreTipo = textField1.getText().trim();
        String descripcion = textField2.getText().trim();
        String nombreServicio = textField3.getText().trim();
        String duracionTexto = textField4.getText().trim();

        // Comprobar campos vacíos
        if (nombreTipo.isEmpty()
                || descripcion.isEmpty()
                || nombreServicio.isEmpty()
                || duracionTexto.isEmpty()) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Debe completar todos los campos.",
                    "Campos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Validar nombre del tipo de servicio
        if (!Validaciones.validarLetras(nombreTipo)) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "El tipo de servicio solo puede contener letras.",
                    "Tipo de servicio incorrecto",
                    JOptionPane.WARNING_MESSAGE
            );

            textField1.requestFocus();
            return;
        }

        // Validar descripción
        if (descripcion.isEmpty()) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "La descripción no puede estar vacía.",
                    "Descripción incorrecta",
                    JOptionPane.WARNING_MESSAGE
            );

            textField2.requestFocus();
            return;
        }

        // Validar nombre del servicio
        if (!Validaciones.validarLetras(nombreServicio)) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "El nombre del servicio solo puede contener letras.",
                    "Servicio incorrecto",
                    JOptionPane.WARNING_MESSAGE
            );

            textField3.requestFocus();
            return;
        }

        int duracion;

        try {
            duracion = Integer.parseInt(duracionTexto);

            if (duracion <= 0) {
                JOptionPane.showMessageDialog(
                        panelPrincipal,
                        "La duración debe ser mayor que cero.",
                        "Duración incorrecta",
                        JOptionPane.WARNING_MESSAGE
                );

                textField4.requestFocus();
                return;
            }

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "La duración debe contener únicamente números enteros.",
                    "Formato incorrecto",
                    JOptionPane.ERROR_MESSAGE
            );

            textField4.requestFocus();
            return;
        }

        if (tipoServicioTemporal == null) {

            tipoServicioTemporal = new TipoServicio(
                    nombreTipo,
                    descripcion,
                    new ArrayList<>()
            );


            textField1.setEditable(false);
            textField2.setEditable(false);
        }


        for (Servicio servicioExistente :
                tipoServicioTemporal.getServicios()) {

            if (servicioExistente.getNombre()
                    .equalsIgnoreCase(nombreServicio)) {

                JOptionPane.showMessageDialog(
                        panelPrincipal,
                        "Ya agregó un servicio con ese nombre.",
                        "Servicio repetido",
                        JOptionPane.WARNING_MESSAGE
                );

                textField3.requestFocus();
                return;
            }
        }

        Servicio servicio = new Servicio(
                nombreServicio,
                Disponibilidad.DISPONIBLE,
                duracion
        );

        tipoServicioTemporal.getServicios().add(servicio);

        int respuesta = JOptionPane.showConfirmDialog(
                panelPrincipal,
                "Servicio añadido correctamente.\n"
                        + "¿Desea agregar otro servicio al tipo "
                        + tipoServicioTemporal.getNombreTipoServicio()
                        + "?",
                "Agregar otro servicio",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (respuesta == JOptionPane.YES_OPTION) {

            limpiarCamposDelServicio();

        } else {

            guardarTipoServicio();
        }
    }

    private void guardarTipoServicio() {

        DAO tipoServicioDAO =
                new TipoServicioDAOMemoriaImpl();

        boolean guardado =
                tipoServicioDAO.nuevo(tipoServicioTemporal);

        if (guardado) {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "Tipo de servicio registrado correctamente.\n"
                            + "Se guardaron "
                            + tipoServicioTemporal.getServicios().size()
                            + " servicio(s).",
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            volverAGestionarServicios();

        } else {

            JOptionPane.showMessageDialog(
                    panelPrincipal,
                    "No se pudo registrar el tipo de servicio.\n"
                            + "Es posible que ya exista uno con ese nombre.",
                    "Error de registro",
                    JOptionPane.ERROR_MESSAGE
            );

            /*
             * Como no se guardó, permitimos modificar nuevamente
             * el tipo y la descripción.
             */
            textField1.setEditable(true);
            textField2.setEditable(true);
        }
    }

    private void limpiarCamposDelServicio() {

        textField3.setText("");
        textField4.setText("");
        textField3.requestFocus();
    }

    private void volverAGestionarServicios() {

        JFrame serviciosFrame =
                new JFrame("Gestionar Servicios - NovaCare");

        serviciosFrame.setContentPane(
                new VentanaGestionarServicios().panelPrincipal
        );

        serviciosFrame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        serviciosFrame.pack();
        serviciosFrame.setLocationRelativeTo(null);
        serviciosFrame.setVisible(true);

        JFrame ventanaActual =
                (JFrame) SwingUtilities.getWindowAncestor(
                        panelPrincipal
                );

        if (ventanaActual != null) {
            ventanaActual.dispose();
        }
    }
}