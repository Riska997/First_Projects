module com.mycompany.acronymgenerator {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.acronymgenerator to javafx.fxml;
    exports com.mycompany.acronymgenerator;
}
