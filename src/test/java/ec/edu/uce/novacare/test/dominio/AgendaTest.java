package ec.edu.uce.novacare.test.dominio;

import ec.edu.uce.novacare.dominio.Agenda;
import ec.edu.uce.novacare.dominio.Cita;
import ec.edu.uce.novacare.dominio.EstadoAgenda;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    @Test
    void getCitasPendiente() {
        Agenda agenda = new Agenda();
        agenda.setCitasPendiente("2 pendientes");
        assertEquals("2 pendientes", agenda.getCitasPendiente());
        System.out.println("El metodo getCitasPendiente funciona correctamente ✅");
    }

    @Test
    void setCitasPendiente() {
        Agenda agenda = new Agenda();
        agenda.setCitasPendiente("3 pendientes");
        assertEquals("3 pendientes", agenda.getCitasPendiente());
        System.out.println("El metodo setCitasPendiente funciona correctamente ✅");
    }

    @Test
    void getFecha() {
        Agenda agenda = new Agenda();
        agenda.setFecha("2026-05-12");
        assertEquals("2026-05-12", agenda.getFecha());
        System.out.println("El metodo getFecha funciona correctamente ✅");
    }

    @Test
    void setFecha() {
        Agenda agenda = new Agenda();
        agenda.setFecha("2026-05-12");
        assertEquals("2026-05-12", agenda.getFecha());
        System.out.println("El metodo setFecha funciona correctamente ✅");
    }

    @Test
    void setFechaInvalida() {
        Agenda agenda = new Agenda();
        agenda.setFecha("21/05/2026");
        assertEquals("Sin fecha", agenda.getFecha());
        System.out.println("El metodo setFechaInvalida funciona correctamente ✅");
    }

    @Test
    void getEstado() {
        Agenda agenda = new Agenda();
        agenda.setEstado(EstadoAgenda.DISPONIBLE);
        assertEquals(EstadoAgenda.DISPONIBLE, agenda.getEstado());
        System.out.println("El metodo getEstado funciona correctamente ✅");
    }

    @Test
    void setEstado() {
        Agenda agenda = new Agenda();
        agenda.setEstado(EstadoAgenda.OCUPADA);
        assertEquals(EstadoAgenda.OCUPADA, agenda.getEstado());
        System.out.println("El metodo setEstado funciona correctamente ✅");
    }

    @Test
    void setEstadoInvalido() {
        Agenda agenda = new Agenda();
        agenda.setEstado(null);
        assertEquals(EstadoAgenda.DISPONIBLE, agenda.getEstado());
        System.out.println("El metodo setEstadoInvalido funciona correctamente ✅");
    }

    @Test
    void getNumeroCitasPorDia() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorDia(5);
        assertEquals(5, agenda.getNumeroCitasPorDia());
        System.out.println("El metodo getNumeroCitasPorDia funciona correctamente ✅");
    }

    @Test
    void setNumeroCitasPorDia() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorDia(10);
        assertEquals(10, agenda.getNumeroCitasPorDia());
        System.out.println("El metodo setNumeroCitasPorDia funciona correctamente ✅");
    }

    @Test
    void setNumeroCitasPorDiaInvalido() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorDia(-5);
        assertEquals(0, agenda.getNumeroCitasPorDia());
        System.out.println("El metodo setNumeroCitasPorDiaInvalido funciona correctamente ✅");
    }

    @Test
    void getNumeroCitasPorSemana() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorSemana(15);
        assertEquals(15, agenda.getNumeroCitasPorSemana());
        System.out.println("El metodo getNumeroCitasPorSemana funciona correctamente ✅");
    }

    @Test
    void setNumeroCitasPorSemana() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorSemana(20);
        assertEquals(20, agenda.getNumeroCitasPorSemana());
        System.out.println("El metodo setNumeroCitasPorSemana funciona correctamente ✅");
    }

    @Test
    void setNumeroCitasPorSemanaInvalido() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorSemana(-10);
        assertEquals(0, agenda.getNumeroCitasPorSemana());
        System.out.println("El metodo setNumeroCitasPorSemanaInvalido funciona correctamente ✅");
    }

    @Test
    void getNumeroCitasPorMes() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorMes(40);
        assertEquals(40, agenda.getNumeroCitasPorMes());
        System.out.println("El metodo getNumeroCitasPorMes funciona correctamente ✅");
    }

    @Test
    void setNumeroCitasPorMes() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorMes(50);
        assertEquals(50, agenda.getNumeroCitasPorMes());
        System.out.println("El metodo setNumeroCitasPorMes funciona correctamente ✅");
    }

    @Test
    void setNumeroCitasPorMesInvalido() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorMes(-20);
        assertEquals(0, agenda.getNumeroCitasPorMes());
        System.out.println("El metodo setNumeroCitasPorMesInvalido funciona correctamente ✅");
    }

    @Test
    void getNumeroCitasCanceladas() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasCanceladas(2);
        assertEquals(2, agenda.getNumeroCitasCanceladas());
        System.out.println("El metodo getNumeroCitasCanceladas funciona correctamente ✅");

    }

    @Test
    void setNumeroCitasCanceladas() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasCanceladas(1);
        assertEquals(1, agenda.getNumeroCitasCanceladas());
        System.out.println("El metodo setNumeroCitasCanceladas funciona correctamente ✅");
    }

    @Test
    void setNumeroCitasCanceladasInvalido() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasCanceladas(-1);
        assertEquals(0, agenda.getNumeroCitasCanceladas());
        System.out.println("El metodo setNumeroCitasCanceladasInvalido funciona correctamente ✅");
    }

    @Test
    void getCitas() {
        Agenda agenda = new Agenda();
        java.util.List<Cita> citas = new java.util.ArrayList<>();
        agenda.setCitas(citas);
        assertEquals(citas, agenda.getCitas());
        System.out.println("El metodo getCitas funciona correctamente ✅");
    }

    @Test
    void setCitas() {
        Agenda agenda = new Agenda();
        java.util.List<Cita> citas = new java.util.ArrayList<>();
        agenda.setCitas(citas);
        assertEquals(citas, agenda.getCitas());
        System.out.println("El metodo setCitas funciona correctamente ✅");
    }

    @Test
    void testToString() {
        Agenda agenda = new Agenda();

        agenda.setCitasPendiente("2 pendientes");
        agenda.setFecha("2026-05-21");
        agenda.setEstado(EstadoAgenda.DISPONIBLE);
        agenda.setNumeroCitasPorDia(3);
        agenda.setNumeroCitasPorSemana(10);
        agenda.setNumeroCitasPorMes(30);
        agenda.setNumeroCitasCanceladas(1);

        String esperado = "Agenda{" +
                "citasPendiente='2 pendientes'" +
                ", fecha='2026-05-21'" +
                ", estado='"+EstadoAgenda.DISPONIBLE.getDescripcion() + '\''+
                ", numeroCitasPorDia=3" +
                ", numeroCitasPorSemana=10" +
                ", numeroCitasPorMes=30" +
                ", numeroCitasCanceladas=1" +
                ", citas=" + agenda.getCitas() +
                '}';
        assertEquals(esperado, agenda.toString());
        System.out.println(agenda);
    }
}