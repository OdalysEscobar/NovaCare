package ec.edu.uce.novacare.util;

import ec.edu.uce.novacare.dominio.Agenda;
import ec.edu.uce.novacare.dominio.Cita;
import ec.edu.uce.novacare.dominio.Cliente;
import ec.edu.uce.novacare.dominio.Servicio;
import java.util.ArrayList;

public class testCita {

    public static void main(String[] args) {

        System.out.println("=== TEST CITA ===");

        Servicio servicio = new Servicio(
                "Limpieza Facial",
                60,
                true
        );

        // Usamos el constructor que SÍ existe en Cliente
        Cliente cliente = new Cliente(new ArrayList<>());

        Agenda agenda = new Agenda();

        Cita cita = new Cita(
                "15/08/2026",
                agenda,
                cliente,
                servicio,
                "14:30"
        );

        // PRUEBA FECHA
        System.out.print("Prueba fecha: ");
        if ("15/08/2026".equals(cita.getFecha())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA HORA
        System.out.print("Prueba hora: ");
        if ("14:30".equals(cita.getHora())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        // PRUEBA SERVICIO
        System.out.print("Prueba servicio: ");
        if ("Limpieza Facial".equals(cita.getServicio().getTipoServicio())) {
            System.out.println("PASÓ ✔");
        } else {
            System.out.println("FALLÓ ❌");
        }

        System.out.println("\nDATOS DE LA CITA:");
        System.out.println(cita);
    }
}