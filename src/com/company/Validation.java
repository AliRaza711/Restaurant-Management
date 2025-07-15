package com.company;

import java.util.Scanner;

public class Validation {
    private String adminPass = "abc.123";

    public String getPass(){
        return adminPass;
    }
    // Method to check if a string can be parsed to an integer
    public boolean isValidInteger(String input) {
        // Check if the string matches the pattern for a valid integer
        if (input != null && input.matches("-?\\d+")) {
            return true;  // It's a valid integer
        } else {
            return false;  // It's not a valid integer
        }
    }

    public boolean isValidName(String name) {
        return name.matches("^[a-zA-Z\\s]+$");
    }

    // Method to check if an integer is within a specified range
    public static boolean isInRange(String input, int min, int max) {
        int value = Integer.parseInt(input);
        return value >= min && value <= max;
    }

    // Method to get a valid double input (e.g., for prices)
    public static double getValidDoubleInput(Scanner scanner) {
        String input;
        double value;
        while (true) {
            input = scanner.nextLine();
            try {
                value = Double.parseDouble(input);
                if (value > 0) { // Ensure positive value
                    break;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid price. Please enter a valid price:");
            }
        }
        return value;
    }

    // Method to get a valid integer input with range check (e.g., for popularity)
    public static int getValidIntegerInput(Scanner scanner, int min, int max) {
        String input;
        int value;
        while (true) {
            input = scanner.nextLine();
            try {
                value = Integer.parseInt(input);
                if (value >= min && value <= max) {
                    break;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid number.");
                System.out.println("Please enter a number between " + min + " and " + max + ":");
            }
        }
        return value;
    }
}
