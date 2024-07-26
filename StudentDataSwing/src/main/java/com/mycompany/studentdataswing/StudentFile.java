/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentdataswing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author ct.2022.v8q1g3
 */
public class StudentFile {
    
   private final String fileName = "studentFile.txt";

    public String getFileName() {
        return fileName;
    }
   
   public static void WriteToFile(ArrayList<Student>studentList){
       try(Formatter output = new Formatter("studentFile.txt")){
           //Trying to open file studentFile.txt
           for(Student student : studentList){
               try{
               output.format("%s %s %s %d %s%n", student.getName(), student.getSurname(), student.getCampus(), student.getAge(), student.getSpecial());
               }catch(NoSuchElementException e){
                    e.printStackTrace();
               }
           }
           
       }catch(SecurityException | FileNotFoundException | FormatterClosedException e){
           e.printStackTrace();
       }
       
   }
   
   public static ArrayList<Student>ReadFromFile(){
       ArrayList<Student>students = new ArrayList<>();
       
       try(Scanner input = new Scanner(Paths.get("studentFile.txt"))){
           //while loop use to test if input have something
           while(input.hasNext()){
               students.add( new Student (input.next(),input.next(),input.next(),input.nextInt(),input.next()));
           }
       }catch(IOException | NoSuchElementException | IllegalStateException e){
           e.printStackTrace();
       }
       
       return students;
   }
    
}
