package ec.edu.uce.novacare.dominio;

public enum Especialidad {

    BARBERIA("Barberia","BAR"),
    MANICURA("Manicura", "MAN"),
    PEDICURA("Pedicura", "PED"),
    PEINADO("Peinado", "PEI"),
    MAQUILLAJE("Maquillaje", "MAQ"),
    SPA("Spa", "SPA");

    private final String descripcion;
    private final String abreviacion;

    private Especialidad(String descripcion, String abreviacion) {
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
