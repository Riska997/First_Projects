/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.payroll;

/**
 *
 * @author Mandla
 */
public class Date {
    private int month;
    private int day;
    private int year;
    
    private static final int[] daysPerMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    
    public Date(int month,int day,int year){
        if(month <= 0 || month > 12){
            throw new IllegalArgumentException("Data Error: Month (" + month + ") must be betwwen 1 - 12!");
        }
        
        if(day <= 0 || (day > daysPerMonth[month] && !(month == 2 && day == 29))){
            throw new IllegalArgumentException("Data Error: Day (" + day + ") out of range for the specified month and year!");
        }
        
        if(day == 29 && month == 2 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))){
            throw new IllegalArgumentException("Data Error: Day (" + day + ") out of range for the specified month and year!");
        }
        
        this.month = month;
        this.day = day;
        this.year = year;
        
        //System.out.printf("Date objected constructed for date %s%n",this); //Will use the ToString Method of the Object Class
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }
    
    
    
    @Override
    public String toString(){
        return String.format("%02d/%02d/%04d",this.getMonth(),this.getDay(),this.getYear());
    }     
}
