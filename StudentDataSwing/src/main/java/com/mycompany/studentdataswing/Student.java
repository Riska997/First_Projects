/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentdataswing;

/**
 *
 * @author ct.2022.v8q1g3
 */
public class Student {
    private final String name;
    private final String surname;
    private final String campus;
    private final int Age;
    private final String special;

    public Student(String name, String surname, String campus, int Age, String special) {
        this.name = name;
        this.surname = surname;
        this.campus = campus;
        this.Age = Age;
        this.special = special;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCampus() {
        return campus;
    }

    public int getAge() {
        return Age;
    }

    public String getSpecial() {
        return special;
    }
    
    @Override
    public String toString(){//format String-toString
        return String.format("%-15s%-15s%-15s%-5d%-25s", this.getName(), this.getSurname(), this.getCampus(), this.getAge(), this.getSpecial());
        
    }
    
    
}
