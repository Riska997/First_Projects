/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.guessthenumberdeluxe;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Riska
 */

public class GuesstheNumberdeluxe {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        // Prompting user to enter input
        System.out.println("Welcome to Guess the Number Deluxe!");
        System.out.print("Enter the minimum number for the range: ");
        int min = input.nextInt();
        System.out.print("Enter the maximum number for the range: ");
        int max = input.nextInt();
        
        int secretNumber = random.nextInt(max - min + 1) + min;
        int attempts = 0;
        int score = 100;

        System.out.println("Guess a number between " + min + " and " + max + ".");
        
        // Game loop
        while (true) {
           // System.out.println("Guess a number between " + min + " and " + max + ".");
            System.out.print("Enter your guess: ");
            int guess = input.nextInt();
            attempts++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                break;
            } else {
                System.out.println("You're getting warmer.");
                System.out.print("Would you like to use a hint? (Y/N): ");
                char choice = input.next().charAt(0);
                
                if (Character.toUpperCase(choice) == 'Y') {
                    System.out.println("Hint: The number is between " + (secretNumber - 5) + " and " + (secretNumber + 5) + ".");
                    score -= 10;
                    System.out.println("Your current score: " + score);
                }
            }
        }
    }
}
