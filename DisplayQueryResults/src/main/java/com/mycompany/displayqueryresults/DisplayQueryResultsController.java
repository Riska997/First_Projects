package com.mycompany.displayqueryresults;

import java.sql.SQLException;
import java.util.regex.PatternSyntaxException;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.GridPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DisplayQueryResultsController {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/books";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    //Default SELECT QUERY...to load the intial data
    private static final String DEFAULT_QUERY = "SELECT * FROM authors";

    //These are used to configure the JTable for display and sorting
    private ResultSetTableModel tableModel;
    private TableRowSorter<TableModel> sorter;

    @FXML
    private Button applyFilterBtn;

    @FXML
     private TextField filterTextField;

    @FXML
    private TextArea queryTextArea;

    @FXML
    private Button submitQueryBtn;

    @FXML
    private BorderPane borderPane;

    private void intialize() {
        queryTextArea.setText(DEFAULT_QUERY);

        try {
            tableModel = new ResultSetTableModel(DATABASE_URL, USERNAME, PASSWORD, DEFAULT_QUERY);

            JTable resultTable = new JTable(tableModel);

            sorter = new TableRowSorter<TableModel>(tableModel);
            resultTable.setRowSorter(sorter);

            //Add this to JTable Swing Component as a control onto the view
            SwingNode swingNode = new SwingNode();
            swingNode.setContent(new JScrollPane(resultTable));
            borderPane.setCenter(swingNode);

        } catch (SQLException e) {
            display(AlertType.ERROR, "Database Error", e.getMessage());
            
            try{
                tableModel.disconnectedFromDatabase();
            }catch(SQLException e2){
                display(AlertType.ERROR, "Database Error", e.getMessage());
            }
            System.exit(1);
        }
    }

        @FXML
        void ApplyFilterBtnPressed(ActionEvent event) {

            String filter = filterTextField.getText().trim();

                        if (filter.length() == 0) {
                            sorter.setRowFilter(null);

                        } else {
                            try {
                                sorter.setRowFilter(RowFilter.regexFilter(filter));

                            } catch (PatternSyntaxException e) {
                                display(AlertType.ERROR, "Database Error", e.getMessage());
                            }

                        }

                    }

        @FXML
        void SubmitQueryBtnPressed(ActionEvent event ) {
        
        try{
            tableModel.setQuery(queryTextArea.getText().trim());
        }catch(IllegalStateException | SQLException e){
            display(AlertType.ERROR, "Database Error", e.getMessage());
            
            try{
                tableModel.setQuery(DEFAULT_QUERY);
                queryTextArea.setText(DEFAULT_QUERY);
            }catch(IllegalStateException | SQLException ex){
                display(AlertType.ERROR, "Database Error", e.getMessage());
            }
        
        }
    }


    

    private void display(AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
