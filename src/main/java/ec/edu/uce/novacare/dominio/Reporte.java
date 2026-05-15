package ec.edu.uce.novacare.dominio;

import java.util.List;

public class Reporte {

    private Empleado empleado;
    private List<Cita> citas;

    private int numeroCitasPorDia;
    private int numeroCitasPorSemana;
    private int numeroCitasPorMes;
    private int numeroCitasCancelas;

    public Reporte() {
    }

    public Reporte(Empleado empleado, List<Cita> citas, int numeroCitasPorDia, int numeroCitasPorSemana, int numeroCitasPorMes, int numeroCitasCancelas) {
        this.empleado = empleado;
        this.citas = citas;
        this.numeroCitasPorDia = numeroCitasPorDia;
        this.numeroCitasPorSemana = numeroCitasPorSemana;
        this.numeroCitasPorMes = numeroCitasPorMes;
        this.numeroCitasCancelas = numeroCitasCancelas;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "empleado=" + empleado +
                ", citas=" + citas +
                ", numeroCitasPorDia=" + numeroCitasPorDia +
                ", numeroCitasPorSemana=" + numeroCitasPorSemana +
                ", numeroCitasPorMes=" + numeroCitasPorMes +
                ", numeroCitasCancelas=" + numeroCitasCancelas +
                '}';
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public int getNumeroCitasPorDia() {
        return numeroCitasPorDia;
    }

    public void setNumeroCitasPorDia(int numeroCitasPorDia) {
        if (numeroCitasPorDia >= 0) {
            this.numeroCitasPorDia = numeroCitasPorDia;
        }
    }

    public int getNumeroCitasPorSemana() {
        return numeroCitasPorSemana;
    }

    public void setNumeroCitasPorSemana(int numeroCitasPorSemana) {
        this.numeroCitasPorSemana = numeroCitasPorSemana;
    }

    public int getNumeroCitasPorMes() {
        return numeroCitasPorMes;
    }

    public void setNumeroCitasPorMes(int numeroCitasPorMes) {
        this.numeroCitasPorMes = numeroCitasPorMes;
    }

    public int getNumeroCitasCancelas() {
        return numeroCitasCancelas;
    }

    public void setNumeroCitasCancelas(int numeroCitasCancelas) {
        this.numeroCitasCancelas = numeroCitasCancelas;
    }
}
