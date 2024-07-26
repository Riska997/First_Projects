/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fruitbowl;

import java.util.Scanner;

/**
 *
 * @author Riska
 */
public class Fruitbowl {

    public static void main(String[] args) {
        
        //Declaring variables
        int fruit =0;
        int apple;
        int pie;
        
        //Capturing user input
        Scanner input = new Scanner(System.in);
        
        //Looping when user input is incorrect
       do{
        //Validing user input
        if(fruit%2 == 0){
            
            fruit = input.nextInt();
            apple = fruit/2;
            pie = apple/3;
            
            System.out.println(pie);
        }else{
            System.out.println("Error");
        }
        }while(fruit%2 != 0);
    }
}
