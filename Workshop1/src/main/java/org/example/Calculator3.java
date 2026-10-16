package org.example;

import java.util.Scanner;

public class Calculator3 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        // USER INPUT
        System.out.println("Enter the Following");

        System.out.println("Monthly Payout Amount: ");
        double monthlyPay = scanner.nextDouble();

        System.out.println("Expected Interest Rate: ");
        double interestRate = scanner.nextDouble();

        System.out.println("Number of Years till Pay Out: ");
        double annuityYears = scanner.nextDouble();


        //CALCULATIONS
        double monthlyInterest = interestRate / 12 / 100;

        double totalNumPayments = annuityYears * 12;

        double growing = Math.pow(1 + monthlyInterest, -totalNumPayments);

        double presentValue = monthlyPay * ((1 - growing) / monthlyInterest);


        //FINAL OUTPUT
        System.out.printf("Present Value of the Annuity: $%.2f%n", presentValue);

        scanner.close();
    }
}
