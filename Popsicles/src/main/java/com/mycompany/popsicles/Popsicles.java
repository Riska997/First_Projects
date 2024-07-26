/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.popsicles;

/**
 *
 * @author Riska
 */
import java.util.Scanner;

public class Popsicles{
   public static void main(String[] args){
       
       
       do{
       
       //Input from users
       Scanner sc = new Scanner(System.in);//no. of siblings
       
       System.out.println("Please enter the number of siblings: ");
       int numOfSiblings = sc.nextInt();
       
       System.out.println("Please enter the number of popsicles: ");
       int numOfPopsicles = sc.nextInt();
       
       find(numOfSiblings,numOfPopsicles);
       
       
       
       } while(true);
   }
   
   static void find(int numOfSiblings,int numOfPopsicles) {
   if (numOfPopsicles%numOfSiblings ==0){
    System.out.println("give away");
   }else{
       System.out.println("eat them yourself");
   }
   
  
   }
}
