package org.example;

import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        //INIT USER INPUT
        System.out.println("Please Input the Following");

        System.out.println("Initial Deposit: ");
        double deposit = scanner.nextDouble();

        System.out.println("Annual interest Rate: ");
        double annualRate = scanner.nextDouble();

        System.out.println("Number of Year(s): ");
        int years = scanner.nextInt();


        //CALCULATIONS
        double dailyRate = annualRate / 100 / 365;

        double futureValue = deposit * Math.pow(1 + dailyRate, 365 * years);

        double totalInterest = futureValue - deposit;


        //FINAL OUTPUT PRINT
        System.out.printf("Your Future Value: $%.2f%n", futureValue);
        System.out.printf("Total Interest Earned: $%.2f%n", totalInterest);


    }
}
