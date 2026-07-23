package ec.edu.uce.novacare.gui;

import ec.edu.uce.novacare.DAO.CitaDAOMemoriaImpl;
import ec.edu.uce.novacare.DAO.DAO;
import ec.edu.uce.novacare.DAO.TipoServicioDAOFabrica;
import ec.edu.uce.novacare.dominio.Cita;
import ec.edu.uce.novacare.dominio.Cliente;
import ec.edu.uce.novacare.dominio.Servicio;
import ec.edu.uce.novacare.dominio.TipoServicio;
import ec.edu.uce.novacare.util.Validaciones;

import javax.swing.*;
import java.util.List;

public class VentanCrearCita {

    public JPanel panelPrincipal;

    private JTextField textField1; // Nombre del Cliente
    private JTextField textField4; // Fecha
    private JTextField textField5; // Hora

    private JButton CREARButton;
    private JButton VOLVERButton;

    private JComboBox<TipoServicio> comboTipoServicio;
    private JComboBox<Servicio> comboServicio;


    private DAO citaDAO;
    private DAO tipoServicioDAO;


    public VentanCrearCita() {


        citaDAO = new CitaDAOMemoriaImpl();

        tipoServicioDAO =
                new TipoServicioDAOFabrica().crearTipoServicioDAO();


        // Cargar tipos de servicio al iniciar
        cargarTiposServicio();


        // Cuando cambia el tipo, carga sus servicios
        comboTipoServicio.addActionListener(e -> cargarServicios());


        CREARButton.addActionListener(e -> guardarCita());


        VOLVERButton.addActionListener(e -> volverAMenuCitas());

    }



    private void cargarTiposServicio() {


        comboTipoServicio.removeAllItems();


        List<TipoServicio> tipos =
                (List<TipoServicio>) tipoServicioDAO.listarTodos();


        for(TipoServicio tipo : tipos){

            comboTipoServicio.addItem(tipo);

        }

    }




    private void cargarServicios() {


        comboServicio.removeAllItems();


        TipoServicio tipoSeleccionado =
                (TipoServicio) comboTipoServicio.getSelectedItem();



        if(tipoSeleccionado != null){


            for(Servicio servicio : tipoSeleccionado.getServicios()){


                comboServicio.addItem(servicio);


            }

        }

    }




    private void guardarCita(){


        String nombreCliente =
                textField1.getText().trim();


        String fecha =
                textField4.getText().trim();


        String hora =
                textField5.getText().trim();



        // Validar campos vacíos

        if(nombreCliente.isEmpty()
                || fecha.isEmpty()
                || hora.isEmpty()){


            JOptionPane.showMessageDialog(panelPrincipal,
                    "Complete todos los campos.");

            return;

        }



        // Validar nombre

        if(!Validaciones.validarLetras(nombreCliente)){


            JOptionPane.showMessageDialog(panelPrincipal,
                    "El nombre solo debe contener letras.");

            return;

        }



        // Validar fecha

        if(!Validaciones.validarFecha(fecha)){


            JOptionPane.showMessageDialog(panelPrincipal,
                    "Fecha inválida. Formato: AAAA-MM-DD");

            return;

        }



        // Validar hora

        if(!Validaciones.validarHora(hora)){


            JOptionPane.showMessageDialog(panelPrincipal,
                    "Hora inválida. Formato: HH:MM");

            return;

        }




        // Obtener servicio seleccionado del combo

        Servicio servicioSeleccionado =
                (Servicio) comboServicio.getSelectedItem();



        if(servicioSeleccionado == null){


            JOptionPane.showMessageDialog(panelPrincipal,
                    "Seleccione un servicio.");

            return;

        }



        // Crear cliente

        Cliente cliente = new Cliente();

        cliente.setNombre(nombreCliente);




        // Crear cita

        Cita cita = new Cita();


        cita.setCliente(cliente);

        cita.setServicio(servicioSeleccionado);

        cita.setFecha(fecha);

        cita.setHora(hora);




        // Guardar mediante DAO

        boolean guardado =
                citaDAO.nuevo(cita);



        if(guardado){


            JOptionPane.showMessageDialog(panelPrincipal,
                    "Cita creada correctamente.");


            volverAMenuCitas();



        }else{


            JOptionPane.showMessageDialog(panelPrincipal,
                    "No se pudo crear la cita.");

        }


    }




    private void volverAMenuCitas(){


        JFrame citasFrame =
                new JFrame("Gestionar Citas - NovaCare");


        citasFrame.setContentPane(
                new VentanaGestionarCitas().panelPrincipal);


        citasFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        citasFrame.pack();

        citasFrame.setLocationRelativeTo(null);

        citasFrame.setVisible(true);



        JFrame ventanaActual =
                (JFrame) SwingUtilities.getWindowAncestor(panelPrincipal);



        if(ventanaActual != null){

            ventanaActual.dispose();

        }

    }

}