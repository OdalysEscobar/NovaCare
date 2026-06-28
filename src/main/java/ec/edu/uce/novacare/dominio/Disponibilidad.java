package ec.edu.uce.novacare.dominio;

public enum Disponibilidad {

    DISPONIBLE("Disponible"),
    NO_DISPONIBLE("No disponible");

    private final String descripcion;

    Disponibilidad(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }

}
