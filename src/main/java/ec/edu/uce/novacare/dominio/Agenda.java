package ec.edu.uce.novacare.dominio;

import ec.edu.uce.novacare.util.Validaciones;

import java.util.Arrays;

/**
 * Clase que representa la agenda de un empleado.
 * Permite almacenar información relacionada con las citas.
 */
public class Agenda {
    private String citasPendiente;
    private String fecha;
    private String estado;
    private int numeroCitasPorDia;
    private int numeroCitasPorSemana;
    private int numeroCitasPorMes;
    private int numeroCitasCanceladas;

    private Cita[] citas;

    /**
     * Constructor por defecto.
     * Inicializa los atributos con valores predeterminados.
     */
    public Agenda() {
        this.citasPendiente="Sin citas pendientes";
        this.fecha="Sin fecha";
        this.estado="Sin estado";
        this.numeroCitasPorDia=0;
        this.numeroCitasPorSemana=0;
        this.numeroCitasPorMes=0;
        this.numeroCitasCanceladas=0;
        this.citas = new Cita[0];
    }

    /**
     * Constructor con parámetros.
     * @param citasPendiente citas pendientes de la agenda
     * @param citas arreglo de citas
     * @param fecha fecha de la agenda
     * @param estado estado de la agenda
     * @param numeroCitasPorDia número de citas por día
     * @param numeroCitasPorSemana número de citas por semana
     * @param numeroCitasPorMes número de citas por mes
     * @param numeroCitasCanceladas número de citas canceladas
     */
    public Agenda(String citasPendiente, Cita[] citas, String fecha, String estado, int numeroCitasPorDia,
                  int numeroCitasPorSemana , int numeroCitasPorMes, int numeroCitasCanceladas) {
        this.citasPendiente = citasPendiente;
        this.citas = citas;
        setFecha(fecha);
        setEstado(estado);
        setNumeroCitasPorDia(numeroCitasPorDia);
        setNumeroCitasPorSemana(numeroCitasPorSemana);
        setNumeroCitasPorMes(numeroCitasPorMes);
        setNumeroCitasCanceladas(numeroCitasCanceladas);
    }



    /**
     * Obtiene las citas pendientes.
     * @return citas pendientes de la agenda
     */
    public String getCitasPendiente() {
        return citasPendiente;
    }

    /**
     * Modifica las citas pendientes.
     * @param citasPendiente nuevas citas pendientes
     */
    public void setCitasPendiente(String citasPendiente) {
        this.citasPendiente = citasPendiente;
    }

    /**
     * Obtiene la fecha de la agenda.
     * @return fecha de la agenda
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Modifica la fecha de la agenda.
     * @param fecha nueva fecha de la agenda
     */
    public void setFecha(String fecha) {
        if(Validaciones.validarFecha(fecha)) {
            this.fecha = fecha;
        }
    }

    /**
     * Obtiene el estado de la agenda.
     * @return estado de la agenda
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Modifica el estado de la agenda.
     * @param estado nuevo estado de la agenda
     */
    public void setEstado(String estado) {
        if (Validaciones.validarLetras(estado)) {
            this.estado = estado;
        }
    }

    /**
     * Obtiene el número de citas por día.
     * @return número de citas por día
     */
    public int getNumeroCitasPorDia() {
        return numeroCitasPorDia;
    }

    /**
     * Modifica el número de citas por día.
     * @param numeroCitasPorDia nuevo número de citas por día
     */
    public void setNumeroCitasPorDia(int numeroCitasPorDia) {
        if (numeroCitasPorDia>=0) {
            this.numeroCitasPorDia = numeroCitasPorDia;
        }
    }

    /**
     * Obtiene el número de citas por semana.
     * @return número de citas por semana
     */
    public int getNumeroCitasPorSemana() {
        return numeroCitasPorSemana;
    }

    /**
     * Modifica el número de citas por semana.
     * @param numeroCitasPorSemana nuevo número de citas por semana
     */
    public void setNumeroCitasPorSemana(int numeroCitasPorSemana) {
        if(numeroCitasPorSemana>=0) {
            this.numeroCitasPorSemana = numeroCitasPorSemana;
        }
    }

    /**
     * Obtiene el número de citas por mes.
     * @return número de citas por mes
     */
    public int getNumeroCitasPorMes() {
        return numeroCitasPorMes;
    }

    /**
     * Modifica el número de citas por mes.
     * @param numeroCitasPorMes nuevo número de citas por mes
     */
    public void setNumeroCitasPorMes(int numeroCitasPorMes) {
        if(numeroCitasPorMes>=0) {
            this.numeroCitasPorMes = numeroCitasPorMes;
        }
    }

    /**
     * Obtiene el número de citas canceladas.
     * @return número de citas canceladas
     */
    public int getNumeroCitasCanceladas() {
        return numeroCitasCanceladas;
    }

    /**
     * Modifica el número de citas canceladas.
     * @param numeroCitasCanceladas nuevo número de citas canceladas
     */
    public void setNumeroCitasCanceladas(int numeroCitasCanceladas) {
        if (numeroCitasCanceladas>=0) {
            this.numeroCitasCanceladas = numeroCitasCanceladas;
        }
    }

    /**
     * Obtiene el arreglo de citas.
     * @return arreglo de citas
     */
    public Cita[] getCitas() {
        return citas;
    }

    /**
     * Modifica el arreglo de citas.
     * @param citas nuevo arreglo de citas
     */
    public void setCitas(Cita[] citas) {
        this.citas = citas;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "citasPendiente='" + citasPendiente + '\'' +
                ", fecha='" + fecha + '\'' +
                ", estado='" + estado + '\'' +
                ", numeroCitasPorDia=" + numeroCitasPorDia +
                ", numeroCitasPorSemana=" + numeroCitasPorSemana +
                ", numeroCitasPorMes=" + numeroCitasPorMes +
                ", numeroCitasCanceladas=" + numeroCitasCanceladas +
                ", citas=" + Arrays.toString(citas) +
                '}';
    }
}