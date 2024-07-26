/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.displayqueryresults;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ct.2022.v8q1g3
 */
class ResultSetTableModel extends AbstractTableModel {

    private final Connection connection;
    private final Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numOfRows;
    private boolean connectedToDatabase = false; //Keep track of the database

    public ResultSetTableModel(String url, String username, String password, String query) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        connectedToDatabase = true;
        setQuery(query);
    }

    @Override
    public String getColumnName(int columnIndex) throws IllegalStateException {

        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connection to Database");
        }

        try {
            return metaData.getColumnName(columnIndex + 1);

        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /*
* @param column number for the column being rendered
* @return Returns the Data Type Class for the current column being rendered
* @throws IllegalStateException if the database connection is closed
     */
    @Override
    public Class getColumnClass(int column) throws IllegalStateException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connection to Database");
        }
        try {
            return Class.forName(metaData.getColumnClassName(column +1));

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);

        }
        return Object.class;
    }

    @Override
    public int getRowCount() throws IllegalStateException {
       if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connection to Database");
        }
       
       return numOfRows;
    }

    @Override
    public int getColumnCount() throws IllegalStateException {
         if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connection to Database");
        }
         
        try{
            return metaData.getColumnCount();
        }catch(SQLException ex){
             Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) throws IllegalStateException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connection to Database");
        }

        try {
            resultSet.absolute(rowIndex + 1);
            return resultSet.getObject(columnIndex+1);

        } catch (SQLException ex) {
            Logger.getLogger(ResultSetTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    void setQuery(String query) throws IllegalStateException, SQLException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connection to Database");
        }

        resultSet = statement.executeQuery(query);
        metaData = resultSet.getMetaData();
        resultSet.last();
        numOfRows = resultSet.getRow();

        fireTableStructureChanged();
    }

    public void disconnectedFromDatabase() throws SQLException {
        if(connectedToDatabase){
            resultSet.close();
            statement.close();
            connection.close();
        }
    }

  
}
