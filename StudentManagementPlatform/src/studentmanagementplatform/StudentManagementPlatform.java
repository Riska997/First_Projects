/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementplatform;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riska
 */
public class StudentManagementPlatform {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
            Connection connection = null;
            Statement statement = null;
            
        
        try {
            //getting database connection
            connection = DBConnection.getDBConnection();
        
            statement = connection.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Students (" +
                                    "studentNumber VARCHAR(10) PRIMARY KEY, " +
                                    "name VARCHAR(100), " +
                                    "enrolledModule VARCHAR(100), " +
                                    "enrollmentDate DATE, " +
                                    "lecturerName VARCHAR(100), " +
                                    "button BOOLEAN)";
            
            statement.executeUpdate(createTableSQL);
            
            String insertSQL = "INSERT INTO Students (studentNumber, name, enrolledModule, enrollmentDate, lecturerName, button) VALUES " +
                               "('S001', 'Alice Johnson', 'Software Engineering', '2024-01-10', 'Dr. Smith', TRUE), " +
                               "('S002', 'Bob Brown', 'Data Structures', '2024-02-12', 'Prof. Davis', FALSE), " +
                               "('S003', 'Carol White', 'Operating Systems', '2024-03-15', 'Dr. Martinez', TRUE), " +
                               "('S004', 'David Green', 'Database Systems', '2024-04-18', 'Prof. Lee', FALSE), " +
                               "('S005', 'Eva Black', 'Network Security', '2024-05-20', 'Dr. Clark', TRUE)";

            statement.executeUpdate(insertSQL);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentManagementPlatform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(StudentManagementPlatform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentManger().setVisible(true);
            }
        });
        
    }
    
}
