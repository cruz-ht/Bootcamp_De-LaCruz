package org.example;

import java.util.Scanner;

public class Calculator3 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        //TITLE
        System.out.println("━━━━ Annuity Present Value Calculator ━━━━");
        System.out.println("Please Answer the Following 4 questions to receive your, result!\n");

        // USER INPUT
        System.out.println("How Much will the Annuity pay out Each Month: ");
        double monthlyPay = scanner.nextDouble();

        System.out.println("What is the Expected Annual Interest Rate?(e.g. 2.5 for 2.5%) ");
        double interestRate = scanner.nextDouble();

        System.out.println("How many years will the annuity pay out?");
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
