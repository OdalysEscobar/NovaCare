package ec.edu.uce.novacare.test;

import ec.edu.uce.novacare.dominio.Agenda;
import ec.edu.uce.novacare.dominio.Cita;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgendaTest {

    @Test
    void getCitasPendiente() {
        Agenda agenda = new Agenda();
        agenda.setCitasPendiente("2 pendientes");
        assertEquals("2 pendientes", agenda.getCitasPendiente());
    }

    @Test
    void setCitasPendiente() {
        Agenda agenda = new Agenda();
        agenda.setCitasPendiente("3 pendientes");
        assertEquals("3 pendientes", agenda.getCitasPendiente());
    }

    @Test
    void getFecha() {
        Agenda agenda = new Agenda();
        agenda.setFecha("2026-05-12");
        assertEquals("2026-05-12", agenda.getFecha());
    }

    @Test
    void setFecha() {
        Agenda agenda = new Agenda();
        agenda.setFecha("2026-05-12");
        assertEquals("2026-05-12", agenda.getFecha());
    }

    @Test
    void setFechaInvalida() {
        Agenda agenda = new Agenda();
        agenda.setFecha("21/05/2026");
        assertEquals("Sin fecha", agenda.getFecha());
    }

    @Test
    void getEstado() {
        Agenda agenda = new Agenda();
        agenda.setEstado("Activa");
        assertEquals("Activa", agenda.getEstado());
    }

    @Test
    void setEstado() {
        Agenda agenda = new Agenda();
        agenda.setEstado("Inactiva");
        assertEquals("Inactiva", agenda.getEstado());
    }

    @Test
    void setEstadoInvalido() {
        Agenda agenda = new Agenda();
        agenda.setEstado("Activa123");
        assertEquals("Sin estado", agenda.getEstado());
    }

    @Test
    void getNumeroCitasPorDia() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorDia(5);
        assertEquals(5, agenda.getNumeroCitasPorDia());
    }

    @Test
    void setNumeroCitasPorDia() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorDia(10);
        assertEquals(10, agenda.getNumeroCitasPorDia());
    }

    @Test
    void setNumeroCitasPorDiaInvalido() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorDia(-5);
        assertEquals(0, agenda.getNumeroCitasPorDia());
    }

    @Test
    void getNumeroCitasPorSemana() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorSemana(15);
        assertEquals(15, agenda.getNumeroCitasPorSemana());
    }

    @Test
    void setNumeroCitasPorSemana() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorSemana(20);
        assertEquals(20, agenda.getNumeroCitasPorSemana());
    }

    @Test
    void setNumeroCitasPorSemanaInvalido() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorSemana(-10);
        assertEquals(0, agenda.getNumeroCitasPorSemana());
    }

    @Test
    void getNumeroCitasPorMes() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorMes(40);
        assertEquals(40, agenda.getNumeroCitasPorMes());
    }

    @Test
    void setNumeroCitasPorMes() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorMes(50);
        assertEquals(50, agenda.getNumeroCitasPorMes());
    }

    @Test
    void setNumeroCitasPorMesInvalido() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasPorMes(-20);
        assertEquals(0, agenda.getNumeroCitasPorMes());
    }

    @Test
    void getNumeroCitasCanceladas() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasCanceladas(2);

        assertEquals(2, agenda.getNumeroCitasCanceladas());
    }

    @Test
    void setNumeroCitasCanceladas() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasCanceladas(1);
        assertEquals(1, agenda.getNumeroCitasCanceladas());
    }

    @Test
    void setNumeroCitasCanceladasInvalido() {
        Agenda agenda = new Agenda();
        agenda.setNumeroCitasCanceladas(-1);
        assertEquals(0, agenda.getNumeroCitasCanceladas());
    }

    @Test
    void getCitas() {
        Agenda agenda = new Agenda();
        Cita[] citas = new Cita[3];
        agenda.setCitas(citas);
        assertEquals(citas, agenda.getCitas());
    }

    @Test
    void setCitas() {
        Agenda agenda = new Agenda();
        Cita[] citas = new Cita[2];
        agenda.setCitas(citas);
        assertEquals(citas, agenda.getCitas());
    }

    @Test
    void testToString() {
        Agenda agenda = new Agenda();

        agenda.setCitasPendiente("2 pendientes");
        agenda.setFecha("2026-05-21");
        agenda.setEstado("Activa");
        agenda.setNumeroCitasPorDia(3);
        agenda.setNumeroCitasPorSemana(10);
        agenda.setNumeroCitasPorMes(30);
        agenda.setNumeroCitasCanceladas(1);

        String esperado = "Agenda{" +
                "citasPendiente='2 pendientes'" +
                ", fecha='2026-05-21'" +
                ", estado='Activa'" +
                ", numeroCitasPorDia=3" +
                ", numeroCitasPorSemana=10" +
                ", numeroCitasPorMes=30" +
                ", numeroCitasCanceladas=1" +
                ", citas=[]" +
                '}';
        assertEquals(esperado, agenda.toString());
        System.out.println(agenda);
    }
}