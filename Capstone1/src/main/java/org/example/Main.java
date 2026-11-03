package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {

    //FONT & COLORS
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";

    public static final String HEADER = "\u001B[38;2;100;160;230m";
    public static final String SUBTEXT = "\u001B[38;2;150;150;150m";
    public static final String ACCENTS = "\u001B[38;2;212;175;55m";
    public static final String ERROR = "\u001B[38;2;230;90;90m";
    public static final String SUCCESS = "\u001B[38;2;80;200;120m";

    //MAIN MENU
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Transaction> transactionList = FileManager.readItems();

        String option = "";
        while(!option.equals("4")) {

            System.out.println(BOLD + HEADER + "\nDLC VAULT BANKING" + RESET);
            System.out.println("Welcome, How can we Assist you Today?");
            System.out.println(ACCENTS + "──────────────────────────────────────" + RESET);
            System.out.println(ACCENTS + "[1]" + RESET +" Add Deposit");
            System.out.println(ACCENTS + "[2]" + RESET +" Make Payment");
            System.out.println(ACCENTS + "[3]" + RESET +" View Account Ledger");
            System.out.println(ACCENTS + "[4]" + RESET +" Exit");
            System.out.println(ACCENTS + "──────────────────────────────────────" + RESET);

            System.out.println(SUBTEXT + "Please Select an Option to Continue: " + RESET);
            option = scanner.nextLine();

            switch(option) {
                case "1":
                    addDeposit(transactionList, scanner);
                    break;

                case "2":
                    makePayment(transactionList, scanner);
                    break;

                case "3":
                    System.out.println(HEADER + "\nAccessing your Account Activity...\n\n");
                    try {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException ex) {
                        System.out.println("Loading interrupted.");
                    }
                    Ledger.showLedger(transactionList, scanner);
                    break;

                case "4":
                    System.out.println(HEADER +"\n\nThank you for Choosing DLC VAULT BANKING. Your Session has Ended. Have a Great Day." + RESET);
                    break;
                default:
                    System.out.println(ERROR + "INVALID SELECTION" + RESET);
                    System.out.println(ERROR + "Please enter a Valid Menu Option.\n\n" + RESET);
            }
        }
    }

    //MAIN SCREEN METHODS

    //DEPOSITING
    public static void addDeposit(List<Transaction> transactionList, Scanner scanner) {
        System.out.println(BOLD +"\n\nNEW DEPOSIT" + RESET);
        System.out.println(SUBTEXT + "Enter the Transaction Information Below." + RESET);
        System.out.println(ACCENTS + "─────────────────────────────────────────────" + RESET);

        System.out.println(SUBTEXT + "Transaction Description: " + RESET);
        String userDesc = scanner.nextLine();
        System.out.println(SUBTEXT + "Deposit Source or Vendor: " + RESET);
        String userVendor = scanner.nextLine();

        double amount = 0;

        while (amount <= 0) {
            System.out.println(SUBTEXT + "Deposit Amount (USD, Excluding $): "+ RESET);

            try{
                amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0) {
                    System.out.println(ERROR + "INVALID ENTRY" + RESET);
                    System.out.println(ERROR + "Reason: Transaction Amount must be Greater than 0. Please Try Again.\n\n" + RESET);
                }
            }
            catch (NumberFormatException ex) {
                System.out.println(ERROR + "INVALID ENTRY" + RESET);
                System.out.println(ERROR + "Reason: Unable to Deposit. Please Enter a Valid Numerical Amount.\n\n" + RESET);
            }
        }
        //collects
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        //creating and adding
        Transaction transaction = new Transaction(date, time, userDesc, userVendor, amount);
        transactionList.add(transaction);
        //writing to the file
        FileManager.writeTransaction(transaction);

        System.out.println(SUCCESS + "\nTRANSACTION SUCCESSFUL" + RESET);
        System.out.printf(SUCCESS + "Your Deposit of $ %,.2f has been Successfully Recorded.%n%n" + RESET, amount);

    }


    //PAYMENT
    public static void makePayment(List<Transaction> transactionList, Scanner scanner) {
        System.out.println(BOLD +"\n\nNEW PAYMENT" + RESET);
        System.out.println(SUBTEXT + "Enter the Transaction Information Below." + RESET);
        System.out.println(ACCENTS + "─────────────────────────────────────────────" + RESET);


        System.out.println("Transaction Description: ");
        String userDesc = scanner.nextLine();

        System.out.println("Payment Recipient: ");
        String userVendor = scanner.nextLine();

        double amount = 0;

        while (amount <= 0) {
            System.out.println("Payment Amount (USD, Excluding $): ");

            try{
                amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0) {
                    System.out.println(ERROR + "INVALID ENTRY" + RESET);
                    System.out.println(ERROR + "Reason: Transaction Amount must be Greater than 0. Please Try Again.\n\n" + RESET);
                }
            }
            catch (NumberFormatException ex) {
                System.out.println(ERROR + "INVALID ENTRY" + RESET);
                System.out.println(ERROR + "Reason: Unable to Deposit. Please Enter a Valid Numerical Amount.\n\n" + RESET);
            }
        }

        amount *= -1;

        //collects
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        //creating and adding
        Transaction transaction = new Transaction(date, time, userDesc, userVendor, amount);
        transactionList.add(transaction);

        //writing to the file
        FileManager.writeTransaction(transaction);
        System.out.println(SUCCESS + "\nPAYMENT SUCCESSFUL" + RESET);
        System.out.printf(SUCCESS + "Payment of $%,.2f has been Successfully Recorded.%n%n"+ RESET, Math.abs(amount) );
    }
}