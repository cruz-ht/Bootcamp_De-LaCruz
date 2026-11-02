package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    //FONT & COLORS
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";
    public static final String HEADER = "\u001B[38;2;100;160;230m";
    public static final String ACCENTS = "\u001B[38;2;212;175;55m";

    public static final String ERROR = "\u001B[38;2;230;90;90m";
    public static final String SUCCESS = "\u001B[38;2;80;200;120m";





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Transaction> transactionList = FileManager.readItems();

        String option = "";

        while(!option.equals("4")) {

            System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
            System.out.println("Welcome, How can We Assist you Today?");

            System.out.println(HEADER + "────────────────────────────────────" + RESET);

            System.out.println(ACCENTS + "[1]" + RESET +" Add Deposit");
            System.out.println(ACCENTS + "[2]" + RESET +" Make Payment");
            System.out.println(ACCENTS + "[3]" + RESET +" View Account Ledger");
            System.out.println(ACCENTS + "[4]" + RESET +" Exit");

            System.out.println("\n Please Select an Option: ");

            option = scanner.nextLine();

            switch(option) {
                case "1":
                    System.out.println("Coming Soon..");
                    break;
                case "2":
                    System.out.println("Coming Soon.");
                    break;
                case "3":
                    System.out.println("Coming Soon...");
                    break;
                case "4":
                    System.out.println(HEADER +"Thank you for choosing DLC VAULT BANKING. Your Session has Ended. Have a Great Day." + RESET);
                    break;
                default:
                    System.out.println(ERROR + BOLD + "\nInvalid selection. Please enter a Valid Menu Option.\n" + RESET);

            }
        }
    }

    //METHODS

}