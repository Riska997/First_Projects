/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package researchmanagementplatform;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riska
 */
public class ResearchManagementPlatform {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            Connection conn = null;
            Statement s = null;
            
            try {
                conn = DBConnection.getDBConnection();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ResearchManagementPlatform.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            s = conn.createStatement();
            
            String createTable;
            createTable = "CREATE TABLE IF NOT EXISTS`research`.`researchers` (`researcher_ID` VARCHAR(20) NOT NULL , `name` VARCHAR(255) NOT NULL , `research_Title` VARCHAR(255) NOT NULL , `project_start _date` DATE NOT NULL , `supervisor_name` VARCHAR(255) NOT NULL , `button` BOOLEAN NOT NULL , PRIMARY KEY (`researcher_ID`)) ENGINE = InnoDB;";
            
            s.executeUpdate(createTable);
            
            String insertSQL;
            insertSQL = "INSERT INTO `researchers` (`researcher_ID`, `name`, `research_Title`, `project_start _date`, `supervisor_name`, `button`) VALUES ('V112', 'James Sten', 'Ethical issues', '2024-05-08', 'Dr John Doe', '1')" ;
                    
            s.executeUpdate(insertSQL);
            
        } catch (SQLException ex) {
            Logger.getLogger(ResearchManagementPlatform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
