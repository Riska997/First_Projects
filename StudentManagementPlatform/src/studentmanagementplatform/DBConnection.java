/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementplatform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Riska
 */
    public class DBConnection {
        // Establish connection details 

        private static final String URL = "jdbc:mysql://localhost:3306/AcademicRecords";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "";
        private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

        // Method to establish connection
        public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
            try {
                Class.forName(DRIVER);
                return DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                throw new SQLException("Error connecting to the database.", e);
            }
        }

    }
