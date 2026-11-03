package org.example;

import java.util.List;
import java.util.Scanner;
//import main palette
import static org.example.Main.*;

public class Ledger {
    Scanner scanner = new Scanner(System.in);
    public static void showLedger(List<Transaction> transactionList, Scanner scanner){

        String option = "";
        while(!option.equals("5")) {

            System.out.println(BOLD + HEADER + "\nACCOUNT LEDGER" + RESET);

            System.out.println("Review your account activity.");
            System.out.println(ACCENTS + "───────────────────────────────" + RESET);
            System.out.println(ACCENTS + "[1] " + RESET +"All Transactions");
            System.out.println(ACCENTS + "[2] " + RESET +"Deposits");
            System.out.println(ACCENTS + "[3] " + RESET +"Payments");
            System.out.println(ACCENTS + "[4] " + RESET +"Reports");
            System.out.println(ACCENTS + "[5] " + RESET +"Return to Main Menu");
            System.out.println(ACCENTS + "───────────────────────────────" + RESET);

            System.out.println(SUBTEXT + "Please Select an Option: " + RESET);
            option = scanner.nextLine();

            switch(option) {
                case "1":
                    System.out.println("Coming soon .");
                    break;
                case "2":
                    System.out.println("Coming soon ..");
                    break;
                case "3":
                    System.out.println("Coming soon ...");
                    break;
                case "4":
                    System.out.println("Coming soon ....");
                    break;
                case "5":
                    System.out.println(HEADER + "\n Returning to Main Menu...\n\n" + RESET);
                    try {
                        Thread.sleep(300);
                    }
                    catch (InterruptedException ex) {
                        System.out.println("Loading interrupted.");
                    }
                    break;

                default:
                    System.out.println(ERROR + "INVALID SELECTION" + RESET);
                    System.out.println(ERROR + "Please enter a Valid Menu Option.\n\n" + RESET);
            }
        }
    }
}
