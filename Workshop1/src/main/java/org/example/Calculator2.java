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




    }
}
