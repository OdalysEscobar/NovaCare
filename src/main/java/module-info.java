module ec.edu.uce.novacare {
    requires javafx.controls;
    requires javafx.fxml;


    opens ec.edu.uce.novacare to javafx.fxml;
    exports ec.edu.uce.novacare;
    exports ec.edu.uce.novacare.util;
    opens ec.edu.uce.novacare.util to javafx.fxml;
}