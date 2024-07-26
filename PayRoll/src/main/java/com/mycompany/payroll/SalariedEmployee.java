/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.payroll;

/**
 *
 * @author zanel
 */
public class SalariedEmployee extends Employee{
    private double weeklySalary;

    /**
     *
     * @param firstName - Employee's First Names
     * @param lastName - Employee's Last Name
     * @param employeeID - Employee's ID: Usually 4 digits
     * @param birthDate - Employee's Date of birth
     * @param weeklySalary - Employee's Weekly Flat Wages
     */
    public SalariedEmployee(String firstName, String lastName, int employeeID, Date birthDate, double weeklySalary) {
        super(firstName, lastName, employeeID, birthDate);
        
        if(weeklySalary<0.0){
            throw new IllegalArgumentException("Value Error: Weekly Salary must be >= 0.0!!");
        }
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
    
    @Override
    public String toString(){
        return String.format("%s%n%-15s%20.2f%n%40s", super.toString(),
                "Weekly Salary:",this.getWeeklySalary(),"-".repeat(40));
    }
    
    /**
     *
     * @return [double] - Employee's flat Weekly Salary
     */
    @Override
    public double earnings() {
        return this.getWeeklySalary();
    }  
}
