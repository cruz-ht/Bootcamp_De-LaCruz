package org.example;

import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //TITLE
        System.out.println("━━━━ CD Future Value Calculator ━━━━");
        System.out.println("Please Answer the Following 3 questions to receive your, result!\n");


        //USER INPUT
        System.out.println("Deposit Amount: ");
        double deposit = scanner.nextDouble();

        System.out.println("What is the Annual interest Rate? (e.g. 4.5 for 4.5%) ");
        double annualRate = scanner.nextDouble();

        System.out.println("How many years until the CD matures: ");
        int years = scanner.nextInt();


        //CALCULATIONS
        double dailyRate = annualRate / 100 / 365;

        double futureValue = deposit * Math.pow(1 + dailyRate, 365 * years);

        double totalInterest = futureValue - deposit;


        //FINAL OUTPUT PRINT
        System.out.printf("Your Future Value: $%.2f%n", futureValue);
        System.out.printf("Total Interest Earned: $%.2f%n", totalInterest);


        scanner.close();
    }
}
