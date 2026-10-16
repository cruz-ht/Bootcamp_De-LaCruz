package org.example;

import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        //TITLE
        System.out.println("━━━━  MORTGAGE CALCULATOR  ━━━━");
        System.out.println("Please Answer the Following 3 questions to receive your, result!\n");

        //USER PROMPT
        System.out.println("What is the principal amount of the loan? ");
        double principal = scanner.nextDouble();

        System.out.println("What is the annual interest rate? ");
        double interestRate = scanner.nextDouble();

        System.out.println("How many years is the loan? ");
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
