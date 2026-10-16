package org.example;

import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        //USER PROMPT
        System.out.println("What is your Principal Amount? (loan amount)");
        double principal = scanner.nextDouble();

        System.out.println("What is your Annual Interest Rate?");
        double interestRate = scanner.nextDouble();

        System.out.println("Enter the length of your Payment");
        double length = scanner.nextDouble();


        //CALCULATIONS
        double monthlyRate = (interestRate / 12) /100;
        double numOfPayments = length * 12.0;


        // (1 + r)^n
        double growthFactor = Math.pow(1 + monthlyRate, numOfPayments);
        // r(1 + r)^n
        double numerator = monthlyRate * growthFactor;
        // (1 + r)^n - 1
        double monthlyPayment = principal * (numerator / (growthFactor - 1));



        double totalInterest = (monthlyPayment * numOfPayments) - principal;


        //FINAL OUTPUT
        System.out.printf("Your Monthly Payment is: %.2f%n", monthlyPayment);
        System.out.printf("Total interest Paid: %.2f%n", totalInterest);


        scanner.close();
    }
}
