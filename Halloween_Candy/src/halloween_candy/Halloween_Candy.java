package halloween_candy;

import java.util.Scanner;

public class Halloween_Candy {

    public static void main(String[] args) {
        //Ensure that the user is able to go back to the first question if an error occurs
        try (Scanner input = new Scanner(System.in)) {
            //Ensure that the user is able to go back to the first question if an error occurs
            while (true) {
                System.out.println("How many houses did you visit?");
                
                // Checking if input is an integer or not
                if (input.hasNextInt()) {
                    int houses = input.nextInt();
                    
                    // Checking if the number of input entered is greater than or equal to 3
                    if (houses >= 3) {
                        int perChance = (int) Math.round((2.0 / houses) * 100);
                        System.out.println("Percentage chance of getting a dollar bill: " + perChance + "%");
                        break;  // Exit the loop if a valid input is provided
                    } else {
                        System.out.println("Number must be 3 or greater!!");
                    }
                } else {
                    System.out.println("Error: Not an integer. Try again!!");
                    input.next();  // Consume invalid input to avoid an infinite loop
                }
            }
            // Closing the scanner
        }
    }
}
