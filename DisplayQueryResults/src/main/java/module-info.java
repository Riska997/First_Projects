module com.mycompany.displayqueryresults {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;
    requires java.sql;
    

    opens com.mycompany.displayqueryresults to javafx.fxml;
    exports com.mycompany.displayqueryresults;
}
