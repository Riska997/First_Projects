package com.mycompany.rental;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Rental {

    static int[] Capture() {
        Scanner input = new Scanner(System.in);
        int[] result = new int[2]; // stores carType and numOfDays

        try {
            System.out.println("Please select a car type:");
            System.out.println("1. Compact");
            System.out.println("2. Sedan");
            System.out.println("3. SUV");
            System.out.println("Enter the number corresponding to your choice: ");
            int carType = input.nextInt();

            if (carType < 1 || carType > 3) {
                throw new InputMismatchException("Invalid car type.");
            }
            result[0] = carType;

            System.out.println("Please enter the number of days for rental: ");
            int numOfDays = input.nextInt();

            if (numOfDays <= 0) {
                throw new InputMismatchException("Number of days must be greater than zero.");
            }
            result[1] = numOfDays;
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
            System.exit(1); // Terminate the program
        } finally {
            input.close(); // Close the Scanner
        }

        return result;
    }

    static int CalculateTotal(int carType, int numOfDays) {
        final int COMPACT = 25;
        final int SEDAN = 35;
        final int SUV = 50;

        int totalCost = 0;
        switch (carType) {
            case 1:
                totalCost = COMPACT * numOfDays;
                break;
            case 2:
                totalCost = SEDAN * numOfDays;
                break;
            case 3:
                totalCost = SUV * numOfDays;
                break;
        }
        return totalCost;
    }

    static void Display(int carType, int numOfDays, int totalCost) {
        System.out.println("You have selected a " + getCarTypeName(carType) + " for " + numOfDays + " days.");
        System.out.println("The total cost for the rental is: R" + totalCost);
    }

    static String getCarTypeName(int carType) {
        return switch (carType) {
            case 1 -> "Compact";
            case 2 -> "Sedan";
            case 3 -> "SUV";
            default -> "Unknown";
        };
    }

    public static void main(String[] args) {
        int[] rentalInfo = Capture();
        int carType = rentalInfo[0];
        int numOfDays = rentalInfo[1];
        int totalCost = CalculateTotal(carType, numOfDays);
        Display(carType, numOfDays, totalCost);
    }
}
