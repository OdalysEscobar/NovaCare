module ec.edu.uce.novacare {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.unsupported.desktop;

    exports ec.edu.uce.novacare;
    exports ec.edu.uce.novacare.util;
    exports ec.edu.uce.novacare.dominio;
    exports ec.edu.uce.novacare.DAO;

    opens ec.edu.uce.novacare to javafx.fxml;
    opens ec.edu.uce.novacare.util to javafx.fxml;
}