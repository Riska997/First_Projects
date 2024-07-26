/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.payroll;

/**
 *
 * @author zanel
 */
public class CommissionEmployee extends Employee{
    private double grossSales;
    private double commissionRate;

    public CommissionEmployee(String firstName, String lastName, int employeeID, Date birthDate, double grossSales, double commissionRate) {
        super(firstName, lastName, employeeID, birthDate);
        
        if(grossSales < 0.0){
            throw new IllegalArgumentException("Value Error: Gross Sales must be >= 0.0!!");
        }
        
        if(commissionRate <= 0.0 || commissionRate >= 1.0){
            throw new IllegalArgumentException("Value Error: Commission Rate is Between 0.01 and 9.9!!");
        }
        
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }
    
    @Override
    public String toString(){
        return String.format("%s%n%20s%.2f%n%20s%.2f%n%40s", super.toString(),
                "Gross Sales:",this.getGrossSales(),"Commission Rate:",this.getCommissionRate(),"-".repeat(40));
    }
    
    /**
     *
     * @return [double] - Employee's Salary Calculated as a Commission of the Gross Sales, given a Commission Rate
     */
    @Override
    public double earnings() {
        return getCommissionRate() * getGrossSales();
    }
    
}
