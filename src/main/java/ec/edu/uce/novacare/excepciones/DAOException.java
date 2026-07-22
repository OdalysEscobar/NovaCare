package ec.edu.uce.novacare.excepciones;

public class DAOException extends Exception{

    // Constructor vacío
    public DAOException() {
        super();
    }

    // Constructor que recibe un mensaje personalizado explicando el error
    public DAOException(String mensaje) {
        super(mensaje);
    }

    // Constructor que recibe la causa original del error (ej. una IOException)
    public DAOException(Throwable causa) {
        super(causa);
    }

    // Constructor que recibe tanto el mensaje como la causa original
    public DAOException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

}
