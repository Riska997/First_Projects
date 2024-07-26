/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.payroll;

/**
 *
 * @author Mandla
 */
public abstract class Employee {
    private final String firstName;
    private final String lastName;
    private final int employeeID;
    private final Date birthDate;

    /**
     *
     * @param firstName - Employee's First Names
     * @param lastName - Employee's Last Name
     * @param employeeID - Employee's ID: Usually 4 digits
     * @param birthDate - Employee's Date of birth
     */
    public Employee(String firstName, String lastName, int employeeID, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    
    @Override
    public String toString(){
        return String.format("%n%-15s%20s%n%-15s%20s%n%-15s%20d%n%-15s%20s%n", 
                "First Name:",this.getFirstName(),"Last Name:",this.getLastName(),
                "Employee ID:",this.getEmployeeID(),"Date of Birth:",this.getBirthDate());
    }
    
    public abstract double earnings(); //Abstract Method to be implemented in sub classes.
}
