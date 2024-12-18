package com.example.stringcalculator;

public class  StringCalculator {

    // Method to add numbers from a string
    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String[] tokens = numbers.split("[,\n]");
        int sum = 0;

        for (String token : tokens) {
            try {
                int num = Integer.parseInt(token.trim()); // Try to parse each number
                if (num < 0) {
                    throw new IllegalArgumentException("Negative numbers are not allowed: " + num);
                }
                sum += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid input. Please provide only numbers.");
            }
        }

        return sum;
    }

    // Main method for execution
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();

        // Test cases
        String input = "1,2,3"; // You can modify this to any input string
        try {
            int result = calculator.add(input);
            System.out.println("Input: " + input);
            System.out.println("The sum of the numbers is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
