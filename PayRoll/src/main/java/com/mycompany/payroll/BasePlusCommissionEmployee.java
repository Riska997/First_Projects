/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.payroll;

/**
 *
 * @author Mandla
 */
public class BasePlusCommissionEmployee extends CommissionEmployee{
    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, int employeeID, Date birthDate, double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, employeeID, birthDate, grossSales, commissionRate);
        
        if(baseSalary < 0.0){
            throw new IllegalArgumentException("Value Error: The Base Salary is >= 0.0!!");
        }
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    @Override
    public String toString(){
        return String.format("%s%n%20s%.2f%n%40s", super.toString(),
                "Base Salary:",this.getBaseSalary(),"-".repeat(40));
    }
    
    /**
     *
     * @return [double] - Employee's Salary Calculated from a Base Salary Plus Commission Salary
     */
    @Override
    public double earnings(){
        return getBaseSalary() + super.earnings();
    }
}
