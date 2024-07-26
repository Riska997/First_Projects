/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tabletpurchasefinancecalculator;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Riska
 */

public class TabletPurchaseFinanceCalculator {
    
   // Method to calculate and return the price based on the option
    public static double calculatePrice(char option, double PRICE_S, double PRICE_M, double PRICE_L ) {
        double creditPrice = 0.0;
        final double interest = 0.854;
       
         
        if(option == 'S'){
            creditPrice = PRICE_S +(PRICE_S *0.854); 
        }
        if(option == 'M'){
            creditPrice = PRICE_M +(PRICE_M *0.854); 
        }
        if(option == 'L'){
            creditPrice = PRICE_S +(PRICE_L *0.854); 
        }
        
        return creditPrice; 
    }

    public static void main(String[] args) {
        
         //Declaring constants in the System
        final double PRICE_S = 5799.00;
        final double PRICE_M = 7999.00;
        final double PRICE_L = 10099.00;
        
        //Declaring variables
        char option;
        
        //formatting Price
        DecimalFormat randFormat;  
        randFormat = new DecimalFormat("R#,###.00"); 
      
        //Looping the user actions if incorrect option is entered
        do{
            //Displaying tablet options to the user
            System.out.printf("\n\tSelect a Tablet: %n");
            System.out.printf("S - 64GB Tablet%22sPrice: %s\n", "", randFormat.format(PRICE_S));
            System.out.printf("M - 128GB Tablet%21sPrice: %s\n", "", randFormat.format(PRICE_M));
            System.out.printf("L - 256GB Tablet%21sPrice: %s\n\n", "", randFormat.format(PRICE_L));

            System.out.print("Enter your choice: ");
            

          //asking for user input 
          Scanner input = new Scanner(System.in);
          option = input.next().charAt(0);

          
          //Validating the captured option
            if( option == 'S' || option == 'M' || option == 'L'){
               double monthlyInstalments;
               int month = 24;
             
                monthlyInstalments = calculatePrice(option,PRICE_S,PRICE_M,PRICE_L)/24 ;
                System.out.printf("\nPay as little as: %s%s pm x 24 months\n", "", randFormat.format(monthlyInstalments));
                System.out.printf("===============================================================================================%n");
                System.out.printf("\n***Credit Price: %s\n", randFormat.format(calculatePrice(option, PRICE_S, PRICE_M, PRICE_L)));
                
               
                
            }else{
                 System.out.println("\nInvalid choice! Option '" + option + "' does not exist.");
             }

         }while (option != 'S' && option != 'M' && option != 'L');
        
    }
}

