package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int option = 0;
        while(option != 3){

            System.out.println("\nWELCOME, RUNNER.");
            System.out.println("Your next upgrade starts here. Access the marketplace below.");

            System.out.println("\nSELECT YOUR DESTINATION_");
            System.out.println("[1]  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Browse the Shop");
            System.out.println("[2]  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  View Selected Gear");
            System.out.println("[3]  ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤ ⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤⃤  Disconnect");

            System.out.println("\nEnter Command: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    break;

                case 2:
                    break;

                case 3:
                    System.out.println("CONNECTION TERMINATED // Until next time, Runner.");
                    System.exit(0);
                default:
                    System.out.println("UNKNOWN COMMAND // Try another input, runner.\n");

            }
        }
    }





}