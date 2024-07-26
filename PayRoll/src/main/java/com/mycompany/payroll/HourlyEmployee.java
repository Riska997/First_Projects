/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.payroll;

/**
 *
 * @author Mandla
 */
public class HourlyEmployee extends Employee {
    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName, int employeeID, Date birthDate, double wage, double hours) {
        super(firstName, lastName, employeeID, birthDate);
        
        if(wage < 0.0){
            throw new IllegalArgumentException("Value Error: Wage per Hour must be >= 0!!");
        }
        
        if(hours < 0.0 || hours > 168){
            throw new IllegalArgumentException("Value Error: Hours worked must be between 0.0 and 168!!");
        }
        
        this.wage = wage;
        this.hours = hours;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }
    
    @Override
    public String toString(){
        return String.format("%s%n%20s%.2f%n%20s%.2f%n%40s", super.toString(),
                "Wage Per Hour:",this.getWage(),"Hours Worked:",this.getHours(),"-".repeat(40));
    }
    
    /**
     *
     * @return [double] - Employee's Salary Calculate a Wage Rate per Hour for the Hours worked
     */
    @Override
    public double earnings() {
        if(getHours() <= 40){
            return getWage() * getHours();
        }
        else{
            return 40 * getWage() + (getWage() - 40) * getWage() * 1.5;
        }
    } 
}
