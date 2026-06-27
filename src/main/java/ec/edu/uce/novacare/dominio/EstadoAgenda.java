package ec.edu.uce.novacare.dominio;

public enum EstadoAgenda {
    DISPONIBLE("Disponible", "DIS"),
    OCUPADA("Ocupada", "OCU"),
    PENDIENTE("Pendiente", "PEN"),
    CANCELADA("Cancelada", "CAN");

    private final String descripcion;
    private final String abreviacion;

    private EstadoAgenda(String descripcion, String abreviacion) {
        this.descripcion = descripcion;
        this.abreviacion = abreviacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getAbreviacion() {
        return abreviacion;
    }
}
