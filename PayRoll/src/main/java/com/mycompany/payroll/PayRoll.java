/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.payroll;

/**
 *
 * @author Mandla
 */
public class Payroll {

    public static void main(String[] args) {
        SalariedEmployee salariedEmp = new SalariedEmployee("Jurgens","Van Dyk",452,new Date(02,28,2004),12000);
        HourlyEmployee hourlyEmp = new HourlyEmployee("Stephanos","Balden",1451,new Date(12,25,2001),420,64);
        CommissionEmployee commissionEmp = new CommissionEmployee("Prisca","Mulishi",3251,new Date(1,1,2002),253025,0.12);
        BasePlusCommissionEmployee baseCommEmp = new BasePlusCommissionEmployee("Martin","Stander",780,new Date(4,30,1999),154230,0.14,4210);
        
        System.out.println("Employees processed individually (static binding):");
        
        System.out.printf("%n%s%n%-15s%20.2f%n%40s", salariedEmp,"Salary Earned:",salariedEmp.earnings(),"=".repeat(40));
        System.out.printf("%n%s%n%-15s%20.2f%n%40s", hourlyEmp,"Salary Earned:",hourlyEmp.earnings(),"=".repeat(40));
        System.out.printf("%n%s%n%-15s%20.2f%n%40s", commissionEmp,"Salary Earned:",commissionEmp.earnings(),"=".repeat(40));
        System.out.printf("%n%s%n%-15s%20.2f%n%40s", baseCommEmp,"Salary Earned:",baseCommEmp.earnings(),"=".repeat(40));
    
        Employee [] employees = new Employee[4];   
        employees[0] = salariedEmp;
        employees[1] = hourlyEmp;
        employees[2] = commissionEmp;
        employees[3] = baseCommEmp;
        
       System.out.println("Employees proceed polymophically: ");
       
       for(Employee currentEmployee : employees){
        System.out.println(currentEmployee);
        
        if (currentEmployee instanceof BasePlusCommissionEmployee){
        BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
        employee.setBaseSalary(employee.getBaseSalary()*1.1);
        
        System.out.printf("New Base Salary with 10% increase is: R%.2f%n",
                employee.getBaseSalary());
        }
       }
    }
}
