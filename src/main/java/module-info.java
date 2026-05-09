module ec.edu.uce.novacare {
    requires javafx.controls;
    requires javafx.fxml;


    opens ec.edu.uce.novacare to javafx.fxml;
    exports ec.edu.uce.novacare;
}