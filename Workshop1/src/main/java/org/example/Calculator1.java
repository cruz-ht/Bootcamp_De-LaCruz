package org.example;

import java.util.Scanner;

public class Calculator1 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);


        System.out.println("What is your Principal Amount? (loan amount)");
        double Principal = scanner.nextInt();


        System.out.println("What is your Annual Interest Rate?");
        double interestRate = scanner.nextInt();

        System.out.println("Enter the length of your Payment");
        double length = scanner.nextInt();

    }
}
