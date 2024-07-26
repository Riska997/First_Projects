/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package researchmanagementplatform;

/**
 *
 * @author Riska
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DBConnection {
    
    //Establish connection details
    private static final String URL="jdbc:mysql://localhost:3306/Research?zeroDateTimeBehavior=CONVERT_TO_NULL";
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    static Connection getDBConnection;
     
    
    //Method to establish connection
    public static Connection getDBConnection()throws ClassNotFoundException, SQLException{
    
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error connecting to database", "Database Error", JOptionPane.ERROR_MESSAGE);
            
        }
        return null;
  
        
    }
    
    
}
